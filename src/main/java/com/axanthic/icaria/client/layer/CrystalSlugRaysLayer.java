package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.model.CrystalSlugModel;
import com.axanthic.icaria.common.entity.SlugEntity;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CrystalSlugRaysLayer extends RenderLayer<SlugEntity, CrystalSlugModel> {
	public CrystalSlugRaysLayer(RenderLayerParent<SlugEntity, CrystalSlugModel> pRenderer) {
		super(pRenderer);
	}

	@Override
	public void render(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, SlugEntity pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTick, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.neck(pPoseStack, pBuffer, pLivingEntity, pPartialTick);
		this.center(pPoseStack, pBuffer, pLivingEntity, pPartialTick);
		this.rear(pPoseStack, pBuffer, pLivingEntity, pPartialTick);
	}

	public void neck(PoseStack pPoseStack, MultiBufferSource pBuffer, SlugEntity pLivingEntity, float pPartialTick) {
		pPoseStack.pushPose();
		this.getParentModel().translateToNeck(pPoseStack);
		IcariaClientHelper.setPositionAndSize(pPoseStack, 0.125F, -0.060F, -0.095F, 0.375F);
		IcariaClientHelper.renderRays(pPoseStack, pBuffer, pLivingEntity, pPartialTick, pLivingEntity.red, pLivingEntity.green, pLivingEntity.blue);
		pPoseStack.popPose();
	}

	public void center(PoseStack pPoseStack, MultiBufferSource pBuffer, SlugEntity pLivingEntity, float pPartialTick) {
		pPoseStack.pushPose();
		this.getParentModel().translateToCenter(pPoseStack);
		IcariaClientHelper.setPositionAndSize(pPoseStack, -0.060F, -0.055F, -0.310F, 0.375F);
		IcariaClientHelper.renderRays(pPoseStack, pBuffer, pLivingEntity, pPartialTick, pLivingEntity.red, pLivingEntity.green, pLivingEntity.blue);
		pPoseStack.popPose();
	}

	public void rear(PoseStack pPoseStack, MultiBufferSource pBuffer, SlugEntity pLivingEntity, float pPartialTick) {
		pPoseStack.pushPose();
		this.getParentModel().translateToRear(pPoseStack);
		IcariaClientHelper.setPositionAndSize(pPoseStack, 0.090F, -0.060F, 0.165F, 0.375F);
		IcariaClientHelper.renderRays(pPoseStack, pBuffer, pLivingEntity, pPartialTick, pLivingEntity.red, pLivingEntity.green, pLivingEntity.blue);
		pPoseStack.popPose();
	}
}
