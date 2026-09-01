package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.model.CerverModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.CerverRenderState;
import com.axanthic.icaria.common.entity.CerverEntity;
import com.axanthic.icaria.common.registry.IcariaIdentifiers;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CerverRenderer extends MobRenderer<CerverEntity, CerverRenderState, CerverModel> {
	public CerverRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new CerverModel(pContext.bakeLayer(IcariaModelLayerLocations.CERVER)), 0.75F);
	}

	@Override
	public void extractRenderState(CerverEntity pEntity, CerverRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.attackAnimationState = pEntity.attackAnimationState;
	}

	@Override
	public Identifier getTextureLocation(CerverRenderState pRenderState) {
		return IcariaIdentifiers.CERVER;
	}

	@Override
	public CerverRenderState createRenderState() {
		return new CerverRenderState();
	}
}
