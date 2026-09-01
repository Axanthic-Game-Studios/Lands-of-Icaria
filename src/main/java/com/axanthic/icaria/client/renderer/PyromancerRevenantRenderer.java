package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.PyromancerRevenantEmissiveRenderLayer;
import com.axanthic.icaria.client.layer.PyromancerRevenantItemRenderLayer;
import com.axanthic.icaria.client.model.PyromancerRevenantModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.PyromancerRevenantRenderState;
import com.axanthic.icaria.common.entity.PyromancerRevenantEntity;
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

public class PyromancerRevenantRenderer extends MobRenderer<PyromancerRevenantEntity, PyromancerRevenantRenderState, PyromancerRevenantModel> {
	public PyromancerRevenantRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new PyromancerRevenantModel(pContext.bakeLayer(IcariaModelLayerLocations.PYROMANCER_REVENANT_BODY)), 0.5F);
		this.addLayer(new PyromancerRevenantEmissiveRenderLayer(this));
		this.addLayer(new PyromancerRevenantItemRenderLayer(this));
	}

	@Override
	public void extractRenderState(PyromancerRevenantEntity pEntity, PyromancerRevenantRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.attackTime = pEntity.getAttackAnim(pPartialTick);
		pRenderState.id = pEntity.getId();
		pRenderState.reloadAnimationState = pEntity.reloadAnimationState;
		pRenderState.thrownAnimationState = pEntity.thrownAnimationState;
		pRenderState.itemStackRenderState = new ItemStackRenderState();
		pRenderState.livingEntity = pEntity;
		this.itemModelResolver.updateForLiving(pRenderState.itemStackRenderState, pEntity.getMainHandItem(), ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, pEntity);
	}

	@Override
	public void scale(PyromancerRevenantRenderState pRenderState, PoseStack pPoseStack) {
		pPoseStack.scale(0.875F, 0.875F, 0.875F);
	}

	@Override
	public Identifier getTextureLocation(PyromancerRevenantRenderState pRenderState) {
		return IcariaIdentifiers.PYROMANCER_REVENANT;
	}

	@Override
	public PyromancerRevenantRenderState createRenderState() {
		return new PyromancerRevenantRenderState();
	}
}
