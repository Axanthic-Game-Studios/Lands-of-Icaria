package com.axanthic.icaria.common.world.feature.tree;

import com.mojang.serialization.Codec;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaTreeFeature extends Feature<NoneFeatureConfiguration> {
	public Block fallen;
	public Block leaves;
	public Block log;
	public Block shrooms;
	public Block twigs;

	public IcariaTreeFeature(Codec<NoneFeatureConfiguration> pCodec, Block pFallen, Block pLeaves, Block pLog, Block pShrooms, Block pTwigs) {
		super(pCodec);
		this.fallen = pFallen;
		this.leaves = pLeaves;
		this.log = pLog;
		this.shrooms = pShrooms;
		this.twigs = pTwigs;
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pFeaturePlaceContext) {
		return true;
	}

	public void placeFallenPatch(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, int pChance) {
		this.placeFallen(pWorldGenLevel, pBlockPos.north(1), 1, pChance);
		this.placeFallen(pWorldGenLevel, pBlockPos.north(1).east(1), 1, pChance);
		this.placeFallen(pWorldGenLevel, pBlockPos.north(2), 1, pChance);
		this.placeFallen(pWorldGenLevel, pBlockPos.north(2).east(1), 1, pChance);
		this.placeFallen(pWorldGenLevel, pBlockPos.north(2).west(1), 1, pChance);
		this.placeFallen(pWorldGenLevel, pBlockPos.east(1), 1, pChance);
		this.placeFallen(pWorldGenLevel, pBlockPos.east(1).south(1), 1, pChance);
		this.placeFallen(pWorldGenLevel, pBlockPos.east(2), 1, pChance);
		this.placeFallen(pWorldGenLevel, pBlockPos.east(2).north(1), 1, pChance);
		this.placeFallen(pWorldGenLevel, pBlockPos.east(2).south(1), 1, pChance);
		this.placeFallen(pWorldGenLevel, pBlockPos.south(1), 1, pChance);
		this.placeFallen(pWorldGenLevel, pBlockPos.south(1).west(1), 1, pChance);
		this.placeFallen(pWorldGenLevel, pBlockPos.south(2), 1, pChance);
		this.placeFallen(pWorldGenLevel, pBlockPos.south(2).east(1), 1, pChance);
		this.placeFallen(pWorldGenLevel, pBlockPos.south(2).west(1), 1, pChance);
		this.placeFallen(pWorldGenLevel, pBlockPos.west(1), 1, pChance);
		this.placeFallen(pWorldGenLevel, pBlockPos.west(1).north(1), 1, pChance);
		this.placeFallen(pWorldGenLevel, pBlockPos.west(2), 1, pChance);
		this.placeFallen(pWorldGenLevel, pBlockPos.west(2).north(1), 1, pChance);
		this.placeFallen(pWorldGenLevel, pBlockPos.west(2).south(1), 1, pChance);
	}

	public void placeFallen(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, int pHeight, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeFallen(pWorldGenLevel, pBlockPos, pHeight);
		}
	}

	public void placeFallen(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, int pHeight) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && pWorldGenLevel.getBlockState(pBlockPos.below()).is(BlockTags.DIRT)) {
			this.setBlock(pWorldGenLevel, pBlockPos, this.fallen.defaultBlockState().setValue(BlockStateProperties.LAYERS, pHeight));
		}
	}

	public void placeLeaves(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeLeaves(pWorldGenLevel, pBlockPos);
		}
	}

	public void placeLeaves(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir()) {
			this.setBlock(pWorldGenLevel, pBlockPos, this.leaves.defaultBlockState().setValue(BlockStateProperties.DISTANCE, 1));
		}
	}

	public void placeLog(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction.Axis pAxis, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeLog(pWorldGenLevel, pBlockPos, pAxis);
		}
	}

	public void placeLog(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction.Axis pAxis) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() || pWorldGenLevel.getBlockState(pBlockPos).is(BlockTags.LEAVES)) {
			this.setBlock(pWorldGenLevel, pBlockPos, this.log.defaultBlockState().setValue(BlockStateProperties.AXIS, pAxis));
		}
	}

	public void placeShroomsPatch(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, int pChance) {
		this.placeShrooms(pWorldGenLevel, pBlockPos.north().above(), Direction.NORTH, pChance);
		this.placeShrooms(pWorldGenLevel, pBlockPos.east().above(), Direction.EAST, pChance);
		this.placeShrooms(pWorldGenLevel, pBlockPos.south().above(), Direction.SOUTH, pChance);
		this.placeShrooms(pWorldGenLevel, pBlockPos.west().above(), Direction.WEST, pChance);
	}

	public void placeShrooms(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction pDirection, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeShrooms(pWorldGenLevel, pBlockPos, pDirection);
		}
	}

	public void placeShrooms(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction pDirection) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && pWorldGenLevel.getBlockState(pBlockPos.relative(pDirection.getOpposite())).is(BlockTags.LOGS)) {
			this.setBlock(pWorldGenLevel, pBlockPos, this.shrooms.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, pDirection));
		}
	}

	public void placeTwigsPatch(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, int pChance) {
		this.placeTwigs(pWorldGenLevel, pBlockPos.north(1), pChance);
		this.placeTwigs(pWorldGenLevel, pBlockPos.north(1).east(1), pChance);
		this.placeTwigs(pWorldGenLevel, pBlockPos.north(2), pChance);
		this.placeTwigs(pWorldGenLevel, pBlockPos.north(2).east(1), pChance);
		this.placeTwigs(pWorldGenLevel, pBlockPos.north(2).west(1), pChance);
		this.placeTwigs(pWorldGenLevel, pBlockPos.east(1), pChance);
		this.placeTwigs(pWorldGenLevel, pBlockPos.east(1).south(1), pChance);
		this.placeTwigs(pWorldGenLevel, pBlockPos.east(2), pChance);
		this.placeTwigs(pWorldGenLevel, pBlockPos.east(2).north(1), pChance);
		this.placeTwigs(pWorldGenLevel, pBlockPos.east(2).south(1), pChance);
		this.placeTwigs(pWorldGenLevel, pBlockPos.south(1), pChance);
		this.placeTwigs(pWorldGenLevel, pBlockPos.south(1).west(1), pChance);
		this.placeTwigs(pWorldGenLevel, pBlockPos.south(2), pChance);
		this.placeTwigs(pWorldGenLevel, pBlockPos.south(2).east(1), pChance);
		this.placeTwigs(pWorldGenLevel, pBlockPos.south(2).west(1), pChance);
		this.placeTwigs(pWorldGenLevel, pBlockPos.west(1), pChance);
		this.placeTwigs(pWorldGenLevel, pBlockPos.west(1).north(1), pChance);
		this.placeTwigs(pWorldGenLevel, pBlockPos.west(2), pChance);
		this.placeTwigs(pWorldGenLevel, pBlockPos.west(2).north(1), pChance);
		this.placeTwigs(pWorldGenLevel, pBlockPos.west(2).south(1), pChance);
	}

	public void placeTwigs(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeTwigs(pWorldGenLevel, pBlockPos);
		}
	}

	public void placeTwigs(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && pWorldGenLevel.getBlockState(pBlockPos.below()).is(BlockTags.DIRT)) {
			this.setBlock(pWorldGenLevel, pBlockPos, this.twigs.defaultBlockState());
		}
	}
}
