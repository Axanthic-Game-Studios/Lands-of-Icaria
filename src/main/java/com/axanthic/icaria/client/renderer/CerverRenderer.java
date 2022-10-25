package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.model.CerverModel;
import com.axanthic.icaria.common.entity.CerverEntity;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CerverRenderer extends MobRenderer<CerverEntity, CerverModel> {
    public static ResourceLocation RESOURCE_LOCATION = new ResourceLocation(IcariaInfo.MODID, "textures/entity/cerver.png");

    public CerverRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new CerverModel(pContext.bakeLayer(CerverModel.LAYER_LOCATION)), 0.75F);
    }

    @Override
    public ResourceLocation getTextureLocation(CerverEntity pEntity) {
        return RESOURCE_LOCATION;
    }
}
