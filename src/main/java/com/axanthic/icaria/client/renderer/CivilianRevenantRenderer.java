package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.CivilianRevenantEmissiveLayer;
import com.axanthic.icaria.client.layer.CivilianRevenantItemLayer;
import com.axanthic.icaria.client.model.CivilianRevenantModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.CivilianRevenantRenderState;
import com.axanthic.icaria.common.entity.CivilianRevenantEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CivilianRevenantRenderer extends MobRenderer<CivilianRevenantEntity, CivilianRevenantRenderState, CivilianRevenantModel> {
	public CivilianRevenantRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new CivilianRevenantModel(pContext.bakeLayer(IcariaModelLayerLocations.CIVILIAN_REVENANT_BODY)), 0.5F);
		this.addLayer(new CivilianRevenantEmissiveLayer(this));
		this.addLayer(new CivilianRevenantItemLayer(this));
	}

	@Override
	public void extractRenderState(CivilianRevenantEntity pEntity, CivilianRevenantRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.attackTime = pEntity.getAttackAnim(pPartialTick);
		pRenderState.id = pEntity.getId();
		pRenderState.livingEntity = pEntity;
	}

	@Override
	public void scale(CivilianRevenantRenderState pRenderState, PoseStack pPoseStack) {
		pPoseStack.scale(0.875F, 0.875F, 0.875F);
	}

	@Override
	public CivilianRevenantRenderState createRenderState() {
		return new CivilianRevenantRenderState();
	}

	@Override
	public ResourceLocation getTextureLocation(CivilianRevenantRenderState pRenderState) {
		return IcariaResourceLocations.CIVILIAN_REVENANT;
	}
}
