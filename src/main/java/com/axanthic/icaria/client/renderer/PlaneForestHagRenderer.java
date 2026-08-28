package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.PlaneForestHagEmissiveRenderLayer;
import com.axanthic.icaria.client.model.PlaneForestHagModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.PlaneForestHagRenderState;
import com.axanthic.icaria.common.entity.ForestHagEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class PlaneForestHagRenderer extends MobRenderer<ForestHagEntity, PlaneForestHagRenderState, PlaneForestHagModel> {
	public PlaneForestHagRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new PlaneForestHagModel(pContext.bakeLayer(IcariaModelLayerLocations.PLANE_FOREST_HAG)), 0.75F);
		this.addLayer(new PlaneForestHagEmissiveRenderLayer(this));
	}

	@Override
	public void extractRenderState(ForestHagEntity pEntity, PlaneForestHagRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.aggressive = pEntity.isAggressive();
		pRenderState.attackTime = pEntity.getAttackAnim(pPartialTick);
		pRenderState.livingEntity = pEntity;
	}

	@Override
	public PlaneForestHagRenderState createRenderState() {
		return new PlaneForestHagRenderState();
	}

	@Override
	public ResourceLocation getTextureLocation(PlaneForestHagRenderState pRenderState) {
		return IcariaResourceLocations.PLANE_FOREST_HAG;
	}
}
