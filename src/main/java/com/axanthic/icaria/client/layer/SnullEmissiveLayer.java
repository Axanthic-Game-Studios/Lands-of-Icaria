package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.model.SnullModel;
import com.axanthic.icaria.client.registry.IcariaRenderTypes;
import com.axanthic.icaria.common.entity.SnullEntity;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;

import java.awt.*;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class SnullEmissiveLayer extends RenderLayer<SnullEntity, SnullModel> {
    public SnullEmissiveLayer(RenderLayerParent<SnullEntity, SnullModel> pRenderer) {
        super(pRenderer);
    }

    @Override
    public void render(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, SnullEntity pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTick, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        Color color = Color.getHSBColor(pAgeInTicks * 0.1F, 1.0F, 1.0F);
        this.getParentModel().renderToBuffer(pPoseStack, pBuffer.getBuffer(IcariaRenderTypes.SNULL_EMISSIVE), LightTexture.FULL_SKY, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, !pLivingEntity.isInvisible() ? IcariaClientHelper.getLightBasedAlpha(pLivingEntity, pPartialTick) : 0.0F);
        if (pLivingEntity.getCustomName() != null && pLivingEntity.getCustomName().getString().equals("Pro")) {
            this.getParentModel().renderToBuffer(pPoseStack, pBuffer.getBuffer(IcariaRenderTypes.SNULL_EYES), LightTexture.FULL_SKY, OverlayTexture.NO_OVERLAY, color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, !pLivingEntity.isInvisible() ? IcariaClientHelper.getLightBasedAlpha(pLivingEntity, pPartialTick) : 0.0F);
        } else if (pLivingEntity.getCustomName() != null && pLivingEntity.getCustomName().getString().equals("Sans")) {
            this.getParentModel().renderToBuffer(pPoseStack, pBuffer.getBuffer(IcariaRenderTypes.SNULL_SANS), LightTexture.FULL_SKY, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, !pLivingEntity.isInvisible() ? IcariaClientHelper.getLightBasedAlpha(pLivingEntity, pPartialTick) : 0.0F);
        }
    }
}
