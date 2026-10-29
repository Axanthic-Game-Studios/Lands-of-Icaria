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

public record HiddenFeature(BlockState hidden, BlockState surface) implements Feature {
	public static final MapCodec<HiddenFeature> CODEC = RecordCodecBuilder.mapCodec(
		instance -> instance.group(
			BlockState.CODEC.fieldOf("hidden").forGetter(HiddenFeature::hidden),
			BlockState.CODEC.fieldOf("surface").forGetter(HiddenFeature::surface)
		).apply(instance, HiddenFeature::new)
	);

	@Override
	public boolean place(WorldGenLevel pWorldGenLevel, ChunkGenerator pChunkGenerator, RandomSource pRandomSource, BlockPos pBlockPos) {
		this.placeHidden(pWorldGenLevel, pBlockPos.below(2));
		this.placeHidden(pWorldGenLevel, pBlockPos.below(2).north(), 4);
		this.placeHidden(pWorldGenLevel, pBlockPos.below(2).east(), 4);
		this.placeHidden(pWorldGenLevel, pBlockPos.below(2).south(), 4);
		this.placeHidden(pWorldGenLevel, pBlockPos.below(2).west(), 4);

		this.placeSurface(pWorldGenLevel, pBlockPos);

		return true;
	}

	public void placeHidden(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeHidden(pWorldGenLevel, pBlockPos);
		}
	}

	public void placeHidden(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos) {
		if (pWorldGenLevel.getBlockState(pBlockPos.above()).isSolidRender() && pWorldGenLevel.getBlockState(pBlockPos.below()).isSolidRender() && pWorldGenLevel.getBlockState(pBlockPos.north()).isSolidRender() && pWorldGenLevel.getBlockState(pBlockPos.east()).isSolidRender() && pWorldGenLevel.getBlockState(pBlockPos.south()).isSolidRender() && pWorldGenLevel.getBlockState(pBlockPos.west()).isSolidRender()) {
			this.setBlock(pWorldGenLevel, pBlockPos, this.hidden());
		}
	}

	public void placeSurface(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeSurface(pWorldGenLevel, pBlockPos);
		}
	}

	public void placeSurface(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir()) {
			this.setBlock(pWorldGenLevel, pBlockPos, this.surface());
		}
	}

	@Override
	public MapCodec<HiddenFeature> codec() {
		return HiddenFeature.CODEC;
	}
}
