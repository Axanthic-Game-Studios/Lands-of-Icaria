package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.FirForestHagEmissiveLayer;
import com.axanthic.icaria.client.model.FirForestHagModel;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.client.state.FirForestHagRenderState;
import com.axanthic.icaria.common.entity.ForestHagEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FirForestHagRenderer extends MobRenderer<ForestHagEntity, FirForestHagRenderState, FirForestHagModel> {
	public FirForestHagRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new FirForestHagModel(pContext.bakeLayer(IcariaLayerLocations.FIR_FOREST_HAG)), 0.75F);
		this.addLayer(new FirForestHagEmissiveLayer(this));
	}

	@Override
	public void extractRenderState(ForestHagEntity pEntity, FirForestHagRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.aggressive = pEntity.isAggressive();
		pRenderState.attackTime = pEntity.getAttackAnim(pPartialTick);
		pRenderState.livingEntity = pEntity;
	}

	@Override
	public FirForestHagRenderState createRenderState() {
		return new FirForestHagRenderState();
	}

	@Override
	public ResourceLocation getTextureLocation(FirForestHagRenderState pRenderState) {
		return IcariaResourceLocations.FIR_FOREST_HAG;
	}
}
