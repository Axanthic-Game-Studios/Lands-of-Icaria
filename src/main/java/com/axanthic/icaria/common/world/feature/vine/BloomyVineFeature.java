package com.axanthic.icaria.common.world.feature.vine;

import com.axanthic.icaria.common.block.IcariaVineBlock;
import com.axanthic.icaria.common.properties.Vine;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class BloomyVineFeature extends IcariaVineFeature {
	public BloomyVineFeature(Codec<NoneFeatureConfiguration> pCodec) {
		super(pCodec, IcariaBlocks.BLOOMY_VINE.get());
	}

	@Override
	public void placeVine(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction pDirection) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && (pWorldGenLevel.getBlockState(pBlockPos.relative(pDirection)).is(BlockTags.LEAVES) || pWorldGenLevel.getBlockState(pBlockPos.relative(pDirection)).isSolidRender()) && IcariaVineBlock.isAcceptableNeighbour(pWorldGenLevel, pBlockPos.relative(pDirection), pDirection)) {
			if (pWorldGenLevel.getRandom().nextBoolean()) {
				if (pWorldGenLevel.getRandom().nextInt(3) == 0) {
					this.setBlock(pWorldGenLevel, pBlockPos, this.vine.defaultBlockState().setValue(IcariaVineBlock.MAP.get(pDirection), true).setValue(IcariaBlockStateProperties.VINE, Vine.NONE));
				} else if (pWorldGenLevel.getRandom().nextInt(3) == 1) {
					this.setBlock(pWorldGenLevel, pBlockPos, this.vine.defaultBlockState().setValue(IcariaVineBlock.MAP.get(pDirection), true).setValue(IcariaBlockStateProperties.VINE, Vine.BLOOMING));
				} else if (pWorldGenLevel.getRandom().nextInt(3) == 2) {
					this.setBlock(pWorldGenLevel, pBlockPos, this.vine.defaultBlockState().setValue(IcariaVineBlock.MAP.get(pDirection), true).setValue(IcariaBlockStateProperties.VINE, Vine.RIPE));
				}
			} else {
				this.setBlock(pWorldGenLevel, pBlockPos, this.vine.defaultBlockState().setValue(IcariaVineBlock.MAP.get(pDirection), true).setValue(IcariaBlockStateProperties.VINE, Vine.VINE));
			}
		}
	}
}
