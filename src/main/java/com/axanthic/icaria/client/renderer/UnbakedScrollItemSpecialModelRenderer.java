package com.axanthic.icaria.client.renderer;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;
import com.mojang.serialization.MapCodec;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.special.SpecialModelRenderer;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record UnbakedScrollItemSpecialModelRenderer() implements SpecialModelRenderer.Unbaked {
	public static final MapCodec<UnbakedScrollItemSpecialModelRenderer> MAP_CODEC = MapCodec.unit(UnbakedScrollItemSpecialModelRenderer::new);

	@Override
	public MapCodec<UnbakedScrollItemSpecialModelRenderer> type() {
		return UnbakedScrollItemSpecialModelRenderer.MAP_CODEC;
	}

	@Override
	public SpecialModelRenderer<?> bake(SpecialModelRenderer.BakingContext pBakingContext) {
		return new ScrollItemSpecialModelRenderer();
	}
}
