package com.axanthic.icaria.common.world.feature.tree.small;

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

public record SmallPlaneTreeFeature(BlockState fallen, BlockState leaves, BlockState log) implements Feature {
	public static final MapCodec<SmallPlaneTreeFeature> CODEC = RecordCodecBuilder.mapCodec(
		instance -> instance.group(
			BlockState.CODEC.fieldOf("fallen").forGetter(SmallPlaneTreeFeature::fallen),
			BlockState.CODEC.fieldOf("leaves").forGetter(SmallPlaneTreeFeature::leaves),
			BlockState.CODEC.fieldOf("log").forGetter(SmallPlaneTreeFeature::log)
		).apply(instance, SmallPlaneTreeFeature::new)
	);

	@Override
	public boolean place(WorldGenLevel pWorldGenLevel, ChunkGenerator pChunkGenerator, RandomSource pRandomSource, BlockPos pBlockPos) {
		var direction = Direction.Plane.HORIZONTAL.getRandomDirection(pRandomSource);

		var aabb = IcariaFeatureHelper.aabb(pBlockPos);

		if (pWorldGenLevel.getBlockStates(aabb).allMatch(BlockBehaviour.BlockStateBase::isSolidRender) && pWorldGenLevel.getBlockStates(aabb.move(0.0D, 1.0D, 0.0D)).allMatch(BlockBehaviour.BlockStateBase::isAir)) {
			IcariaFeatureHelper.placeLog(pWorldGenLevel, pBlockPos, this.log(), Direction.Axis.Y);

			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction.getClockWise()), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction.getCounterClockWise()), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction.getOpposite()), this.leaves());

			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction).relative(direction.getClockWise()), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.relative(direction.getOpposite()).relative(direction.getCounterClockWise()), this.leaves());

			IcariaFeatureHelper.placeFallen(pWorldGenLevel, pBlockPos.above(), this.fallen(), pRandomSource.nextIntBetweenInclusive(4, 8));

			return true;
		} else {
			return false;
		}
	}

	@Override
	public MapCodec<SmallPlaneTreeFeature> codec() {
		return SmallPlaneTreeFeature.CODEC;
	}
}
