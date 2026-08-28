package com.axanthic.icaria.common.world.feature.hidden;

import com.mojang.serialization.Codec;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class HiddenFeature extends Feature<NoneFeatureConfiguration> {
	public Block hidden;
	public Block surface;

	public HiddenFeature(Codec<NoneFeatureConfiguration> pCodec, Block pHidden, Block pSurface) {
		super(pCodec);
		this.hidden = pHidden;
		this.surface = pSurface;
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pFeaturePlaceContext) {
		var level = pFeaturePlaceContext.level();
		var origin = pFeaturePlaceContext.origin();

		this.placeHidden(level, origin.below(2));
		this.placeHidden(level, origin.below(2).north(), 4);
		this.placeHidden(level, origin.below(2).east(), 4);
		this.placeHidden(level, origin.below(2).south(), 4);
		this.placeHidden(level, origin.below(2).west(), 4);

		this.placeSurface(level, origin);

		return true;
	}

	public void placeHidden(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeHidden(pWorldGenLevel, pBlockPos);
		}
	}

	public void placeHidden(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos) {
		if (pWorldGenLevel.getBlockState(pBlockPos.above()).isSolidRender() && pWorldGenLevel.getBlockState(pBlockPos.below()).isSolidRender() && pWorldGenLevel.getBlockState(pBlockPos.north()).isSolidRender() && pWorldGenLevel.getBlockState(pBlockPos.east()).isSolidRender() && pWorldGenLevel.getBlockState(pBlockPos.south()).isSolidRender() && pWorldGenLevel.getBlockState(pBlockPos.west()).isSolidRender()) {
			this.setBlock(pWorldGenLevel, pBlockPos, this.hidden.defaultBlockState());
		}
	}

	public void placeSurface(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeSurface(pWorldGenLevel, pBlockPos);
		}
	}

	public void placeSurface(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir()) {
			this.setBlock(pWorldGenLevel, pBlockPos, this.surface.defaultBlockState());
		}
	}
}
