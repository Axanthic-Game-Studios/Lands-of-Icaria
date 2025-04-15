package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.CrystalSlugEmissiveLayer;
import com.axanthic.icaria.client.layer.CrystalSlugRaysLayer;
import com.axanthic.icaria.client.model.CrystalSlugModel;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.client.state.CrystalSlugRenderState;
import com.axanthic.icaria.common.entity.SlugEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CrystalSlugRenderer extends MobRenderer<SlugEntity, CrystalSlugRenderState, CrystalSlugModel> {
	public CrystalSlugRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new CrystalSlugModel(pContext.bakeLayer(IcariaLayerLocations.CRYSTAL_SLUG_BODY)), 1.0F);
		this.addLayer(new CrystalSlugEmissiveLayer(this));
		this.addLayer(new CrystalSlugRaysLayer(this));
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
	public void render(CrystalSlugRenderState pRenderState, PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight) {
		super.render(pRenderState, pPoseStack, pMultiBufferSource, pPackedLight);
		this.shadowStrength = pRenderState.shadowStrength;
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
	public CrystalSlugRenderState createRenderState() {
		return new CrystalSlugRenderState();
	}

	@Override
	public ResourceLocation getTextureLocation(CrystalSlugRenderState pRenderState) {
		return IcariaResourceLocations.CRYSTAL_SLUG;
	}
}
