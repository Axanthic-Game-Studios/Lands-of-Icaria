package com.axanthic.icaria.common.world.feature.tree.small;

import com.mojang.serialization.Codec;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.phys.AABB;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SmallIcariaTreeFeature extends Feature<NoneFeatureConfiguration> {
	public Block fallen;
	public Block leaves;
	public Block log;

	public SmallIcariaTreeFeature(Codec<NoneFeatureConfiguration> pCodec, Block pFallen, Block pLeaves, Block pLog) {
		super(pCodec);
		this.fallen = pFallen;
		this.leaves = pLeaves;
		this.log = pLog;
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pFeaturePlaceContext) {
		return true;
	}

	public void placeFallen(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, int pHeight, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeFallen(pWorldGenLevel, pBlockPos, pHeight);
		}
	}

	public void placeFallen(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, int pHeight) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir()) {
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
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir()) {
			this.setBlock(pWorldGenLevel, pBlockPos, this.log.defaultBlockState().setValue(BlockStateProperties.AXIS, pAxis));
		}
	}

	public AABB aabb(BlockPos pBlockPos) {
		return new AABB(
			pBlockPos.below().north().east().getX(),
			pBlockPos.below().north().east().getY(),
			pBlockPos.below().north().east().getZ(),
			pBlockPos.below().south().west().getX(),
			pBlockPos.below().south().west().getY(),
			pBlockPos.below().south().west().getZ()
		);
	}
}
