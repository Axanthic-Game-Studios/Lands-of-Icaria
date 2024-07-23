package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.SolifugaeEmissiveLayer;
import com.axanthic.icaria.client.model.SolifugaeModel;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.common.entity.SolifugaeEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SolifugaeRenderer extends MobRenderer<SolifugaeEntity, SolifugaeModel> {
	public SolifugaeRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new SolifugaeModel(pContext.bakeLayer(IcariaLayerLocations.SOLIFUGAE)), 0.75F);
		this.addLayer(new SolifugaeEmissiveLayer(this));
	}

	@Override
	public void scale(SolifugaeEntity pLivingEntity, PoseStack pMatrixStack, float pPartialTickTime) {
		pMatrixStack.scale(0.625F, 0.625F, 0.625F);
	}

	@Override
	public ResourceLocation getTextureLocation(SolifugaeEntity pEntity) {
		return IcariaResourceLocations.SOLIFUGAE;
	}
}
