package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.model.SowModel;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.common.entity.SowEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SowRenderer extends MobRenderer<SowEntity, SowModel> {
    public SowRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new SowModel(pContext.bakeLayer(IcariaLayerLocations.SOW)), 1.0F);
    }

    @Override
    public float getShadowRadius(SowEntity pEntity) {
        return pEntity.getScaleForShadow();
    }

    @Override
    public void render(SowEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }

    @Override
    public void scale(SowEntity pLivingEntity, PoseStack pMatrixStack, float pPartialTickTime) {
        pMatrixStack.scale(pLivingEntity.getScaleForRender(), pLivingEntity.getScaleForRender(), pLivingEntity.getScaleForRender());
    }

    @Override
    public ResourceLocation getTextureLocation(SowEntity pEntity) {
        return IcariaResourceLocations.SOW;
    }
}
