package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;
import com.axanthic.icaria.client.layer.CrystalSlugEmissiveLayer;
import com.axanthic.icaria.client.layer.CrystalSlugRaysLayer;
import com.axanthic.icaria.client.model.CrystalSlugModel;
import com.axanthic.icaria.common.entity.SlugEntity;

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
    public float shdwMult = 0.35F;
    public float sizeMult = 0.25F;

    public CrystalSlugRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new CrystalSlugModel(pContext.bakeLayer(IcariaLayerLocations.CRYSTAL_SLUG_BODY)), 1.0F);
        this.addLayer(new CrystalSlugEmissiveLayer(this));
        this.addLayer(new CrystalSlugRaysLayer(this));
    }

    @Override
    public void render(SlugEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
        this.shadowRadius = pEntity.isBaby() ? this.shdwMult * pEntity.getScaleFromSize() : this.shdwMult * 2.0F;
        this.shadowStrength = pEntity.getShadowStrength();
    }

    @Override
    public void scale(SlugEntity pLivingEntity, PoseStack pMatrixStack, float pPartialTickTime) {
        float size = this.sizeMult * pLivingEntity.getScaleFromSize();
        pMatrixStack.scale(size, size, size);
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
