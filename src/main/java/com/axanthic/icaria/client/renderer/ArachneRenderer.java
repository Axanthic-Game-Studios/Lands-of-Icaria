package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.ArachneEmissiveRenderLayer;
import com.axanthic.icaria.client.model.ArachneModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.ArachneRenderState;
import com.axanthic.icaria.common.entity.ArachneEntity;
import com.axanthic.icaria.common.registry.IcariaIdentifiers;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ArachneRenderer extends MobRenderer<ArachneEntity, ArachneRenderState, ArachneModel> {
	public ArachneRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new ArachneModel(pContext.bakeLayer(IcariaModelLayerLocations.ARACHNE)), 1.25F);
		this.addLayer(new ArachneEmissiveRenderLayer(this));
	}

	@Override
	public void extractRenderState(ArachneEntity pEntity, ArachneRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.attackAnimationState = pEntity.attackAnimationState;
		pRenderState.livingEntity = pEntity;
	}

	@Override
	public Identifier getTextureLocation(ArachneRenderState pRenderState) {
		return IcariaIdentifiers.ARACHNE;
	}

	@Override
	public ArachneRenderState createRenderState() {
		return new ArachneRenderState();
	}
}
