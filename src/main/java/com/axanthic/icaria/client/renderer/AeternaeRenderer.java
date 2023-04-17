package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.client.registry.IcariaResourceLocations;
import com.axanthic.icaria.client.model.AeternaeModel;
import com.axanthic.icaria.common.entity.AeternaeEntity;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class AeternaeRenderer extends MobRenderer<AeternaeEntity, AeternaeModel> {
    public float shdwMult = 0.4F;
    public float sizeMult = 0.25F;

    public AeternaeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new AeternaeModel(pContext.bakeLayer(IcariaLayerLocations.AETERNAE)), 1.0F);
    }

    @Override
    public void render(AeternaeEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
        this.shadowRadius = pEntity.isBaby() ? this.shdwMult * pEntity.getScaleFromSize() : this.shdwMult * 2.0F;
    }

    @Override
    public void scale(AeternaeEntity pLivingEntity, PoseStack pMatrixStack, float pPartialTickTime) {
        float size = this.sizeMult * pLivingEntity.getScaleFromSize();
        pMatrixStack.scale(size, size, size);
    }

    @Override
    public ResourceLocation getTextureLocation(AeternaeEntity pEntity) {
        return IcariaResourceLocations.AETERNAE;
    }
}
