package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.model.ClusterSlugModel;
import com.axanthic.icaria.client.state.ClusterSlugRenderState;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ClusterSlugRaysRenderLayer extends RenderLayer<ClusterSlugRenderState, ClusterSlugModel> {
	public ClusterSlugRaysRenderLayer(RenderLayerParent<ClusterSlugRenderState, ClusterSlugModel> pRenderLayerParent) {
		super(pRenderLayerParent);
	}

	@Override
	public void submit(PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, int pLightCoords, ClusterSlugRenderState pRenderState, float pYRot, float pXRot) {
		this.center(pPoseStack, pRenderState, pSubmitNodeCollector);
		this.neck(pPoseStack, pRenderState, pSubmitNodeCollector);
		this.rear(pPoseStack, pRenderState, pSubmitNodeCollector);
	}

	public void center(PoseStack pPoseStack, ClusterSlugRenderState pRenderState, SubmitNodeCollector pSubmitNodeCollector) {
		pPoseStack.pushPose();
		this.getParentModel().translateToCenter(pPoseStack);
		IcariaClientHelper.setPositionAndSize(pPoseStack, -0.060F, -0.055F, -0.310F, 0.375F);
		IcariaClientHelper.submitRays(pSubmitNodeCollector, pPoseStack, pRenderState.livingEntity, pRenderState.red, pRenderState.green, pRenderState.blue);
		pPoseStack.popPose();
	}

	public void neck(PoseStack pPoseStack, ClusterSlugRenderState pRenderState, SubmitNodeCollector pSubmitNodeCollector) {
		pPoseStack.pushPose();
		this.getParentModel().translateToNeck(pPoseStack);
		IcariaClientHelper.setPositionAndSize(pPoseStack, 0.125F, -0.060F, -0.095F, 0.375F);
		IcariaClientHelper.submitRays(pSubmitNodeCollector, pPoseStack, pRenderState.livingEntity, pRenderState.red, pRenderState.green, pRenderState.blue);
		pPoseStack.popPose();
	}

	public void rear(PoseStack pPoseStack, ClusterSlugRenderState pRenderState, SubmitNodeCollector pSubmitNodeCollector) {
		pPoseStack.pushPose();
		this.getParentModel().translateToRear(pPoseStack);
		IcariaClientHelper.setPositionAndSize(pPoseStack, 0.090F, -0.060F, 0.165F, 0.375F);
		IcariaClientHelper.submitRays(pSubmitNodeCollector, pPoseStack, pRenderState.livingEntity, pRenderState.red, pRenderState.green, pRenderState.blue);
		pPoseStack.popPose();
	}
}
