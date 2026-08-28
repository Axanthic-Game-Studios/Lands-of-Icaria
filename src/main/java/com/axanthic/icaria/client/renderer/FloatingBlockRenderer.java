package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.state.FloatingBlockRenderState;
import com.axanthic.icaria.common.entity.FloatingBlockEntity;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FloatingBlockRenderer extends EntityRenderer<FloatingBlockEntity, FloatingBlockRenderState> {
	public FloatingBlockRenderer(EntityRendererProvider.Context pContext) {
		super(pContext);
	}

	@Override
	public void extractRenderState(FloatingBlockEntity pEntity, FloatingBlockRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.blockState = pEntity.getBlockState();
	}

	@Override
	public void submit(FloatingBlockRenderState pRenderState, PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, CameraRenderState pCameraRenderState) {
		pPoseStack.pushPose();
		pPoseStack.translate(-0.5D, 0.0D, -0.5D);
		pSubmitNodeCollector.submitBlock(pPoseStack, pRenderState.blockState, pRenderState.lightCoords, OverlayTexture.NO_OVERLAY, pRenderState.outlineColor);
		pPoseStack.popPose();
		super.submit(pRenderState, pPoseStack, pSubmitNodeCollector, pCameraRenderState);
	}

	@Override
	public FloatingBlockRenderState createRenderState() {
		return new FloatingBlockRenderState();
	}
}
