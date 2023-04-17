package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.client.registry.IcariaResourceLocations;
import com.axanthic.icaria.client.layer.PlaneForestHagEmissiveLayer;
import com.axanthic.icaria.client.model.PlaneForestHagModel;
import com.axanthic.icaria.common.entity.ForestHagEntity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class PlaneForestHagRenderer extends MobRenderer<ForestHagEntity, PlaneForestHagModel> {
    public PlaneForestHagRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new PlaneForestHagModel(pContext.bakeLayer(IcariaLayerLocations.PLANE_FOREST_HAG)), 0.75F);
        this.addLayer(new PlaneForestHagEmissiveLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(ForestHagEntity pEntity) {
        return IcariaResourceLocations.PLANE_FOREST_HAG;
    }
}
