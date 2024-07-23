package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.PyromancerRevenantEmissiveLayer;
import com.axanthic.icaria.client.layer.PyromancerRevenantItemLayer;
import com.axanthic.icaria.client.model.PyromancerRevenantModel;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.common.entity.PyromancerRevenantEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class PyromancerRevenantRenderer extends MobRenderer<PyromancerRevenantEntity, PyromancerRevenantModel> {
	public PyromancerRevenantRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new PyromancerRevenantModel(pContext.bakeLayer(IcariaLayerLocations.PYROMANCER_REVENANT_BODY)), 0.5F);
		this.addLayer(new PyromancerRevenantEmissiveLayer(this));
		this.addLayer(new PyromancerRevenantItemLayer(this));
	}

	@Override
	public void scale(PyromancerRevenantEntity pLivingEntity, PoseStack pMatrixStack, float pPartialTickTime) {
		pMatrixStack.scale(0.875F, 0.875F, 0.875F);
	}

	@Override
	public ResourceLocation getTextureLocation(PyromancerRevenantEntity pEntity) {
		return IcariaResourceLocations.PYROMANCER_REVENANT;
	}
}
