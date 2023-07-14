package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;
import com.axanthic.icaria.client.layer.ForestSnullEmissiveLayer;
import com.axanthic.icaria.client.model.ForestSnullModel;
import com.axanthic.icaria.common.entity.SnullEntity;

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

public class ForestSnullRenderer extends MobRenderer<SnullEntity, ForestSnullModel> {
    public float shdwMult = 0.35F;
    public float sizeMult = 0.25F;

    public ForestSnullRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ForestSnullModel(pContext.bakeLayer(IcariaLayerLocations.FOREST_SNULL)), 1.0F);
        this.addLayer(new ForestSnullEmissiveLayer(this));
    }

    @Override
    public void render(SnullEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
        this.shadowRadius = pEntity.isBaby() ? this.shdwMult * pEntity.getScaleFromSize() : this.shdwMult * 2.0F;
    }

    @Override
    public void scale(SnullEntity pLivingEntity, PoseStack pMatrixStack, float pPartialTickTime) {
        float size = this.sizeMult * pLivingEntity.getScaleFromSize();
        pMatrixStack.scale(size, size, size);
        pMatrixStack.translate(0.0F, 0.0F, -0.25F);
        if (pLivingEntity.onClimbable()) {
            pMatrixStack.mulPose(Axis.XN.rotationDegrees(90.0F));
            pMatrixStack.translate(0.0F, 0.25F, 0.0F);
        }
    }

    @Override
    public ResourceLocation getTextureLocation(SnullEntity pEntity) {
        return IcariaResourceLocations.FOREST_SNULL;
    }
}
