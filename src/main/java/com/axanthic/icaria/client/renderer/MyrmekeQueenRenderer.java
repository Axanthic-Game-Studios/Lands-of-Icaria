package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.client.registry.IcariaResourceLocations;
import com.axanthic.icaria.client.layer.MyrmekeQueenRaysLayer;
import com.axanthic.icaria.client.layer.MyrmekeQueenEmissiveLayer;
import com.axanthic.icaria.client.model.MyrmekeQueenModel;
import com.axanthic.icaria.common.entity.MyrmekeQueenEntity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class MyrmekeQueenRenderer extends MobRenderer<MyrmekeQueenEntity, MyrmekeQueenModel> {
    public MyrmekeQueenRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new MyrmekeQueenModel(pContext.bakeLayer(IcariaLayerLocations.MYRMEKE_QUEEN_BODY)), 0.75F);
        this.addLayer(new MyrmekeQueenEmissiveLayer(this));
        this.addLayer(new MyrmekeQueenRaysLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(MyrmekeQueenEntity pEntity) {
        return IcariaResourceLocations.MYRMEKE_QUEEN;
    }
}
