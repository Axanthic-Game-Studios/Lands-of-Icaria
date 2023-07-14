package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;
import com.axanthic.icaria.client.layer.DroughtrootForestHagEmissiveLayer;
import com.axanthic.icaria.client.model.DroughtrootForestHagModel;
import com.axanthic.icaria.common.entity.ForestHagEntity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class DroughtrootForestHagRenderer extends MobRenderer<ForestHagEntity, DroughtrootForestHagModel> {
    public DroughtrootForestHagRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new DroughtrootForestHagModel(pContext.bakeLayer(IcariaLayerLocations.DROUGHTROOT_FOREST_HAG)), 0.75F);
        this.addLayer(new DroughtrootForestHagEmissiveLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(ForestHagEntity pEntity) {
        return IcariaResourceLocations.DROUGHTROOT_FOREST_HAG;
    }
}
