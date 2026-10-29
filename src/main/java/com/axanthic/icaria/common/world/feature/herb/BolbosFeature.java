package com.axanthic.icaria.common.world.feature.herb;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.MapCodec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.phys.AABB;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class BolbosFeature implements Feature {
	public static final MapCodec<BolbosFeature> CODEC = MapCodec.unit(BolbosFeature::new);

	@Override
	public boolean place(WorldGenLevel pWorldGenLevel, ChunkGenerator pChunkGenerator, RandomSource pRandomSource, BlockPos pBlockPos) {
		var direction = Direction.Plane.HORIZONTAL.getRandomDirection(pRandomSource);

		var size = 4;

		var aabb = new AABB(pBlockPos.getX(), pBlockPos.getY(), pBlockPos.getZ(), pBlockPos.getX(), pBlockPos.getY() + 16, pBlockPos.getZ());

		for (var x = -size; x <= size; x++) {
			for (var y = -size; y <= size; y++) {
				for (var z = -size; z <= size; z++) {
					if (pWorldGenLevel.getBlockStates(aabb).anyMatch(blockState -> blockState.is(IcariaBlocks.GRAINITE.get()))) {
						this.placeHerb(pWorldGenLevel, pBlockPos.relative(direction, x).above(y).relative(direction.getClockWise(), z), 16);
					}
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
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && pWorldGenLevel.getBlockState(pBlockPos.below()).is(IcariaBlocks.GRAINEL.get())) {
			this.setBlock(pWorldGenLevel, pBlockPos, IcariaBlocks.BOLBOS.get().defaultBlockState());
		}
	}

	@Override
	public MapCodec<BolbosFeature> codec() {
		return BolbosFeature.CODEC;
	}
}
