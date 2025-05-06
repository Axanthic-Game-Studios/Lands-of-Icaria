package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.SolifugaeEmissiveLayer;
import com.axanthic.icaria.client.model.SolifugaeModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.SolifugaeRenderState;
import com.axanthic.icaria.common.entity.SolifugaeEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SolifugaeRenderer extends MobRenderer<SolifugaeEntity, SolifugaeRenderState, SolifugaeModel> {
	public SolifugaeRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new SolifugaeModel(pContext.bakeLayer(IcariaModelLayerLocations.SOLIFUGAE)), 0.75F);
		this.addLayer(new SolifugaeEmissiveLayer(this));
	}

	@Override
	public void extractRenderState(SolifugaeEntity pEntity, SolifugaeRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.livingEntity = pEntity;
	}

	@Override
	public void scale(SolifugaeRenderState pRenderState, PoseStack pPoseStack) {
		pPoseStack.scale(0.625F, 0.625F, 0.625F);
	}

	@Override
	public SolifugaeRenderState createRenderState() {
		return new SolifugaeRenderState();
	}

	@Override
	public ResourceLocation getTextureLocation(SolifugaeRenderState pRenderState) {
		return IcariaResourceLocations.SOLIFUGAE;
	}
}
