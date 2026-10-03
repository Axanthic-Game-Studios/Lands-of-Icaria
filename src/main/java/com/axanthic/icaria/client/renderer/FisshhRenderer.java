package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.client.model.FisshhModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.FisshhRenderState;
import com.axanthic.icaria.common.entity.FisshhEntity;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FisshhRenderer extends MobRenderer<FisshhEntity, FisshhRenderState, FisshhModel> {
	public FisshhRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new FisshhModel(pContext.bakeLayer(IcariaModelLayerLocations.FISSHH)), 1.0F);
	}

	@Override
	public float getShadowRadius(FisshhRenderState pRenderState) {
		return pRenderState.shadowScale;
	}

	@Override
	public void extractRenderState(FisshhEntity pEntity, FisshhRenderState pRenderState, float pPartialTicks) {
		super.extractRenderState(pEntity, pRenderState, pPartialTicks);
		pRenderState.renderScale = pEntity.getSizeForRender();
		pRenderState.shadowScale = pEntity.getSizeForShadow();
		pRenderState.id = pEntity.getId();
		pRenderState.fisshhVariant = pEntity.getVariant();
	}

	@Override
	public void scale(FisshhRenderState pRenderState, PoseStack pPoseStack) {
		pPoseStack.scale(pRenderState.renderScale, pRenderState.renderScale, pRenderState.renderScale);
	}

	@Override
	public Identifier getTextureLocation(FisshhRenderState pRenderState) {
		return pRenderState.fisshhVariant.value().resourceTexture().texturePath();
	}

	@Override
	public FisshhRenderState createRenderState() {
		return new FisshhRenderState();
	}
}
