package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.model.ThogModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.ThogRenderState;
import com.axanthic.icaria.common.entity.ThogEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ThogRenderer extends MobRenderer<ThogEntity, ThogRenderState, ThogModel> {
	public ThogRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new ThogModel(pContext.bakeLayer(IcariaModelLayerLocations.THOG)), 1.0F);
	}

	@Override
	public float getShadowRadius(ThogRenderState pRenderState) {
		return pRenderState.shadowScale;
	}

	@Override
	public void extractRenderState(ThogEntity pEntity, ThogRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.renderScale = pEntity.getSizeForRender();
		pRenderState.shadowScale = pEntity.getSizeForShadow();
		pRenderState.size = pEntity.getSize();
		pRenderState.attackAnimationState = pEntity.attackAnimationState;
		pRenderState.eatingAnimationState = pEntity.eatingAnimationState;
	}

	@Override
	public void scale(ThogRenderState pRenderState, PoseStack pPoseStack) {
		pPoseStack.scale(pRenderState.renderScale, pRenderState.renderScale, pRenderState.renderScale);
	}

	@Override
	public ThogRenderState createRenderState() {
		return new ThogRenderState();
	}

	@Override
	public ResourceLocation getTextureLocation(ThogRenderState pRenderState) {
		return IcariaResourceLocations.THOG;
	}
}
