package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.LaurelForestHagEmissiveLayer;
import com.axanthic.icaria.client.model.LaurelForestHagModel;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.common.entity.ForestHagEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class LaurelForestHagRenderer extends MobRenderer<ForestHagEntity, LaurelForestHagModel> {
	public LaurelForestHagRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new LaurelForestHagModel(pContext.bakeLayer(IcariaLayerLocations.LAUREL_FOREST_HAG)), 0.75F);
		this.addLayer(new LaurelForestHagEmissiveLayer(this));
	}

	@Override
	public ResourceLocation getTextureLocation(ForestHagEntity pEntity) {
		return IcariaResourceLocations.LAUREL_FOREST_HAG;
	}
}
