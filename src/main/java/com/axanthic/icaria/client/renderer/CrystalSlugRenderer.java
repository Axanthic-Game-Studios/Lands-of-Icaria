package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.CrystalSlugEmissiveLayer;
import com.axanthic.icaria.client.layer.CrystalSlugRaysLayer;
import com.axanthic.icaria.client.model.CrystalSlugModel;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.common.entity.SlugEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CrystalSlugRenderer extends MobRenderer<SlugEntity, CrystalSlugModel> {
    public CrystalSlugRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new CrystalSlugModel(pContext.bakeLayer(IcariaLayerLocations.CRYSTAL_SLUG_BODY)), 1.0F);
        this.addLayer(new CrystalSlugEmissiveLayer(this));
        this.addLayer(new CrystalSlugRaysLayer(this));
    }

    @Override
    public float getShadowRadius(SlugEntity pEntity) {
        return pEntity.getScaleForShadow();
    }

    @Override
    public void render(SlugEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
        this.shadowStrength = pEntity.getShadowStrength();
    }

    @Override
    public void scale(SlugEntity pLivingEntity, PoseStack pMatrixStack, float pPartialTickTime) {
        pMatrixStack.scale(pLivingEntity.getScaleForRender(), pLivingEntity.getScaleForRender(), pLivingEntity.getScaleForRender());
        if (pLivingEntity.onClimbable()) {
            pMatrixStack.mulPose(Axis.XN.rotationDegrees(90.0F));
            pMatrixStack.translate(0.0F, 0.25F, 0.0F);
        }
    }

    @Override
    public ResourceLocation getTextureLocation(SlugEntity pEntity) {
        return IcariaResourceLocations.CRYSTAL_SLUG;
    }
}
