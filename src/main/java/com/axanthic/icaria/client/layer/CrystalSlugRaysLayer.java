package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.model.CrystalSlugModel;
import com.axanthic.icaria.client.state.CrystalSlugRenderState;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CrystalSlugRaysLayer extends RenderLayer<CrystalSlugRenderState, CrystalSlugModel> {
	public CrystalSlugRaysLayer(RenderLayerParent<CrystalSlugRenderState, CrystalSlugModel> pRenderLayerParent) {
		super(pRenderLayerParent);
	}

	@Override
	public void render(PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight, CrystalSlugRenderState pRenderState, float pYRot, float pXRot) {
		this.center(pRenderState, pPoseStack, pMultiBufferSource);
		this.neck(pRenderState, pPoseStack, pMultiBufferSource);
		this.rear(pRenderState, pPoseStack, pMultiBufferSource);
	}

	public void center(CrystalSlugRenderState pRenderState, PoseStack pPoseStack, MultiBufferSource pMultiBufferSource) {
		pPoseStack.pushPose();
		this.getParentModel().translateToCenter(pPoseStack);
		IcariaClientHelper.setPositionAndSize(pPoseStack, -0.060F, -0.055F, -0.310F, 0.375F);
		IcariaClientHelper.renderRays(pPoseStack, pMultiBufferSource, pRenderState.livingEntity, pRenderState.partialTick, pRenderState.red, pRenderState.green, pRenderState.blue);
		pPoseStack.popPose();
	}

	public void neck(CrystalSlugRenderState pRenderState, PoseStack pPoseStack, MultiBufferSource pMultiBufferSource) {
		pPoseStack.pushPose();
		this.getParentModel().translateToNeck(pPoseStack);
		IcariaClientHelper.setPositionAndSize(pPoseStack, 0.125F, -0.060F, -0.095F, 0.375F);
		IcariaClientHelper.renderRays(pPoseStack, pMultiBufferSource, pRenderState.livingEntity, pRenderState.partialTick, pRenderState.red, pRenderState.green, pRenderState.blue);
		pPoseStack.popPose();
	}

	public void rear(CrystalSlugRenderState pRenderState, PoseStack pPoseStack, MultiBufferSource pMultiBufferSource) {
		pPoseStack.pushPose();
		this.getParentModel().translateToRear(pPoseStack);
		IcariaClientHelper.setPositionAndSize(pPoseStack, 0.090F, -0.060F, 0.165F, 0.375F);
		IcariaClientHelper.renderRays(pPoseStack, pMultiBufferSource, pRenderState.livingEntity, pRenderState.partialTick, pRenderState.red, pRenderState.green, pRenderState.blue);
		pPoseStack.popPose();
	}
}
