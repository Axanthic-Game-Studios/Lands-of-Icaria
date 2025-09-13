package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.model.FisshhModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.FisshhRenderState;
import com.axanthic.icaria.common.entity.FisshhEntity;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

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
	public void extractRenderState(FisshhEntity pEntity, FisshhRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
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
	public FisshhRenderState createRenderState() {
		return new FisshhRenderState();
	}

	@Override
	public ResourceLocation getTextureLocation(FisshhRenderState pRenderState) {
		return pRenderState.fisshhVariant.value().clientAsset().texturePath();
	}
}
