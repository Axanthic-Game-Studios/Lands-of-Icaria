package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.client.registry.IcariaResourceLocations;
import com.axanthic.icaria.client.model.MyrmekeDroneModel;
import com.axanthic.icaria.common.entity.MyrmekeDroneEntity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class MyrmekeDroneRenderer extends MobRenderer<MyrmekeDroneEntity, MyrmekeDroneModel> {
    public MyrmekeDroneRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new MyrmekeDroneModel(pContext.bakeLayer(IcariaLayerLocations.MYRMEKE_DRONE)), 0.75F);
    }

    @Override
    public ResourceLocation getTextureLocation(MyrmekeDroneEntity pEntity) {
        return IcariaResourceLocations.MYRMEKE_DRONE;
    }
}
