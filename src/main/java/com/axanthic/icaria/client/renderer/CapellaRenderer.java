package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.model.CapellaModel;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.client.state.CapellaRenderState;
import com.axanthic.icaria.common.entity.CapellaEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CapellaRenderer extends MobRenderer<CapellaEntity, CapellaRenderState, CapellaModel> {
	public CapellaRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new CapellaModel(pContext.bakeLayer(IcariaLayerLocations.CAPELLA)), 1.0F);
	}

	@Override
	public float getShadowRadius(CapellaRenderState pRenderState) {
		return pRenderState.shadowScale;
	}

	@Override
	public void extractRenderState(CapellaEntity pEntity, CapellaRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.renderScale = pEntity.getSizeForRender();
		pRenderState.shadowScale = pEntity.getSizeForShadow();
		pRenderState.size = pEntity.getSize();
		pRenderState.attackAnimationState = pEntity.attackAnimationState;
		pRenderState.eatingAnimationState = pEntity.eatingAnimationState;
	}

	@Override
	public void scale(CapellaRenderState pRenderState, PoseStack pPoseStack) {
		pPoseStack.scale(pRenderState.renderScale, pRenderState.renderScale, pRenderState.renderScale);
	}

	@Override
	public CapellaRenderState createRenderState() {
		return new CapellaRenderState();
	}

	@Override
	public ResourceLocation getTextureLocation(CapellaRenderState pRenderState) {
		return IcariaResourceLocations.CAPELLA;
	}
}
