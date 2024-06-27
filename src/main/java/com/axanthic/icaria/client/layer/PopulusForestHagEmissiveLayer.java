package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.model.PopulusForestHagModel;
import com.axanthic.icaria.client.registry.IcariaRenderTypes;
import com.axanthic.icaria.common.entity.ForestHagEntity;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class PopulusForestHagEmissiveLayer extends RenderLayer<ForestHagEntity, PopulusForestHagModel> {
    public PopulusForestHagEmissiveLayer(RenderLayerParent<ForestHagEntity, PopulusForestHagModel> pRenderer) {
        super(pRenderer);
    }

    @Override
    public void render(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, ForestHagEntity pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTick, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        this.getParentModel().renderToBuffer(pPoseStack, pBuffer.getBuffer(IcariaRenderTypes.POPULUS_FOREST_HAG_EMISSIVE), LightTexture.FULL_SKY, OverlayTexture.NO_OVERLAY, IcariaClientHelper.getColorAndAlpha(pLivingEntity, pLivingEntity.isTargeting()));
    }
}
