package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.VinegaroonEmissiveRenderLayer;
import com.axanthic.icaria.client.model.VinegaroonModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.VinegaroonRenderState;
import com.axanthic.icaria.common.entity.VinegaroonEntity;
import com.axanthic.icaria.common.registry.IcariaIdentifiers;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class VinegaroonRenderer extends MobRenderer<VinegaroonEntity, VinegaroonRenderState, VinegaroonModel> {
	public VinegaroonRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new VinegaroonModel(pContext.bakeLayer(IcariaModelLayerLocations.VINEGAROON)), 1.375F);
		this.addLayer(new VinegaroonEmissiveRenderLayer(this));
	}

	@Override
	public void extractRenderState(VinegaroonEntity pEntity, VinegaroonRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.isRidden = pEntity.hasExactlyOnePlayerPassenger();
		pRenderState.attackAnimationState = pEntity.attackAnimationState;
		pRenderState.livingEntity = pEntity;
	}

	@Override
	public Identifier getTextureLocation(VinegaroonRenderState pRenderState) {
		return IcariaIdentifiers.VINEGAROON;
	}

	@Override
	public VinegaroonRenderState createRenderState() {
		return new VinegaroonRenderState();
	}
}
