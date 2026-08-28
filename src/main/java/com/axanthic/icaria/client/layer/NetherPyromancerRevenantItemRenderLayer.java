package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.model.NetherPyromancerRevenantModel;
import com.axanthic.icaria.client.state.NetherPyromancerRevenantRenderState;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.HumanoidArm;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class NetherPyromancerRevenantItemRenderLayer extends RenderLayer<NetherPyromancerRevenantRenderState, NetherPyromancerRevenantModel> {
	public NetherPyromancerRevenantItemRenderLayer(RenderLayerParent<NetherPyromancerRevenantRenderState, NetherPyromancerRevenantModel> pRenderLayerParent) {
		super(pRenderLayerParent);
	}

	@Override
	public void submit(PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, int pPackedLight, NetherPyromancerRevenantRenderState pRenderState, float yRot, float xRot) {
		pPoseStack.pushPose();
		this.getParentModel().translateToHand(pRenderState, HumanoidArm.RIGHT, pPoseStack);
		IcariaClientHelper.setPart(pPoseStack, this.getParentModel().armRightLower);
		IcariaClientHelper.setPositionAndRotation(pPoseStack, 0.0F, 0.030F, 0.010F, 260.0F, 180.0F, 0.0F);
		pRenderState.itemStackRenderState.submit(pPoseStack, pSubmitNodeCollector, pPackedLight, OverlayTexture.NO_OVERLAY, 0);
		pPoseStack.popPose();
	}
}
