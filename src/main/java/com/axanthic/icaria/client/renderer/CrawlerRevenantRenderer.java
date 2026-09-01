package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.CrawlerRevenantEmissiveRenderLayer;
import com.axanthic.icaria.client.layer.CrawlerRevenantItemRenderLayer;
import com.axanthic.icaria.client.model.CrawlerRevenantModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.CrawlerRevenantRenderState;
import com.axanthic.icaria.common.entity.CrawlerRevenantEntity;
import com.axanthic.icaria.common.registry.IcariaIdentifiers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemDisplayContext;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CrawlerRevenantRenderer extends MobRenderer<CrawlerRevenantEntity, CrawlerRevenantRenderState, CrawlerRevenantModel> {
	public CrawlerRevenantRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new CrawlerRevenantModel(pContext.bakeLayer(IcariaModelLayerLocations.CRAWLER_REVENANT_BODY)), 0.5F);
		this.addLayer(new CrawlerRevenantEmissiveRenderLayer(this));
		this.addLayer(new CrawlerRevenantItemRenderLayer(this));
	}

	@Override
	public void extractRenderState(CrawlerRevenantEntity pEntity, CrawlerRevenantRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.attackTime = pEntity.getAttackAnim(pPartialTick);
		pRenderState.shadowStrength = pEntity.getShadowStrength();
		pRenderState.id = pEntity.getId();
		pRenderState.maxTick = pEntity.maxTick;
		pRenderState.tick = pEntity.getTick();
		pRenderState.itemStackRenderState = new ItemStackRenderState();
		pRenderState.livingEntity = pEntity;
		this.itemModelResolver.updateForLiving(pRenderState.itemStackRenderState, pEntity.getMainHandItem(), ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, pEntity);
	}

	@Override
	public void scale(CrawlerRevenantRenderState pRenderState, PoseStack pPoseStack) {
		pPoseStack.scale(0.875F, 0.875F, 0.875F);
	}

	@Override
	public void submit(CrawlerRevenantRenderState pRenderState, PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, CameraRenderState pCameraRenderState) {
		super.submit(pRenderState, pPoseStack, pSubmitNodeCollector, pCameraRenderState);
		this.shadowStrength = pRenderState.shadowStrength;
	}

	@Override
	public Identifier getTextureLocation(CrawlerRevenantRenderState pRenderState) {
		return IcariaIdentifiers.CRAWLER_REVENANT;
	}

	@Override
	public CrawlerRevenantRenderState createRenderState() {
		return new CrawlerRevenantRenderState();
	}
}
