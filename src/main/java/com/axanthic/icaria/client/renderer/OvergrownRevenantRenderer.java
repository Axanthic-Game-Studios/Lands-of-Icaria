package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.OvergrownRevenantEmissiveRenderLayer;
import com.axanthic.icaria.client.layer.OvergrownRevenantItemRenderLayer;
import com.axanthic.icaria.client.layer.OvergrownRevenantRaysRenderLayer;
import com.axanthic.icaria.client.model.OvergrownRevenantModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.OvergrownRevenantRenderState;
import com.axanthic.icaria.common.entity.OvergrownRevenantEntity;
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

public class OvergrownRevenantRenderer extends MobRenderer<OvergrownRevenantEntity, OvergrownRevenantRenderState, OvergrownRevenantModel> {
	public OvergrownRevenantRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new OvergrownRevenantModel(pContext.bakeLayer(IcariaModelLayerLocations.OVERGROWN_REVENANT_BODY)), 0.5F);
		this.addLayer(new OvergrownRevenantEmissiveRenderLayer(this));
		this.addLayer(new OvergrownRevenantItemRenderLayer(this));
		this.addLayer(new OvergrownRevenantRaysRenderLayer(this));
	}

	@Override
	public void extractRenderState(OvergrownRevenantEntity pEntity, OvergrownRevenantRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.attackTime = pEntity.getAttackAnim(pPartialTick);
		pRenderState.blue = pEntity.blue;
		pRenderState.green = pEntity.green;
		pRenderState.red = pEntity.red;
		pRenderState.id = pEntity.getId();
		pRenderState.itemStackRenderState = new ItemStackRenderState();
		pRenderState.livingEntity = pEntity;
		this.itemModelResolver.updateForLiving(pRenderState.itemStackRenderState, pEntity.getMainHandItem(), ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, pEntity);
	}

	@Override
	public void scale(OvergrownRevenantRenderState pRenderState, PoseStack pPoseStack) {
		pPoseStack.scale(0.875F, 0.875F, 0.875F);
	}

	@Override
	public Identifier getTextureLocation(OvergrownRevenantRenderState pRenderState) {
		return IcariaIdentifiers.OVERGROWN_REVENANT;
	}

	@Override
	public OvergrownRevenantRenderState createRenderState() {
		return new OvergrownRevenantRenderState();
	}
}
