package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.SnullEmissiveLayer;
import com.axanthic.icaria.client.model.SnullModel;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.common.entity.SnullEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SnullRenderer extends MobRenderer<SnullEntity, SnullModel> {
	public SnullRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new SnullModel(pContext.bakeLayer(IcariaLayerLocations.SNULL)), 1.0F);
		this.addLayer(new SnullEmissiveLayer(this));
	}

	@Override
	public float getShadowRadius(SnullEntity pEntity) {
		return pEntity.getScaleForShadow();
	}

	@Override
	public void scale(SnullEntity pLivingEntity, PoseStack pMatrixStack, float pPartialTickTime) {
		pMatrixStack.scale(pLivingEntity.getScaleForRender(), pLivingEntity.getScaleForRender(), pLivingEntity.getScaleForRender());
		if (pLivingEntity.onClimbable()) {
			pMatrixStack.mulPose(Axis.XN.rotationDegrees(90.0F));
			pMatrixStack.translate(0.0F, 0.25F, 0.0F);
		}
	}

	@Override
	public ResourceLocation getTextureLocation(SnullEntity pEntity) {
		return IcariaResourceLocations.SNULL;
	}
}
