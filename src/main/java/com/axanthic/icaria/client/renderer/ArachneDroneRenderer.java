package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;
import com.axanthic.icaria.client.layer.ArachneDroneEmissiveLayer;
import com.axanthic.icaria.client.model.ArachneDroneModel;
import com.axanthic.icaria.common.entity.ArachneDroneEntity;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ArachneDroneRenderer extends MobRenderer<ArachneDroneEntity, ArachneDroneModel> {
    public float shdwMult = 0.3F;
    public float sizeMult = 0.125F;

    public ArachneDroneRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ArachneDroneModel(pContext.bakeLayer(IcariaLayerLocations.ARACHNE_DRONE)), 1.0F);
        this.addLayer(new ArachneDroneEmissiveLayer(this));
    }

    @Override
    public void render(ArachneDroneEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
        this.shadowRadius = pEntity.isBaby() ? this.shdwMult * pEntity.getScaleFromSize() : this.shdwMult * 2.0F;
    }

    @Override
    public void scale(ArachneDroneEntity pLivingEntity, PoseStack pMatrixStack, float pPartialTickTime) {
        float size = this.sizeMult * pLivingEntity.getScaleFromSize();
        pMatrixStack.scale(size, size, size);
    }

    @Override
    public ResourceLocation getTextureLocation(ArachneDroneEntity pEntity) {
        return IcariaResourceLocations.ARACHNE_DRONE;
    }
}
