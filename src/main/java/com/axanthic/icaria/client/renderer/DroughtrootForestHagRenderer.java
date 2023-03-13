package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.DroughtrootForestHagEmissiveLayer;
import com.axanthic.icaria.client.model.DroughtrootForestHagModel;
import com.axanthic.icaria.common.entity.ForestHagEntity;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class DroughtrootForestHagRenderer extends MobRenderer<ForestHagEntity, DroughtrootForestHagModel> {
    public static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation(IcariaInfo.MODID, "textures/entity/droughtroot_forest_hag.png");

    public DroughtrootForestHagRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new DroughtrootForestHagModel(pContext.bakeLayer(DroughtrootForestHagModel.LAYER_LOCATION)), 0.75F);
        this.addLayer(new DroughtrootForestHagEmissiveLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(ForestHagEntity pEntity) {
        return RESOURCE_LOCATION;
    }
}
