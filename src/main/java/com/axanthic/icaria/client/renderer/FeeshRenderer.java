package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.model.FeeshModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.FeeshRenderState;
import com.axanthic.icaria.common.entity.FeeshEntity;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FeeshRenderer extends MobRenderer<FeeshEntity, FeeshRenderState, FeeshModel> {
	public FeeshRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new FeeshModel(pContext.bakeLayer(IcariaModelLayerLocations.FEESH)), 1.0F);
	}

	@Override
	public float getShadowRadius(FeeshRenderState pRenderState) {
		return pRenderState.shadowScale;
	}

	@Override
	public void extractRenderState(FeeshEntity pEntity, FeeshRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.renderScale = pEntity.getSizeForRender();
		pRenderState.shadowScale = pEntity.getSizeForShadow();
		pRenderState.id = pEntity.getId();
		pRenderState.feeshVariant = pEntity.getVariant();
	}

	@Override
	public void scale(FeeshRenderState pRenderState, PoseStack pPoseStack) {
		pPoseStack.scale(pRenderState.renderScale, pRenderState.renderScale, pRenderState.renderScale);
	}

	@Override
	public FeeshRenderState createRenderState() {
		return new FeeshRenderState();
	}

	@Override
	public ResourceLocation getTextureLocation(FeeshRenderState pRenderState) {
		return pRenderState.feeshVariant.value().clientAsset().texturePath();
	}
}
