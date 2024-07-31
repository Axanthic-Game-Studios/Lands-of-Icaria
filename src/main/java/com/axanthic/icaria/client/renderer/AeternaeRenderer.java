package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.model.AeternaeModel;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.common.entity.AeternaeEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class AeternaeRenderer extends MobRenderer<AeternaeEntity, AeternaeModel> {
	public AeternaeRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new AeternaeModel(pContext.bakeLayer(IcariaLayerLocations.AETERNAE)), 1.0F);
	}

	@Override
	public float getShadowRadius(AeternaeEntity pEntity) {
		return pEntity.getScaleForShadow();
	}

	@Override
	public void scale(AeternaeEntity pLivingEntity, PoseStack pMatrixStack, float pPartialTickTime) {
		pMatrixStack.scale(pLivingEntity.getScaleForRender(), pLivingEntity.getScaleForRender(), pLivingEntity.getScaleForRender());
	}

	@Override
	public ResourceLocation getTextureLocation(AeternaeEntity pEntity) {
		return IcariaResourceLocations.AETERNAE;
	}
}
