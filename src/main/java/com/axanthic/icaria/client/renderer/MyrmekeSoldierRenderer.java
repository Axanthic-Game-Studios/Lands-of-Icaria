package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.client.layer.MyrmekeSoldierEmissiveRenderLayer;
import com.axanthic.icaria.client.model.MyrmekeSoldierModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.MyrmekeSoldierRenderState;
import com.axanthic.icaria.common.entity.MyrmekeSoldierEntity;
import com.axanthic.icaria.common.registry.IcariaIdentifiers;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.resources.Identifier;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class MyrmekeSoldierRenderer extends MobRenderer<MyrmekeSoldierEntity, MyrmekeSoldierRenderState, MyrmekeSoldierModel> {
	public MyrmekeSoldierRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new MyrmekeSoldierModel(pContext.bakeLayer(IcariaModelLayerLocations.MYRMEKE_SOLDIER)), 0.75F);
		this.addLayer(new MyrmekeSoldierEmissiveRenderLayer(this));
	}

	@Override
	public void extractRenderState(MyrmekeSoldierEntity pEntity, MyrmekeSoldierRenderState pRenderState, float pPartialTicks) {
		super.extractRenderState(pEntity, pRenderState, pPartialTicks);
		pRenderState.shadowStrength = pEntity.getShadowStrength();
		pRenderState.maxTick = pEntity.maxTick;
		pRenderState.tick = pEntity.getTick();
		pRenderState.attackAnimationState = pEntity.attackAnimationState;
		pRenderState.livingEntity = pEntity;
	}

	@Override
	public void submit(MyrmekeSoldierRenderState pRenderState, PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, CameraRenderState pCameraRenderState) {
		super.submit(pRenderState, pPoseStack, pSubmitNodeCollector, pCameraRenderState);
		this.shadowStrength = pRenderState.shadowStrength;
	}

	@Override
	public Identifier getTextureLocation(MyrmekeSoldierRenderState pRenderState) {
		return IcariaIdentifiers.MYRMEKE_SOLDIER;
	}

	@Override
	public MyrmekeSoldierRenderState createRenderState() {
		return new MyrmekeSoldierRenderState();
	}
}
