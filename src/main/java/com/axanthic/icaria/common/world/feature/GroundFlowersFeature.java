package com.axanthic.icaria.common.world.feature;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record GroundFlowersFeature(BlockState flowers) implements Feature {
	public static final MapCodec<GroundFlowersFeature> CODEC = RecordCodecBuilder.mapCodec(
		instance -> instance.group(
			BlockState.CODEC.fieldOf("flowers").forGetter(GroundFlowersFeature::flowers)
		).apply(instance, GroundFlowersFeature::new)
	);

	@Override
	public boolean place(WorldGenLevel pWorldGenLevel, ChunkGenerator pChunkGenerator, RandomSource pRandomSource, BlockPos pBlockPos) {
		var direction = Direction.Plane.HORIZONTAL.getRandomDirection(pRandomSource);

		var size = 4;

		for (var x = -size; x <= size; x++) {
			for (var y = -size; y <= size; y++) {
				for (var z = -size; z <= size; z++) {
					this.placeFlowers(pWorldGenLevel, pBlockPos.relative(direction, x).above(y).relative(direction.getClockWise(), z), direction, 16);
				}
			}
		}

		return true;
	}

	public void placeFlowers(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction pDirection, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeFlowers(pWorldGenLevel, pBlockPos, pDirection);
		}
	}

	public void placeFlowers(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction pDirection) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && pWorldGenLevel.getBlockState(pBlockPos.below()).is(BlockTags.SUBSTRATE_OVERWORLD)) {
			this.setBlock(pWorldGenLevel, pBlockPos, this.flowers().setValue(BlockStateProperties.FLOWER_AMOUNT, pWorldGenLevel.getRandom().nextIntBetweenInclusive(1, 4)).setValue(BlockStateProperties.HORIZONTAL_FACING, pDirection));
		}
	}

	@Override
	public MapCodec<GroundFlowersFeature> codec() {
		return GroundFlowersFeature.CODEC;
	}
}
