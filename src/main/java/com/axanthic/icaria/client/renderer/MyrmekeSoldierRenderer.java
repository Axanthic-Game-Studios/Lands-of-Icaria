package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.model.MyrmekeSoldierModel;
import com.axanthic.icaria.common.entity.MyrmekeSoldierEntity;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class MyrmekeSoldierRenderer extends MobRenderer<MyrmekeSoldierEntity, MyrmekeSoldierModel> {
    public static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation(IcariaInfo.MODID, "textures/entity/myrmeke_soldier.png");

    public MyrmekeSoldierRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new MyrmekeSoldierModel(pContext.bakeLayer(MyrmekeSoldierModel.LAYER_LOCATION)), 0.75F);
    }

    @Override
    public ResourceLocation getTextureLocation(MyrmekeSoldierEntity pEntity) {
        return RESOURCE_LOCATION;
    }
}
