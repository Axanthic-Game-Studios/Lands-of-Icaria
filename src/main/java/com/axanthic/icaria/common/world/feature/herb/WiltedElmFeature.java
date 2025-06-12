package com.axanthic.icaria.common.world.feature.herb;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.phys.AABB;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class WiltedElmFeature extends Feature<NoneFeatureConfiguration> {
	public WiltedElmFeature(Codec<NoneFeatureConfiguration> pCodec) {
		super(pCodec);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pFeaturePlaceContext) {
		var level = pFeaturePlaceContext.level();
		var origin = pFeaturePlaceContext.origin();
		var random = pFeaturePlaceContext.random();

		var direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);

		var size = 2;

		var aabb = new AABB(origin.getX() - 8, origin.getY(), origin.getZ() - 8, origin.getX() + 8, origin.getY(), origin.getZ() + 8);

		var leaves = level.getBlockStates(aabb).anyMatch(blockState -> blockState.is(IcariaBlocks.FALLEN_CYPRESS_LEAVES.get())) || level.getBlockStates(aabb).anyMatch(blockState -> blockState.is(IcariaBlocks.FALLEN_FIR_LEAVES.get())) || level.getBlockStates(aabb).anyMatch(blockState -> blockState.is(IcariaBlocks.FALLEN_LAUREL_LEAVES.get())) || level.getBlockStates(aabb).anyMatch(blockState -> blockState.is(IcariaBlocks.FALLEN_OLIVE_LEAVES.get())) || level.getBlockStates(aabb).anyMatch(blockState -> blockState.is(IcariaBlocks.FALLEN_PLANE_LEAVES.get())) || level.getBlockStates(aabb).anyMatch(blockState -> blockState.is(IcariaBlocks.FALLEN_POPULUS_LEAVES.get()));
		var moss = level.getBlockStates(aabb).anyMatch(blockState -> blockState.is(IcariaBlocks.FOREST_MOSS.get())) || level.getBlockStates(aabb).anyMatch(blockState -> blockState.is(IcariaBlocks.SCRUBLAND_MOSS.get())) || level.getBlockStates(aabb).anyMatch(blockState -> blockState.is(IcariaBlocks.STEPPE_MOSS.get()));

		for (var x = -size; x <= size; x++) {
			for (var y = -size; y <= size; y++) {
				for (var z = -size; z <= size; z++) {
					if (leaves && moss) {
						this.placeHerb(level, origin.relative(direction, x).above(y).relative(direction.getClockWise(), z), 16);
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
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && pWorldGenLevel.getBlockState(pBlockPos.below()).is(BlockTags.DIRT)) {
			this.setBlock(pWorldGenLevel, pBlockPos, IcariaBlocks.WILTED_ELM.get().defaultBlockState());
		}
	}
}
