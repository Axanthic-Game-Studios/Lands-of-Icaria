package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.entity.CrystalBlockEntity;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")
@ParametersAreNonnullByDefault

@OnlyIn(Dist.CLIENT)
public class CrystalBlockRenderer implements BlockEntityRenderer<CrystalBlockEntity> {
	public boolean RENDER_RAYS = IcariaConfig.RENDER_RAYS.get();
	public float HALF_SQRT_3 = (float)(Math.sqrt(3.0D) / 2.0D);

	public CrystalBlockRenderer(BlockEntityRendererProvider.Context pContext) {

	}

	@Override
	public void render(CrystalBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
		VertexConsumer vertexConsumer = pBufferSource.getBuffer(RenderType.lightning());

		Matrix4f matrix4f = pPoseStack.last().pose();

		Random random = new Random(432L);

		double x = pBlockEntity.x;
		double y = pBlockEntity.y;
		double z = pBlockEntity.z;

		float length = random.nextFloat() * 2.0F + 1.25F;
		float width = random.nextFloat() *  0.5F + 0.25F;
		float fade = Math.min(0.0F, 1.0F);

		int alpha = (int)(16.0F * (1.0F - fade));
		if (!RENDER_RAYS) {
			alpha = 0;
		}
		int r = pBlockEntity.r;
		int g = pBlockEntity.g;
		int b = pBlockEntity.b;

		GlStateManager._depthMask(false);

		pPoseStack.translate(x, y, z);

		for(int i = 0; (float)i < 96; ++i) {
			pPoseStack.mulPose(Vector3f.XP.rotationDegrees(random.nextFloat() * 360.0F));
			pPoseStack.mulPose(Vector3f.YP.rotationDegrees(random.nextFloat() * 360.0F));
			pPoseStack.mulPose(Vector3f.ZP.rotationDegrees(random.nextFloat() * 360.0F));
			pPoseStack.mulPose(Vector3f.XP.rotationDegrees(random.nextFloat() * 360.0F));
			pPoseStack.mulPose(Vector3f.YP.rotationDegrees(random.nextFloat() * 360.0F));
			pPoseStack.mulPose(Vector3f.ZP.rotationDegrees(random.nextFloat() * 360.0F));

			vertexA(vertexConsumer, matrix4f, r, g, b, alpha);
			vertexB(vertexConsumer, matrix4f, length, width);
			vertexC(vertexConsumer, matrix4f, length, width);
			vertexA(vertexConsumer, matrix4f, r, g, b, alpha);
			vertexC(vertexConsumer, matrix4f, length, width);
			vertexD(vertexConsumer, matrix4f, length, width);
			vertexA(vertexConsumer, matrix4f, r, g, b, alpha);
			vertexD(vertexConsumer, matrix4f, length, width);
			vertexB(vertexConsumer, matrix4f, length, width);
		}
	}

	public void vertexA(VertexConsumer vertexConsumer, Matrix4f matrix4f, int r, int g, int b, int alpha) {
		vertexConsumer.vertex(matrix4f, 0.0F, 0.0F, 0.0F).color(r, g, b, alpha).endVertex();
	}

	public void vertexB(VertexConsumer vertexConsumer, Matrix4f matrix4f, float length, float width) {
		vertexConsumer.vertex(matrix4f, -HALF_SQRT_3 * width, length, -0.5F * width).color(255, 255, 255, 0).endVertex();
	}

	public void vertexC(VertexConsumer vertexConsumer, Matrix4f matrix4f, float length, float width) {
		vertexConsumer.vertex(matrix4f, HALF_SQRT_3 * width, length, -0.5F * width).color(255, 255, 255, 0).endVertex();
	}

	public void vertexD(VertexConsumer vertexConsumer, Matrix4f matrix4f, float length, float width) {
		vertexConsumer.vertex(matrix4f, 0.0F, length, width).color(255, 255, 255, 0).endVertex();
	}
}
