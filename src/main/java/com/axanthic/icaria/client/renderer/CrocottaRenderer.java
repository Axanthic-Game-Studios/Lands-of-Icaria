package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.model.CrocottaModel;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.client.state.CrocottaRenderState;
import com.axanthic.icaria.common.entity.CrocottaEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CrocottaRenderer extends MobRenderer<CrocottaEntity, CrocottaRenderState, CrocottaModel> {
	public CrocottaRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new CrocottaModel(pContext.bakeLayer(IcariaLayerLocations.CROCOTTA)), 0.75F);
	}

	@Override
	public void extractRenderState(CrocottaEntity pEntity, CrocottaRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.attackAnimationState = pEntity.attackAnimationState;
	}

	@Override
	public CrocottaRenderState createRenderState() {
		return new CrocottaRenderState();
	}

	@Override
	public ResourceLocation getTextureLocation(CrocottaRenderState pRenderState) {
		return IcariaResourceLocations.CROCOTTA;
	}
}
