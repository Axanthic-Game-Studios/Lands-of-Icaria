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

public record SmallLaurelTreeFeature(BlockState fallen, BlockState leaves, BlockState log) implements Feature {
	public static final MapCodec<SmallLaurelTreeFeature> CODEC = RecordCodecBuilder.mapCodec(
		instance -> instance.group(
			BlockState.CODEC.fieldOf("fallen").forGetter(SmallLaurelTreeFeature::fallen),
			BlockState.CODEC.fieldOf("leaves").forGetter(SmallLaurelTreeFeature::leaves),
			BlockState.CODEC.fieldOf("log").forGetter(SmallLaurelTreeFeature::log)
		).apply(instance, SmallLaurelTreeFeature::new)
	);

	@Override
	public boolean place(WorldGenLevel pWorldGenLevel, ChunkGenerator pChunkGenerator, RandomSource pRandomSource, BlockPos pBlockPos) {
		var aabb = IcariaFeatureHelper.aabb(pBlockPos);

		if (pWorldGenLevel.getBlockStates(aabb).allMatch(BlockBehaviour.BlockStateBase::isSolidRender) && pWorldGenLevel.getBlockStates(aabb.move(0.0D, 1.0D, 0.0D)).allMatch(BlockBehaviour.BlockStateBase::isAir)) {
			IcariaFeatureHelper.placeLog(pWorldGenLevel, pBlockPos, this.log(), Direction.Axis.Y);

			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.north(), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.east(), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.south(), this.leaves());
			IcariaFeatureHelper.placeLeaves(pWorldGenLevel, pBlockPos.west(), this.leaves());

			IcariaFeatureHelper.placeFallen(pWorldGenLevel, pBlockPos.above(), this.fallen(), pRandomSource.nextIntBetweenInclusive(4, 8));

			return true;
		} else {
			return false;
		}
	}

	@Override
	public MapCodec<SmallLaurelTreeFeature> codec() {
		return SmallLaurelTreeFeature.CODEC;
	}
}
