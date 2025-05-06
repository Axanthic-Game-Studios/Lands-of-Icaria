package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.MyrmekeSoldierEmissiveLayer;
import com.axanthic.icaria.client.model.MyrmekeSoldierModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.MyrmekeSoldierRenderState;
import com.axanthic.icaria.common.entity.MyrmekeSoldierEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class MyrmekeSoldierRenderer extends MobRenderer<MyrmekeSoldierEntity, MyrmekeSoldierRenderState, MyrmekeSoldierModel> {
	public MyrmekeSoldierRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new MyrmekeSoldierModel(pContext.bakeLayer(IcariaModelLayerLocations.MYRMEKE_SOLDIER)), 0.75F);
		this.addLayer(new MyrmekeSoldierEmissiveLayer(this));
	}

	@Override
	public void extractRenderState(MyrmekeSoldierEntity pEntity, MyrmekeSoldierRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.shadowStrength = pEntity.getShadowStrength();
		pRenderState.maxTick = pEntity.maxTick;
		pRenderState.tick = pEntity.getTick();
		pRenderState.attackAnimationState = pEntity.attackAnimationState;
		pRenderState.livingEntity = pEntity;
	}

	@Override
	public void render(MyrmekeSoldierRenderState pRenderState, PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight) {
		super.render(pRenderState, pPoseStack, pMultiBufferSource, pPackedLight);
		this.shadowStrength = pRenderState.shadowStrength;
	}

	@Override
	public MyrmekeSoldierRenderState createRenderState() {
		return new MyrmekeSoldierRenderState();
	}

	@Override
	public ResourceLocation getTextureLocation(MyrmekeSoldierRenderState pRenderState) {
		return IcariaResourceLocations.MYRMEKE_SOLDIER;
	}
}
