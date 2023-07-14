package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;
import com.axanthic.icaria.client.model.CerverModel;
import com.axanthic.icaria.common.entity.CerverEntity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CerverRenderer extends MobRenderer<CerverEntity, CerverModel> {
    public CerverRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new CerverModel(pContext.bakeLayer(IcariaLayerLocations.CERVER)), 1.0F);
    }

    @Override
    public ResourceLocation getTextureLocation(CerverEntity pEntity) {
        return IcariaResourceLocations.CERVER;
    }
}
