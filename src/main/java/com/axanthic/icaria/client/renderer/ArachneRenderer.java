package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;
import com.axanthic.icaria.client.layer.ArachneEmissiveLayer;
import com.axanthic.icaria.client.model.ArachneModel;
import com.axanthic.icaria.common.entity.ArachneEntity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ArachneRenderer extends MobRenderer<ArachneEntity, ArachneModel> {
    public ArachneRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ArachneModel(pContext.bakeLayer(IcariaLayerLocations.ARACHNE)), 1.25F);
        this.addLayer(new ArachneEmissiveLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(ArachneEntity pEntity) {
        return IcariaResourceLocations.ARACHNE;
    }
}
