package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.registry.IcariaRenderTypes;
import com.axanthic.icaria.client.model.SoldierRevenantModel;
import com.axanthic.icaria.common.entity.SoldierRevenantEntity;
import com.axanthic.icaria.client.helper.IcariaClientHelper;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class SoldierRevenantEmissiveLayer extends RenderLayer<SoldierRevenantEntity, SoldierRevenantModel> {
    public SoldierRevenantEmissiveLayer(RenderLayerParent<SoldierRevenantEntity, SoldierRevenantModel> pRenderer) {
        super(pRenderer);
    }

    @Override
    public void render(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, SoldierRevenantEntity pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTick, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        this.getParentModel().renderToBuffer(pPoseStack, pBuffer.getBuffer(IcariaRenderTypes.SOLDIER_REVENANT_EMISSIVE), LightTexture.FULL_SKY, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, !pLivingEntity.isInvisible() ? IcariaClientHelper.getLightBasedAlpha(pLivingEntity, pPartialTick) : 0.0F);
    }
}
