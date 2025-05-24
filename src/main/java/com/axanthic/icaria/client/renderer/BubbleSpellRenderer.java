package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.registry.IcariaRenderTypes;
import com.axanthic.icaria.client.state.BubbleSpellRenderState;
import com.axanthic.icaria.common.entity.BubbleSpellEntity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.RandomSource;

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
	public void render(BubbleSpellRenderState pRenderState, PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight) {
		pPoseStack.pushPose();

		var randomSource = RandomSource.create(pRenderState.id);

		var matrix4f = pPoseStack.last().pose();

		var vertexConsumer = pMultiBufferSource.getBuffer(IcariaRenderTypes.ADDITIVE);

		var alpha = 0.25F;

		var scale = 0.25F;

		var speed = 0.5F;

		var ticks = pRenderState.ageInTicks;

		var r0 = randomSource.nextFloat();
		var g0 = randomSource.nextFloat();
		var b0 = randomSource.nextFloat();
		var r1 = randomSource.nextFloat();
		var g1 = randomSource.nextFloat();
		var b1 = randomSource.nextFloat();
		var r2 = randomSource.nextFloat();
		var g2 = randomSource.nextFloat();
		var b2 = randomSource.nextFloat();
		var r3 = randomSource.nextFloat();
		var g3 = randomSource.nextFloat();
		var b3 = randomSource.nextFloat();
		var r4 = randomSource.nextFloat();
		var g4 = randomSource.nextFloat();
		var b4 = randomSource.nextFloat();
		var r5 = randomSource.nextFloat();
		var g5 = randomSource.nextFloat();
		var b5 = randomSource.nextFloat();
		var r6 = randomSource.nextFloat();
		var g6 = randomSource.nextFloat();
		var b6 = randomSource.nextFloat();
		var r7 = randomSource.nextFloat();
		var g7 = randomSource.nextFloat();
		var b7 = randomSource.nextFloat();

		pPoseStack.translate(0.0D, 0.25D, 0.0D);

		pPoseStack.mulPose(Axis.XP.rotationDegrees(randomSource.nextFloat() * 360.0F + speed * ticks));
		pPoseStack.mulPose(Axis.YP.rotationDegrees(randomSource.nextFloat() * 360.0F + speed * ticks));
		pPoseStack.mulPose(Axis.ZP.rotationDegrees(randomSource.nextFloat() * 360.0F + speed * ticks));

		vertexConsumer.addVertex(matrix4f, -scale, -scale, scale).setColor(r0, g0, b0, alpha);
		vertexConsumer.addVertex(matrix4f, -scale, scale, scale).setColor(r1, g1, b1, alpha);
		vertexConsumer.addVertex(matrix4f, -scale, scale, -scale).setColor(r2, g2, b2, alpha);
		vertexConsumer.addVertex(matrix4f, -scale, -scale, -scale).setColor(r3, g3, b3, alpha);

		vertexConsumer.addVertex(matrix4f, -scale, -scale, -scale).setColor(r3, g3, b3, alpha);
		vertexConsumer.addVertex(matrix4f, -scale, scale, -scale).setColor(r2, g2, b2, alpha);
		vertexConsumer.addVertex(matrix4f, scale, scale, -scale).setColor(r4, g4, b4, alpha);
		vertexConsumer.addVertex(matrix4f, scale, -scale, -scale).setColor(r5, g5, b5, alpha);

		vertexConsumer.addVertex(matrix4f, scale, -scale, -scale).setColor(r5, g5, b5, alpha);
		vertexConsumer.addVertex(matrix4f, scale, scale, -scale).setColor(r4, g4, b4, alpha);
		vertexConsumer.addVertex(matrix4f, scale, scale, scale).setColor(r6, g6, b6, alpha);
		vertexConsumer.addVertex(matrix4f, scale, -scale, scale).setColor(r7, g7, b7, alpha);

		vertexConsumer.addVertex(matrix4f, scale, -scale, scale).setColor(r7, g7, b7, alpha);
		vertexConsumer.addVertex(matrix4f, scale, scale, scale).setColor(r6, g6, b6, alpha);
		vertexConsumer.addVertex(matrix4f, -scale, scale, scale).setColor(r1, g1, b1, alpha);
		vertexConsumer.addVertex(matrix4f, -scale, -scale, scale).setColor(r0, g0, b0, alpha);

		vertexConsumer.addVertex(matrix4f, scale, scale, scale).setColor(r6, g6, b6, alpha);
		vertexConsumer.addVertex(matrix4f, scale, scale, -scale).setColor(r4, g4, b4, alpha);
		vertexConsumer.addVertex(matrix4f, -scale, scale, -scale).setColor(r2, g2, b2, alpha);
		vertexConsumer.addVertex(matrix4f, -scale, scale, scale).setColor(r1, g1, b1, alpha);

		vertexConsumer.addVertex(matrix4f, -scale, -scale, -scale).setColor(r3, g3, b3, alpha);
		vertexConsumer.addVertex(matrix4f, scale, -scale, -scale).setColor(r5, g5, b5, alpha);
		vertexConsumer.addVertex(matrix4f, scale, -scale, scale).setColor(r7, g7, b7, alpha);
		vertexConsumer.addVertex(matrix4f, -scale, -scale, scale).setColor(r0, g0, b0, alpha);

		pPoseStack.popPose();

		super.render(pRenderState, pPoseStack, pMultiBufferSource, pPackedLight);
	}

	@Override
	public BubbleSpellRenderState createRenderState() {
		return new BubbleSpellRenderState();
	}
}
