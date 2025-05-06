package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.LaurelForestHagEmissiveLayer;
import com.axanthic.icaria.client.model.LaurelForestHagModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.LaurelForestHagRenderState;
import com.axanthic.icaria.common.entity.ForestHagEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class LaurelForestHagRenderer extends MobRenderer<ForestHagEntity, LaurelForestHagRenderState, LaurelForestHagModel> {
	public LaurelForestHagRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new LaurelForestHagModel(pContext.bakeLayer(IcariaModelLayerLocations.LAUREL_FOREST_HAG)), 0.75F);
		this.addLayer(new LaurelForestHagEmissiveLayer(this));
	}

	@Override
	public void extractRenderState(ForestHagEntity pEntity, LaurelForestHagRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.aggressive = pEntity.isAggressive();
		pRenderState.attackTime = pEntity.getAttackAnim(pPartialTick);
		pRenderState.livingEntity = pEntity;
	}

	@Override
	public LaurelForestHagRenderState createRenderState() {
		return new LaurelForestHagRenderState();
	}

	@Override
	public ResourceLocation getTextureLocation(LaurelForestHagRenderState pRenderState) {
		return IcariaResourceLocations.LAUREL_FOREST_HAG;
	}
}
