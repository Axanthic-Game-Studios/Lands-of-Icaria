package com.axanthic.icaria.common.world.feature.herb;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.MapCodec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.phys.AABB;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class WiltedElmFeature implements Feature {
	public static final MapCodec<WiltedElmFeature> CODEC = MapCodec.unit(WiltedElmFeature::new);

	@Override
	public boolean place(WorldGenLevel pWorldGenLevel, ChunkGenerator pChunkGenerator, RandomSource pRandomSource, BlockPos pBlockPos) {
		var direction = Direction.Plane.HORIZONTAL.getRandomDirection(pRandomSource);

		var size = 4;

		var aabb = new AABB(pBlockPos.getX() - 2, pBlockPos.getY(), pBlockPos.getZ() - 2, pBlockPos.getX() + 2, pBlockPos.getY(), pBlockPos.getZ() + 2);

		var leaves = pWorldGenLevel.getBlockStates(aabb).anyMatch(blockState -> blockState.is(IcariaBlocks.FALLEN_CYPRESS_LEAVES.get())) || pWorldGenLevel.getBlockStates(aabb).anyMatch(blockState -> blockState.is(IcariaBlocks.FALLEN_FIR_LEAVES.get())) || pWorldGenLevel.getBlockStates(aabb).anyMatch(blockState -> blockState.is(IcariaBlocks.FALLEN_LAUREL_LEAVES.get())) || pWorldGenLevel.getBlockStates(aabb).anyMatch(blockState -> blockState.is(IcariaBlocks.FALLEN_OLIVE_LEAVES.get())) || pWorldGenLevel.getBlockStates(aabb).anyMatch(blockState -> blockState.is(IcariaBlocks.FALLEN_PLANE_LEAVES.get())) || pWorldGenLevel.getBlockStates(aabb).anyMatch(blockState -> blockState.is(IcariaBlocks.FALLEN_POPULUS_LEAVES.get()));
		var moss = pWorldGenLevel.getBlockStates(aabb).anyMatch(blockState -> blockState.is(IcariaBlocks.FOREST_MOSS.get())) || pWorldGenLevel.getBlockStates(aabb).anyMatch(blockState -> blockState.is(IcariaBlocks.SCRUBLAND_MOSS.get())) || pWorldGenLevel.getBlockStates(aabb).anyMatch(blockState -> blockState.is(IcariaBlocks.STEPPE_MOSS.get()));

		for (var x = -size; x <= size; x++) {
			for (var y = -size; y <= size; y++) {
				for (var z = -size; z <= size; z++) {
					if (leaves && moss) {
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
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && pWorldGenLevel.getBlockState(pBlockPos.below()).is(BlockTags.SUBSTRATE_OVERWORLD)) {
			this.setBlock(pWorldGenLevel, pBlockPos, IcariaBlocks.WILTED_ELM.get().defaultBlockState());
		}
	}

	@Override
	public MapCodec<WiltedElmFeature> codec() {
		return WiltedElmFeature.CODEC;
	}
}
