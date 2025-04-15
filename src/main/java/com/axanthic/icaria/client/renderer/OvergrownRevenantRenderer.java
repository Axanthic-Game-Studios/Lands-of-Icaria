package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.OvergrownRevenantEmissiveLayer;
import com.axanthic.icaria.client.layer.OvergrownRevenantItemLayer;
import com.axanthic.icaria.client.layer.OvergrownRevenantRaysLayer;
import com.axanthic.icaria.client.model.OvergrownRevenantModel;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.client.state.OvergrownRevenantRenderState;
import com.axanthic.icaria.common.entity.OvergrownRevenantEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class OvergrownRevenantRenderer extends MobRenderer<OvergrownRevenantEntity, OvergrownRevenantRenderState, OvergrownRevenantModel> {
	public OvergrownRevenantRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new OvergrownRevenantModel(pContext.bakeLayer(IcariaLayerLocations.OVERGROWN_REVENANT_BODY)), 0.5F);
		this.addLayer(new OvergrownRevenantEmissiveLayer(this));
		this.addLayer(new OvergrownRevenantItemLayer(this));
		this.addLayer(new OvergrownRevenantRaysLayer(this));
	}

	@Override
	public void extractRenderState(OvergrownRevenantEntity pEntity, OvergrownRevenantRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.attackTime = pEntity.getAttackAnim(pPartialTick);
		pRenderState.blue = pEntity.blue;
		pRenderState.green = pEntity.green;
		pRenderState.red = pEntity.red;
		pRenderState.id = pEntity.getId();
		pRenderState.livingEntity = pEntity;
	}

	@Override
	public void scale(OvergrownRevenantRenderState pRenderState, PoseStack pPoseStack) {
		pPoseStack.scale(0.875F, 0.875F, 0.875F);
	}

	@Override
	public OvergrownRevenantRenderState createRenderState() {
		return new OvergrownRevenantRenderState();
	}

	@Override
	public ResourceLocation getTextureLocation(OvergrownRevenantRenderState pRenderState) {
		return IcariaResourceLocations.OVERGROWN_REVENANT;
	}
}
