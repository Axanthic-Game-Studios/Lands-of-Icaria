package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.model.CerverModel;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.client.state.CerverRenderState;
import com.axanthic.icaria.common.entity.CerverEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CerverRenderer extends MobRenderer<CerverEntity, CerverRenderState, CerverModel> {
	public CerverRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new CerverModel(pContext.bakeLayer(IcariaLayerLocations.CERVER)), 0.75F);
	}

	@Override
	public void extractRenderState(CerverEntity pEntity, CerverRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.attackAnimationState = pEntity.attackAnimationState;
	}

	@Override
	public CerverRenderState createRenderState() {
		return new CerverRenderState();
	}

	@Override
	public ResourceLocation getTextureLocation(CerverRenderState pRenderState) {
		return IcariaResourceLocations.CERVER;
	}
}
