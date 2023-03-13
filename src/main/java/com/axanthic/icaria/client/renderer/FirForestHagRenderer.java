package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.FirForestHagEmissiveLayer;
import com.axanthic.icaria.client.model.FirForestHagModel;
import com.axanthic.icaria.common.entity.ForestHagEntity;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FirForestHagRenderer extends MobRenderer<ForestHagEntity, FirForestHagModel> {
    public static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation(IcariaInfo.MODID, "textures/entity/fir_forest_hag.png");

    public FirForestHagRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new FirForestHagModel(pContext.bakeLayer(FirForestHagModel.LAYER_LOCATION)), 0.75F);
        this.addLayer(new FirForestHagEmissiveLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(ForestHagEntity pEntity) {
        return RESOURCE_LOCATION;
    }
}
