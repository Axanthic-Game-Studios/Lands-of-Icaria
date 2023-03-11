package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.ArganHoundEmissiveLayer;
import com.axanthic.icaria.client.model.ArganHoundModel;
import com.axanthic.icaria.common.entity.ArganHoundEntity;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ArganHoundRenderer extends MobRenderer<ArganHoundEntity, ArganHoundModel> {
    public static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation(IcariaInfo.MODID, "textures/entity/argan_hound.png");

    public ArganHoundRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ArganHoundModel(pContext.bakeLayer(ArganHoundModel.LAYER_LOCATION)), 0.75F);
        this.addLayer(new ArganHoundEmissiveLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(ArganHoundEntity pEntity) {
        return RESOURCE_LOCATION;
    }
}
