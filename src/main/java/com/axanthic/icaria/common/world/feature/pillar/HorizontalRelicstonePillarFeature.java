package com.axanthic.icaria.common.world.feature.pillar;

import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.data.provider.tags.IcariaBlockTagsProvider;

import com.mojang.serialization.Codec;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class HorizontalRelicstonePillarFeature extends Feature<NoneFeatureConfiguration> {
	public HorizontalRelicstonePillarFeature(Codec<NoneFeatureConfiguration> pCodec) {
		super(pCodec);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pFeaturePlaceContext) {
		var level = pFeaturePlaceContext.level();
		var origin = pFeaturePlaceContext.origin();
		var random = pFeaturePlaceContext.random();

		var direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);

		var length = random.nextIntBetweenInclusive(2, 4);
		var offset = 0;

		this.placeHead(level, origin, direction);

		for (var i = 1; i <= length; ++i) {
			++offset;
			this.placePillar(level, origin.relative(direction, offset), direction);
		}

		++offset;
		this.placeHead(level, origin.relative(direction, offset), direction.getOpposite());

		return true;
	}

	public void placeHead(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction pDirection, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeHead(pWorldGenLevel, pBlockPos, pDirection);
		}
	}

	public void placeHead(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction pDirection) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && pWorldGenLevel.getBlockState(pBlockPos.below()).is(IcariaBlockTagsProvider.SOILS)) {
			this.setBlock(pWorldGenLevel, pBlockPos, IcariaBlocks.RELICSTONE_PILLAR_HEAD.get().defaultBlockState().setValue(BlockStateProperties.FACING, pDirection));
		}
	}

	public void placePillar(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction pDirection, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placePillar(pWorldGenLevel, pBlockPos, pDirection);
		}
	}

	public void placePillar(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction pDirection) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && pWorldGenLevel.getBlockState(pBlockPos.below()).is(IcariaBlockTagsProvider.SOILS)) {
			this.setBlock(pWorldGenLevel, pBlockPos, IcariaBlocks.RELICSTONE_PILLAR.get().defaultBlockState().setValue(BlockStateProperties.AXIS, pDirection.getAxis()));
		}
	}
}
