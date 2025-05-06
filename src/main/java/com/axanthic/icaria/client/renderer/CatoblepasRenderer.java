package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.model.CatoblepasModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.CatoblepasRenderState;
import com.axanthic.icaria.common.entity.CatoblepasEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CatoblepasRenderer extends MobRenderer<CatoblepasEntity, CatoblepasRenderState, CatoblepasModel> {
	public CatoblepasRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new CatoblepasModel(pContext.bakeLayer(IcariaModelLayerLocations.CATOBLEPAS)), 1.0F);
	}

	@Override
	public float getShadowRadius(CatoblepasRenderState pRenderState) {
		return pRenderState.shadowScale;
	}

	@Override
	public void extractRenderState(CatoblepasEntity pEntity, CatoblepasRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.renderScale = pEntity.getSizeForRender();
		pRenderState.shadowScale = pEntity.getSizeForShadow();
		pRenderState.size = pEntity.getSize();
		pRenderState.attackAnimationState = pEntity.attackAnimationState;
		pRenderState.eatingAnimationState = pEntity.eatingAnimationState;
	}

	@Override
	public void scale(CatoblepasRenderState pRenderState, PoseStack pPoseStack) {
		pPoseStack.scale(pRenderState.renderScale, pRenderState.renderScale, pRenderState.renderScale);
	}

	@Override
	public CatoblepasRenderState createRenderState() {
		return new CatoblepasRenderState();
	}

	@Override
	public ResourceLocation getTextureLocation(CatoblepasRenderState pRenderState) {
		return IcariaResourceLocations.CATOBLEPAS;
	}
}
