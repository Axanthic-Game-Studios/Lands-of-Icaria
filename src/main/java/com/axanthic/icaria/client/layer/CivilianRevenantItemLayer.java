package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.model.CivilianRevenantModel;
import com.axanthic.icaria.client.state.CivilianRevenantRenderState;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.HumanoidArm;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CivilianRevenantItemLayer extends RenderLayer<CivilianRevenantRenderState, CivilianRevenantModel> {
	public CivilianRevenantItemLayer(RenderLayerParent<CivilianRevenantRenderState, CivilianRevenantModel> pRenderLayerParent) {
		super(pRenderLayerParent);
	}

	@Override
	public void render(PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight, CivilianRevenantRenderState pRenderState, float pYRot, float pXRot) {
		pPoseStack.pushPose();
		this.getParentModel().translateToHand(HumanoidArm.RIGHT, pPoseStack);
		IcariaClientHelper.setPart(pPoseStack, this.getParentModel().armRightLower);
		IcariaClientHelper.setPositionAndRotation(pPoseStack, 0.050F, 0.030F, 0.060F, 260.0F, 180.0F, 0.0F);
		IcariaClientHelper.setItem(pPoseStack, pMultiBufferSource, pRenderState.livingEntity, pPackedLight);
		pPoseStack.popPose();
	}
}
