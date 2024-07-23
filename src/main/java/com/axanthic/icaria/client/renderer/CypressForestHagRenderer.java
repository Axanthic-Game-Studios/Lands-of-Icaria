package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.CypressForestHagEmissiveLayer;
import com.axanthic.icaria.client.model.CypressForestHagModel;
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

public class CypressForestHagRenderer extends MobRenderer<ForestHagEntity, CypressForestHagModel> {
	public CypressForestHagRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new CypressForestHagModel(pContext.bakeLayer(IcariaLayerLocations.CYPRESS_FOREST_HAG)), 0.75F);
		this.addLayer(new CypressForestHagEmissiveLayer(this));
	}

	@Override
	public ResourceLocation getTextureLocation(ForestHagEntity pEntity) {
		return IcariaResourceLocations.CYPRESS_FOREST_HAG;
	}
}
