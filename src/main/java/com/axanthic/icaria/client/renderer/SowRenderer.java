package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.model.SowModel;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.client.state.SowRenderState;
import com.axanthic.icaria.common.entity.SowEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SowRenderer extends MobRenderer<SowEntity, SowRenderState, SowModel> {
	public SowRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new SowModel(pContext.bakeLayer(IcariaLayerLocations.SOW)), 1.0F);
	}

	@Override
	public float getShadowRadius(SowRenderState pRenderState) {
		return pRenderState.shadowScale;
	}

	@Override
	public void extractRenderState(SowEntity pEntity, SowRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.renderScale = pEntity.getSizeForRender();
		pRenderState.shadowScale = pEntity.getSizeForShadow();
		pRenderState.size = pEntity.getSize();
		pRenderState.attackAnimationState = pEntity.attackAnimationState;
		pRenderState.eatingAnimationState = pEntity.eatingAnimationState;
	}

	@Override
	public void scale(SowRenderState pRenderState, PoseStack pPoseStack) {
		pPoseStack.scale(pRenderState.renderScale, pRenderState.renderScale, pRenderState.renderScale);
	}

	@Override
	public SowRenderState createRenderState() {
		return new SowRenderState();
	}

	@Override
	public ResourceLocation getTextureLocation(SowRenderState pRenderState) {
		return IcariaResourceLocations.SOW;
	}
}
