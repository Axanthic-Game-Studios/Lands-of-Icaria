package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import com.mojang.serialization.MapCodec;

import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.world.item.ItemStack;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record UnbakedScrollItemSpecialModelRenderer() implements SpecialModelRenderer.Unbaked<ItemStack> {
	public static final MapCodec<UnbakedScrollItemSpecialModelRenderer> MAP_CODEC = MapCodec.unit(UnbakedScrollItemSpecialModelRenderer::new);

	@Override
	public MapCodec<UnbakedScrollItemSpecialModelRenderer> type() {
		return UnbakedScrollItemSpecialModelRenderer.MAP_CODEC;
	}

	@Override
	public SpecialModelRenderer<ItemStack> bake(SpecialModelRenderer.BakingContext pBakingContext) {
		return new ScrollItemSpecialModelRenderer();
	}
}
