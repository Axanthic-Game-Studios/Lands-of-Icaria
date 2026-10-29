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

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record SpikeFeature(BlockState block) implements Feature {
	public static final MapCodec<SpikeFeature> CODEC = RecordCodecBuilder.mapCodec(
		instance -> instance.group(
			BlockState.CODEC.fieldOf("block").forGetter(SpikeFeature::block)
		).apply(instance, SpikeFeature::new)
	);

	@Override
	public boolean place(WorldGenLevel pWorldGenLevel, ChunkGenerator pChunkGenerator, RandomSource pRandomSource, BlockPos pBlockPos) {
		var length = 3;
		var height = 4;

		for (var x = 1; x <= length - 2; x++) {
			for (var y = 1; y <= height - 2; y++) {
				for (var z = 1; z <= length - 2; z++) {
					this.placeBlock(pWorldGenLevel, pBlockPos.below(2).north(x + 7).above(y + 18).east(z + 7));
				}
			}
		}

		this.placeUpperRing(pWorldGenLevel, pBlockPos.below(), 9, 19, 7, 1, 2);
		this.placeUpperRing(pWorldGenLevel, pBlockPos.below(), 9, 20, 7, 2, 1);

		for (var x = 1; x <= length - 1; x++) {
			for (var y = 1; y <= height - 1; y++) {
				for (var z = 1; z <= length - 1; z++) {
					this.placeBlock(pWorldGenLevel, pBlockPos.below(2).north(x + 4).above(y + 12).east(z + 4));
					this.placeBlock(pWorldGenLevel, pBlockPos.below(2).north(x + 5).above(y + 15).east(z + 5));
				}
			}
		}

		this.placeInnerRing(pWorldGenLevel, pBlockPos.below(), 7, 13, 4, 1, 3);
		this.placeInnerRing(pWorldGenLevel, pBlockPos.below(), 7, 14, 4, 1, 1);
		this.placeInnerRing(pWorldGenLevel, pBlockPos.below(), 7, 15, 4, 3, 1);
		this.placeInnerRing(pWorldGenLevel, pBlockPos.below(), 8, 16, 5, 1, 3);
		this.placeInnerRing(pWorldGenLevel, pBlockPos.below(), 8, 17, 5, 1, 1);
		this.placeInnerRing(pWorldGenLevel, pBlockPos.below(), 8, 18, 5, 3, 1);

		for (var x = 1; x <= length; x++) {
			for (var y = 1; y <= height; y++) {
				for (var z = 1; z <= length; z++) {
					this.placeBlock(pWorldGenLevel, pBlockPos.below(2).north(x).above(y).east(z));
					this.placeBlock(pWorldGenLevel, pBlockPos.below(2).north(x + 1).above(y + 4).east(z + 1));
					this.placeBlock(pWorldGenLevel, pBlockPos.below(2).north(x + 2).above(y + 8).east(z + 2));
				}
			}
		}

		this.placeLowerRing(pWorldGenLevel, pBlockPos.below(), 4, 1, 0, 1, 4);
		this.placeLowerRing(pWorldGenLevel, pBlockPos.below(), 4, 2, 0, 1, 2);
		this.placeLowerRing(pWorldGenLevel, pBlockPos.below(), 4, 3, 0, 2, 1);
		this.placeLowerRing(pWorldGenLevel, pBlockPos.below(), 4, 4, 0, 4, 1);
		this.placeLowerRing(pWorldGenLevel, pBlockPos.below(), 5, 5, 1, 1, 4);
		this.placeLowerRing(pWorldGenLevel, pBlockPos.below(), 5, 6, 1, 1, 2);
		this.placeLowerRing(pWorldGenLevel, pBlockPos.below(), 5, 7, 1, 2, 1);
		this.placeLowerRing(pWorldGenLevel, pBlockPos.below(), 5, 8, 1, 4, 1);
		this.placeLowerRing(pWorldGenLevel, pBlockPos.below(), 6, 9, 2, 1, 4);
		this.placeLowerRing(pWorldGenLevel, pBlockPos.below(), 6, 10, 2, 1, 2);
		this.placeLowerRing(pWorldGenLevel, pBlockPos.below(), 6, 11, 2, 2, 1);
		this.placeLowerRing(pWorldGenLevel, pBlockPos.below(), 6, 12, 2, 4, 1);

		return true;
	}

	public void placeUpperRing(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, int pX, int pY, int pZ, int pChanceSouthWest, int pChanceNorthEast) {
		this.placeBlock(pWorldGenLevel, pBlockPos.below().north(pX).above(pY).east(pZ + 1), pChanceNorthEast);
		this.placeBlock(pWorldGenLevel, pBlockPos.below().north(pZ).above(pY).east(pZ + 1), pChanceSouthWest);
		this.placeBlock(pWorldGenLevel, pBlockPos.below().north(pZ + 1).above(pY).east(pX), pChanceNorthEast);
		this.placeBlock(pWorldGenLevel, pBlockPos.below().north(pZ + 1).above(pY).east(pZ), pChanceSouthWest);
	}

	public void placeInnerRing(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, int pX, int pY, int pZ, int pChanceSouthWest, int pChanceNorthEast) {
		this.placeBlock(pWorldGenLevel, pBlockPos.below().north(pX).above(pY).east(pZ + 1), pChanceNorthEast);
		this.placeBlock(pWorldGenLevel, pBlockPos.below().north(pX).above(pY).east(pZ + 2), pChanceNorthEast);
		this.placeBlock(pWorldGenLevel, pBlockPos.below().north(pZ).above(pY).east(pZ + 1), pChanceSouthWest);
		this.placeBlock(pWorldGenLevel, pBlockPos.below().north(pZ).above(pY).east(pZ + 1), pChanceSouthWest);
		this.placeBlock(pWorldGenLevel, pBlockPos.below().north(pZ + 1).above(pY).east(pX), pChanceNorthEast);
		this.placeBlock(pWorldGenLevel, pBlockPos.below().north(pZ + 1).above(pY).east(pX), pChanceNorthEast);
		this.placeBlock(pWorldGenLevel, pBlockPos.below().north(pZ + 1).above(pY).east(pZ), pChanceSouthWest);
		this.placeBlock(pWorldGenLevel, pBlockPos.below().north(pZ + 1).above(pY).east(pZ), pChanceSouthWest);
	}

	public void placeLowerRing(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, int pX, int pY, int pZ, int pChanceSouthWest, int pChanceNorthEast) {
		this.placeBlock(pWorldGenLevel, pBlockPos.below().north(pX).above(pY).east(pZ + 1), pChanceNorthEast);
		this.placeBlock(pWorldGenLevel, pBlockPos.below().north(pX).above(pY).east(pZ + 2), pChanceNorthEast);
		this.placeBlock(pWorldGenLevel, pBlockPos.below().north(pX).above(pY).east(pZ + 3), pChanceNorthEast);
		this.placeBlock(pWorldGenLevel, pBlockPos.below().north(pZ).above(pY).east(pZ + 1), pChanceSouthWest);
		this.placeBlock(pWorldGenLevel, pBlockPos.below().north(pZ).above(pY).east(pZ + 2), pChanceSouthWest);
		this.placeBlock(pWorldGenLevel, pBlockPos.below().north(pZ).above(pY).east(pZ + 3), pChanceSouthWest);
		this.placeBlock(pWorldGenLevel, pBlockPos.below().north(pZ + 1).above(pY).east(pX), pChanceNorthEast);
		this.placeBlock(pWorldGenLevel, pBlockPos.below().north(pZ + 2).above(pY).east(pX), pChanceNorthEast);
		this.placeBlock(pWorldGenLevel, pBlockPos.below().north(pZ + 3).above(pY).east(pX), pChanceNorthEast);
		this.placeBlock(pWorldGenLevel, pBlockPos.below().north(pZ + 1).above(pY).east(pZ), pChanceSouthWest);
		this.placeBlock(pWorldGenLevel, pBlockPos.below().north(pZ + 2).above(pY).east(pZ), pChanceSouthWest);
		this.placeBlock(pWorldGenLevel, pBlockPos.below().north(pZ + 3).above(pY).east(pZ), pChanceSouthWest);
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
	public MapCodec<SpikeFeature> codec() {
		return SpikeFeature.CODEC;
	}
}
