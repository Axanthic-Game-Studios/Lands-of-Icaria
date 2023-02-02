package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.entity.CrystalBlockEntity;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;

import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;

import org.joml.Matrix4f;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")
@ParametersAreNonnullByDefault

public class CrystalBlockRenderer implements BlockEntityRenderer<CrystalBlockEntity> {
	public static final float HALF_SQRT_3 = Mth.sqrt(3.0F) / 2.0F;

	public static final RenderStateShard.ShaderStateShard LIGHTNING_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeLightningShader);

	public static final RenderStateShard.TransparencyStateShard ADDITIVE_LIGHTNING_TRANSPARENCY = new RenderStateShard.TransparencyStateShard("additive_lightning_transparency", () -> {
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE);
	}, () -> {
		RenderSystem.depthMask(true);
		RenderSystem.disableBlend();
		RenderSystem.defaultBlendFunc();
	});

	public static final RenderStateShard.TransparencyStateShard SUBTRACTIVE_LIGHTNING_TRANSPARENCY = new RenderStateShard.TransparencyStateShard("subtractive_lightning_transparency", () -> {
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.SRC_COLOR, GlStateManager.SourceFactor.ZERO, GlStateManager.DestFactor.ONE);
	}, () -> {
		RenderSystem.depthMask(true);
		RenderSystem.disableBlend();
		RenderSystem.defaultBlendFunc();
	});

	public static final RenderType ADDITIVE_LIGHTNING = RenderType.create("additive_lightning", DefaultVertexFormat.POSITION_COLOR, VertexFormat.Mode.QUADS, 256, false, true, RenderType.CompositeState.builder().setShaderState(LIGHTNING_SHADER).setTransparencyState(ADDITIVE_LIGHTNING_TRANSPARENCY).createCompositeState(false));
	public static final RenderType SUBTRACTIVE_LIGHTNING = RenderType.create("subtractive_lightning", DefaultVertexFormat.POSITION_COLOR, VertexFormat.Mode.QUADS, 256, false, true, RenderType.CompositeState.builder().setShaderState(LIGHTNING_SHADER).setTransparencyState(SUBTRACTIVE_LIGHTNING_TRANSPARENCY).createCompositeState(false));

	public CrystalBlockRenderer(BlockEntityRendererProvider.Context pContext) {

	}

	@Override
	public int getViewDistance() {
		return IcariaConfig.RENDER_DISTANCE_RAYS.get();
	}

	@Override
	public void render(CrystalBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
		if (IcariaConfig.RENDER_RAYS.get()) {
			Matrix4f matrix4f = pPoseStack.last().pose();
			RandomSource randomSource = RandomSource.create(432L);
			VertexConsumer vertexConsumer = pBufferSource.getBuffer(ADDITIVE_LIGHTNING);

			float length = randomSource.nextFloat() * 2.0F + 1.25F;
			float width = randomSource.nextFloat() * 0.5F + 0.25F;

			int alpha = (int) (16.0F * (1.0F - Math.min(0.0F, 1.0F)));
			int r = pBlockEntity.r;
			int g = pBlockEntity.g;
			int b = pBlockEntity.b;

			pPoseStack.translate(pBlockEntity.x, pBlockEntity.y, pBlockEntity.z);

			for (int i = 0; i < 96; ++i) {
				pPoseStack.mulPose(Axis.XP.rotationDegrees(randomSource.nextFloat() * 360.0F));
				pPoseStack.mulPose(Axis.YP.rotationDegrees(randomSource.nextFloat() * 360.0F));
				pPoseStack.mulPose(Axis.ZP.rotationDegrees(randomSource.nextFloat() * 360.0F));

				this.vertexA(vertexConsumer, matrix4f, r, g, b, alpha);
				this.vertexB(vertexConsumer, matrix4f, length, width);
				this.vertexC(vertexConsumer, matrix4f, length, width);
				this.vertexA(vertexConsumer, matrix4f, r, g, b, alpha);
				this.vertexC(vertexConsumer, matrix4f, length, width);
				this.vertexD(vertexConsumer, matrix4f, length, width);
				this.vertexA(vertexConsumer, matrix4f, r, g, b, alpha);
				this.vertexD(vertexConsumer, matrix4f, length, width);
				this.vertexB(vertexConsumer, matrix4f, length, width);
			}
		}
	}

	public void vertexA(VertexConsumer pVertexConsumer, Matrix4f pMatrix4f, int pRed, int pGreen, int pBlue, int pAlpha) {
		pVertexConsumer.vertex(pMatrix4f, 0.0F, 0.0F, 0.0F).color(pRed, pGreen, pBlue, pAlpha).endVertex();
	}

	public void vertexB(VertexConsumer pVertexConsumer, Matrix4f pMatrix4f, float pLength, float pWidth) {
		pVertexConsumer.vertex(pMatrix4f, -HALF_SQRT_3 * pWidth, pLength, -0.5F * pWidth).color(255, 255, 255, 0).endVertex();
	}

	public void vertexC(VertexConsumer pVertexConsumer, Matrix4f pMatrix4f, float pLength, float pWidth) {
		pVertexConsumer.vertex(pMatrix4f, HALF_SQRT_3 * pWidth, pLength, -0.5F * pWidth).color(255, 255, 255, 0).endVertex();
	}

	public void vertexD(VertexConsumer pVertexConsumer, Matrix4f pMatrix4f, float pLength, float pWidth) {
		pVertexConsumer.vertex(pMatrix4f, 0.0F, pLength, pWidth).color(255, 255, 255, 0).endVertex();
	}
}
