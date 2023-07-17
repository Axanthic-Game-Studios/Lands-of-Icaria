package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.model.OvergrownRevenantModel;
import com.axanthic.icaria.common.entity.OvergrownRevenantEntity;
import com.axanthic.icaria.client.helper.IcariaClientHelper;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class OvergrownRevenantRaysLayer extends RenderLayer<OvergrownRevenantEntity, OvergrownRevenantModel> {
    public OvergrownRevenantRaysLayer(RenderLayerParent<OvergrownRevenantEntity, OvergrownRevenantModel> pRenderer) {
        super(pRenderer);
    }

    @Override
    public void render(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, OvergrownRevenantEntity pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTick, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        this.head(pPoseStack, pBuffer, pLivingEntity);
        this.shoulder(pPoseStack, pBuffer, pLivingEntity);
        this.biceps(pPoseStack, pBuffer, pLivingEntity);
        this.pelvis(pPoseStack, pBuffer, pLivingEntity);
        this.foot(pPoseStack, pBuffer, pLivingEntity);
    }

    public void head(PoseStack pPoseStack, MultiBufferSource pBuffer, OvergrownRevenantEntity pLivingEntity) {
        pPoseStack.pushPose();
        this.getParentModel().translateToHead(pPoseStack);
        IcariaClientHelper.setPart(pPoseStack, this.getParentModel().headMain);
        IcariaClientHelper.setPositionAndSize(pPoseStack, -0.075F, 0.150F, -0.225F, 0.375F);
        IcariaClientHelper.renderRays(pPoseStack, pBuffer, pLivingEntity, pLivingEntity.red, pLivingEntity.green, pLivingEntity.blue);
        pPoseStack.popPose();
    }

    public void shoulder(PoseStack pPoseStack, MultiBufferSource pBuffer, OvergrownRevenantEntity pLivingEntity) {
        pPoseStack.pushPose();
        this.getParentModel().translateToShoulder(pPoseStack);
        IcariaClientHelper.setPositionAndSize(pPoseStack, -0.300F, -0.050F, 0.075F, 0.250F);
        IcariaClientHelper.renderRays(pPoseStack, pBuffer, pLivingEntity, pLivingEntity.red, pLivingEntity.green, pLivingEntity.blue);
        pPoseStack.popPose();
    }

    public void biceps(PoseStack pPoseStack, MultiBufferSource pBuffer, OvergrownRevenantEntity pLivingEntity) {
        pPoseStack.pushPose();
        this.getParentModel().translateToBiceps(pPoseStack);
        IcariaClientHelper.setPart(pPoseStack, this.getParentModel().armLeftUpper);
        IcariaClientHelper.setPositionAndSize(pPoseStack, -0.350F, 0.150F, -0.075F, 0.250F);
        IcariaClientHelper.renderRays(pPoseStack, pBuffer, pLivingEntity, pLivingEntity.red, pLivingEntity.green, pLivingEntity.blue);
        pPoseStack.popPose();
    }

    public void pelvis(PoseStack pPoseStack, MultiBufferSource pBuffer, OvergrownRevenantEntity pLivingEntity) {
        pPoseStack.pushPose();
        this.getParentModel().translateToPelvis(pPoseStack);
        IcariaClientHelper.setPositionAndSize(pPoseStack, -0.200F, -0.025F, 0.100F, 0.250F);
        IcariaClientHelper.renderRays(pPoseStack, pBuffer, pLivingEntity, pLivingEntity.red, pLivingEntity.green, pLivingEntity.blue);
        pPoseStack.popPose();
    }

    public void foot(PoseStack pPoseStack, MultiBufferSource pBuffer, OvergrownRevenantEntity pLivingEntity) {
        pPoseStack.pushPose();
        this.getParentModel().translateToFoot(pPoseStack);
        IcariaClientHelper.setPart(pPoseStack, this.getParentModel().legLeft);
        IcariaClientHelper.setPositionAndSize(pPoseStack, 0.0F, -0.150F, 0.0F, 0.250F);
        IcariaClientHelper.renderRays(pPoseStack, pBuffer, pLivingEntity, pLivingEntity.red, pLivingEntity.green, pLivingEntity.blue);
        pPoseStack.popPose();
    }
}
