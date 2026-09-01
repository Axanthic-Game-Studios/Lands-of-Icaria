package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.LaurelForestHagEmissiveRenderLayer;
import com.axanthic.icaria.client.model.LaurelForestHagModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.LaurelForestHagRenderState;
import com.axanthic.icaria.common.entity.ForestHagEntity;
import com.axanthic.icaria.common.registry.IcariaIdentifiers;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class LaurelForestHagRenderer extends MobRenderer<ForestHagEntity, LaurelForestHagRenderState, LaurelForestHagModel> {
	public LaurelForestHagRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new LaurelForestHagModel(pContext.bakeLayer(IcariaModelLayerLocations.LAUREL_FOREST_HAG)), 0.75F);
		this.addLayer(new LaurelForestHagEmissiveRenderLayer(this));
	}

	@Override
	public void extractRenderState(ForestHagEntity pEntity, LaurelForestHagRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.aggressive = pEntity.isAggressive();
		pRenderState.attackTime = pEntity.getAttackAnim(pPartialTick);
		pRenderState.livingEntity = pEntity;
	}

	@Override
	public Identifier getTextureLocation(LaurelForestHagRenderState pRenderState) {
		return IcariaIdentifiers.LAUREL_FOREST_HAG;
	}

	@Override
	public LaurelForestHagRenderState createRenderState() {
		return new LaurelForestHagRenderState();
	}
}
