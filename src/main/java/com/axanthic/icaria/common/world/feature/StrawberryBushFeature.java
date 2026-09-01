package com.axanthic.icaria.common.world.feature;

import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;
import com.mojang.serialization.Codec;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class StrawberryBushFeature extends Feature<NoneFeatureConfiguration> {
	public StrawberryBushFeature(Codec<NoneFeatureConfiguration> pCodec) {
		super(pCodec);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pFeaturePlaceContext) {
		var level = pFeaturePlaceContext.level();
		var origin = pFeaturePlaceContext.origin();
		var random = pFeaturePlaceContext.random();

		var direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);

		var size = 2;

		for (var x = -size; x <= size; x++) {
			for (var y = -size; y <= size; y++) {
				for (var z = -size; z <= size; z++) {
					this.placeBerries(level, origin.relative(direction, x).above(y).relative(direction.getClockWise(), z), 4);
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
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && pWorldGenLevel.getBlockState(pBlockPos.below()).is(BlockTags.DIRT)) {
			if (pWorldGenLevel.getRandom().nextBoolean()) {
				this.setBlock(pWorldGenLevel, pBlockPos, IcariaBlocks.STRAWBERRY_BUSH.get().defaultBlockState().setValue(IcariaBlockStateProperties.RIPE_BUSH, false));
			} else {
				this.setBlock(pWorldGenLevel, pBlockPos, IcariaBlocks.STRAWBERRY_BUSH.get().defaultBlockState().setValue(IcariaBlockStateProperties.RIPE_BUSH, true));
			}
		}
	}
}
