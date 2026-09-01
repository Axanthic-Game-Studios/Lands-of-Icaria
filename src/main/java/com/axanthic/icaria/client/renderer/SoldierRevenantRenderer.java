package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.SoldierRevenantEmissiveRenderLayer;
import com.axanthic.icaria.client.layer.SoldierRevenantItemRenderLayer;
import com.axanthic.icaria.client.model.SoldierRevenantModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.SoldierRevenantRenderState;
import com.axanthic.icaria.common.entity.SoldierRevenantEntity;
import com.axanthic.icaria.common.registry.IcariaIdentifiers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemDisplayContext;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SoldierRevenantRenderer extends MobRenderer<SoldierRevenantEntity, SoldierRevenantRenderState, SoldierRevenantModel> {
	public SoldierRevenantRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new SoldierRevenantModel(pContext.bakeLayer(IcariaModelLayerLocations.SOLDIER_REVENANT_BODY)), 0.5F);
		this.addLayer(new SoldierRevenantEmissiveRenderLayer(this));
		this.addLayer(new SoldierRevenantItemRenderLayer(this));
	}

	@Override
	public void extractRenderState(SoldierRevenantEntity pEntity, SoldierRevenantRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.attackTime = pEntity.getAttackAnim(pPartialTick);
		pRenderState.id = pEntity.getId();
		pRenderState.itemStackRenderState = new ItemStackRenderState();
		pRenderState.livingEntity = pEntity;
		this.itemModelResolver.updateForLiving(pRenderState.itemStackRenderState, pEntity.getMainHandItem(), ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, pEntity);
	}

	@Override
	public void scale(SoldierRevenantRenderState pRenderState, PoseStack pPoseStack) {
		pPoseStack.scale(0.875F, 0.875F, 0.875F);
	}

	@Override
	public Identifier getTextureLocation(SoldierRevenantRenderState pRenderState) {
		return IcariaIdentifiers.SOLDIER_REVENANT;
	}

	@Override
	public SoldierRevenantRenderState createRenderState() {
		return new SoldierRevenantRenderState();
	}
}
