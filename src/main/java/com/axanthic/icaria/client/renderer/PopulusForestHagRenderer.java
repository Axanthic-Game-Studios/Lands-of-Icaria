package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.PopulusForestHagEmissiveLayer;
import com.axanthic.icaria.client.model.PopulusForestHagModel;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.client.state.PopulusForestHagRenderState;
import com.axanthic.icaria.common.entity.ForestHagEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class PopulusForestHagRenderer extends MobRenderer<ForestHagEntity, PopulusForestHagRenderState, PopulusForestHagModel> {
	public PopulusForestHagRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new PopulusForestHagModel(pContext.bakeLayer(IcariaLayerLocations.POPULUS_FOREST_HAG)), 0.75F);
		this.addLayer(new PopulusForestHagEmissiveLayer(this));
	}

	@Override
	public void extractRenderState(ForestHagEntity pEntity, PopulusForestHagRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.aggressive = pEntity.isAggressive();
		pRenderState.attackTime = pEntity.getAttackAnim(pPartialTick);
		pRenderState.livingEntity = pEntity;
	}

	@Override
	public PopulusForestHagRenderState createRenderState() {
		return new PopulusForestHagRenderState();
	}

	@Override
	public ResourceLocation getTextureLocation(PopulusForestHagRenderState pRenderState) {
		return IcariaResourceLocations.POPULUS_FOREST_HAG;
	}
}
