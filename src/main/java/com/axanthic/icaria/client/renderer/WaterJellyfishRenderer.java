package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.WaterJellyfishEmissiveRenderLayer;
import com.axanthic.icaria.client.model.WaterJellyfishModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.WaterJellyfishRenderState;
import com.axanthic.icaria.common.entity.WaterJellyfishEntity;
import com.axanthic.icaria.common.registry.IcariaIdentifiers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;
import com.mojang.math.Axis;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class WaterJellyfishRenderer extends MobRenderer<WaterJellyfishEntity, WaterJellyfishRenderState, WaterJellyfishModel> {
	public WaterJellyfishRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new WaterJellyfishModel(pContext.bakeLayer(IcariaModelLayerLocations.WATER_JELLYFISH)), 1.0F);
		this.addLayer(new WaterJellyfishEmissiveRenderLayer(this));
	}

	@Override
	public float getShadowRadius(WaterJellyfishRenderState pRenderState) {
		return pRenderState.shadowScale;
	}

	@Override
	public void extractRenderState(WaterJellyfishEntity pEntity, WaterJellyfishRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.renderScale = pEntity.getSizeForRender();
		pRenderState.shadowScale = pEntity.getSizeForShadow();
		pRenderState.tentacleAngle = Mth.lerp(pPartialTick, pEntity.tentacleAngleOld, pEntity.tentacleAngle);
		pRenderState.xBodyRot = Mth.lerp(pPartialTick, pEntity.xBodyRotOld, pEntity.xBodyRot);
		pRenderState.zBodyRot = Mth.lerp(pPartialTick, pEntity.zBodyRotOld, pEntity.zBodyRot);
		pRenderState.livingEntity = pEntity;
	}

	@Override
	public void scale(WaterJellyfishRenderState pRenderState, PoseStack pPoseStack) {
		pPoseStack.scale(pRenderState.renderScale, pRenderState.renderScale, pRenderState.renderScale);
	}

	@Override
	public void setupRotations(WaterJellyfishRenderState pRenderState, PoseStack pPoseStack, float pBodyRot, float pScale) {
		super.setupRotations(pRenderState, pPoseStack, pBodyRot, pScale);
		pPoseStack.translate(0.0F, pRenderState.renderScale * 0.5F, 0.0F);
		pPoseStack.mulPose(Axis.XP.rotationDegrees(pRenderState.xBodyRot));
		pPoseStack.mulPose(Axis.YP.rotationDegrees(pRenderState.zBodyRot));
		pPoseStack.translate(0.0F, pRenderState.renderScale * -1.0F, 0.0F);
	}

	@Override
	public Identifier getTextureLocation(WaterJellyfishRenderState pRenderState) {
		return IcariaIdentifiers.WATER_JELLYFISH;
	}

	@Override
	public WaterJellyfishRenderState createRenderState() {
		return new WaterJellyfishRenderState();
	}
}
