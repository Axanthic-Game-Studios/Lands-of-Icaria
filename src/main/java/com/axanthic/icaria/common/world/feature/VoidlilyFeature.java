package com.axanthic.icaria.common.world.feature;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.MapCodec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.phys.AABB;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class VoidlilyFeature implements Feature {
	public static final MapCodec<VoidlilyFeature> CODEC = MapCodec.unit(VoidlilyFeature::new);

	@Override
	public boolean place(WorldGenLevel pWorldGenLevel, ChunkGenerator pChunkGenerator, RandomSource pRandomSource, BlockPos pBlockPos) {
		var direction = Direction.Plane.HORIZONTAL.getRandomDirection(pRandomSource);

		var relative = pBlockPos.relative(direction);

		var size = 4;

		var aabb = new AABB(relative.getX(), relative.getY(), relative.getZ(), relative.getX(), relative.getY() - 16, relative.getZ());

		for (var x = -size; x <= size; x++) {
			for (var y = -size; y <= size; y++) {
				for (var z = -size; z <= size; z++) {
					if (pWorldGenLevel.getBlockStates(aabb).allMatch(blockState -> blockState.is(Blocks.AIR))) {
						this.placeFlower(pWorldGenLevel, pBlockPos.relative(direction, x).above(y).relative(direction.getClockWise(), z), 16);
					}
				}
			}
		}

		return true;
	}

	public void placeFlower(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeFlower(pWorldGenLevel, pBlockPos);
		}
	}

	public void placeFlower(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && pWorldGenLevel.getBlockState(pBlockPos.below()).is(BlockTags.SUBSTRATE_OVERWORLD)) {
			this.setBlock(pWorldGenLevel, pBlockPos, IcariaBlocks.VOIDLILY.get().defaultBlockState());
		}
	}

	@Override
	public MapCodec<VoidlilyFeature> codec() {
		return VoidlilyFeature.CODEC;
	}
}
