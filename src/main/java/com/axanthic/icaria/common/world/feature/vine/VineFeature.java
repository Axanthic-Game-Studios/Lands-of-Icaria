package com.axanthic.icaria.common.world.feature.vine;

import com.axanthic.icaria.common.block.IcariaVineBlock;
import com.axanthic.icaria.common.properties.Vine;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;
import com.mojang.serialization.Codec;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class VineFeature extends Feature<NoneFeatureConfiguration> {
	public Block vine;

	public VineFeature(Codec<NoneFeatureConfiguration> pCodec, Block pVine) {
		super(pCodec);
		this.vine = pVine;
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pFeaturePlaceContext) {
		var level = pFeaturePlaceContext.level();
		var origin = pFeaturePlaceContext.origin();

		for (var direction : Direction.Plane.HORIZONTAL) {
			this.placeVine(level, origin, direction);
		}

		return true;
	}

	public void placeVine(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction pDirection, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeVine(pWorldGenLevel, pBlockPos, pDirection);
		}
	}

	public void placeVine(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction pDirection) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && (pWorldGenLevel.getBlockState(pBlockPos.relative(pDirection)).is(BlockTags.LEAVES) || pWorldGenLevel.getBlockState(pBlockPos.relative(pDirection)).isSolidRender()) && IcariaVineBlock.isAcceptableNeighbour(pWorldGenLevel, pBlockPos.relative(pDirection), pDirection)) {
			if (pWorldGenLevel.getRandom().nextBoolean()) {
				this.setBlock(pWorldGenLevel, pBlockPos, this.vine.defaultBlockState().setValue(IcariaVineBlock.MAP.get(pDirection), true).setValue(IcariaBlockStateProperties.VINE, Vine.NONE));
			} else {
				this.setBlock(pWorldGenLevel, pBlockPos, this.vine.defaultBlockState().setValue(IcariaVineBlock.MAP.get(pDirection), true).setValue(IcariaBlockStateProperties.VINE, Vine.VINE));
			}
		}
	}
}
