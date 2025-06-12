package com.axanthic.icaria.common.world.feature.tree.fallen;

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
import net.minecraft.world.phys.AABB;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FallenIcariaTreeFeature extends Feature<NoneFeatureConfiguration> {
	public Block dead;
	public Block leaves;
	public Block log;
	public Block shrooms;
	public Block twigs;

	public FallenIcariaTreeFeature(Codec<NoneFeatureConfiguration> pCodec, Block pDead, Block pLeaves, Block pLog, Block pShrooms, Block pTwigs) {
		super(pCodec);
		this.dead = pDead;
		this.leaves = pLeaves;
		this.log = pLog;
		this.shrooms = pShrooms;
		this.twigs = pTwigs;
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pFeaturePlaceContext) {
		return true;
	}

	public void placeDead(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction.Axis pAxis, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeDead(pWorldGenLevel, pBlockPos, pAxis);
		}
	}

	public void placeDead(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction.Axis pAxis) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() || pWorldGenLevel.getBlockState(pBlockPos).is(BlockTags.LEAVES)) {
			this.setBlock(pWorldGenLevel, pBlockPos, this.dead.defaultBlockState().setValue(BlockStateProperties.AXIS, pAxis));
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

	public AABB aabb(BlockPos pBlockPos, Direction pDirection, int pLength, int pOffset, int pWidth) {
		return new AABB(
			pBlockPos.below().relative(pDirection.getClockWise(), pWidth).relative(pDirection, pOffset).relative(pDirection).getX(),
			pBlockPos.below().relative(pDirection.getClockWise(), pWidth).relative(pDirection, pOffset).relative(pDirection).getY(),
			pBlockPos.below().relative(pDirection.getClockWise(), pWidth).relative(pDirection, pOffset).relative(pDirection).getZ(),
			pBlockPos.below().relative(pDirection.getCounterClockWise(), pWidth).relative(pDirection, pOffset).relative(pDirection, pLength).getX(),
			pBlockPos.below().relative(pDirection.getCounterClockWise(), pWidth).relative(pDirection, pOffset).relative(pDirection, pLength).getY(),
			pBlockPos.below().relative(pDirection.getCounterClockWise(), pWidth).relative(pDirection, pOffset).relative(pDirection, pLength).getZ()
		);
	}
}
