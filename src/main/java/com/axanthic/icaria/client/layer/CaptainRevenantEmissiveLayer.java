package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.registry.IcariaRenderTypes;
import com.axanthic.icaria.client.model.CaptainRevenantModel;
import com.axanthic.icaria.common.entity.CaptainRevenantEntity;
import com.axanthic.icaria.client.helper.IcariaClientHelper;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class CaptainRevenantEmissiveLayer extends RenderLayer<CaptainRevenantEntity, CaptainRevenantModel> {
    public CaptainRevenantEmissiveLayer(RenderLayerParent<CaptainRevenantEntity, CaptainRevenantModel> pRenderer) {
        super(pRenderer);
    }

    @Override
    public void render(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, CaptainRevenantEntity pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTick, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        this.getParentModel().renderToBuffer(pPoseStack, pBuffer.getBuffer(IcariaRenderTypes.CAPTAIN_REVENANT_EMISSIVE), LightTexture.FULL_SKY, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, !pLivingEntity.isInvisible() ? IcariaClientHelper.getLightBasedAlpha(pLivingEntity, pPartialTick) : 0.0F);
    }
}
