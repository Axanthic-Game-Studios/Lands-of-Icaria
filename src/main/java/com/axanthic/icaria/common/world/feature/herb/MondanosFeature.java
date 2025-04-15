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

public class MondanosFeature extends Feature<NoneFeatureConfiguration> {
	public MondanosFeature(Codec<NoneFeatureConfiguration> pCodec) {
		super(pCodec);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pFeaturePlaceContext) {
		var level = pFeaturePlaceContext.level();
		var origin = pFeaturePlaceContext.origin();
		var random = pFeaturePlaceContext.random();

		var direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);

		var aabb = AABB.ofSize(origin.below().getCenter(), 4, 0, 4);
		var list = level.getBlockStates(aabb).toList();

		var sand = list.contains(IcariaBlocks.GRAINEL.get().defaultBlockState()) || list.contains(IcariaBlocks.SILKSAND.get().defaultBlockState());
		var loam = list.contains(IcariaBlocks.LOAM.get().defaultBlockState());

		var size = 2;

		for (var x = -size; x <= size; x++) {
			for (var y = -size; y <= size; y++) {
				for (var z = -size; z <= size; z++) {
					if (loam && sand) {
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
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && pWorldGenLevel.getBlockState(pBlockPos.below()).is(BlockTags.SAND)) {
			this.setBlock(pWorldGenLevel, pBlockPos, IcariaBlocks.MONDANOS.get().defaultBlockState());
		}
	}
}
