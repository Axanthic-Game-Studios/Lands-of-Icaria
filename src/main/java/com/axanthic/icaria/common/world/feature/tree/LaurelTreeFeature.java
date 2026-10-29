package com.axanthic.icaria.common.world.feature.tree;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.helper.IcariaFeatureHelper;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.ArrayList;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record LaurelTreeFeature(BlockState fallen, BlockState leaves, BlockState log, BlockState shrooms, BlockState twigs) implements Feature {
	public static final MapCodec<LaurelTreeFeature> CODEC = RecordCodecBuilder.mapCodec(
		instance -> instance.group(
			BlockState.CODEC.fieldOf("fallen").forGetter(LaurelTreeFeature::fallen),
			BlockState.CODEC.fieldOf("leaves").forGetter(LaurelTreeFeature::leaves),
			BlockState.CODEC.fieldOf("log").forGetter(LaurelTreeFeature::log),
			BlockState.CODEC.fieldOf("shrooms").forGetter(LaurelTreeFeature::shrooms),
			BlockState.CODEC.fieldOf("twigs").forGetter(LaurelTreeFeature::twigs)
		).apply(instance, LaurelTreeFeature::new)
	);

	@Override
	public boolean place(WorldGenLevel pWorldGenLevel, ChunkGenerator pChunkGenerator, RandomSource pRandomSource, BlockPos pBlockPos) {
		var directions = new ArrayList<Direction>();

		var countBranch = pRandomSource.nextIntBetweenInclusive(2, 3);
		var heightTrunk = pRandomSource.nextIntBetweenInclusive(2, 4);
		var heightTotal = pBlockPos.below().getY() + heightTrunk + 7;

		if (heightTotal < pWorldGenLevel.getMaxY() && pWorldGenLevel.getBlockState(pBlockPos.atY(heightTotal)).canBeReplaced()) {
			for (var direction : Direction.Plane.HORIZONTAL) {
				directions.add(direction);
			}

			for (var i = 1; i <= heightTrunk; i++) {
				IcariaFeatureHelper.placeLog(pWorldGenLevel, pBlockPos.below().above(i), this.log(), Direction.Axis.Y);
			}

			for (var i = 1; i <= countBranch; i++) {
				var direction = directions.get(pRandomSource.nextInt(directions.size()));
				var clockWise = direction.getClockWise();
				var blockPos = pBlockPos.below().above(heightTrunk);

				var heightBranch = pRandomSource.nextIntBetweenInclusive(4, 6);

				directions.remove(direction);

				for (var j = 1; j <= heightBranch; j++) {
					blockPos = blockPos.above();
					if (pRandomSource.nextInt(j * 2 + 1) == 0) {
						blockPos = blockPos.relative(direction);
					}

					if (pRandomSource.nextInt(j * 2 + 3) == 0) {
						blockPos = blockPos.relative(clockWise);
					}

					IcariaFeatureHelper.placeLog(pWorldGenLevel, blockPos, this.log(), Direction.Axis.Y);
					IcariaFeatureHelper.placeLeaves(pWorldGenLevel, blockPos.above(), this.leaves());
					IcariaFeatureHelper.placeLeaves(pWorldGenLevel, blockPos.north(), this.leaves());
					IcariaFeatureHelper.placeLeaves(pWorldGenLevel, blockPos.east(), this.leaves());
					IcariaFeatureHelper.placeLeaves(pWorldGenLevel, blockPos.south(), this.leaves());
					IcariaFeatureHelper.placeLeaves(pWorldGenLevel, blockPos.west(), this.leaves());
					IcariaFeatureHelper.placeLeaves(pWorldGenLevel, blockPos.below(), this.leaves());
				}
			}

			IcariaFeatureHelper.placeTwigsPatch(pWorldGenLevel, pBlockPos, this.twigs(), 4);
			IcariaFeatureHelper.placeFallenPatch(pWorldGenLevel, pBlockPos, this.fallen(), 4);
			IcariaFeatureHelper.placeShroomsPatch(pWorldGenLevel, pBlockPos, this.shrooms(), 4);

			return true;
		} else {
			return false;
		}
	}

	@Override
	public MapCodec<LaurelTreeFeature> codec() {
		return LaurelTreeFeature.CODEC;
	}
}
