package com.axanthic.icaria.common.world.feature;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class YellowstoneBoulderFeature extends Feature<NoneFeatureConfiguration> {
	public YellowstoneBoulderFeature(Codec<NoneFeatureConfiguration> pCodec) {
		super(pCodec);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pFeaturePlaceContext) {
		var level = pFeaturePlaceContext.level();
		var origin = pFeaturePlaceContext.origin();
		var random = pFeaturePlaceContext.random();

		for (var l = 0; l < 3; ++l) {
			var x = random.nextIntBetweenInclusive(2, 3);
			var y = random.nextIntBetweenInclusive(2, 3);
			var z = random.nextIntBetweenInclusive(2, 3);

			var f = (x + y + z) * 0.333F + 0.5F;

			for (var blockPos : BlockPos.betweenClosed(origin.offset(-x, -y, -z), origin.offset(x, y, z))) {
				if (blockPos.distSqr(origin) <= f * f) {
					level.setBlock(blockPos, IcariaBlocks.YELLOWSTONE.get().defaultBlockState(), 3);
				}
			}

			origin = origin.offset(random.nextIntBetweenInclusive(-1, 0), random.nextIntBetweenInclusive(-1, 0), random.nextIntBetweenInclusive(-1, 0));
		}

		return true;
	}

	public void placeStone(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeStone(pWorldGenLevel, pBlockPos);
		}
	}

	public void placeStone(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir()) {
			this.setBlock(pWorldGenLevel, pBlockPos, IcariaBlocks.YELLOWSTONE.get().defaultBlockState());
		}
	}
}
