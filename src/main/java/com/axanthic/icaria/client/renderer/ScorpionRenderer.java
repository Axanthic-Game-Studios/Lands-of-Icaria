package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.ScorpionEmissiveRenderLayer;
import com.axanthic.icaria.client.model.ScorpionModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.ScorpionRenderState;
import com.axanthic.icaria.common.entity.ScorpionEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ScorpionRenderer extends MobRenderer<ScorpionEntity, ScorpionRenderState, ScorpionModel> {
	public ScorpionRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new ScorpionModel(pContext.bakeLayer(IcariaModelLayerLocations.SCORPION)), 1.375F);
		this.addLayer(new ScorpionEmissiveRenderLayer(this));
	}

	@Override
	public void extractRenderState(ScorpionEntity pEntity, ScorpionRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.attackAnimationState = pEntity.attackAnimationState;
		pRenderState.livingEntity = pEntity;
	}

	@Override
	public ScorpionRenderState createRenderState() {
		return new ScorpionRenderState();
	}

	@Override
	public ResourceLocation getTextureLocation(ScorpionRenderState pRenderState) {
		return IcariaResourceLocations.SCORPION;
	}
}
