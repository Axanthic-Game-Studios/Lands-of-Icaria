package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.VoidJellyfishEmissiveLayer;
import com.axanthic.icaria.client.model.VoidJellyfishModel;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.client.state.VoidJellyfishRenderState;
import com.axanthic.icaria.common.entity.VoidJellyfishEntity;
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

public class VoidJellyfishRenderer extends MobRenderer<VoidJellyfishEntity, VoidJellyfishRenderState, VoidJellyfishModel> {
	public VoidJellyfishRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new VoidJellyfishModel(pContext.bakeLayer(IcariaLayerLocations.VOID_JELLYFISH)), 1.0F);
		this.addLayer(new VoidJellyfishEmissiveLayer(this));
	}

	@Override
	public float getShadowRadius(VoidJellyfishRenderState pRenderState) {
		return pRenderState.shadowScale;
	}

	@Override
	public void extractRenderState(VoidJellyfishEntity pEntity, VoidJellyfishRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.renderScale = pEntity.getSizeForRender();
		pRenderState.shadowScale = pEntity.getSizeForShadow();
		pRenderState.tentacleAngle = Mth.lerp(pPartialTick, pEntity.tentacleAngleOld, pEntity.tentacleAngle);
		pRenderState.xBodyRot = Mth.lerp(pPartialTick, pEntity.xBodyRotOld, pEntity.xBodyRot);
		pRenderState.zBodyRot = Mth.lerp(pPartialTick, pEntity.zBodyRotOld, pEntity.zBodyRot);
		pRenderState.livingEntity = pEntity;
	}

	@Override
	public void scale(VoidJellyfishRenderState pRenderState, PoseStack pPoseStack) {
		pPoseStack.scale(pRenderState.renderScale, pRenderState.renderScale, pRenderState.renderScale);
	}

	@Override
	public void setupRotations(VoidJellyfishRenderState pRenderState, PoseStack pPoseStack, float pBodyRot, float pScale) {
		super.setupRotations(pRenderState, pPoseStack, pBodyRot, pScale);
		pPoseStack.translate(0.0F, pRenderState.renderScale * 0.5F, 0.0F);
		pPoseStack.mulPose(Axis.XP.rotationDegrees(pRenderState.xBodyRot));
		pPoseStack.mulPose(Axis.YP.rotationDegrees(pRenderState.zBodyRot));
		pPoseStack.translate(0.0F, pRenderState.renderScale * -1.0F, 0.0F);
	}

	@Override
	public VoidJellyfishRenderState createRenderState() {
		return new VoidJellyfishRenderState();
	}

	@Override
	public ResourceLocation getTextureLocation(VoidJellyfishRenderState pRenderState) {
		return IcariaResourceLocations.VOID_JELLYFISH;
	}
}
