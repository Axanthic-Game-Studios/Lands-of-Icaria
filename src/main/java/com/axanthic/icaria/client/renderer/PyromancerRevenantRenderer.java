package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.PyromancerRevenantEmissiveLayer;
import com.axanthic.icaria.client.layer.PyromancerRevenantItemLayer;
import com.axanthic.icaria.client.model.PyromancerRevenantModel;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.client.state.PyromancerRevenantRenderState;
import com.axanthic.icaria.common.entity.PyromancerRevenantEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class PyromancerRevenantRenderer extends MobRenderer<PyromancerRevenantEntity, PyromancerRevenantRenderState, PyromancerRevenantModel> {
	public PyromancerRevenantRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new PyromancerRevenantModel(pContext.bakeLayer(IcariaLayerLocations.PYROMANCER_REVENANT_BODY)), 0.5F);
		this.addLayer(new PyromancerRevenantEmissiveLayer(this));
		this.addLayer(new PyromancerRevenantItemLayer(this));
	}

	@Override
	public void extractRenderState(PyromancerRevenantEntity pEntity, PyromancerRevenantRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.attackTime = pEntity.getAttackAnim(pPartialTick);
		pRenderState.id = pEntity.getId();
		pRenderState.reloadAnimationState = pEntity.reloadAnimationState;
		pRenderState.thrownAnimationState = pEntity.thrownAnimationState;
		pRenderState.livingEntity = pEntity;
	}

	@Override
	public void scale(PyromancerRevenantRenderState pRenderState, PoseStack pPoseStack) {
		pPoseStack.scale(0.875F, 0.875F, 0.875F);
	}

	@Override
	public PyromancerRevenantRenderState createRenderState() {
		return new PyromancerRevenantRenderState();
	}

	@Override
	public ResourceLocation getTextureLocation(PyromancerRevenantRenderState pRenderState) {
		return IcariaResourceLocations.PYROMANCER_REVENANT;
	}
}
