package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.model.AeternaeModel;
import com.axanthic.icaria.common.entity.AeternaeEntity;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class AeternaeRenderer extends MobRenderer<AeternaeEntity, AeternaeModel> {
    public static ResourceLocation RESOURCE_LOCATION = new ResourceLocation(IcariaInfo.MODID, "textures/entity/aeternae.png");

    public AeternaeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new AeternaeModel(pContext.bakeLayer(AeternaeModel.LAYER_LOCATION)), 0.75F);
    }

    @Override
    public ResourceLocation getTextureLocation(AeternaeEntity pEntity) {
        return RESOURCE_LOCATION;
    }
}
