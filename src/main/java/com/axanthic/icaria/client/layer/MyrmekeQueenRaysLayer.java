package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.model.MyrmekeQueenModel;
import com.axanthic.icaria.common.entity.MyrmekeQueenEntity;
import com.axanthic.icaria.client.helper.IcariaClientHelper;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class MyrmekeQueenRaysLayer extends RenderLayer<MyrmekeQueenEntity, MyrmekeQueenModel> {
    public MyrmekeQueenRaysLayer(RenderLayerParent<MyrmekeQueenEntity, MyrmekeQueenModel> pRenderer) {
        super(pRenderer);
    }

    @Override
    public void render(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, MyrmekeQueenEntity pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTick, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        pPoseStack.pushPose();
        this.getParentModel().translateToHead(pPoseStack);
        IcariaClientHelper.setPart(pPoseStack, this.getParentModel().head);
        IcariaClientHelper.setPositionAndSize(pPoseStack, -0.010F, -1.265F, 0.185F, 0.375F);
        IcariaClientHelper.renderRays(pPoseStack, pBuffer, pLivingEntity, pLivingEntity.red, pLivingEntity.green, pLivingEntity.blue);
        pPoseStack.popPose();
    }
}
