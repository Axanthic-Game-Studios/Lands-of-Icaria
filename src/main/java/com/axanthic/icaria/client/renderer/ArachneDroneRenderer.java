package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.ArachneDroneEmissiveRenderLayer;
import com.axanthic.icaria.client.model.ArachneDroneModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.ArachneDroneRenderState;
import com.axanthic.icaria.common.entity.ArachneDroneEntity;
import com.axanthic.icaria.common.registry.IcariaIdentifiers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ArachneDroneRenderer extends MobRenderer<ArachneDroneEntity, ArachneDroneRenderState, ArachneDroneModel> {
	public ArachneDroneRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new ArachneDroneModel(pContext.bakeLayer(IcariaModelLayerLocations.ARACHNE_DRONE)), 1.0F);
		this.addLayer(new ArachneDroneEmissiveRenderLayer(this));
	}

	@Override
	public float getShadowRadius(ArachneDroneRenderState pRenderState) {
		return pRenderState.shadowScale;
	}

	@Override
	public void extractRenderState(ArachneDroneEntity pEntity, ArachneDroneRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.renderScale = pEntity.getSizeForRender();
		pRenderState.shadowScale = pEntity.getSizeForShadow();
		pRenderState.attackAnimationState = pEntity.attackAnimationState;
		pRenderState.livingEntity = pEntity;
	}

	@Override
	public void scale(ArachneDroneRenderState pRenderState, PoseStack pPoseStack) {
		pPoseStack.scale(pRenderState.renderScale, pRenderState.renderScale, pRenderState.renderScale);
	}

	@Override
	public Identifier getTextureLocation(ArachneDroneRenderState pRenderState) {
		return IcariaIdentifiers.ARACHNE_DRONE;
	}

	@Override
	public ArachneDroneRenderState createRenderState() {
		return new ArachneDroneRenderState();
	}
}
