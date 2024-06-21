package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.PopulusForestHagEmissiveLayer;
import com.axanthic.icaria.client.model.PopulusForestHagModel;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.common.entity.ForestHagEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class PopulusForestHagRenderer extends MobRenderer<ForestHagEntity, PopulusForestHagModel> {
    public PopulusForestHagRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new PopulusForestHagModel(pContext.bakeLayer(IcariaLayerLocations.POPULUS_FOREST_HAG)), 0.75F);
        this.addLayer(new PopulusForestHagEmissiveLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(ForestHagEntity pEntity) {
        return IcariaResourceLocations.POPULUS_FOREST_HAG;
    }
}
