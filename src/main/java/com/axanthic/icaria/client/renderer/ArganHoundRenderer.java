package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.ArganHoundEmissiveLayer;
import com.axanthic.icaria.client.model.ArganHoundModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.ArganHoundRenderState;
import com.axanthic.icaria.common.entity.ArganHoundEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ArganHoundRenderer extends MobRenderer<ArganHoundEntity, ArganHoundRenderState, ArganHoundModel> {
	public ArganHoundRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new ArganHoundModel(pContext.bakeLayer(IcariaModelLayerLocations.ARGAN_HOUND)), 0.75F);
		this.addLayer(new ArganHoundEmissiveLayer(this));
	}

	@Override
	public void extractRenderState(ArganHoundEntity pEntity, ArganHoundRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.attackAnimationState = pEntity.attackAnimationState;
		pRenderState.livingEntity = pEntity;
	}

	@Override
	public ArganHoundRenderState createRenderState() {
		return new ArganHoundRenderState();
	}

	@Override
	public ResourceLocation getTextureLocation(ArganHoundRenderState pRenderState) {
		return IcariaResourceLocations.ARGAN_HOUND;
	}
}
