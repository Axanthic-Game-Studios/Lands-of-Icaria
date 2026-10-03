package com.axanthic.icaria.common.world.feature.flowers;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GroundFlowersFeature extends Feature<NoneFeatureConfiguration> {
	public Block flowers;

	public GroundFlowersFeature(Codec<NoneFeatureConfiguration> pCodec, Block pFlowers) {
		super(pCodec);
		this.flowers = pFlowers;
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pFeaturePlaceContext) {
		var level = pFeaturePlaceContext.level();
		var origin = pFeaturePlaceContext.origin();
		var random = pFeaturePlaceContext.random();

		var direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);

		var size = 4;

		for (var x = -size; x <= size; x++) {
			for (var y = -size; y <= size; y++) {
				for (var z = -size; z <= size; z++) {
					this.placeFlowers(level, origin.relative(direction, x).above(y).relative(direction.getClockWise(), z), direction, 16);
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
			this.setBlock(pWorldGenLevel, pBlockPos, this.flowers.defaultBlockState().setValue(BlockStateProperties.FLOWER_AMOUNT, pWorldGenLevel.getRandom().nextIntBetweenInclusive(1, 4)).setValue(BlockStateProperties.HORIZONTAL_FACING, pDirection));
		}
	}
}
