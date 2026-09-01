package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.FirForestHagEmissiveRenderLayer;
import com.axanthic.icaria.client.model.FirForestHagModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.FirForestHagRenderState;
import com.axanthic.icaria.common.entity.ForestHagEntity;
import com.axanthic.icaria.common.registry.IcariaIdentifiers;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FirForestHagRenderer extends MobRenderer<ForestHagEntity, FirForestHagRenderState, FirForestHagModel> {
	public FirForestHagRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new FirForestHagModel(pContext.bakeLayer(IcariaModelLayerLocations.FIR_FOREST_HAG)), 0.75F);
		this.addLayer(new FirForestHagEmissiveRenderLayer(this));
	}

	@Override
	public void extractRenderState(ForestHagEntity pEntity, FirForestHagRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.aggressive = pEntity.isAggressive();
		pRenderState.attackTime = pEntity.getAttackAnim(pPartialTick);
		pRenderState.livingEntity = pEntity;
	}

	@Override
	public Identifier getTextureLocation(FirForestHagRenderState pRenderState) {
		return IcariaIdentifiers.FIR_FOREST_HAG;
	}

	@Override
	public FirForestHagRenderState createRenderState() {
		return new FirForestHagRenderState();
	}
}
