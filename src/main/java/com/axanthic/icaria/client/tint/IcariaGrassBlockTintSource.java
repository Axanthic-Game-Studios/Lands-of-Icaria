package com.axanthic.icaria.client.tint;

import com.axanthic.icaria.common.registry.IcariaColors;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.color.block.BlockTintSource;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record IcariaGrassBlockTintSource(boolean particle) implements BlockTintSource {

	@Override
	public int color(BlockState pBlockState) {
		return IcariaColors.TINT_GRASS;
	}

	@Override
	public int colorInWorld(BlockState pBlockState, BlockAndTintGetter pBlockAndTintGetter, BlockPos pBlockPos) {
		return BiomeColors.getAverageGrassColor(pBlockAndTintGetter, pBlockPos);
	}

	@Override
	public int colorAsTerrainParticle(BlockState pBlockState, BlockAndTintGetter pBlockAndTintGetter, BlockPos pBlockPos) {
		return this.particle() ? BiomeColors.getAverageGrassColor(pBlockAndTintGetter, pBlockPos) : IcariaColors.TINT_EMPTY;
	}
}
