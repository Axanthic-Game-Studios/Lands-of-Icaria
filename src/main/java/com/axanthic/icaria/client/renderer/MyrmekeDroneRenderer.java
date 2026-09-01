package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.MyrmekeDroneEmissiveRenderLayer;
import com.axanthic.icaria.client.model.MyrmekeDroneModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.MyrmekeDroneRenderState;
import com.axanthic.icaria.common.entity.MyrmekeDroneEntity;
import com.axanthic.icaria.common.registry.IcariaIdentifiers;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class MyrmekeDroneRenderer extends MobRenderer<MyrmekeDroneEntity, MyrmekeDroneRenderState, MyrmekeDroneModel> {
	public MyrmekeDroneRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new MyrmekeDroneModel(pContext.bakeLayer(IcariaModelLayerLocations.MYRMEKE_DRONE)), 0.75F);
		this.addLayer(new MyrmekeDroneEmissiveRenderLayer(this));
	}

	@Override
	public void extractRenderState(MyrmekeDroneEntity pEntity, MyrmekeDroneRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.attackAnimationState = pEntity.attackAnimationState;
		pRenderState.livingEntity = pEntity;
	}

	@Override
	public Identifier getTextureLocation(MyrmekeDroneRenderState pRenderState) {
		return IcariaIdentifiers.MYRMEKE_DRONE;
	}

	@Override
	public MyrmekeDroneRenderState createRenderState() {
		return new MyrmekeDroneRenderState();
	}
}
