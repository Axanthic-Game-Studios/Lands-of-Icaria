package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.ArachneDroneEmissiveLayer;
import com.axanthic.icaria.client.model.ArachneDroneModel;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.common.entity.ArachneDroneEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ArachneDroneRenderer extends MobRenderer<ArachneDroneEntity, ArachneDroneModel> {
	public ArachneDroneRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new ArachneDroneModel(pContext.bakeLayer(IcariaLayerLocations.ARACHNE_DRONE)), 1.0F);
		this.addLayer(new ArachneDroneEmissiveLayer(this));
	}

	@Override
	public float getShadowRadius(ArachneDroneEntity pEntity) {
		return pEntity.getScaleForShadow();
	}

	@Override
	public void scale(ArachneDroneEntity pLivingEntity, PoseStack pMatrixStack, float pPartialTickTime) {
		pMatrixStack.scale(pLivingEntity.getScaleForRender(), pLivingEntity.getScaleForRender(), pLivingEntity.getScaleForRender());
	}

	@Override
	public ResourceLocation getTextureLocation(ArachneDroneEntity pEntity) {
		return IcariaResourceLocations.ARACHNE_DRONE;
	}
}
