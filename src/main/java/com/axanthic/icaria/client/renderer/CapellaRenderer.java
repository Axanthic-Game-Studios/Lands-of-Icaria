package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.model.CapellaModel;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.common.entity.CapellaEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CapellaRenderer extends MobRenderer<CapellaEntity, CapellaModel> {
	public CapellaRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new CapellaModel(pContext.bakeLayer(IcariaLayerLocations.CAPELLA)), 1.0F);
	}

	@Override
	public float getShadowRadius(CapellaEntity pEntity) {
		return pEntity.getScaleForShadow();
	}

	@Override
	public void scale(CapellaEntity pLivingEntity, PoseStack pMatrixStack, float pPartialTickTime) {
		pMatrixStack.scale(pLivingEntity.getScaleForRender(), pLivingEntity.getScaleForRender(), pLivingEntity.getScaleForRender());
	}

	@Override
	public ResourceLocation getTextureLocation(CapellaEntity pEntity) {
		return IcariaResourceLocations.CAPELLA;
	}
}
