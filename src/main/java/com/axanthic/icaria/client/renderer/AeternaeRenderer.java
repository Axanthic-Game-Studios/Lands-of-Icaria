package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.model.AeternaeModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.AeternaeRenderState;
import com.axanthic.icaria.common.entity.AeternaeEntity;
import com.axanthic.icaria.common.registry.IcariaIdentifiers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class AeternaeRenderer extends MobRenderer<AeternaeEntity, AeternaeRenderState, AeternaeModel> {
	public AeternaeRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new AeternaeModel(pContext.bakeLayer(IcariaModelLayerLocations.AETERNAE)), 1.0F);
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
	public Identifier getTextureLocation(AeternaeRenderState pRenderState) {
		return IcariaIdentifiers.AETERNAE;
	}

	@Override
	public AeternaeRenderState createRenderState() {
		return new AeternaeRenderState();
	}
}
