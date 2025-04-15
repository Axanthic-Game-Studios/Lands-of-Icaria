package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.HyliasterTranslucentLayer;
import com.axanthic.icaria.client.model.HyliasterModel;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.client.state.HyliasterRenderState;
import com.axanthic.icaria.common.entity.HyliasterEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class HyliasterRenderer extends MobRenderer<HyliasterEntity, HyliasterRenderState, HyliasterModel> {
	public HyliasterRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new HyliasterModel(pContext.bakeLayer(IcariaLayerLocations.HYLIASTER)), 1.0F);
		this.addLayer(new HyliasterTranslucentLayer(this));
	}

	@Override
	public float getShadowRadius(HyliasterRenderState pRenderState) {
		return pRenderState.shadowScale;
	}

	@Override
	public void extractRenderState(HyliasterEntity pEntity, HyliasterRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.renderScale = pEntity.getSizeForRender();
		pRenderState.shadowScale = pEntity.getSizeForShadow();
		pRenderState.size = pEntity.getSize();
		pRenderState.moveAnimationState = pEntity.moveAnimationState;
		pRenderState.livingEntity = pEntity;
	}

	@Override
	public void scale(HyliasterRenderState pRenderState, PoseStack pPoseStack) {
		pPoseStack.scale(pRenderState.renderScale, pRenderState.renderScale, pRenderState.renderScale);
	}

	@Override
	public HyliasterRenderState createRenderState() {
		return new HyliasterRenderState();
	}

	@Override
	public ResourceLocation getTextureLocation(HyliasterRenderState pRenderState) {
		return IcariaResourceLocations.HYLIASTER;
	}
}
