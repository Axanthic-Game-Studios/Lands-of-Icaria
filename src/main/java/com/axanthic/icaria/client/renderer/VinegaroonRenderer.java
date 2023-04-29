package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.VinegaroonEmissiveLayer;
import com.axanthic.icaria.client.model.VinegaroonModel;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.client.registry.IcariaResourceLocations;
import com.axanthic.icaria.common.entity.VinegaroonEntity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class VinegaroonRenderer extends MobRenderer<VinegaroonEntity, VinegaroonModel> {
    public VinegaroonRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new VinegaroonModel(pContext.bakeLayer(IcariaLayerLocations.VINEGAROON)), 1.375F);
        this.addLayer(new VinegaroonEmissiveLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(VinegaroonEntity pEntity) {
        return IcariaResourceLocations.VINEGAROON;
    }
}
