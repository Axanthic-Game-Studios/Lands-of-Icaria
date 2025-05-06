package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.CypressForestHagEmissiveLayer;
import com.axanthic.icaria.client.model.CypressForestHagModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.CypressForestHagRenderState;
import com.axanthic.icaria.common.entity.ForestHagEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CypressForestHagRenderer extends MobRenderer<ForestHagEntity, CypressForestHagRenderState, CypressForestHagModel> {
	public CypressForestHagRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new CypressForestHagModel(pContext.bakeLayer(IcariaModelLayerLocations.CYPRESS_FOREST_HAG)), 0.75F);
		this.addLayer(new CypressForestHagEmissiveLayer(this));
	}

	@Override
	public void extractRenderState(ForestHagEntity pEntity, CypressForestHagRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.aggressive = pEntity.isAggressive();
		pRenderState.attackTime = pEntity.getAttackAnim(pPartialTick);
		pRenderState.livingEntity = pEntity;
	}

	@Override
	public CypressForestHagRenderState createRenderState() {
		return new CypressForestHagRenderState();
	}

	@Override
	public ResourceLocation getTextureLocation(CypressForestHagRenderState pRenderState) {
		return IcariaResourceLocations.CYPRESS_FOREST_HAG;
	}
}
