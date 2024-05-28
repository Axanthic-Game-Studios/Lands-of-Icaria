package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.registry.IcariaRenderTypes;
import com.axanthic.icaria.client.model.CrawlerRevenantModel;
import com.axanthic.icaria.common.entity.CrawlerRevenantEntity;
import com.axanthic.icaria.client.helper.IcariaClientHelper;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class CrawlerRevenantEmissiveLayer extends RenderLayer<CrawlerRevenantEntity, CrawlerRevenantModel> {
    public CrawlerRevenantEmissiveLayer(RenderLayerParent<CrawlerRevenantEntity, CrawlerRevenantModel> pRenderer) {
        super(pRenderer);
    }

    @Override
    public void render(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, CrawlerRevenantEntity pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTick, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        this.getParentModel().renderToBuffer(pPoseStack, pBuffer.getBuffer(IcariaRenderTypes.CRAWLER_REVENANT_EMISSIVE), LightTexture.FULL_SKY, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, !pLivingEntity.isInvisible() ? IcariaClientHelper.getLightBasedAlpha(pLivingEntity, pPartialTick) : 0.0F);
    }
}
