package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.ArachneEmissiveLayer;
import com.axanthic.icaria.client.model.ArachneModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.ArachneRenderState;
import com.axanthic.icaria.common.entity.ArachneEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ArachneRenderer extends MobRenderer<ArachneEntity, ArachneRenderState, ArachneModel> {
	public ArachneRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new ArachneModel(pContext.bakeLayer(IcariaModelLayerLocations.ARACHNE)), 1.25F);
		this.addLayer(new ArachneEmissiveLayer(this));
	}

	@Override
	public void extractRenderState(ArachneEntity pEntity, ArachneRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.attackAnimationState = pEntity.attackAnimationState;
		pRenderState.livingEntity = pEntity;
	}

	@Override
	public ArachneRenderState createRenderState() {
		return new ArachneRenderState();
	}

	@Override
	public ResourceLocation getTextureLocation(ArachneRenderState pRenderState) {
		return IcariaResourceLocations.ARACHNE;
	}
}
