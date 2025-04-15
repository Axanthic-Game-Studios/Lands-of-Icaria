package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.model.PyromancerRevenantModel;
import com.axanthic.icaria.client.state.PyromancerRevenantRenderState;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.HumanoidArm;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class PyromancerRevenantItemLayer extends RenderLayer<PyromancerRevenantRenderState, PyromancerRevenantModel> {
	public PyromancerRevenantItemLayer(RenderLayerParent<PyromancerRevenantRenderState, PyromancerRevenantModel> pRenderLayerParent) {
		super(pRenderLayerParent);
	}

	@Override
	public void render(PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight, PyromancerRevenantRenderState pRenderState, float pYRot, float pXRot) {
		pPoseStack.pushPose();
		this.getParentModel().translateToHand(HumanoidArm.RIGHT, pPoseStack);
		IcariaClientHelper.setPart(pPoseStack, this.getParentModel().armRightLower);
		IcariaClientHelper.setPositionAndRotation(pPoseStack, 0.0F, 0.030F, 0.010F, 260.0F, 180.0F, 0.0F);
		IcariaClientHelper.setItem(pPoseStack, pMultiBufferSource, pRenderState.livingEntity, pPackedLight);
		pPoseStack.popPose();
	}
}
