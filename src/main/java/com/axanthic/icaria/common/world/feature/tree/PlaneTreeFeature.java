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

public record PlaneTreeFeature(BlockState fallen, BlockState leaves, BlockState log, BlockState shrooms, BlockState twigs) implements Feature {
	public static final MapCodec<PlaneTreeFeature> CODEC = RecordCodecBuilder.mapCodec(
		instance -> instance.group(
			BlockState.CODEC.fieldOf("fallen").forGetter(PlaneTreeFeature::fallen),
			BlockState.CODEC.fieldOf("leaves").forGetter(PlaneTreeFeature::leaves),
			BlockState.CODEC.fieldOf("log").forGetter(PlaneTreeFeature::log),
			BlockState.CODEC.fieldOf("shrooms").forGetter(PlaneTreeFeature::shrooms),
			BlockState.CODEC.fieldOf("twigs").forGetter(PlaneTreeFeature::twigs)
		).apply(instance, PlaneTreeFeature::new)
	);

	@Override
	public boolean place(WorldGenLevel pWorldGenLevel, ChunkGenerator pChunkGenerator, RandomSource pRandomSource, BlockPos pBlockPos) {
		var directions = new ArrayList<Direction>();

		var countBranch = pRandomSource.nextIntBetweenInclusive(2, 3);
		var heightTrunk = pRandomSource.nextIntBetweenInclusive(2, 4);
		var heightTotal = pBlockPos.below().getY() + heightTrunk + 5;

		if (heightTotal < pWorldGenLevel.getMaxY() && pWorldGenLevel.getBlockState(pBlockPos.atY(heightTotal)).canBeReplaced()) {
			for (var direction : Direction.Plane.HORIZONTAL) {
				directions.add(direction);
			}

			for (var i = 1; i <= heightTrunk; i++) {
				IcariaFeatureHelper.placeLog(pWorldGenLevel, pBlockPos.below().above(i), this.log(), Direction.Axis.Y);
			}

			for (var i = 1; i <= countBranch; i++) {
				var front = Direction.Plane.HORIZONTAL.getRandomDirection(pRandomSource);
				var right = front.getClockWise();
				var back = front.getOpposite();
				var left = front.getCounterClockWise();
				var direction = directions.get(pRandomSource.nextInt(directions.size()));
				var clockWise = direction.getClockWise();
				var blockPos = pBlockPos.below().above(heightTrunk);

				var heightBranch = pRandomSource.nextIntBetweenInclusive(2, 4);

				directions.remove(direction);

				for (var j = 1; j <= heightBranch; j++) {
					blockPos = blockPos.above().relative(direction);
					if (pRandomSource.nextInt(3) == 0) {
						blockPos = blockPos.relative(clockWise);
					}

					IcariaFeatureHelper.placeLog(pWorldGenLevel, blockPos, this.log(), direction.getAxis());
				}

				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, blockPos.relative(front).relative(right), this.leaves(), 2);
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, blockPos.relative(back).relative(left), this.leaves(), 2);
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, blockPos.north(), this.leaves());
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, blockPos.east(), this.leaves());
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, blockPos.south(), this.leaves());
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, blockPos.west(), this.leaves());
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, blockPos.above(), this.leaves());
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, blockPos.above().relative(front), this.leaves(), 2);
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, blockPos.above().relative(front).relative(right), this.leaves(), 2);
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, blockPos.above().relative(right), this.leaves(), 2);
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, blockPos.below(), this.leaves());
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, blockPos.below().relative(back), this.leaves(), 2);
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, blockPos.below().relative(back).relative(left), this.leaves(), 2);
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, blockPos.below().relative(left), this.leaves(), 2);
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
	public MapCodec<PlaneTreeFeature> codec() {
		return PlaneTreeFeature.CODEC;
	}
}
