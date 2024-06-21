package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.ScorpionEmissiveLayer;
import com.axanthic.icaria.client.model.ScorpionModel;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.common.entity.ScorpionEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ScorpionRenderer extends MobRenderer<ScorpionEntity, ScorpionModel> {
    public ScorpionRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ScorpionModel(pContext.bakeLayer(IcariaLayerLocations.SCORPION)), 1.375F);
        this.addLayer(new ScorpionEmissiveLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(ScorpionEntity pEntity) {
        return IcariaResourceLocations.SCORPION;
    }
}
