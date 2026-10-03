package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.client.layer.PlaneForestHagEmissiveRenderLayer;
import com.axanthic.icaria.client.model.PlaneForestHagModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.PlaneForestHagRenderState;
import com.axanthic.icaria.common.entity.ForestHagEntity;
import com.axanthic.icaria.common.registry.IcariaIdentifiers;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class PlaneForestHagRenderer extends MobRenderer<ForestHagEntity, PlaneForestHagRenderState, PlaneForestHagModel> {
	public PlaneForestHagRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new PlaneForestHagModel(pContext.bakeLayer(IcariaModelLayerLocations.PLANE_FOREST_HAG)), 0.75F);
		this.addLayer(new PlaneForestHagEmissiveRenderLayer(this));
	}

	@Override
	public void extractRenderState(ForestHagEntity pEntity, PlaneForestHagRenderState pRenderState, float pPartialTicks) {
		super.extractRenderState(pEntity, pRenderState, pPartialTicks);
		pRenderState.aggressive = pEntity.isAggressive();
		pRenderState.attackTime = pEntity.getAttackAnim(pPartialTicks);
		pRenderState.livingEntity = pEntity;
	}

	@Override
	public Identifier getTextureLocation(PlaneForestHagRenderState pRenderState) {
		return IcariaIdentifiers.PLANE_FOREST_HAG;
	}

	@Override
	public PlaneForestHagRenderState createRenderState() {
		return new PlaneForestHagRenderState();
	}
}
