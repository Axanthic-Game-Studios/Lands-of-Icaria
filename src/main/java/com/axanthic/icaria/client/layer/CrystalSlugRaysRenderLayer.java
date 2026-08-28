package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.model.CrystalSlugModel;
import com.axanthic.icaria.client.state.CrystalSlugRenderState;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CrystalSlugRaysRenderLayer extends RenderLayer<CrystalSlugRenderState, CrystalSlugModel> {
	public CrystalSlugRaysRenderLayer(RenderLayerParent<CrystalSlugRenderState, CrystalSlugModel> pRenderLayerParent) {
		super(pRenderLayerParent);
	}

	@Override
	public void submit(PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, int pPackedLight, CrystalSlugRenderState pRenderState, float pYRot, float pXRot) {
		this.center(pPoseStack, pRenderState, pSubmitNodeCollector);
		this.neck(pPoseStack, pRenderState, pSubmitNodeCollector);
		this.rear(pPoseStack, pRenderState, pSubmitNodeCollector);
	}

	public void center(PoseStack pPoseStack, CrystalSlugRenderState pRenderState, SubmitNodeCollector pSubmitNodeCollector) {
		pPoseStack.pushPose();
		this.getParentModel().translateToCenter(pPoseStack);
		IcariaClientHelper.setPositionAndSize(pPoseStack, -0.060F, -0.055F, -0.310F, 0.375F);
		IcariaClientHelper.submitRays(pSubmitNodeCollector, pPoseStack, pRenderState.livingEntity, pRenderState.partialTick, pRenderState.red, pRenderState.green, pRenderState.blue);
		pPoseStack.popPose();
	}

	public void neck(PoseStack pPoseStack, CrystalSlugRenderState pRenderState, SubmitNodeCollector pSubmitNodeCollector) {
		pPoseStack.pushPose();
		this.getParentModel().translateToNeck(pPoseStack);
		IcariaClientHelper.setPositionAndSize(pPoseStack, 0.125F, -0.060F, -0.095F, 0.375F);
		IcariaClientHelper.submitRays(pSubmitNodeCollector, pPoseStack, pRenderState.livingEntity, pRenderState.partialTick, pRenderState.red, pRenderState.green, pRenderState.blue);
		pPoseStack.popPose();
	}

	public void rear(PoseStack pPoseStack, CrystalSlugRenderState pRenderState, SubmitNodeCollector pSubmitNodeCollector) {
		pPoseStack.pushPose();
		this.getParentModel().translateToRear(pPoseStack);
		IcariaClientHelper.setPositionAndSize(pPoseStack, 0.090F, -0.060F, 0.165F, 0.375F);
		IcariaClientHelper.submitRays(pSubmitNodeCollector, pPoseStack, pRenderState.livingEntity, pRenderState.partialTick, pRenderState.red, pRenderState.green, pRenderState.blue);
		pPoseStack.popPose();
	}
}
