package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.OliveForestHagEmissiveRenderLayer;
import com.axanthic.icaria.client.model.OliveForestHagModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.OliveForestHagRenderState;
import com.axanthic.icaria.common.entity.ForestHagEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class OliveForestHagRenderer extends MobRenderer<ForestHagEntity, OliveForestHagRenderState, OliveForestHagModel> {
	public OliveForestHagRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new OliveForestHagModel(pContext.bakeLayer(IcariaModelLayerLocations.OLIVE_FOREST_HAG)), 0.75F);
		this.addLayer(new OliveForestHagEmissiveRenderLayer(this));
	}

	@Override
	public void extractRenderState(ForestHagEntity pEntity, OliveForestHagRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.aggressive = pEntity.isAggressive();
		pRenderState.attackTime = pEntity.getAttackAnim(pPartialTick);
		pRenderState.livingEntity = pEntity;
	}

	@Override
	public OliveForestHagRenderState createRenderState() {
		return new OliveForestHagRenderState();
	}

	@Override
	public ResourceLocation getTextureLocation(OliveForestHagRenderState pRenderState) {
		return IcariaResourceLocations.OLIVE_FOREST_HAG;
	}
}
