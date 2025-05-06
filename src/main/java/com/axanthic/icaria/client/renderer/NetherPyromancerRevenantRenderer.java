package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.NetherPyromancerRevenantEmissiveLayer;
import com.axanthic.icaria.client.layer.NetherPyromancerRevenantItemLayer;
import com.axanthic.icaria.client.model.NetherPyromancerRevenantModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.NetherPyromancerRevenantRenderState;
import com.axanthic.icaria.common.entity.NetherPyromancerRevenantEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class NetherPyromancerRevenantRenderer extends MobRenderer<NetherPyromancerRevenantEntity, NetherPyromancerRevenantRenderState, NetherPyromancerRevenantModel> {
	public NetherPyromancerRevenantRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new NetherPyromancerRevenantModel(pContext.bakeLayer(IcariaModelLayerLocations.NETHER_PYROMANCER_REVENANT_BODY)), 0.5F);
		this.addLayer(new NetherPyromancerRevenantEmissiveLayer(this));
		this.addLayer(new NetherPyromancerRevenantItemLayer(this));
	}

	@Override
	public void extractRenderState(NetherPyromancerRevenantEntity pEntity, NetherPyromancerRevenantRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.attackTime = pEntity.getAttackAnim(pPartialTick);
		pRenderState.id = pEntity.getId();
		pRenderState.reloadAnimationState = pEntity.reloadAnimationState;
		pRenderState.thrownAnimationState = pEntity.thrownAnimationState;
		pRenderState.livingEntity = pEntity;
	}

	@Override
	public void scale(NetherPyromancerRevenantRenderState pRenderState, PoseStack pPoseStack) {
		pPoseStack.scale(0.875F, 0.875F, 0.875F);
	}

	@Override
	public NetherPyromancerRevenantRenderState createRenderState() {
		return new NetherPyromancerRevenantRenderState();
	}

	@Override
	public ResourceLocation getTextureLocation(NetherPyromancerRevenantRenderState pRenderState) {
		return IcariaResourceLocations.NETHER_PYROMANCER_REVENANT;
	}
}
