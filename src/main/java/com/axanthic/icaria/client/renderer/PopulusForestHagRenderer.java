package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.PopulusForestHagEmissiveLayer;
import com.axanthic.icaria.client.model.PopulusForestHagModel;
import com.axanthic.icaria.common.entity.ForestHagEntity;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class PopulusForestHagRenderer extends MobRenderer<ForestHagEntity, PopulusForestHagModel> {
    public static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation(IcariaInfo.MODID, "textures/entity/populus_forest_hag.png");

    public PopulusForestHagRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new PopulusForestHagModel(pContext.bakeLayer(PopulusForestHagModel.LAYER_LOCATION)), 0.75F);
        this.addLayer(new PopulusForestHagEmissiveLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(ForestHagEntity pEntity) {
        return RESOURCE_LOCATION;
    }
}
