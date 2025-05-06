package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.CrawlerRevenantEmissiveLayer;
import com.axanthic.icaria.client.layer.CrawlerRevenantItemLayer;
import com.axanthic.icaria.client.model.CrawlerRevenantModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.CrawlerRevenantRenderState;
import com.axanthic.icaria.common.entity.CrawlerRevenantEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CrawlerRevenantRenderer extends MobRenderer<CrawlerRevenantEntity, CrawlerRevenantRenderState, CrawlerRevenantModel> {
	public CrawlerRevenantRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new CrawlerRevenantModel(pContext.bakeLayer(IcariaModelLayerLocations.CRAWLER_REVENANT_BODY)), 0.5F);
		this.addLayer(new CrawlerRevenantEmissiveLayer(this));
		this.addLayer(new CrawlerRevenantItemLayer(this));
	}

	@Override
	public void extractRenderState(CrawlerRevenantEntity pEntity, CrawlerRevenantRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.attackTime = pEntity.getAttackAnim(pPartialTick);
		pRenderState.shadowStrength = pEntity.getShadowStrength();
		pRenderState.id = pEntity.getId();
		pRenderState.maxTick = pEntity.maxTick;
		pRenderState.tick = pEntity.getTick();
		pRenderState.livingEntity = pEntity;
	}

	@Override
	public void render(CrawlerRevenantRenderState pRenderState, PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight) {
		super.render(pRenderState, pPoseStack, pMultiBufferSource, pPackedLight);
		this.shadowStrength = pRenderState.shadowStrength;
	}

	@Override
	public void scale(CrawlerRevenantRenderState pRenderState, PoseStack pPoseStack) {
		pPoseStack.scale(0.875F, 0.875F, 0.875F);
	}

	@Override
	public CrawlerRevenantRenderState createRenderState() {
		return new CrawlerRevenantRenderState();
	}

	@Override
	public ResourceLocation getTextureLocation(CrawlerRevenantRenderState pRenderState) {
		return IcariaResourceLocations.CRAWLER_REVENANT;
	}
}
