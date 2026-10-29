package com.axanthic.icaria.common.world.feature;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record BoulderFeature(BlockState block) implements Feature {
	public static final MapCodec<BoulderFeature> CODEC = RecordCodecBuilder.mapCodec(
		instance -> instance.group(
			BlockState.CODEC.fieldOf("block").forGetter(BoulderFeature::block)
		).apply(instance, BoulderFeature::new)
	);

	@Override
	public boolean place(WorldGenLevel pWorldGenLevel, ChunkGenerator pChunkGenerator, RandomSource pRandomSource, BlockPos pBlockPos) {
		for (var l = 0; l < 3; l++) {
			var x = pRandomSource.nextIntBetweenInclusive(2, 3);
			var y = pRandomSource.nextIntBetweenInclusive(2, 3);
			var z = pRandomSource.nextIntBetweenInclusive(2, 3);

			var f = (x + y + z) * 0.333F + 0.5F;

			for (var blockPos : BlockPos.betweenClosed(pBlockPos.offset(-x, -y, -z), pBlockPos.offset(x, y, z))) {
				if (blockPos.distSqr(pBlockPos) <= f * f) {
					this.setBlock(pWorldGenLevel, blockPos, this.block());
				}
			}

			pBlockPos = pBlockPos.offset(pRandomSource.nextIntBetweenInclusive(-1, 0), pRandomSource.nextIntBetweenInclusive(-1, 0), pRandomSource.nextIntBetweenInclusive(-1, 0));
		}

		return true;
	}

	public void placeBlock(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeBlock(pWorldGenLevel, pBlockPos);
		}
	}

	public void placeBlock(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir()) {
			this.setBlock(pWorldGenLevel, pBlockPos, this.block());
		}
	}

	@Override
	public MapCodec<BoulderFeature> codec() {
		return BoulderFeature.CODEC;
	}
}
