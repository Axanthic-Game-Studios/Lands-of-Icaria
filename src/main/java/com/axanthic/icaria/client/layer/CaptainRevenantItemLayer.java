package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.model.CaptainRevenantModel;
import com.axanthic.icaria.common.entity.CaptainRevenantEntity;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.HumanoidArm;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CaptainRevenantItemLayer extends RenderLayer<CaptainRevenantEntity, CaptainRevenantModel> {
	public CaptainRevenantItemLayer(RenderLayerParent<CaptainRevenantEntity, CaptainRevenantModel> pRenderer) {
		super(pRenderer);
	}

	@Override
	public void render(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, CaptainRevenantEntity pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTick, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		if (pLivingEntity.getUnequips() < pLivingEntity.maxUnequips / 2 && pLivingEntity.onRallying() || pLivingEntity.getReequips() >= pLivingEntity.maxReequips / 2) {
			this.back(pPoseStack, pBuffer, pPackedLight, pLivingEntity);
		} else {
			this.hand(pPoseStack, pBuffer, pPackedLight, pLivingEntity);
		}
	}

	public void back(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, CaptainRevenantEntity pLivingEntity) {
		pPoseStack.pushPose();
		this.getParentModel().translateToBelt(pPoseStack);
		IcariaClientHelper.setPart(pPoseStack, this.getParentModel().beltMain);
		IcariaClientHelper.setPositionAndRotation(pPoseStack, -0.250F, -0.100F, -0.200F, 270.0F, 100.0F, 90.0F);
		IcariaClientHelper.setItem(pPoseStack, pBuffer, pPackedLight, pLivingEntity);
		pPoseStack.popPose();
	}

	public void hand(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, CaptainRevenantEntity pLivingEntity) {
		pPoseStack.pushPose();
		this.getParentModel().translateToHand(HumanoidArm.RIGHT, pPoseStack);
		IcariaClientHelper.setPart(pPoseStack, this.getParentModel().armRightLower);
		IcariaClientHelper.setPositionAndRotation(pPoseStack, -0.050F, 0.100F, 0.040F, 260.0F, 180.0F, 0.0F);
		IcariaClientHelper.setItem(pPoseStack, pBuffer, pPackedLight, pLivingEntity);
		pPoseStack.popPose();
	}
}
