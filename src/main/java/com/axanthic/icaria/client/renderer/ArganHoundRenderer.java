package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.ArganHoundEmissiveRenderLayer;
import com.axanthic.icaria.client.model.ArganHoundModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.ArganHoundRenderState;
import com.axanthic.icaria.common.entity.ArganHoundEntity;
import com.axanthic.icaria.common.registry.IcariaIdentifiers;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ArganHoundRenderer extends MobRenderer<ArganHoundEntity, ArganHoundRenderState, ArganHoundModel> {
	public ArganHoundRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new ArganHoundModel(pContext.bakeLayer(IcariaModelLayerLocations.ARGAN_HOUND)), 0.75F);
		this.addLayer(new ArganHoundEmissiveRenderLayer(this));
	}

	@Override
	public void extractRenderState(ArganHoundEntity pEntity, ArganHoundRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.attackAnimationState = pEntity.attackAnimationState;
		pRenderState.livingEntity = pEntity;
	}

	@Override
	public Identifier getTextureLocation(ArganHoundRenderState pRenderState) {
		return IcariaIdentifiers.ARGAN_HOUND;
	}

	@Override
	public ArganHoundRenderState createRenderState() {
		return new ArganHoundRenderState();
	}
}
