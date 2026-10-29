package com.axanthic.icaria.common.world.feature.herb;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaFluids;

import com.mojang.serialization.MapCodec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class PsilocybosFeature implements Feature {
	public static final MapCodec<PsilocybosFeature> CODEC = MapCodec.unit(PsilocybosFeature::new);

	@Override
	public boolean place(WorldGenLevel pWorldGenLevel, ChunkGenerator pChunkGenerator, RandomSource pRandomSource, BlockPos pBlockPos) {
		var direction = Direction.Plane.HORIZONTAL.getRandomDirection(pRandomSource);

		var size = 4;

		for (var x = -size; x <= size; x++) {
			for (var y = -size; y <= size; y++) {
				for (var z = -size; z <= size; z++) {
					this.placeHerb(pWorldGenLevel, pBlockPos.relative(direction, x).above(y).relative(direction.getClockWise(), z), 16);
				}
			}
		}

		return true;
	}

	public void placeHerb(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeHerb(pWorldGenLevel, pBlockPos);
		}
	}

	public void placeHerb(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos) {
		if (pWorldGenLevel.getBlockState(pBlockPos.above()).isAir() && pWorldGenLevel.getBlockState(pBlockPos.below()).is(BlockTags.SUBSTRATE_OVERWORLD) && pWorldGenLevel.getFluidState(pBlockPos).is(IcariaFluids.MEDITERRANEAN_WATER.get())) {
			this.setBlock(pWorldGenLevel, pBlockPos, IcariaBlocks.PSILOCYBOS.get().defaultBlockState().setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pWorldGenLevel.getFluidState(pBlockPos).is(IcariaFluids.MEDITERRANEAN_WATER.get())));
		}
	}

	@Override
	public MapCodec<PsilocybosFeature> codec() {
		return PsilocybosFeature.CODEC;
	}
}
