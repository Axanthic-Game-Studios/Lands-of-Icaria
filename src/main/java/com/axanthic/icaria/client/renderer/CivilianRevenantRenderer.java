package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.client.registry.IcariaResourceLocations;
import com.axanthic.icaria.client.layer.CivilianRevenantEmissiveLayer;
import com.axanthic.icaria.client.layer.CivilianRevenantItemLayer;
import com.axanthic.icaria.client.model.CivilianRevenantModel;
import com.axanthic.icaria.common.entity.CivilianRevenantEntity;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CivilianRevenantRenderer extends MobRenderer<CivilianRevenantEntity, CivilianRevenantModel> {
    public CivilianRevenantRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new CivilianRevenantModel(pContext.bakeLayer(IcariaLayerLocations.CIVILIAN_REVENANT_BODY)), 0.5F);
        this.addLayer(new CivilianRevenantEmissiveLayer(this));
        this.addLayer(new CivilianRevenantItemLayer(this));
    }

    @Override
    public void scale(CivilianRevenantEntity pLivingEntity, PoseStack pMatrixStack, float pPartialTickTime) {
        pMatrixStack.scale(0.875F, 0.875F, 0.875F);
    }

    @Override
    public ResourceLocation getTextureLocation(CivilianRevenantEntity pEntity) {
        return IcariaResourceLocations.CIVILIAN_REVENANT;
    }
}
