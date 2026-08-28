package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.registry.IcariaRenderTypes;
import com.axanthic.icaria.client.state.SpellRenderState;
import com.axanthic.icaria.common.entity.SpellEntity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.Mth;

import org.joml.Matrix4f;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SpellRenderer extends EntityRenderer<SpellEntity, SpellRenderState> {
	public SpellRenderer(EntityRendererProvider.Context pContext) {
		super(pContext);
	}

	public float getX(float pLength, float pSpeed, float pTicks, float pWiggle) {
		return Mth.cos(pLength / 3.5F - pSpeed * pTicks / 2.0F) * pLength * pWiggle + Mth.cos(pLength / 2.0F - pSpeed * pTicks / 3.5F + 3.0F) * pLength * pWiggle + Mth.sin(pLength / 7.5F - pSpeed * pTicks / 6.0F + 2.0F) * pLength * pWiggle + Mth.sin(-pSpeed * pTicks / 5.0F + 2.0F) * pLength * pWiggle;
	}

	public float getY(float pLength, float pSpeed, float pTicks, float pWiggle) {
		return Mth.sin(pLength / 2.5F - pSpeed * pTicks / 3.0F) * pLength * pWiggle + Mth.sin(pLength / 3.0F - pSpeed * pTicks / 2.5F + 2.0F) * pLength * pWiggle + Mth.cos(pLength / 7.0F - pSpeed * pTicks / 6.5F + 3.0F) * pLength * pWiggle + Mth.cos(-pSpeed * pTicks / 4.0F + 3.0F) * pLength * pWiggle;
	}

	@Override
	public void extractRenderState(SpellEntity pEntity, SpellRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.xRot = pEntity.getXRot();
		pRenderState.xRotOld = pEntity.xRotO;
		pRenderState.yRot = pEntity.getYRot();
		pRenderState.yRotOld = pEntity.yRotO;
		pRenderState.color = pEntity.getColor();
	}

	@Override
	public void submit(SpellRenderState pRenderState, PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, CameraRenderState pCameraRenderState) {
		pPoseStack.pushPose();

		var color = pRenderState.color;
		var ticks = pRenderState.ageInTicks;

		var distance = 25.0F;
		var length = 50.0F;
		var speed = 1.5F;
		var wiggle = 0.0025F;

		var red = (color >> 16 & 255) / 255.0F;
		var green = (color >> 8 & 255) / 255.0F;
		var blue = (color & 255) / 255.0F;

		pPoseStack.translate(0.0D, 0.25D, 0.0D);

		pPoseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(pRenderState.partialTick, pRenderState.yRotOld, pRenderState.yRot) + 180.0F));
		pPoseStack.mulPose(Axis.XP.rotationDegrees(Mth.lerp(pRenderState.partialTick, pRenderState.xRotOld, pRenderState.xRot) + 90.0F));

		for (var f = 0.0F; f < length; f++) {
			var alpha = (length - f) / length;
			var width = (length - f) / length * 0.25F;

			var x = this.getX(f, speed, ticks, wiggle);
			var y = this.getY(f, speed, ticks, wiggle);

			var resolution = f / distance;

			pSubmitNodeCollector.submitCustomGeometry(pPoseStack, IcariaRenderTypes.ADDITIVE_TEXTURED, (pose, vertexConsumer) -> this.submit(pose.pose(), pRenderState, vertexConsumer, red, green, blue, alpha, x - width, x + width, resolution, y + width, y - width));
			pSubmitNodeCollector.submitCustomGeometry(pPoseStack, IcariaRenderTypes.ADDITIVE_TEXTURED, (pose, vertexConsumer) -> this.submit(pose.pose(), pRenderState, vertexConsumer, red, green, blue, alpha, x + width, x - width, resolution, y + width, y - width));
		}

		pPoseStack.popPose();

		super.submit(pRenderState, pPoseStack, pSubmitNodeCollector, pCameraRenderState);
	}

	public void submit(Matrix4f pMatrix4f, SpellRenderState pRenderState, VertexConsumer pVertexConsumer, float pRed, float pGreen, float pBlue, float pAlpha, float pXMin, float pXMax, float pY, float pZMin, float pZMax) {
		pVertexConsumer.addVertex(pMatrix4f, pXMin, pY, pZMin).setColor(pRed, pGreen, pBlue, pAlpha).setLight(pRenderState.lightCoords).setNormal(1.0F, 1.0F, 1.0F).setOverlay(OverlayTexture.NO_OVERLAY).setUv(0.0F, 1.0F);
		pVertexConsumer.addVertex(pMatrix4f, pXMax, pY, pZMin).setColor(pRed, pGreen, pBlue, pAlpha).setLight(pRenderState.lightCoords).setNormal(1.0F, 1.0F, 1.0F).setOverlay(OverlayTexture.NO_OVERLAY).setUv(1.0F, 1.0F);
		pVertexConsumer.addVertex(pMatrix4f, pXMax, pY, pZMax).setColor(pRed, pGreen, pBlue, pAlpha).setLight(pRenderState.lightCoords).setNormal(1.0F, 1.0F, 1.0F).setOverlay(OverlayTexture.NO_OVERLAY).setUv(1.0F, 0.0F);
		pVertexConsumer.addVertex(pMatrix4f, pXMin, pY, pZMax).setColor(pRed, pGreen, pBlue, pAlpha).setLight(pRenderState.lightCoords).setNormal(1.0F, 1.0F, 1.0F).setOverlay(OverlayTexture.NO_OVERLAY).setUv(0.0F, 0.0F);
	}

	@Override
	public SpellRenderState createRenderState() {
		return new SpellRenderState();
	}
}
