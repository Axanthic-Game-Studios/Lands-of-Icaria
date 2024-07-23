package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.CrawlerRevenantEmissiveLayer;
import com.axanthic.icaria.client.layer.CrawlerRevenantItemLayer;
import com.axanthic.icaria.client.model.CrawlerRevenantModel;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.common.entity.CrawlerRevenantEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CrawlerRevenantRenderer extends MobRenderer<CrawlerRevenantEntity, CrawlerRevenantModel> {
	public CrawlerRevenantRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new CrawlerRevenantModel(pContext.bakeLayer(IcariaLayerLocations.CRAWLER_REVENANT_BODY)), 0.5F);
		this.addLayer(new CrawlerRevenantEmissiveLayer(this));
		this.addLayer(new CrawlerRevenantItemLayer(this));
	}

	@Override
	public void render(CrawlerRevenantEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
		super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
		this.shadowStrength = pEntity.getShadowStrength();
	}

	@Override
	public void scale(CrawlerRevenantEntity pLivingEntity, PoseStack pMatrixStack, float pPartialTickTime) {
		pMatrixStack.scale(0.875F, 0.875F, 0.875F);
	}

	@Override
	public ResourceLocation getTextureLocation(CrawlerRevenantEntity pEntity) {
		return IcariaResourceLocations.CRAWLER_REVENANT;
	}
}
