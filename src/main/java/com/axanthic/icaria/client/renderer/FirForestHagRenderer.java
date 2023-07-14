package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;
import com.axanthic.icaria.client.layer.FirForestHagEmissiveLayer;
import com.axanthic.icaria.client.model.FirForestHagModel;
import com.axanthic.icaria.common.entity.ForestHagEntity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FirForestHagRenderer extends MobRenderer<ForestHagEntity, FirForestHagModel> {
    public FirForestHagRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new FirForestHagModel(pContext.bakeLayer(IcariaLayerLocations.FIR_FOREST_HAG)), 0.75F);
        this.addLayer(new FirForestHagEmissiveLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(ForestHagEntity pEntity) {
        return IcariaResourceLocations.FIR_FOREST_HAG;
    }
}
