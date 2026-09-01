package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.CrystalSlugEmissiveRenderLayer;
import com.axanthic.icaria.client.layer.CrystalSlugRaysRenderLayer;
import com.axanthic.icaria.client.model.CrystalSlugModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.CrystalSlugRenderState;
import com.axanthic.icaria.common.entity.SlugEntity;
import com.axanthic.icaria.common.registry.IcariaIdentifiers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;
import com.mojang.math.Axis;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.resources.Identifier;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CrystalSlugRenderer extends MobRenderer<SlugEntity, CrystalSlugRenderState, CrystalSlugModel> {
	public CrystalSlugRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new CrystalSlugModel(pContext.bakeLayer(IcariaModelLayerLocations.CRYSTAL_SLUG_BODY)), 1.0F);
		this.addLayer(new CrystalSlugEmissiveRenderLayer(this));
		this.addLayer(new CrystalSlugRaysRenderLayer(this));
	}

	@Override
	public float getShadowRadius(CrystalSlugRenderState pRenderState) {
		return pRenderState.shadowScale;
	}

	@Override
	public void extractRenderState(SlugEntity pEntity, CrystalSlugRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
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
	public void scale(CrystalSlugRenderState pRenderState, PoseStack pPoseStack) {
		pPoseStack.scale(pRenderState.renderScale, pRenderState.renderScale, pRenderState.renderScale);
	}

	@Override
	public void setupRotations(CrystalSlugRenderState pRenderState, PoseStack pPoseStack, float pBodyRot, float pScale) {
		super.setupRotations(pRenderState, pPoseStack, pBodyRot, pScale);
		if (pRenderState.climbing) {
			pPoseStack.translate(0.0F, pRenderState.renderScale * 0.25F, 0.0F);
			pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
			pPoseStack.translate(0.0F, pRenderState.renderScale * -0.5F, 0.0F);
		}
	}

	@Override
	public void submit(CrystalSlugRenderState pRenderState, PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, CameraRenderState pCameraRenderState) {
		super.submit(pRenderState, pPoseStack, pSubmitNodeCollector, pCameraRenderState);
		this.shadowStrength = pRenderState.shadowStrength;
	}

	@Override
	public Identifier getTextureLocation(CrystalSlugRenderState pRenderState) {
		return IcariaIdentifiers.CRYSTAL_SLUG;
	}

	@Override
	public CrystalSlugRenderState createRenderState() {
		return new CrystalSlugRenderState();
	}
}
