package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.MyrmekeQueenRaysLayer;
import com.axanthic.icaria.client.layer.MyrmekeQueenEmissiveLayer;
import com.axanthic.icaria.client.model.MyrmekeQueenModel;
import com.axanthic.icaria.common.entity.MyrmekeQueenEntity;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class MyrmekeQueenRenderer extends MobRenderer<MyrmekeQueenEntity, MyrmekeQueenModel> {
    public static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation(IcariaInfo.MODID, "textures/entity/myrmeke_queen.png");

    public MyrmekeQueenRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new MyrmekeQueenModel(pContext.bakeLayer(MyrmekeQueenModel.BODY_LAYER_LOCATION)), 0.75F);
        this.addLayer(new MyrmekeQueenEmissiveLayer(this));
        this.addLayer(new MyrmekeQueenRaysLayer(this, pContext.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(MyrmekeQueenEntity pEntity) {
        return RESOURCE_LOCATION;
    }
}