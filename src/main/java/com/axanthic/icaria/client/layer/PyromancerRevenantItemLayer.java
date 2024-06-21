package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.model.PyromancerRevenantModel;
import com.axanthic.icaria.common.entity.PyromancerRevenantEntity;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.HumanoidArm;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class PyromancerRevenantItemLayer extends RenderLayer<PyromancerRevenantEntity, PyromancerRevenantModel> {
    public PyromancerRevenantItemLayer(RenderLayerParent<PyromancerRevenantEntity, PyromancerRevenantModel> pRenderer) {
        super(pRenderer);
    }

    @Override
    public void render(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, PyromancerRevenantEntity pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTick, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        pPoseStack.pushPose();
        this.getParentModel().translateToHand(HumanoidArm.RIGHT, pPoseStack);
        IcariaClientHelper.setPart(pPoseStack, this.getParentModel().armRightLower);
        IcariaClientHelper.setPositionAndRotation(pPoseStack, 0.0F, 0.030F, 0.010F, 260.0F, 180.0F, 0.0F);
        IcariaClientHelper.setItem(pPoseStack, pBuffer, pPackedLight, pLivingEntity);
        pPoseStack.popPose();
    }
}
