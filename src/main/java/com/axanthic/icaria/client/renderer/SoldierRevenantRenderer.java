package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.SoldierRevenantEmissiveLayer;
import com.axanthic.icaria.client.layer.SoldierRevenantItemLayer;
import com.axanthic.icaria.client.model.SoldierRevenantModel;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.common.entity.SoldierRevenantEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SoldierRevenantRenderer extends MobRenderer<SoldierRevenantEntity, SoldierRevenantModel> {
	public SoldierRevenantRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new SoldierRevenantModel(pContext.bakeLayer(IcariaLayerLocations.SOLDIER_REVENANT_BODY)), 0.5F);
		this.addLayer(new SoldierRevenantEmissiveLayer(this));
		this.addLayer(new SoldierRevenantItemLayer(this));
	}

	@Override
	public void scale(SoldierRevenantEntity pLivingEntity, PoseStack pMatrixStack, float pPartialTickTime) {
		pMatrixStack.scale(0.875F, 0.875F, 0.875F);
	}

	@Override
	public ResourceLocation getTextureLocation(SoldierRevenantEntity pEntity) {
		return IcariaResourceLocations.SOLDIER_REVENANT;
	}
}
