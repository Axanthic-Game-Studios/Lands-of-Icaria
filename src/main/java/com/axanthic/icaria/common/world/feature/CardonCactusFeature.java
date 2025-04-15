package com.axanthic.icaria.common.world.feature;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CardonCactusFeature extends Feature<NoneFeatureConfiguration> {
	public CardonCactusFeature(Codec<NoneFeatureConfiguration> pCodec) {
		super(pCodec);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pFeaturePlaceContext) {
		var level = pFeaturePlaceContext.level();
		var origin = pFeaturePlaceContext.origin();
		var random = pFeaturePlaceContext.random();

		var direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);

		this.placeArm(level, origin, direction, 1, 2);
		this.placeArm(level, origin, direction.getClockWise(), 1, 2);
		this.placeArm(level, origin, direction.getOpposite(), 1, 2);
		this.placeArm(level, origin, direction.getCounterClockWise(), 1, 2);

		this.placeArm(level, origin, direction, 2, 8);
		this.placeArm(level, origin, direction.getClockWise(), 2, 8);
		this.placeArm(level, origin, direction.getOpposite(), 2, 8);
		this.placeArm(level, origin, direction.getCounterClockWise(), 2, 8);

		this.placeTrunk(level, origin, 0);
		this.placeTrunk(level, origin, 1);
		this.placeTrunk(level, origin, 2);
		this.placeTrunk(level, origin, 3);

		this.placeCactus(level, origin.above(4), IcariaBlocks.CARDON_CACTUS.get().defaultBlockState().setValue(BlockStateProperties.DOWN, true));

		return true;
	}

	public void placeArm(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction pDirection, int pOffset, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeArm(pWorldGenLevel, pBlockPos, pDirection, pOffset);
		}
	}

	public void placeArm(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction pDirection, int pOffset) {
		var posOx = pBlockPos.above(pOffset).relative(pDirection);
		var posOy = pBlockPos.above(pOffset + 1).relative(pDirection);
		var check = pWorldGenLevel.getBlockState(posOx.below()).is(BlockTags.SAND);

		if (pWorldGenLevel.getBlockState(posOx).isAir() && pWorldGenLevel.getBlockState(posOy).isAir()) {
			this.placeCactus(pWorldGenLevel, posOx, IcariaBlocks.CARDON_CACTUS.get().defaultBlockState().setValue(BlockStateProperties.UP, true).setValue(BlockStateProperties.DOWN, check).setValue(BlockStateProperties.NORTH, pDirection == Direction.SOUTH && !check).setValue(BlockStateProperties.EAST, pDirection == Direction.WEST && !check).setValue(BlockStateProperties.SOUTH, pDirection == Direction.NORTH && !check).setValue(BlockStateProperties.WEST, pDirection == Direction.EAST && !check));
			this.placeCactus(pWorldGenLevel, posOy, IcariaBlocks.CARDON_CACTUS.get().defaultBlockState().setValue(BlockStateProperties.DOWN, true));
		}
	}

	public void placeTrunk(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, int pOffset, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeTrunk(pWorldGenLevel, pBlockPos, pOffset);
		}
	}

	public void placeTrunk(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, int pOffset) {
		var north = !pWorldGenLevel.getBlockState(pBlockPos.above(pOffset).below()).is(BlockTags.SAND) && !pWorldGenLevel.getBlockState(pBlockPos.above(pOffset).below()).is(IcariaBlocks.CARDON_CACTUS.get()) && pWorldGenLevel.getBlockState(pBlockPos.above(pOffset).north()).is(IcariaBlocks.CARDON_CACTUS.get());
		var belowNorth = !pWorldGenLevel.getBlockState(pBlockPos.above(pOffset).below().north()).is(BlockTags.SAND) && !pWorldGenLevel.getBlockState(pBlockPos.above(pOffset).below().north()).is(IcariaBlocks.CARDON_CACTUS.get()) && pWorldGenLevel.getBlockState(pBlockPos.above(pOffset).north()).is(IcariaBlocks.CARDON_CACTUS.get());
		var east = !pWorldGenLevel.getBlockState(pBlockPos.above(pOffset).below()).is(BlockTags.SAND) && !pWorldGenLevel.getBlockState(pBlockPos.above(pOffset).below()).is(IcariaBlocks.CARDON_CACTUS.get()) && pWorldGenLevel.getBlockState(pBlockPos.above(pOffset).east()).is(IcariaBlocks.CARDON_CACTUS.get());
		var belowEast = !pWorldGenLevel.getBlockState(pBlockPos.above(pOffset).below().east()).is(BlockTags.SAND) && !pWorldGenLevel.getBlockState(pBlockPos.above(pOffset).below().east()).is(IcariaBlocks.CARDON_CACTUS.get()) && pWorldGenLevel.getBlockState(pBlockPos.above(pOffset).east()).is(IcariaBlocks.CARDON_CACTUS.get());
		var south = !pWorldGenLevel.getBlockState(pBlockPos.above(pOffset).below().south()).is(BlockTags.SAND) && !pWorldGenLevel.getBlockState(pBlockPos.above(pOffset).below().south()).is(IcariaBlocks.CARDON_CACTUS.get()) && pWorldGenLevel.getBlockState(pBlockPos.above(pOffset).south()).is(IcariaBlocks.CARDON_CACTUS.get());
		var belowSouth = !pWorldGenLevel.getBlockState(pBlockPos.above(pOffset).below()).is(BlockTags.SAND) && !pWorldGenLevel.getBlockState(pBlockPos.above(pOffset).below()).is(IcariaBlocks.CARDON_CACTUS.get()) && pWorldGenLevel.getBlockState(pBlockPos.above(pOffset).south()).is(IcariaBlocks.CARDON_CACTUS.get());
		var west = !pWorldGenLevel.getBlockState(pBlockPos.above(pOffset).below().west()).is(BlockTags.SAND) && !pWorldGenLevel.getBlockState(pBlockPos.above(pOffset).below().west()).is(IcariaBlocks.CARDON_CACTUS.get()) && pWorldGenLevel.getBlockState(pBlockPos.above(pOffset).west()).is(IcariaBlocks.CARDON_CACTUS.get());
		var belowWest = !pWorldGenLevel.getBlockState(pBlockPos.above(pOffset).below()).is(BlockTags.SAND) && !pWorldGenLevel.getBlockState(pBlockPos.above(pOffset).below()).is(IcariaBlocks.CARDON_CACTUS.get()) && pWorldGenLevel.getBlockState(pBlockPos.above(pOffset).west()).is(IcariaBlocks.CARDON_CACTUS.get());

		this.placeCactus(pWorldGenLevel, pBlockPos.above(pOffset), IcariaBlocks.CARDON_CACTUS.get().defaultBlockState().setValue(BlockStateProperties.UP, true).setValue(BlockStateProperties.DOWN, true).setValue(BlockStateProperties.NORTH, north || belowNorth).setValue(BlockStateProperties.EAST, east || belowEast).setValue(BlockStateProperties.SOUTH, south || belowSouth).setValue(BlockStateProperties.WEST, west || belowWest));
	}

	public void placeCactus(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, BlockState pState, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeCactus(pWorldGenLevel, pBlockPos, pState);
		}
	}

	public void placeCactus(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, BlockState pState) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir()) {
			this.setBlock(pWorldGenLevel, pBlockPos, pState);
		}
	}
}
