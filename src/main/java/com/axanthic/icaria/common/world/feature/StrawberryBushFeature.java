package com.axanthic.icaria.common.world.feature;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaBlocks;

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

public class StrawberryBushFeature implements Feature {
	public static final MapCodec<StrawberryBushFeature> CODEC = MapCodec.unit(StrawberryBushFeature::new);

	@Override
	public boolean place(WorldGenLevel pWorldGenLevel, ChunkGenerator pChunkGenerator, RandomSource pRandomSource, BlockPos pBlockPos) {
		var direction = Direction.Plane.HORIZONTAL.getRandomDirection(pRandomSource);

		var size = 4;

		for (var x = -size; x <= size; x++) {
			for (var y = -size; y <= size; y++) {
				for (var z = -size; z <= size; z++) {
					this.placeBerries(pWorldGenLevel, pBlockPos.relative(direction, x).above(y).relative(direction.getClockWise(), z), 16);
				}
			}
		}

		return true;
	}

	public void placeBerries(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeBerries(pWorldGenLevel, pBlockPos);
		}
	}

	public void placeBerries(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && pWorldGenLevel.getBlockState(pBlockPos.below()).is(BlockTags.SUBSTRATE_OVERWORLD)) {
			if (pWorldGenLevel.getRandom().nextBoolean()) {
				this.setBlock(pWorldGenLevel, pBlockPos, IcariaBlocks.STRAWBERRY_BUSH.get().defaultBlockState().setValue(IcariaBlockStateProperties.RIPE_BUSH, false));
			} else {
				this.setBlock(pWorldGenLevel, pBlockPos, IcariaBlocks.STRAWBERRY_BUSH.get().defaultBlockState().setValue(IcariaBlockStateProperties.RIPE_BUSH, true));
			}
		}
	}

	@Override
	public MapCodec<StrawberryBushFeature> codec() {
		return StrawberryBushFeature.CODEC;
	}
}
