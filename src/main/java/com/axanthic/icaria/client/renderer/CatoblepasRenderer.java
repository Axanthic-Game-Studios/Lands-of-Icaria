package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;
import com.axanthic.icaria.client.model.CatoblepasModel;
import com.axanthic.icaria.common.entity.CatoblepasEntity;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CatoblepasRenderer extends MobRenderer<CatoblepasEntity, CatoblepasModel> {
    public float shdwMult = 0.35F;
    public float sizeMult = 0.25F;

    public CatoblepasRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new CatoblepasModel(pContext.bakeLayer(IcariaLayerLocations.CATOBLEPAS)), 1.0F);
    }

    @Override
    public void render(CatoblepasEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
        this.shadowRadius = pEntity.isBaby() ? this.shdwMult * pEntity.getScaleFromSize() : this.shdwMult * 2.0F;
    }

    @Override
    public void scale(CatoblepasEntity pLivingEntity, PoseStack pMatrixStack, float pPartialTickTime) {
        float size = this.sizeMult * pLivingEntity.getScaleFromSize();
        pMatrixStack.scale(size, size, size);
    }

    @Override
    public ResourceLocation getTextureLocation(CatoblepasEntity pEntity) {
        return IcariaResourceLocations.CATOBLEPAS;
    }
}
