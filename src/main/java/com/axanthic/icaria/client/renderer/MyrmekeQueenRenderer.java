package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.MyrmekeQueenEmissiveRenderLayer;
import com.axanthic.icaria.client.layer.MyrmekeQueenRaysRenderLayer;
import com.axanthic.icaria.client.model.MyrmekeQueenModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.MyrmekeQueenRenderState;
import com.axanthic.icaria.common.entity.MyrmekeQueenEntity;
import com.axanthic.icaria.common.registry.IcariaIdentifiers;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class MyrmekeQueenRenderer extends MobRenderer<MyrmekeQueenEntity, MyrmekeQueenRenderState, MyrmekeQueenModel> {
	public MyrmekeQueenRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new MyrmekeQueenModel(pContext.bakeLayer(IcariaModelLayerLocations.MYRMEKE_QUEEN_BODY)), 0.75F);
		this.addLayer(new MyrmekeQueenEmissiveRenderLayer(this));
		this.addLayer(new MyrmekeQueenRaysRenderLayer(this));
	}

	@Override
	public void extractRenderState(MyrmekeQueenEntity pEntity, MyrmekeQueenRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.blue = pEntity.blue;
		pRenderState.green = pEntity.green;
		pRenderState.red = pEntity.red;
		pRenderState.livingEntity = pEntity;
	}

	@Override
	public Identifier getTextureLocation(MyrmekeQueenRenderState pRenderState) {
		return IcariaIdentifiers.MYRMEKE_QUEEN;
	}

	@Override
	public MyrmekeQueenRenderState createRenderState() {
		return new MyrmekeQueenRenderState();
	}
}
