package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.model.CatoblepasModel;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.common.entity.CatoblepasEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CatoblepasRenderer extends MobRenderer<CatoblepasEntity, CatoblepasModel> {
	public CatoblepasRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new CatoblepasModel(pContext.bakeLayer(IcariaLayerLocations.CATOBLEPAS)), 1.0F);
	}

	@Override
	public float getShadowRadius(CatoblepasEntity pEntity) {
		return pEntity.getScaleForShadow();
	}

	@Override
	public void scale(CatoblepasEntity pLivingEntity, PoseStack pMatrixStack, float pPartialTickTime) {
		pMatrixStack.scale(pLivingEntity.getScaleForRender(), pLivingEntity.getScaleForRender(), pLivingEntity.getScaleForRender());
	}

	@Override
	public ResourceLocation getTextureLocation(CatoblepasEntity pEntity) {
		return IcariaResourceLocations.CATOBLEPAS;
	}
}
