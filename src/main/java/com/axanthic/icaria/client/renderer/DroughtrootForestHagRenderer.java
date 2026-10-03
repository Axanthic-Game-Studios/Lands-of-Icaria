package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.client.layer.DroughtrootForestHagEmissiveRenderLayer;
import com.axanthic.icaria.client.model.DroughtrootForestHagModel;
import com.axanthic.icaria.client.registry.IcariaModelLayerLocations;
import com.axanthic.icaria.client.state.DroughtrootForestHagRenderState;
import com.axanthic.icaria.common.entity.ForestHagEntity;
import com.axanthic.icaria.common.registry.IcariaIdentifiers;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class DroughtrootForestHagRenderer extends MobRenderer<ForestHagEntity, DroughtrootForestHagRenderState, DroughtrootForestHagModel> {
	public DroughtrootForestHagRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new DroughtrootForestHagModel(pContext.bakeLayer(IcariaModelLayerLocations.DROUGHTROOT_FOREST_HAG)), 0.75F);
		this.addLayer(new DroughtrootForestHagEmissiveRenderLayer(this));
	}

	@Override
	public void extractRenderState(ForestHagEntity pEntity, DroughtrootForestHagRenderState pRenderState, float pPartialTicks) {
		super.extractRenderState(pEntity, pRenderState, pPartialTicks);
		pRenderState.aggressive = pEntity.isAggressive();
		pRenderState.attackTime = pEntity.getAttackAnim(pPartialTicks);
		pRenderState.livingEntity = pEntity;
	}

	@Override
	public Identifier getTextureLocation(DroughtrootForestHagRenderState pRenderState) {
		return IcariaIdentifiers.DROUGHTROOT_FOREST_HAG;
	}

	@Override
	public DroughtrootForestHagRenderState createRenderState() {
		return new DroughtrootForestHagRenderState();
	}
}
