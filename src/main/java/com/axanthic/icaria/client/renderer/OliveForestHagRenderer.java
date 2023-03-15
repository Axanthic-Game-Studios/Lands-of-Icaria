package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.OliveForestHagEmissiveLayer;
import com.axanthic.icaria.client.model.OliveForestHagModel;
import com.axanthic.icaria.common.entity.ForestHagEntity;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class OliveForestHagRenderer extends MobRenderer<ForestHagEntity, OliveForestHagModel> {
    public static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation(IcariaInfo.MODID, "textures/entity/olive_forest_hag.png");

    public OliveForestHagRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new OliveForestHagModel(pContext.bakeLayer(OliveForestHagModel.LAYER_LOCATION)), 0.75F);
        this.addLayer(new OliveForestHagEmissiveLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(ForestHagEntity pEntity) {
        return RESOURCE_LOCATION;
    }
}
