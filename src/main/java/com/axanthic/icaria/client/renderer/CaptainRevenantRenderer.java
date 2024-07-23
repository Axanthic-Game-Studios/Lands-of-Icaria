package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.CaptainRevenantEmissiveLayer;
import com.axanthic.icaria.client.layer.CaptainRevenantItemLayer;
import com.axanthic.icaria.client.model.CaptainRevenantModel;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.common.entity.CaptainRevenantEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CaptainRevenantRenderer extends MobRenderer<CaptainRevenantEntity, CaptainRevenantModel> {
	public CaptainRevenantRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new CaptainRevenantModel(pContext.bakeLayer(IcariaLayerLocations.CAPTAIN_REVENANT_BODY)), 0.5F);
		this.addLayer(new CaptainRevenantEmissiveLayer(this));
		this.addLayer(new CaptainRevenantItemLayer(this));
	}

	@Override
	public void scale(CaptainRevenantEntity pLivingEntity, PoseStack pMatrixStack, float pPartialTickTime) {
		pMatrixStack.scale(0.875F, 0.875F, 0.875F);
	}

	@Override
	public ResourceLocation getTextureLocation(CaptainRevenantEntity pEntity) {
		return IcariaResourceLocations.CAPTAIN_REVENANT;
	}
}
