package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.registry.IcariaRenderTypes;
import com.axanthic.icaria.client.state.BubbleSpellRenderState;
import com.axanthic.icaria.common.entity.BubbleSpellEntity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;
import com.mojang.math.Axis;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.util.RandomSource;

import org.joml.Matrix4f;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class BubbleSpellRenderer extends EntityRenderer<BubbleSpellEntity, BubbleSpellRenderState> {
	public BubbleSpellRenderer(EntityRendererProvider.Context pContext) {
		super(pContext);
	}

	@Override
	public void extractRenderState(BubbleSpellEntity pEntity, BubbleSpellRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.id = pEntity.getId();
	}

	@Override
	public void submit(BubbleSpellRenderState pRenderState, PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, CameraRenderState pCameraRenderState) {
		var randomSource = RandomSource.create(pRenderState.id);

		var speed = 0.5F;

		var ticks = pRenderState.ageInTicks;

		pPoseStack.pushPose();

		pPoseStack.translate(0.0D, 0.25D, 0.0D);

		pPoseStack.mulPose(Axis.XP.rotationDegrees(randomSource.nextFloat() * 360.0F + speed * ticks));
		pPoseStack.mulPose(Axis.YP.rotationDegrees(randomSource.nextFloat() * 360.0F + speed * ticks));
		pPoseStack.mulPose(Axis.ZP.rotationDegrees(randomSource.nextFloat() * 360.0F + speed * ticks));

		pSubmitNodeCollector.submitCustomGeometry(pPoseStack, IcariaRenderTypes.ADDITIVE, (pose, vertexConsumer) -> this.submit(pose.pose(), randomSource, vertexConsumer, 0.25F, 0.25F));

		pPoseStack.popPose();

		super.submit(pRenderState, pPoseStack, pSubmitNodeCollector, pCameraRenderState);
	}

	public void submit(Matrix4f pMatrix4f, RandomSource pRandomSource, VertexConsumer pVertexConsumer, float pAlpha, float pScale) {
		var r0 = pRandomSource.nextFloat();
		var g0 = pRandomSource.nextFloat();
		var b0 = pRandomSource.nextFloat();
		var r1 = pRandomSource.nextFloat();
		var g1 = pRandomSource.nextFloat();
		var b1 = pRandomSource.nextFloat();
		var r2 = pRandomSource.nextFloat();
		var g2 = pRandomSource.nextFloat();
		var b2 = pRandomSource.nextFloat();
		var r3 = pRandomSource.nextFloat();
		var g3 = pRandomSource.nextFloat();
		var b3 = pRandomSource.nextFloat();
		var r4 = pRandomSource.nextFloat();
		var g4 = pRandomSource.nextFloat();
		var b4 = pRandomSource.nextFloat();
		var r5 = pRandomSource.nextFloat();
		var g5 = pRandomSource.nextFloat();
		var b5 = pRandomSource.nextFloat();
		var r6 = pRandomSource.nextFloat();
		var g6 = pRandomSource.nextFloat();
		var b6 = pRandomSource.nextFloat();
		var r7 = pRandomSource.nextFloat();
		var g7 = pRandomSource.nextFloat();
		var b7 = pRandomSource.nextFloat();

		pVertexConsumer.addVertex(pMatrix4f, -pScale, -pScale, pScale).setColor(r0, g0, b0, pAlpha);
		pVertexConsumer.addVertex(pMatrix4f, -pScale, pScale, pScale).setColor(r1, g1, b1, pAlpha);
		pVertexConsumer.addVertex(pMatrix4f, -pScale, pScale, -pScale).setColor(r2, g2, b2, pAlpha);
		pVertexConsumer.addVertex(pMatrix4f, -pScale, -pScale, -pScale).setColor(r3, g3, b3, pAlpha);

		pVertexConsumer.addVertex(pMatrix4f, -pScale, -pScale, -pScale).setColor(r3, g3, b3, pAlpha);
		pVertexConsumer.addVertex(pMatrix4f, -pScale, pScale, -pScale).setColor(r2, g2, b2, pAlpha);
		pVertexConsumer.addVertex(pMatrix4f, pScale, pScale, -pScale).setColor(r4, g4, b4, pAlpha);
		pVertexConsumer.addVertex(pMatrix4f, pScale, -pScale, -pScale).setColor(r5, g5, b5, pAlpha);

		pVertexConsumer.addVertex(pMatrix4f, pScale, -pScale, -pScale).setColor(r5, g5, b5, pAlpha);
		pVertexConsumer.addVertex(pMatrix4f, pScale, pScale, -pScale).setColor(r4, g4, b4, pAlpha);
		pVertexConsumer.addVertex(pMatrix4f, pScale, pScale, pScale).setColor(r6, g6, b6, pAlpha);
		pVertexConsumer.addVertex(pMatrix4f, pScale, -pScale, pScale).setColor(r7, g7, b7, pAlpha);

		pVertexConsumer.addVertex(pMatrix4f, pScale, -pScale, pScale).setColor(r7, g7, b7, pAlpha);
		pVertexConsumer.addVertex(pMatrix4f, pScale, pScale, pScale).setColor(r6, g6, b6, pAlpha);
		pVertexConsumer.addVertex(pMatrix4f, -pScale, pScale, pScale).setColor(r1, g1, b1, pAlpha);
		pVertexConsumer.addVertex(pMatrix4f, -pScale, -pScale, pScale).setColor(r0, g0, b0, pAlpha);

		pVertexConsumer.addVertex(pMatrix4f, pScale, pScale, pScale).setColor(r6, g6, b6, pAlpha);
		pVertexConsumer.addVertex(pMatrix4f, pScale, pScale, -pScale).setColor(r4, g4, b4, pAlpha);
		pVertexConsumer.addVertex(pMatrix4f, -pScale, pScale, -pScale).setColor(r2, g2, b2, pAlpha);
		pVertexConsumer.addVertex(pMatrix4f, -pScale, pScale, pScale).setColor(r1, g1, b1, pAlpha);

		pVertexConsumer.addVertex(pMatrix4f, -pScale, -pScale, -pScale).setColor(r3, g3, b3, pAlpha);
		pVertexConsumer.addVertex(pMatrix4f, pScale, -pScale, -pScale).setColor(r5, g5, b5, pAlpha);
		pVertexConsumer.addVertex(pMatrix4f, pScale, -pScale, pScale).setColor(r7, g7, b7, pAlpha);
		pVertexConsumer.addVertex(pMatrix4f, -pScale, -pScale, pScale).setColor(r0, g0, b0, pAlpha);
	}

	@Override
	public BubbleSpellRenderState createRenderState() {
		return new BubbleSpellRenderState();
	}
}
