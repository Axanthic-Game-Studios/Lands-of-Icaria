package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.CaptainRevenantEmissiveRenderLayer;
import com.axanthic.icaria.client.layer.CaptainRevenantItemRenderLayer;
import com.axanthic.icaria.client.model.CaptainRevenantModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.CaptainRevenantRenderState;
import com.axanthic.icaria.common.entity.CaptainRevenantEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CaptainRevenantRenderer extends MobRenderer<CaptainRevenantEntity, CaptainRevenantRenderState, CaptainRevenantModel> {
	public CaptainRevenantRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new CaptainRevenantModel(pContext.bakeLayer(IcariaModelLayerLocations.CAPTAIN_REVENANT_BODY)), 0.5F);
		this.addLayer(new CaptainRevenantEmissiveRenderLayer(this));
		this.addLayer(new CaptainRevenantItemRenderLayer(this));
	}

	@Override
	public void extractRenderState(CaptainRevenantEntity pEntity, CaptainRevenantRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.onRallying = pEntity.onRallying();
		pRenderState.attackTime = pEntity.getAttackAnim(pPartialTick);
		pRenderState.id = pEntity.getId();
		pRenderState.maxReequips = pEntity.maxReequips;
		pRenderState.maxUnequips = pEntity.maxUnequips;
		pRenderState.reequips = pEntity.getReequips();
		pRenderState.unequips = pEntity.getUnequips();
		pRenderState.rallyingAnimationState = pEntity.rallyingAnimationState;
		pRenderState.reequipsAnimationState = pEntity.reequipsAnimationState;
		pRenderState.unequipsAnimationState = pEntity.unequipsAnimationState;
		pRenderState.itemStackRenderState = new ItemStackRenderState();
		pRenderState.livingEntity = pEntity;
		this.itemModelResolver.updateForLiving(pRenderState.itemStackRenderState, pEntity.getMainHandItem(), ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, pEntity);
	}

	@Override
	public void scale(CaptainRevenantRenderState pRenderState, PoseStack pPoseStack) {
		pPoseStack.scale(0.875F, 0.875F, 0.875F);
	}

	@Override
	public CaptainRevenantRenderState createRenderState() {
		return new CaptainRevenantRenderState();
	}

	@Override
	public ResourceLocation getTextureLocation(CaptainRevenantRenderState pRenderState) {
		return IcariaResourceLocations.CAPTAIN_REVENANT;
	}
}
