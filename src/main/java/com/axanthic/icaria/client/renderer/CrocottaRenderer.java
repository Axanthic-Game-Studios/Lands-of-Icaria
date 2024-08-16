package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.model.CrocottaModel;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.common.entity.CrocottaEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CrocottaRenderer extends MobRenderer<CrocottaEntity, CrocottaModel> {
	public CrocottaRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new CrocottaModel(pContext.bakeLayer(IcariaLayerLocations.CROCOTTA)), 1.0F);
	}

	@Override
	public ResourceLocation getTextureLocation(CrocottaEntity pEntity) {
		return IcariaResourceLocations.CROCOTTA;
	}
}
