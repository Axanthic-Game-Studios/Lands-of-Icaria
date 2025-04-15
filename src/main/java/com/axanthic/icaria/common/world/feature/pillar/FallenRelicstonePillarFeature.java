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

public class FallenRelicstonePillarFeature extends Feature<NoneFeatureConfiguration> {
	public FallenRelicstonePillarFeature(Codec<NoneFeatureConfiguration> pCodec) {
		super(pCodec);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pFeaturePlaceContext) {
		var level = pFeaturePlaceContext.level();
		var origin = pFeaturePlaceContext.origin();
		var random = pFeaturePlaceContext.random();

		var direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);

		var length = random.nextIntBetweenInclusive(1, 3);
		var offset = 2;

		this.placeHead(level, origin, Direction.UP);

		this.placePillar(level, origin.above(), Direction.UP);

		this.placeRubble(level, origin.relative(direction), 4);
		this.placeRubble(level, origin.relative(direction).relative(direction.getClockWise()), 4);
		this.placeRubble(level, origin.relative(direction).relative(direction.getCounterClockWise()), 4);
		this.placeRubble(level, origin.relative(direction, 2), 4);
		this.placeRubble(level, origin.relative(direction, 2).relative(direction.getClockWise()), 4);
		this.placeRubble(level, origin.relative(direction, 2).relative(direction.getCounterClockWise()), 4);

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
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && (pWorldGenLevel.getBlockState(pBlockPos.below()).is(IcariaBlockTagsProvider.SOILS) || pWorldGenLevel.getBlockState(pBlockPos.below()).is(IcariaBlocks.RELICSTONE_PILLAR_HEAD.get()))) {
			this.setBlock(pWorldGenLevel, pBlockPos, IcariaBlocks.RELICSTONE_PILLAR.get().defaultBlockState().setValue(BlockStateProperties.AXIS, pDirection.getAxis()));
		}
	}

	public void placeRubble(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeRubble(pWorldGenLevel, pBlockPos);
		}
	}

	public void placeRubble(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && pWorldGenLevel.getBlockState(pBlockPos.below()).is(IcariaBlockTagsProvider.SOILS)) {
			this.setBlock(pWorldGenLevel, pBlockPos, IcariaBlocks.RELICSTONE_RUBBLE.get().defaultBlockState());
		}
	}
}
