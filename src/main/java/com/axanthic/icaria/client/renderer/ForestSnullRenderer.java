package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.ForestSnullEmissiveLayer;
import com.axanthic.icaria.client.model.ForestSnullModel;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.common.entity.SnullEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ForestSnullRenderer extends MobRenderer<SnullEntity, ForestSnullModel> {
	public ForestSnullRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new ForestSnullModel(pContext.bakeLayer(IcariaLayerLocations.FOREST_SNULL)), 1.0F);
		this.addLayer(new ForestSnullEmissiveLayer(this));
	}

	@Override
	public float getShadowRadius(SnullEntity pEntity) {
		return pEntity.getScaleForShadow();
	}

	@Override
	public void render(SnullEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
		super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
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
		return IcariaResourceLocations.FOREST_SNULL;
	}
}
