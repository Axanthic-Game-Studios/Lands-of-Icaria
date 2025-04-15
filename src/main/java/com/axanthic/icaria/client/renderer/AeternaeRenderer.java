package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.model.AeternaeModel;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.client.state.AeternaeRenderState;
import com.axanthic.icaria.common.entity.AeternaeEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class AeternaeRenderer extends MobRenderer<AeternaeEntity, AeternaeRenderState, AeternaeModel> {
	public AeternaeRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new AeternaeModel(pContext.bakeLayer(IcariaLayerLocations.AETERNAE)), 1.0F);
	}

	@Override
	public float getShadowRadius(AeternaeRenderState pRenderState) {
		return pRenderState.shadowScale;
	}

	@Override
	public void extractRenderState(AeternaeEntity pEntity, AeternaeRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.renderScale = pEntity.getSizeForRender();
		pRenderState.shadowScale = pEntity.getSizeForShadow();
		pRenderState.size = pEntity.getSize();
		pRenderState.attackAnimationState = pEntity.attackAnimationState;
		pRenderState.eatingAnimationState = pEntity.eatingAnimationState;
	}

	@Override
	public void scale(AeternaeRenderState pRenderState, PoseStack pPoseStack) {
		pPoseStack.scale(pRenderState.renderScale, pRenderState.renderScale, pRenderState.renderScale);
	}

	@Override
	public AeternaeRenderState createRenderState() {
		return new AeternaeRenderState();
	}

	@Override
	public ResourceLocation getTextureLocation(AeternaeRenderState pRenderState) {
		return IcariaResourceLocations.AETERNAE;
	}
}
