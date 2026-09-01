package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.NatureJellyfishEmissiveRenderLayer;
import com.axanthic.icaria.client.model.NatureJellyfishModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.NatureJellyfishRenderState;
import com.axanthic.icaria.common.entity.NatureJellyfishEntity;
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

public class NatureJellyfishRenderer extends MobRenderer<NatureJellyfishEntity, NatureJellyfishRenderState, NatureJellyfishModel> {
	public NatureJellyfishRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new NatureJellyfishModel(pContext.bakeLayer(IcariaModelLayerLocations.NATURE_JELLYFISH)), 1.0F);
		this.addLayer(new NatureJellyfishEmissiveRenderLayer(this));
	}

	@Override
	public float getShadowRadius(NatureJellyfishRenderState pRenderState) {
		return pRenderState.shadowScale;
	}

	@Override
	public void extractRenderState(NatureJellyfishEntity pEntity, NatureJellyfishRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.renderScale = pEntity.getSizeForRender();
		pRenderState.shadowScale = pEntity.getSizeForShadow();
		pRenderState.tentacleAngle = Mth.lerp(pPartialTick, pEntity.tentacleAngleOld, pEntity.tentacleAngle);
		pRenderState.xBodyRot = Mth.lerp(pPartialTick, pEntity.xBodyRotOld, pEntity.xBodyRot);
		pRenderState.zBodyRot = Mth.lerp(pPartialTick, pEntity.zBodyRotOld, pEntity.zBodyRot);
		pRenderState.livingEntity = pEntity;
	}

	@Override
	public void scale(NatureJellyfishRenderState pRenderState, PoseStack pPoseStack) {
		pPoseStack.scale(pRenderState.renderScale, pRenderState.renderScale, pRenderState.renderScale);
	}

	@Override
	public void setupRotations(NatureJellyfishRenderState pRenderState, PoseStack pPoseStack, float pBodyRot, float pScale) {
		super.setupRotations(pRenderState, pPoseStack, pBodyRot, pScale);
		pPoseStack.translate(0.0F, pRenderState.renderScale * 0.5F, 0.0F);
		pPoseStack.mulPose(Axis.XP.rotationDegrees(pRenderState.xBodyRot));
		pPoseStack.mulPose(Axis.YP.rotationDegrees(pRenderState.zBodyRot));
		pPoseStack.translate(0.0F, pRenderState.renderScale * -1.0F, 0.0F);
	}

	@Override
	public Identifier getTextureLocation(NatureJellyfishRenderState pRenderState) {
		return IcariaIdentifiers.NATURE_JELLYFISH;
	}

	@Override
	public NatureJellyfishRenderState createRenderState() {
		return new NatureJellyfishRenderState();
	}
}
