package com.axanthic.icaria.common.world.feature.tree.fallen;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.helper.IcariaFeatureHelper;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record FallenPlaneTreeFeature(BlockState dead, BlockState leaves, BlockState log, BlockState shrooms, BlockState twigs) implements Feature {
	public static final MapCodec<FallenPlaneTreeFeature> CODEC = RecordCodecBuilder.mapCodec(
		instance -> instance.group(
			BlockState.CODEC.fieldOf("dead").forGetter(FallenPlaneTreeFeature::dead),
			BlockState.CODEC.fieldOf("leaves").forGetter(FallenPlaneTreeFeature::leaves),
			BlockState.CODEC.fieldOf("log").forGetter(FallenPlaneTreeFeature::log),
			BlockState.CODEC.fieldOf("shrooms").forGetter(FallenPlaneTreeFeature::shrooms),
			BlockState.CODEC.fieldOf("twigs").forGetter(FallenPlaneTreeFeature::twigs)
		).apply(instance, FallenPlaneTreeFeature::new)
	);

	@Override
	public boolean place(WorldGenLevel pWorldGenLevel, ChunkGenerator pChunkGenerator, RandomSource pRandomSource, BlockPos pBlockPos) {
		var widthClockWise = 0;
		var widthCounterClockWise = 0;
		var offset = pRandomSource.nextIntBetweenInclusive(1, 2);
		var lengthTrunk = pRandomSource.nextIntBetweenInclusive(0, 2);
		var lengthCrownClockWise = pRandomSource.nextIntBetweenInclusive(2, 4);
		var lengthCrownCounterClockWise = pRandomSource.nextIntBetweenInclusive(2, 4);
		var lengthTotal = Math.max(lengthCrownClockWise, lengthCrownCounterClockWise) + lengthTrunk + 2;

		var direction = Direction.Plane.HORIZONTAL.getRandomDirection(pRandomSource);

		var aabb = IcariaFeatureHelper.aabb(pBlockPos, direction, lengthTotal, offset, 5);

		if (pWorldGenLevel.getBlockStates(aabb).allMatch(BlockBehaviour.BlockStateBase::isSolidRender) && pWorldGenLevel.getBlockStates(aabb.move(0.0D, 1.0D, 0.0D)).allMatch(BlockBehaviour.BlockStateBase::isAir)) {
			IcariaFeatureHelper.placeDead(pWorldGenLevel, pBlockPos, this.dead(), Direction.Axis.Y);

			offset++;
			IcariaFeatureHelper.placeDead(pWorldGenLevel, pBlockPos.relative(direction, offset), this.dead(), direction.getAxis());
			IcariaFeatureHelper.placeShrooms(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getClockWise()), this.shrooms(), direction.getClockWise(), 4);
			IcariaFeatureHelper.placeShrooms(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getCounterClockWise()), this.shrooms(), direction.getCounterClockWise(), 4);

			for (var i = 1; i <= lengthTrunk; i++) {
				offset++;
				IcariaFeatureHelper.placeLog(pWorldGenLevel, pBlockPos.relative(direction, offset), this.log(), direction.getAxis());
			}

			var lengthClockWise = offset;

			for (var i = 1; i <= lengthCrownClockWise; i++) {
				lengthClockWise++;
				widthClockWise++;
				IcariaFeatureHelper.placeLog(pWorldGenLevel, pBlockPos.relative(direction, lengthClockWise).relative(direction.getClockWise(), widthClockWise), this.log(), direction.getClockWise().getAxis());
			}

			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, lengthClockWise).relative(direction.getClockWise(), widthClockWise).above(), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, lengthClockWise).relative(direction.getClockWise(), widthClockWise).relative(direction), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, lengthClockWise).relative(direction.getClockWise(), widthClockWise).relative(direction.getClockWise()), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, lengthClockWise).relative(direction.getClockWise(), widthClockWise).relative(direction.getCounterClockWise()), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, lengthClockWise).relative(direction.getClockWise(), widthClockWise).relative(direction.getOpposite()), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, lengthClockWise).relative(direction.getClockWise(), widthClockWise).relative(direction).above(), this.leaves(), 2);
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, lengthClockWise).relative(direction.getClockWise(), widthClockWise).relative(direction.getClockWise()).above(), this.leaves(), 2);
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, lengthClockWise).relative(direction.getClockWise(), widthClockWise).relative(direction.getOpposite()).above(), this.leaves(), 2);
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, lengthClockWise).relative(direction.getClockWise(), widthClockWise).relative(direction.getClockWise()).relative(direction), this.leaves(), 2);
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, lengthClockWise).relative(direction.getClockWise(), widthClockWise).relative(direction.getClockWise()).relative(direction.getOpposite()), this.leaves(), 2);
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, lengthClockWise).relative(direction.getClockWise(), widthClockWise).relative(direction.getCounterClockWise()).above(), this.leaves(), 2);
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, lengthClockWise).relative(direction.getClockWise(), widthClockWise).relative(direction.getCounterClockWise()).relative(direction), this.leaves(), 2);
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, lengthClockWise).relative(direction.getClockWise(), widthClockWise).relative(direction.getCounterClockWise()).relative(direction.getOpposite()), this.leaves(), 2);

			var lengthCounterClockWise = offset;

			for (var i = 1; i <= lengthCrownCounterClockWise; i++) {
				lengthCounterClockWise++;
				widthCounterClockWise++;
				IcariaFeatureHelper.placeLog(pWorldGenLevel, pBlockPos.relative(direction, lengthCounterClockWise).relative(direction.getCounterClockWise(), widthCounterClockWise), this.log(), direction.getCounterClockWise().getAxis());
			}

			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, lengthCounterClockWise).relative(direction.getCounterClockWise(), widthCounterClockWise).above(), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, lengthCounterClockWise).relative(direction.getCounterClockWise(), widthCounterClockWise).relative(direction), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, lengthCounterClockWise).relative(direction.getCounterClockWise(), widthCounterClockWise).relative(direction.getClockWise()), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, lengthCounterClockWise).relative(direction.getCounterClockWise(), widthCounterClockWise).relative(direction.getCounterClockWise()), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, lengthCounterClockWise).relative(direction.getCounterClockWise(), widthCounterClockWise).relative(direction.getOpposite()), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, lengthCounterClockWise).relative(direction.getCounterClockWise(), widthCounterClockWise).relative(direction).above(), this.leaves(), 2);
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, lengthCounterClockWise).relative(direction.getCounterClockWise(), widthCounterClockWise).relative(direction.getCounterClockWise()).above(), this.leaves(), 2);
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, lengthCounterClockWise).relative(direction.getCounterClockWise(), widthCounterClockWise).relative(direction.getOpposite()).above(), this.leaves(), 2);
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, lengthCounterClockWise).relative(direction.getCounterClockWise(), widthCounterClockWise).relative(direction.getCounterClockWise()).relative(direction), this.leaves(), 2);
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, lengthCounterClockWise).relative(direction.getCounterClockWise(), widthCounterClockWise).relative(direction.getCounterClockWise()).relative(direction.getOpposite()), this.leaves(), 2);
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, lengthCounterClockWise).relative(direction.getCounterClockWise(), widthCounterClockWise).relative(direction.getClockWise()).above(), this.leaves(), 2);
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, lengthCounterClockWise).relative(direction.getCounterClockWise(), widthCounterClockWise).relative(direction.getClockWise()).relative(direction), this.leaves(), 2);
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, lengthCounterClockWise).relative(direction.getCounterClockWise(), widthCounterClockWise).relative(direction.getClockWise()).relative(direction.getOpposite()), this.leaves(), 2);

			IcariaFeatureHelper.placeTwigsPatch(pWorldGenLevel, pBlockPos, this.twigs(), 4);

			return true;
		} else {
			return false;
		}
	}

	@Override
	public MapCodec<FallenPlaneTreeFeature> codec() {
		return FallenPlaneTreeFeature.CODEC;
	}
}
