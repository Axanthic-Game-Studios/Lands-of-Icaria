package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.ForestSnullEmissiveLayer;
import com.axanthic.icaria.client.model.ForestSnullModel;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.client.state.ForestSnullRenderState;
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

public class ForestSnullRenderer extends MobRenderer<SnullEntity, ForestSnullRenderState, ForestSnullModel> {
	public ForestSnullRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new ForestSnullModel(pContext.bakeLayer(IcariaLayerLocations.FOREST_SNULL)), 1.0F);
		this.addLayer(new ForestSnullEmissiveLayer(this));
	}

	@Override
	public float getShadowRadius(ForestSnullRenderState pRenderState) {
		return pRenderState.shadowScale;
	}

	@Override
	public void extractRenderState(SnullEntity pEntity, ForestSnullRenderState pRenderState, float pPartialTick) {
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
	public void scale(ForestSnullRenderState pRenderState, PoseStack pPoseStack) {
		pPoseStack.scale(pRenderState.renderScale, pRenderState.renderScale, pRenderState.renderScale);
	}

	@Override
	public void setupRotations(ForestSnullRenderState pRenderState, PoseStack pPoseStack, float pBodyRot, float pScale) {
		super.setupRotations(pRenderState, pPoseStack, pBodyRot, pScale);
		if (pRenderState.climbing) {
			pPoseStack.translate(0.0F, pRenderState.renderScale * 0.25F, 0.0F);
			pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
			pPoseStack.translate(0.0F, pRenderState.renderScale * -0.5F, 0.0F);
		}
	}

	@Override
	public ForestSnullRenderState createRenderState() {
		return new ForestSnullRenderState();
	}

	@Override
	public ResourceLocation getTextureLocation(ForestSnullRenderState pRenderState) {
		return IcariaResourceLocations.FOREST_SNULL;
	}
}
