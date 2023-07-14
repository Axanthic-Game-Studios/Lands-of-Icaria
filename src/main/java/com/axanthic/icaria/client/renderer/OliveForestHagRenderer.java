package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;
import com.axanthic.icaria.client.layer.OliveForestHagEmissiveLayer;
import com.axanthic.icaria.client.model.OliveForestHagModel;
import com.axanthic.icaria.common.entity.ForestHagEntity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class OliveForestHagRenderer extends MobRenderer<ForestHagEntity, OliveForestHagModel> {
    public OliveForestHagRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new OliveForestHagModel(pContext.bakeLayer(IcariaLayerLocations.OLIVE_FOREST_HAG)), 0.75F);
        this.addLayer(new OliveForestHagEmissiveLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(ForestHagEntity pEntity) {
        return IcariaResourceLocations.OLIVE_FOREST_HAG;
    }
}
