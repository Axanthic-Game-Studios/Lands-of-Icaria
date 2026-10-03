package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.client.layer.ClusterSlugEmissiveRenderLayer;
import com.axanthic.icaria.client.layer.ClusterSlugRaysRenderLayer;
import com.axanthic.icaria.client.model.ClusterSlugModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.ClusterSlugRenderState;
import com.axanthic.icaria.common.entity.SlugEntity;
import com.axanthic.icaria.common.registry.IcariaIdentifiers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.resources.Identifier;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ClusterSlugRenderer extends MobRenderer<SlugEntity, ClusterSlugRenderState, ClusterSlugModel> {
	public ClusterSlugRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new ClusterSlugModel(pContext.bakeLayer(IcariaModelLayerLocations.CLUSTER_SLUG_BODY)), 1.0F);
		this.addLayer(new ClusterSlugEmissiveRenderLayer(this));
		this.addLayer(new ClusterSlugRaysRenderLayer(this));
	}

	@Override
	public float getShadowRadius(ClusterSlugRenderState pRenderState) {
		return pRenderState.shadowScale;
	}

	@Override
	public void extractRenderState(SlugEntity pEntity, ClusterSlugRenderState pRenderState, float pPartialTicks) {
		super.extractRenderState(pEntity, pRenderState, pPartialTicks);
		pRenderState.climbing = pEntity.getClimbing();
		pRenderState.blue = pEntity.blue;
		pRenderState.green = pEntity.green;
		pRenderState.red = pEntity.red;
		pRenderState.renderScale = pEntity.getSizeForRender();
		pRenderState.shadowScale = pEntity.getSizeForShadow();
		pRenderState.shadowStrength = pEntity.getShadowStrength();
		pRenderState.hideAnimationState = pEntity.hideAnimationState;
		pRenderState.hurtAnimationState = pEntity.hurtAnimationState;
		pRenderState.moveAnimationState = pEntity.moveAnimationState;
		pRenderState.showAnimationState = pEntity.showAnimationState;
		pRenderState.livingEntity = pEntity;
	}

	@Override
	public void scale(ClusterSlugRenderState pRenderState, PoseStack pPoseStack) {
		pPoseStack.scale(pRenderState.renderScale, pRenderState.renderScale, pRenderState.renderScale);
	}

	@Override
	public void setupRotations(ClusterSlugRenderState pRenderState, PoseStack pPoseStack, float pBodyRot, float pEntityScale) {
		super.setupRotations(pRenderState, pPoseStack, pBodyRot, pEntityScale);
		if (pRenderState.climbing) {
			pPoseStack.translate(0.0F, pRenderState.renderScale * 0.25F, 0.0F);
			pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
			pPoseStack.translate(0.0F, pRenderState.renderScale * -0.5F, 0.0F);
		}
	}

	@Override
	public void submit(ClusterSlugRenderState pRenderState, PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, CameraRenderState pCameraRenderState) {
		super.submit(pRenderState, pPoseStack, pSubmitNodeCollector, pCameraRenderState);
		this.shadowStrength = pRenderState.shadowStrength;
	}

	@Override
	public Identifier getTextureLocation(ClusterSlugRenderState pRenderState) {
		return IcariaIdentifiers.CLUSTER_SLUG;
	}

	@Override
	public ClusterSlugRenderState createRenderState() {
		return new ClusterSlugRenderState();
	}
}
