package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.model.FicheModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.FicheRenderState;
import com.axanthic.icaria.common.entity.FicheEntity;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FicheRenderer extends MobRenderer<FicheEntity, FicheRenderState, FicheModel> {
	public FicheRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new FicheModel(pContext.bakeLayer(IcariaModelLayerLocations.FICHE)), 1.0F);
	}

	@Override
	public float getShadowRadius(FicheRenderState pRenderState) {
		return pRenderState.shadowScale;
	}

	@Override
	public void extractRenderState(FicheEntity pEntity, FicheRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.renderScale = pEntity.getSizeForRender();
		pRenderState.shadowScale = pEntity.getSizeForShadow();
		pRenderState.id = pEntity.getId();
		pRenderState.ficheVariant = pEntity.getVariant();
	}

	@Override
	public void scale(FicheRenderState pRenderState, PoseStack pPoseStack) {
		pPoseStack.scale(pRenderState.renderScale, pRenderState.renderScale, pRenderState.renderScale);
	}

	@Override
	public FicheRenderState createRenderState() {
		return new FicheRenderState();
	}

	@Override
	public ResourceLocation getTextureLocation(FicheRenderState pRenderState) {
		return pRenderState.ficheVariant.value().clientAsset().texturePath();
	}
}
