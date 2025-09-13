package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.model.FyshModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.FyshRenderState;
import com.axanthic.icaria.common.entity.FyshEntity;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FyshRenderer extends MobRenderer<FyshEntity, FyshRenderState, FyshModel> {
	public FyshRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new FyshModel(pContext.bakeLayer(IcariaModelLayerLocations.FYSH)), 1.0F);
	}

	@Override
	public float getShadowRadius(FyshRenderState pRenderState) {
		return pRenderState.shadowScale;
	}

	@Override
	public void extractRenderState(FyshEntity pEntity, FyshRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.renderScale = pEntity.getSizeForRender();
		pRenderState.shadowScale = pEntity.getSizeForShadow();
		pRenderState.id = pEntity.getId();
		pRenderState.fyshVariant = pEntity.getVariant();
	}

	@Override
	public void scale(FyshRenderState pRenderState, PoseStack pPoseStack) {
		pPoseStack.scale(pRenderState.renderScale, pRenderState.renderScale, pRenderState.renderScale);
	}

	@Override
	public FyshRenderState createRenderState() {
		return new FyshRenderState();
	}

	@Override
	public ResourceLocation getTextureLocation(FyshRenderState pRenderState) {
		return pRenderState.fyshVariant.value().clientAsset().texturePath();
	}
}
