package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.FireJellyfishEmissiveLayer;
import com.axanthic.icaria.client.model.FireJellyfishModel;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.client.state.FireJellyfishRenderState;
import com.axanthic.icaria.common.entity.FireJellyfishEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FireJellyfishRenderer extends MobRenderer<FireJellyfishEntity, FireJellyfishRenderState, FireJellyfishModel> {
	public FireJellyfishRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new FireJellyfishModel(pContext.bakeLayer(IcariaLayerLocations.FIRE_JELLYFISH)), 1.0F);
		this.addLayer(new FireJellyfishEmissiveLayer(this));
	}

	@Override
	public float getShadowRadius(FireJellyfishRenderState pRenderState) {
		return pRenderState.shadowScale;
	}

	@Override
	public void extractRenderState(FireJellyfishEntity pEntity, FireJellyfishRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.renderScale = pEntity.getSizeForRender();
		pRenderState.shadowScale = pEntity.getSizeForShadow();
		pRenderState.tentacleAngle = Mth.lerp(pPartialTick, pEntity.tentacleAngleOld, pEntity.tentacleAngle);
		pRenderState.xBodyRot = Mth.lerp(pPartialTick, pEntity.xBodyRotOld, pEntity.xBodyRot);
		pRenderState.zBodyRot = Mth.lerp(pPartialTick, pEntity.zBodyRotOld, pEntity.zBodyRot);
		pRenderState.livingEntity = pEntity;
	}

	@Override
	public void scale(FireJellyfishRenderState pRenderState, PoseStack pPoseStack) {
		pPoseStack.scale(pRenderState.renderScale, pRenderState.renderScale, pRenderState.renderScale);
	}

	@Override
	public void setupRotations(FireJellyfishRenderState pRenderState, PoseStack pPoseStack, float pBodyRot, float pScale) {
		super.setupRotations(pRenderState, pPoseStack, pBodyRot, pScale);
		pPoseStack.translate(0.0F, pRenderState.renderScale * 0.5F, 0.0F);
		pPoseStack.mulPose(Axis.XP.rotationDegrees(pRenderState.xBodyRot));
		pPoseStack.mulPose(Axis.YP.rotationDegrees(pRenderState.zBodyRot));
		pPoseStack.translate(0.0F, pRenderState.renderScale * -1.0F, 0.0F);
	}

	@Override
	public FireJellyfishRenderState createRenderState() {
		return new FireJellyfishRenderState();
	}

	@Override
	public ResourceLocation getTextureLocation(FireJellyfishRenderState pRenderState) {
		return IcariaResourceLocations.FIRE_JELLYFISH;
	}
}
