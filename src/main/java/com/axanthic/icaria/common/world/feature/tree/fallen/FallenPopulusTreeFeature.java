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

public record FallenPopulusTreeFeature(BlockState dead, BlockState leaves, BlockState log, BlockState shrooms, BlockState twigs) implements Feature {
	public static final MapCodec<FallenPopulusTreeFeature> CODEC = RecordCodecBuilder.mapCodec(
		instance -> instance.group(
			BlockState.CODEC.fieldOf("dead").forGetter(FallenPopulusTreeFeature::dead),
			BlockState.CODEC.fieldOf("leaves").forGetter(FallenPopulusTreeFeature::leaves),
			BlockState.CODEC.fieldOf("log").forGetter(FallenPopulusTreeFeature::log),
			BlockState.CODEC.fieldOf("shrooms").forGetter(FallenPopulusTreeFeature::shrooms),
			BlockState.CODEC.fieldOf("twigs").forGetter(FallenPopulusTreeFeature::twigs)
		).apply(instance, FallenPopulusTreeFeature::new)
	);

	@Override
	public boolean place(WorldGenLevel pWorldGenLevel, ChunkGenerator pChunkGenerator, RandomSource pRandomSource, BlockPos pBlockPos) {
		var offset = pRandomSource.nextIntBetweenInclusive(1, 2);
		var lengthCrown = pRandomSource.nextIntBetweenInclusive(1, 2);
		var lengthTotal = lengthCrown + lengthCrown + 8;

		var direction = Direction.Plane.HORIZONTAL.getRandomDirection(pRandomSource);

		var aabb = IcariaFeatureHelper.aabb(pBlockPos, direction, lengthTotal, offset, 2);

		if (pWorldGenLevel.getBlockStates(aabb).allMatch(BlockBehaviour.BlockStateBase::isSolidRender) && pWorldGenLevel.getBlockStates(aabb.move(0.0D, 1.0D, 0.0D)).allMatch(BlockBehaviour.BlockStateBase::isAir)) {
			IcariaFeatureHelper.placeDead(pWorldGenLevel, pBlockPos, this.dead(), Direction.Axis.Y);

			offset++;
			IcariaFeatureHelper.placeDead(pWorldGenLevel, pBlockPos.relative(direction, offset), this.dead(), direction.getAxis());
			IcariaFeatureHelper.placeShrooms(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getClockWise()), this.shrooms(), direction.getClockWise(), 4);
			IcariaFeatureHelper.placeShrooms(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getCounterClockWise()), this.shrooms(), direction.getCounterClockWise(), 4);

			offset++;
			IcariaFeatureHelper.placeLog(pWorldGenLevel, pBlockPos.relative(direction, offset), this.log(), direction.getAxis());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).above(), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getClockWise()), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getCounterClockWise()), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getClockWise()).above(), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getCounterClockWise()).above(), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).above(2), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getClockWise(), 2), this.leaves(), 2);
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getCounterClockWise(), 2), this.leaves(), 2);

			for (var i = 1; i <= lengthCrown; i++) {
				offset++;
				IcariaFeatureHelper.placeLog(pWorldGenLevel, pBlockPos.relative(direction, offset), this.log(), direction.getAxis());
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).above(), this.leaves());
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getClockWise()), this.leaves());
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getCounterClockWise()), this.leaves());
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getClockWise()).above(), this.leaves());
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getCounterClockWise()).above(), this.leaves());
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).above(2), this.leaves());
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getClockWise(), 2), this.leaves());
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getCounterClockWise(), 2), this.leaves());
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getClockWise()).above(2), this.leaves(), 2);
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getCounterClockWise()).above(2), this.leaves(), 2);
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getClockWise(), 2).above(), this.leaves(), 2);
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getCounterClockWise(), 2).above(), this.leaves(), 2);
			}

			offset++;
			IcariaFeatureHelper.placeLog(pWorldGenLevel, pBlockPos.relative(direction, offset), this.log(), direction.getAxis());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).above(), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getClockWise()), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getCounterClockWise()), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getClockWise()).above(), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getCounterClockWise()).above(), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).above(2), this.leaves(), 2);
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getClockWise(), 2), this.leaves(), 2);
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getCounterClockWise(), 2), this.leaves(), 2);

			for (var i = 1; i <= lengthCrown; i++) {
				offset++;
				IcariaFeatureHelper.placeLog(pWorldGenLevel, pBlockPos.relative(direction, offset), this.log(), direction.getAxis());
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).above(), this.leaves());
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getClockWise()), this.leaves());
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getCounterClockWise()), this.leaves());
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getClockWise()).above(), this.leaves());
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getCounterClockWise()).above(), this.leaves());
			}

			offset++;
			IcariaFeatureHelper.placeLog(pWorldGenLevel, pBlockPos.relative(direction, offset), this.log(), direction.getAxis());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).above(), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getClockWise()), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getCounterClockWise()), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getClockWise()).above(), this.leaves(), 2);
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getCounterClockWise()).above(), this.leaves(), 2);

			offset++;
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).above(), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getClockWise()), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getCounterClockWise()), this.leaves());

			offset++;
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).above(), this.leaves(), 2);
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getClockWise()), this.leaves(), 2);
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(direction.getCounterClockWise()), this.leaves(), 2);

			offset++;
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset), this.leaves());

			offset++;
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset), this.leaves());

			IcariaFeatureHelper.placeTwigsPatch(pWorldGenLevel, pBlockPos, this.twigs(), 4);

			return true;
		} else {
			return false;
		}
	}

	@Override
	public MapCodec<FallenPopulusTreeFeature> codec() {
		return FallenPopulusTreeFeature.CODEC;
	}
}
