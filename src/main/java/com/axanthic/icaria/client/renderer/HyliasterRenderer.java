package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.client.registry.IcariaResourceLocations;
import com.axanthic.icaria.client.layer.HyliasterTranslucentLayer;
import com.axanthic.icaria.client.model.HyliasterModel;
import com.axanthic.icaria.common.entity.HyliasterEntity;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class HyliasterRenderer extends MobRenderer<HyliasterEntity, HyliasterModel> {
    public float shdwMult = 0.25F;
    public float sizeMult = 0.275F;

    public HyliasterRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new HyliasterModel(pContext.bakeLayer(IcariaLayerLocations.HYLIASTER)), 1.0F);
        this.addLayer(new HyliasterTranslucentLayer(this));
    }

    @Override
    public void render(HyliasterEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
        this.shadowRadius = pEntity.isBaby() ? this.shdwMult * pEntity.getScaleFromSize() : this.shdwMult * 2.0F;
    }

    @Override
    public void scale(HyliasterEntity pLivingEntity, PoseStack pMatrixStack, float pPartialTickTime) {
        float size = this.sizeMult * pLivingEntity.getScaleFromSize();
        pMatrixStack.scale(size, size, size);
    }

    @Override
    public ResourceLocation getTextureLocation(HyliasterEntity pEntity) {
        return IcariaResourceLocations.HYLIASTER;
    }
}
