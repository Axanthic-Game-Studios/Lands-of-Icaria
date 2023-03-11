package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.CypressForestHagEmissiveLayer;
import com.axanthic.icaria.client.model.CypressForestHagModel;
import com.axanthic.icaria.common.entity.ForestHagEntity;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CypressForestHagRenderer extends MobRenderer<ForestHagEntity, CypressForestHagModel> {
    public static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation(IcariaInfo.MODID, "textures/entity/cypress_forest_hag.png");

    public CypressForestHagRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new CypressForestHagModel(pContext.bakeLayer(CypressForestHagModel.LAYER_LOCATION)), 0.75F);
        this.addLayer(new CypressForestHagEmissiveLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(ForestHagEntity pEntity) {
        return RESOURCE_LOCATION;
    }
}
