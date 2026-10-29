package com.axanthic.icaria.common.world.feature.tree;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.helper.IcariaFeatureHelper;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record DroughtrootTreeFeature(BlockState fallen, BlockState leaves, BlockState log, BlockState shrooms, BlockState twigs) implements Feature {
	public static final MapCodec<DroughtrootTreeFeature> CODEC = RecordCodecBuilder.mapCodec(
		instance -> instance.group(
			BlockState.CODEC.fieldOf("fallen").forGetter(DroughtrootTreeFeature::fallen),
			BlockState.CODEC.fieldOf("leaves").forGetter(DroughtrootTreeFeature::leaves),
			BlockState.CODEC.fieldOf("log").forGetter(DroughtrootTreeFeature::log),
			BlockState.CODEC.fieldOf("shrooms").forGetter(DroughtrootTreeFeature::shrooms),
			BlockState.CODEC.fieldOf("twigs").forGetter(DroughtrootTreeFeature::twigs)
		).apply(instance, DroughtrootTreeFeature::new)
	);

	@Override
	public boolean place(WorldGenLevel pWorldGenLevel, ChunkGenerator pChunkGenerator, RandomSource pRandomSource, BlockPos pBlockPos) {
		var direction = Direction.Plane.HORIZONTAL.getRandomDirection(pRandomSource);

		var heightTrunk = pRandomSource.nextIntBetweenInclusive(2, 4);
		var heightLower = pRandomSource.nextIntBetweenInclusive(1, 4);
		var heightInner = pRandomSource.nextIntBetweenInclusive(1, 4);
		var heightUpper = pRandomSource.nextIntBetweenInclusive(1, 4);
		var heightTotal = pBlockPos.below().getY() + heightTrunk + heightLower + heightInner + heightUpper;

		if (heightTotal < pWorldGenLevel.getMaxY() && pWorldGenLevel.getBlockState(pBlockPos.atY(heightTotal)).canBeReplaced()) {
			for (var i = 1; i <= heightTrunk; i++) {
				IcariaFeatureHelper.placeLog(pWorldGenLevel, pBlockPos.below().above(i), this.log(), Direction.Axis.Y);
			}

			for (var i = 1; i <= heightLower; i++) {
				heightTrunk++;
				direction = direction.getOpposite();
				IcariaFeatureHelper.placeLog(pWorldGenLevel, pBlockPos.below().above(heightTrunk), this.log(), Direction.Axis.Y);
				IcariaFeatureHelper.placeLog(pWorldGenLevel, pBlockPos.below().above(heightTrunk).relative(direction), this.log(), direction.getAxis());
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).relative(direction), this.leaves(), 2);
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).relative(direction.getClockWise()), this.leaves());
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).relative(direction.getCounterClockWise()), this.leaves());
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).relative(direction).relative(direction.getClockWise()), this.leaves());
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).relative(direction).relative(direction.getCounterClockWise()), this.leaves());
			}

			for (var i = 1; i <= heightInner; i++) {
				heightTrunk++;
				direction = direction.getOpposite();
				IcariaFeatureHelper.placeLog(pWorldGenLevel, pBlockPos.below().above(heightTrunk), this.log(), Direction.Axis.Y);
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).relative(direction), this.leaves());
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).relative(direction.getClockWise()), this.leaves());
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).relative(direction.getCounterClockWise()), this.leaves());
			}

			for (var i = 1; i <= heightUpper; i++) {
				heightTrunk++;
				direction = direction.getOpposite();
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk), this.leaves());
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.below().above(heightTrunk).relative(direction), this.leaves());
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
	public MapCodec<DroughtrootTreeFeature> codec() {
		return DroughtrootTreeFeature.CODEC;
	}
}
