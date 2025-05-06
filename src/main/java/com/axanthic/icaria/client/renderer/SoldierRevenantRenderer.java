package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.SoldierRevenantEmissiveLayer;
import com.axanthic.icaria.client.layer.SoldierRevenantItemLayer;
import com.axanthic.icaria.client.model.SoldierRevenantModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.SoldierRevenantRenderState;
import com.axanthic.icaria.common.entity.SoldierRevenantEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SoldierRevenantRenderer extends MobRenderer<SoldierRevenantEntity, SoldierRevenantRenderState, SoldierRevenantModel> {
	public SoldierRevenantRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new SoldierRevenantModel(pContext.bakeLayer(IcariaModelLayerLocations.SOLDIER_REVENANT_BODY)), 0.5F);
		this.addLayer(new SoldierRevenantEmissiveLayer(this));
		this.addLayer(new SoldierRevenantItemLayer(this));
	}

	@Override
	public void extractRenderState(SoldierRevenantEntity pEntity, SoldierRevenantRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.attackTime = pEntity.getAttackAnim(pPartialTick);
		pRenderState.id = pEntity.getId();
		pRenderState.livingEntity = pEntity;
	}

	@Override
	public void scale(SoldierRevenantRenderState pRenderState, PoseStack pPoseStack) {
		pPoseStack.scale(0.875F, 0.875F, 0.875F);
	}

	@Override
	public SoldierRevenantRenderState createRenderState() {
		return new SoldierRevenantRenderState();
	}

	@Override
	public ResourceLocation getTextureLocation(SoldierRevenantRenderState pRenderState) {
		return IcariaResourceLocations.SOLDIER_REVENANT;
	}
}
