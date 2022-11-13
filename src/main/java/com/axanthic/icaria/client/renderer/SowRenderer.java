package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.model.SowModel;
import com.axanthic.icaria.common.entity.SowEntity;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SowRenderer extends MobRenderer<SowEntity, SowModel> {
    public static ResourceLocation RESOURCE_LOCATION = new ResourceLocation(IcariaInfo.MODID, "textures/entity/sow.png");

    public SowRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new SowModel(pContext.bakeLayer(SowModel.LAYER_LOCATION)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(SowEntity pEntity) {
        return RESOURCE_LOCATION;
    }
}
