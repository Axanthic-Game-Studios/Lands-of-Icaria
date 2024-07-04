package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.model.CrawlerRevenantModel;
import com.axanthic.icaria.common.entity.CrawlerRevenantEntity;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.HumanoidArm;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CrawlerRevenantItemLayer extends RenderLayer<CrawlerRevenantEntity, CrawlerRevenantModel> {
    public CrawlerRevenantItemLayer(RenderLayerParent<CrawlerRevenantEntity, CrawlerRevenantModel> pRenderer) {
        super(pRenderer);
    }

    @Override
    public void render(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, CrawlerRevenantEntity pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTick, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        pPoseStack.pushPose();
        this.getParentModel().translateToHand(HumanoidArm.RIGHT, pPoseStack);
        IcariaClientHelper.setPart(pPoseStack, this.getParentModel().armRightLower);
        IcariaClientHelper.setPositionAndRotation(pPoseStack, -0.090F, 0.045F, -0.040F, 260.0F, 180.0F, 0.0F);
        IcariaClientHelper.setItem(pPoseStack, pBuffer, pPackedLight, pLivingEntity);
        pPoseStack.popPose();
    }
}
