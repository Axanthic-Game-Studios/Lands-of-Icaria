package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.model.PyromancerRevenantModel;
import com.axanthic.icaria.client.state.PyromancerRevenantRenderState;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.HumanoidArm;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class PyromancerRevenantItemRenderLayer extends RenderLayer<PyromancerRevenantRenderState, PyromancerRevenantModel> {
	public PyromancerRevenantItemRenderLayer(RenderLayerParent<PyromancerRevenantRenderState, PyromancerRevenantModel> pRenderLayerParent) {
		super(pRenderLayerParent);
	}

	@Override
	public void submit(PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, int pLightCoords, PyromancerRevenantRenderState pRenderState, float yRot, float xRot) {
		pPoseStack.pushPose();
		this.getParentModel().translateToHand(pRenderState, HumanoidArm.RIGHT, pPoseStack);
		IcariaClientHelper.setPart(pPoseStack, this.getParentModel().armRightLower);
		IcariaClientHelper.setPositionAndRotation(pPoseStack, 0.0F, 0.030F, 0.010F, 260.0F, 180.0F, 0.0F);
		pRenderState.itemStackRenderState.submit(pPoseStack, pSubmitNodeCollector, pLightCoords, OverlayTexture.NO_OVERLAY, pRenderState.outlineColor);
		pPoseStack.popPose();
	}
}
