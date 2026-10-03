package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.client.state.BarrelRenderState;
import com.axanthic.icaria.common.entity.IcariaBarrelEntity;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.block.BlockModelRenderState;
import net.minecraft.client.renderer.block.BlockModelResolver;
import net.minecraft.client.renderer.block.model.BlockDisplayContext;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class BarrelRenderer extends EntityRenderer<IcariaBarrelEntity, BarrelRenderState> {
	public BlockModelResolver blockModelResolver;

	public BarrelRenderer(EntityRendererProvider.Context pContext) {
		super(pContext);
		this.blockModelResolver = pContext.getBlockModelResolver();
	}

	@Override
	public void extractRenderState(IcariaBarrelEntity pEntity, BarrelRenderState pRenderState, float pPartialTicks) {
		super.extractRenderState(pEntity, pRenderState, pPartialTicks);
		pRenderState.blockModelRenderState = new BlockModelRenderState();
		pRenderState.blockState = pEntity.getBlockState();
		this.blockModelResolver.update(pRenderState.blockModelRenderState, pRenderState.blockState, BlockDisplayContext.create());
	}

	@Override
	public void submit(BarrelRenderState pRenderState, PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, CameraRenderState pCameraRenderState) {
		pPoseStack.pushPose();
		pPoseStack.translate(-0.5D, 0.0D, -0.5D);
		pRenderState.blockModelRenderState.submit(pPoseStack, pSubmitNodeCollector, pRenderState.lightCoords, OverlayTexture.NO_OVERLAY, pRenderState.outlineColor);
		pPoseStack.popPose();
		super.submit(pRenderState, pPoseStack, pSubmitNodeCollector, pCameraRenderState);
	}

	@Override
	public BarrelRenderState createRenderState() {
		return new BarrelRenderState();
	}
}
