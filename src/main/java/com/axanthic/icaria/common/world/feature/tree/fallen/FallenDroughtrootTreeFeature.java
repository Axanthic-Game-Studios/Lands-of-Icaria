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

public record FallenDroughtrootTreeFeature(BlockState dead, BlockState leaves, BlockState log, BlockState shrooms, BlockState twigs) implements Feature {
	public static final MapCodec<FallenDroughtrootTreeFeature> CODEC = RecordCodecBuilder.mapCodec(
		instance -> instance.group(
			BlockState.CODEC.fieldOf("dead").forGetter(FallenDroughtrootTreeFeature::dead),
			BlockState.CODEC.fieldOf("leaves").forGetter(FallenDroughtrootTreeFeature::leaves),
			BlockState.CODEC.fieldOf("log").forGetter(FallenDroughtrootTreeFeature::log),
			BlockState.CODEC.fieldOf("shrooms").forGetter(FallenDroughtrootTreeFeature::shrooms),
			BlockState.CODEC.fieldOf("twigs").forGetter(FallenDroughtrootTreeFeature::twigs)
		).apply(instance, FallenDroughtrootTreeFeature::new)
	);

	@Override
	public boolean place(WorldGenLevel pWorldGenLevel, ChunkGenerator pChunkGenerator, RandomSource pRandomSource, BlockPos pBlockPos) {
		var offset = pRandomSource.nextIntBetweenInclusive(1, 2);
		var lengthTrunk = pRandomSource.nextIntBetweenInclusive(0, 2);
		var lengthLower = pRandomSource.nextIntBetweenInclusive(1, 4);
		var lengthInner = pRandomSource.nextIntBetweenInclusive(1, 4);
		var lengthUpper = pRandomSource.nextIntBetweenInclusive(1, 4);
		var lengthTotal = lengthTrunk + lengthLower + lengthInner + lengthUpper + 1;

		var direction = Direction.Plane.HORIZONTAL.getRandomDirection(pRandomSource);
		var orthogonal = direction.getClockWise();

		var aabb = IcariaFeatureHelper.aabb(pBlockPos, direction, lengthTotal, offset, 1);

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

			for (var i = 1; i <= lengthLower; i++) {
				offset++;
				orthogonal = orthogonal.getOpposite();
				IcariaFeatureHelper.placeLog(pWorldGenLevel, pBlockPos.relative(direction, offset), this.log(), direction.getAxis());
				IcariaFeatureHelper.placeLog(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(orthogonal), this.log(), orthogonal.getAxis());
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).above(), this.leaves());
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(orthogonal).above(), this.leaves());
			}

			for (var i = 1; i <= lengthInner; i++) {
				offset++;
				orthogonal = orthogonal.getOpposite();
				IcariaFeatureHelper.placeLog(pWorldGenLevel, pBlockPos.relative(direction, offset), this.log(), direction.getAxis());
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).above(), this.leaves());
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(orthogonal), this.leaves());
			}

			for (var i = 1; i <= lengthUpper; i++) {
				offset++;
				orthogonal = orthogonal.getOpposite();
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset), this.leaves());
				IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction, offset).relative(orthogonal), this.leaves());
			}

			IcariaFeatureHelper.placeTwigsPatch(pWorldGenLevel, pBlockPos, this.twigs(), 4);

			return true;
		} else {
			return false;
		}
	}

	@Override
	public MapCodec<FallenDroughtrootTreeFeature> codec() {
		return FallenDroughtrootTreeFeature.CODEC;
	}
}
