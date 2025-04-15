package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.model.CaptainRevenantModel;
import com.axanthic.icaria.client.state.CaptainRevenantRenderState;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CaptainRevenantItemLayer extends RenderLayer<CaptainRevenantRenderState, CaptainRevenantModel> {
	public CaptainRevenantItemLayer(RenderLayerParent<CaptainRevenantRenderState, CaptainRevenantModel> pRenderLayerParent) {
		super(pRenderLayerParent);
	}

	@Override
	public void render(PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight, CaptainRevenantRenderState pRenderState, float pYRot, float pXRot) {
		if (pRenderState.unequips < pRenderState.maxUnequips / 2 && pRenderState.onRallying || pRenderState.reequips >= pRenderState.maxReequips / 2) {
			this.back(pPoseStack, pMultiBufferSource, pRenderState.livingEntity, pPackedLight);
		} else {
			this.hand(pPoseStack, pMultiBufferSource, pRenderState.livingEntity, pPackedLight);
		}
	}

	public void back(PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, LivingEntity pLivingEntity, int pPackedLight) {
		pPoseStack.pushPose();
		this.getParentModel().translateToBack(pPoseStack);
		IcariaClientHelper.setPart(pPoseStack, this.getParentModel().beltMain);
		IcariaClientHelper.setPositionAndRotation(pPoseStack, -0.250F, -0.100F, -0.200F, 270.0F, 100.0F, 90.0F);
		IcariaClientHelper.setItem(pPoseStack, pMultiBufferSource, pLivingEntity, pPackedLight);
		pPoseStack.popPose();
	}

	public void hand(PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, LivingEntity pLivingEntity, int pPackedLight) {
		pPoseStack.pushPose();
		this.getParentModel().translateToHand(HumanoidArm.RIGHT, pPoseStack);
		IcariaClientHelper.setPart(pPoseStack, this.getParentModel().armRightLower);
		IcariaClientHelper.setPositionAndRotation(pPoseStack, -0.050F, 0.100F, 0.040F, 260.0F, 180.0F, 0.0F);
		IcariaClientHelper.setItem(pPoseStack, pMultiBufferSource, pLivingEntity, pPackedLight);
		pPoseStack.popPose();
	}
}
