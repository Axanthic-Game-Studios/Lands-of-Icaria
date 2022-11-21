package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.model.CatoblepasModel;
import com.axanthic.icaria.common.entity.CatoblepasEntity;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CatoblepasRenderer extends MobRenderer<CatoblepasEntity, CatoblepasModel> {
    public static ResourceLocation RESOURCE_LOCATION = new ResourceLocation(IcariaInfo.MODID, "textures/entity/catoblepas.png");

    public CatoblepasRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new CatoblepasModel(pContext.bakeLayer(CatoblepasModel.LAYER_LOCATION)), 0.75F);
    }

    @Override
    public ResourceLocation getTextureLocation(CatoblepasEntity pEntity) {
        return RESOURCE_LOCATION;
    }
}
