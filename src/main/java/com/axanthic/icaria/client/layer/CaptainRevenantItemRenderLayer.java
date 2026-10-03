package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.model.CaptainRevenantModel;
import com.axanthic.icaria.client.state.CaptainRevenantRenderState;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.HumanoidArm;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CaptainRevenantItemRenderLayer extends RenderLayer<CaptainRevenantRenderState, CaptainRevenantModel> {
	public CaptainRevenantItemRenderLayer(RenderLayerParent<CaptainRevenantRenderState, CaptainRevenantModel> pRenderLayerParent) {
		super(pRenderLayerParent);
	}

	@Override
	public void submit(PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, int pLightCoords, CaptainRevenantRenderState pRenderState, float pYRot, float pXRot) {
		if (pRenderState.unequips < pRenderState.maxUnequips / 2 && pRenderState.onRallying || pRenderState.reequips >= pRenderState.maxReequips / 2) {
			this.back(pSubmitNodeCollector, pRenderState, pPoseStack, pLightCoords);
		} else {
			this.hand(pSubmitNodeCollector, pRenderState, pPoseStack, pLightCoords);
		}
	}

	public void back(SubmitNodeCollector pSubmitNodeCollector, CaptainRevenantRenderState pRenderState, PoseStack pPoseStack, int pLightCoords) {
		pPoseStack.pushPose();
		this.getParentModel().translateToBack(pPoseStack);
		IcariaClientHelper.setPart(pPoseStack, this.getParentModel().beltMain);
		IcariaClientHelper.setPositionAndRotation(pPoseStack, -0.250F, -0.100F, -0.200F, 270.0F, 100.0F, 90.0F);
		pRenderState.itemStackRenderState.submit(pPoseStack, pSubmitNodeCollector, pLightCoords, OverlayTexture.NO_OVERLAY, pRenderState.outlineColor);
		pPoseStack.popPose();
	}

	public void hand(SubmitNodeCollector pSubmitNodeCollector, CaptainRevenantRenderState pRenderState, PoseStack pPoseStack, int pLightCoords) {
		pPoseStack.pushPose();
		this.getParentModel().translateToHand(pRenderState, HumanoidArm.RIGHT, pPoseStack);
		IcariaClientHelper.setPart(pPoseStack, this.getParentModel().armRightLower);
		IcariaClientHelper.setPositionAndRotation(pPoseStack, -0.050F, 0.100F, 0.040F, 260.0F, 180.0F, 0.0F);
		pRenderState.itemStackRenderState.submit(pPoseStack, pSubmitNodeCollector, pLightCoords, OverlayTexture.NO_OVERLAY, pRenderState.outlineColor);
		pPoseStack.popPose();
	}
}
