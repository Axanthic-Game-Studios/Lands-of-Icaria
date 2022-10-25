package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.model.CerverModel;
import com.axanthic.icaria.client.model.MyrmekeDroneModel;
import com.axanthic.icaria.common.entity.CerverEntity;
import com.axanthic.icaria.common.entity.MyrmekeDroneEntity;
import com.axanthic.icaria.common.util.IcariaInfo;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class MyrmekeDroneRenderer extends MobRenderer<MyrmekeDroneEntity, MyrmekeDroneModel> {
    public static ResourceLocation RESOURCE_LOCATION = new ResourceLocation(IcariaInfo.MODID, "textures/entity/myrmeke_drone.png");

    public MyrmekeDroneRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new MyrmekeDroneModel(pContext.bakeLayer(MyrmekeDroneModel.LAYER_LOCATION)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(MyrmekeDroneEntity pEntity) {
        return RESOURCE_LOCATION;
    }
}
