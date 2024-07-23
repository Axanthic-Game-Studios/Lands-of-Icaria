package com.axanthic.icaria.common.world.feature;

import com.axanthic.icaria.common.properties.Ripe;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class StrawberryBushFeature extends Feature<NoneFeatureConfiguration> {
	public StrawberryBushFeature(Codec<NoneFeatureConfiguration> pCodec) {
		super(pCodec);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
		var level = pContext.level();
		var origin = pContext.origin();
		var random = pContext.random();
		var direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);

		int size = 2;

		for (int x = -size; x <= size; x++) {
			for (int y = -size; y <= size; y++) {
				for (int z = -size; z <= size; z++) {
					this.placeBerries(level, origin.relative(direction, x).above(y).relative(direction.getClockWise(), z), 4);
				}
			}
		}

		return true;
	}

	public void placeBerries(WorldGenLevel pLevel, BlockPos pPos, int pChance) {
		if (pLevel.getRandom().nextInt(pChance) == 0) {
			this.placeBerries(pLevel, pPos);
		}
	}

	public void placeBerries(WorldGenLevel pLevel, BlockPos pPos) {
		if (pLevel.getBlockState(pPos).isAir() && pLevel.getBlockState(pPos.below()).is(BlockTags.DIRT)) {
			if (pLevel.getRandom().nextBoolean()) {
				this.setBlock(pLevel, pPos, IcariaBlocks.STRAWBERRY_BUSH.get().defaultBlockState().setValue(IcariaBlockStateProperties.RIPE, Ripe.NONE));
			} else {
				this.setBlock(pLevel, pPos, IcariaBlocks.STRAWBERRY_BUSH.get().defaultBlockState().setValue(IcariaBlockStateProperties.RIPE, Ripe.RIPE));
			}
		}
	}
}
