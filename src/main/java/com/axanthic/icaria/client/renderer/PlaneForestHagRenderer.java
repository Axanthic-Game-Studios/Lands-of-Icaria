package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.PlaneForestHagEmissiveLayer;
import com.axanthic.icaria.client.model.PlaneForestHagModel;
import com.axanthic.icaria.common.entity.ForestHagEntity;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class PlaneForestHagRenderer extends MobRenderer<ForestHagEntity, PlaneForestHagModel> {
    public static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation(IcariaInfo.MODID, "textures/entity/plane_forest_hag.png");

    public PlaneForestHagRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new PlaneForestHagModel(pContext.bakeLayer(PlaneForestHagModel.LAYER_LOCATION)), 0.75F);
        this.addLayer(new PlaneForestHagEmissiveLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(ForestHagEntity pEntity) {
        return RESOURCE_LOCATION;
    }
}
