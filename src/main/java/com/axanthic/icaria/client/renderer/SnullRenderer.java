package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.SnullEmissiveLayer;
import com.axanthic.icaria.client.model.SnullModel;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.client.state.SnullRenderState;
import com.axanthic.icaria.common.entity.SnullEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SnullRenderer extends MobRenderer<SnullEntity, SnullRenderState, SnullModel> {
	public SnullRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new SnullModel(pContext.bakeLayer(IcariaLayerLocations.SNULL)), 1.0F);
		this.addLayer(new SnullEmissiveLayer(this));
	}

	@Override
	public float getShadowRadius(SnullRenderState pRenderState) {
		return pRenderState.shadowScale;
	}

	@Override
	public void extractRenderState(SnullEntity pEntity, SnullRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.climbing = pEntity.getClimbing();
		pRenderState.renderScale = pEntity.getSizeForRender();
		pRenderState.shadowScale = pEntity.getSizeForShadow();
		pRenderState.hideAnimationState = pEntity.hideAnimationState;
		pRenderState.hurtAnimationState = pEntity.hurtAnimationState;
		pRenderState.idleAnimationState = pEntity.idleAnimationState;
		pRenderState.moveAnimationState = pEntity.moveAnimationState;
		pRenderState.showAnimationState = pEntity.showAnimationState;
		pRenderState.livingEntity = pEntity;
	}

	@Override
	public void scale(SnullRenderState pRenderState, PoseStack pPoseStack) {
		pPoseStack.scale(pRenderState.renderScale, pRenderState.renderScale, pRenderState.renderScale);
	}

	@Override
	public void setupRotations(SnullRenderState pRenderState, PoseStack pPoseStack, float pBodyRot, float pScale) {
		super.setupRotations(pRenderState, pPoseStack, pBodyRot, pScale);
		if (pRenderState.climbing) {
			pPoseStack.translate(0.0F, pRenderState.renderScale * 0.25F, 0.0F);
			pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
			pPoseStack.translate(0.0F, pRenderState.renderScale * -0.5F, 0.0F);
		}
	}

	@Override
	public SnullRenderState createRenderState() {
		return new SnullRenderState();
	}

	@Override
	public ResourceLocation getTextureLocation(SnullRenderState pRenderState) {
		return IcariaResourceLocations.SNULL;
	}
}
