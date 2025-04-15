package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.ArachneDroneEmissiveLayer;
import com.axanthic.icaria.client.model.ArachneDroneModel;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.client.state.ArachneDroneRenderState;
import com.axanthic.icaria.common.entity.ArachneDroneEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ArachneDroneRenderer extends MobRenderer<ArachneDroneEntity, ArachneDroneRenderState, ArachneDroneModel> {
	public ArachneDroneRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new ArachneDroneModel(pContext.bakeLayer(IcariaLayerLocations.ARACHNE_DRONE)), 1.0F);
		this.addLayer(new ArachneDroneEmissiveLayer(this));
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
	public ArachneDroneRenderState createRenderState() {
		return new ArachneDroneRenderState();
	}

	@Override
	public ResourceLocation getTextureLocation(ArachneDroneRenderState pRenderState) {
		return IcariaResourceLocations.ARACHNE_DRONE;
	}
}
