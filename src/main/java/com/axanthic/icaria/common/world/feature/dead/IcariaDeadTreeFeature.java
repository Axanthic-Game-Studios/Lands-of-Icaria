package com.axanthic.icaria.common.world.feature.dead;

import com.axanthic.icaria.common.properties.Moss;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaBlocks;

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

public class IcariaDeadTreeFeature extends Feature<NoneFeatureConfiguration> {
	public Block dead;
	public Block log;
	public Block moss;
	public Block shrooms;
	public Block twigs;

	public Moss property;

	public IcariaDeadTreeFeature(Codec<NoneFeatureConfiguration> pCodec, Block pDead, Block pLog, Block pMoss, Block pShrooms, Block pTwigs, Moss pProperty) {
		super(pCodec);
		this.dead = pDead;
		this.log = pLog;
		this.moss = pMoss;
		this.shrooms = pShrooms;
		this.twigs = pTwigs;
		this.property = pProperty;
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pFeaturePlaceContext) {
		var level = pFeaturePlaceContext.level();
		var origin = pFeaturePlaceContext.origin();
		var random = pFeaturePlaceContext.random();

		var direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);

		var length = random.nextIntBetweenInclusive(2, 4);
		var offset = 2;

		this.placeMoss(level, origin.relative(direction, -2), 1, 4);
		this.placeMoss(level, origin.relative(direction, -2).relative(direction.getClockWise(), 1), 1, 4);
		this.placeMoss(level, origin.relative(direction, -2).relative(direction.getClockWise(), 2), 1, 4);
		this.placeMoss(level, origin.relative(direction, -2).relative(direction.getCounterClockWise(), 1), 1, 4);
		this.placeMoss(level, origin.relative(direction, -2).relative(direction.getCounterClockWise(), 2), 1, 4);
		this.placeMoss(level, origin.relative(direction, -1), 2, 4);
		this.placeMoss(level, origin.relative(direction, -1).relative(direction.getClockWise(), 1), 2, 4);
		this.placeMoss(level, origin.relative(direction, -1).relative(direction.getClockWise(), 2), 1, 4);
		this.placeMoss(level, origin.relative(direction, -1).relative(direction.getCounterClockWise(), 1), 2, 4);
		this.placeMoss(level, origin.relative(direction, -1).relative(direction.getCounterClockWise(), 2), 1, 4);

		this.placeLog(level, origin, Direction.Axis.Y);

		this.placeDead(level, origin.above(), Direction.Axis.Y);

		this.placeMoss(level, origin.relative(direction.getClockWise(), 1), 2, 4);
		this.placeMoss(level, origin.relative(direction.getClockWise(), 2), 1, 4);
		this.placeMoss(level, origin.relative(direction.getCounterClockWise(), 1), 2, 4);
		this.placeMoss(level, origin.relative(direction.getCounterClockWise(), 2), 1, 4);

		this.placeMoss(level, origin.relative(direction, 1), 2, 4);
		this.placeMoss(level, origin.relative(direction, 1).relative(direction.getClockWise(), 1), 2, 4);
		this.placeMoss(level, origin.relative(direction, 1).relative(direction.getClockWise(), 2), 1, 4);
		this.placeMoss(level, origin.relative(direction, 1).relative(direction.getCounterClockWise(), 1), 2, 4);
		this.placeMoss(level, origin.relative(direction, 1).relative(direction.getCounterClockWise(), 2), 1, 4);
		this.placeMoss(level, origin.relative(direction, 2), 2, 4);
		this.placeMoss(level, origin.relative(direction, 2).relative(direction.getClockWise(), 1), 2, 4);
		this.placeMoss(level, origin.relative(direction, 2).relative(direction.getClockWise(), 2), 1, 4);
		this.placeMoss(level, origin.relative(direction, 2).relative(direction.getCounterClockWise(), 1), 2, 4);
		this.placeMoss(level, origin.relative(direction, 2).relative(direction.getCounterClockWise(), 2), 1, 4);

		this.placeTwigs(level, origin.relative(direction, 1), 4);
		this.placeTwigs(level, origin.relative(direction, 1).relative(direction.getClockWise()), 4);
		this.placeTwigs(level, origin.relative(direction, 1).relative(direction.getCounterClockWise()), 4);
		this.placeTwigs(level, origin.relative(direction, 2), 4);
		this.placeTwigs(level, origin.relative(direction, 2).relative(direction.getClockWise()), 4);
		this.placeTwigs(level, origin.relative(direction, 2).relative(direction.getCounterClockWise()), 4);

		for (var i = 1; i <= length; ++i) {
			++offset;
			this.placeDead(level, origin.relative(direction, offset), direction.getAxis());
			this.placeMoss(level, origin.relative(direction, offset).relative(direction.getClockWise(), 1), 2, 4);
			this.placeMoss(level, origin.relative(direction, offset).relative(direction.getClockWise(), 2), 1, 4);
			this.placeMoss(level, origin.relative(direction, offset).relative(direction.getCounterClockWise(), 1), 2, 4);
			this.placeMoss(level, origin.relative(direction, offset).relative(direction.getCounterClockWise(), 2), 1, 4);
			this.placeShrooms(level, origin.relative(direction, offset).relative(direction.getClockWise(), 1), direction.getClockWise(), 4);
			this.placeShrooms(level, origin.relative(direction, offset).relative(direction.getCounterClockWise(), 1), direction.getCounterClockWise(), 4);
		}

		this.placeMoss(level, origin.relative(direction, 3 + length), 2, 4);
		this.placeMoss(level, origin.relative(direction, 3 + length).relative(direction.getClockWise(), 1), 2, 4);
		this.placeMoss(level, origin.relative(direction, 3 + length).relative(direction.getClockWise(), 2), 1, 4);
		this.placeMoss(level, origin.relative(direction, 3 + length).relative(direction.getCounterClockWise(), 1), 2, 4);
		this.placeMoss(level, origin.relative(direction, 3 + length).relative(direction.getCounterClockWise(), 2), 1, 4);
		this.placeMoss(level, origin.relative(direction, 4 + length), 1, 4);
		this.placeMoss(level, origin.relative(direction, 4 + length).relative(direction.getClockWise(), 1), 1, 4);
		this.placeMoss(level, origin.relative(direction, 4 + length).relative(direction.getClockWise(), 2), 1, 4);
		this.placeMoss(level, origin.relative(direction, 4 + length).relative(direction.getCounterClockWise(), 1), 1, 4);
		this.placeMoss(level, origin.relative(direction, 4 + length).relative(direction.getCounterClockWise(), 2), 1, 4);

		this.placeTwigs(level, origin.relative(direction, 3 + length), 4);
		this.placeTwigs(level, origin.relative(direction, 3 + length).relative(direction.getClockWise(), 1), 4);
		this.placeTwigs(level, origin.relative(direction, 3 + length).relative(direction.getClockWise(), 2), 4);
		this.placeTwigs(level, origin.relative(direction, 3 + length).relative(direction.getCounterClockWise(), 1), 4);
		this.placeTwigs(level, origin.relative(direction, 3 + length).relative(direction.getCounterClockWise(), 2), 4);
		this.placeTwigs(level, origin.relative(direction, 4 + length), 4);
		this.placeTwigs(level, origin.relative(direction, 4 + length).relative(direction.getClockWise(), 1), 4);
		this.placeTwigs(level, origin.relative(direction, 4 + length).relative(direction.getClockWise(), 2), 4);
		this.placeTwigs(level, origin.relative(direction, 4 + length).relative(direction.getCounterClockWise(), 1), 4);
		this.placeTwigs(level, origin.relative(direction, 4 + length).relative(direction.getCounterClockWise(), 2), 4);
		this.placeTwigs(level, origin.relative(direction, 5 + length), 4);
		this.placeTwigs(level, origin.relative(direction, 5 + length).relative(direction.getClockWise(), 1), 4);
		this.placeTwigs(level, origin.relative(direction, 5 + length).relative(direction.getClockWise(), 2), 4);
		this.placeTwigs(level, origin.relative(direction, 5 + length).relative(direction.getCounterClockWise(), 1), 4);
		this.placeTwigs(level, origin.relative(direction, 5 + length).relative(direction.getCounterClockWise(), 2), 4);
		this.placeTwigs(level, origin.relative(direction, 6 + length), 4);
		this.placeTwigs(level, origin.relative(direction, 6 + length).relative(direction.getClockWise(), 1), 4);
		this.placeTwigs(level, origin.relative(direction, 6 + length).relative(direction.getClockWise(), 2), 4);
		this.placeTwigs(level, origin.relative(direction, 6 + length).relative(direction.getCounterClockWise(), 1), 4);
		this.placeTwigs(level, origin.relative(direction, 6 + length).relative(direction.getCounterClockWise(), 2), 4);

		return true;
	}

	public void placeDead(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction.Axis pAxis, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeDead(pWorldGenLevel, pBlockPos, pAxis);
		}
	}

	public void placeDead(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction.Axis pAxis) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && (pWorldGenLevel.getBlockState(pBlockPos.below()).is(BlockTags.DIRT) || pWorldGenLevel.getBlockState(pBlockPos.below()).is(BlockTags.LOGS))) {
			this.setBlock(pWorldGenLevel, pBlockPos, this.dead.defaultBlockState().setValue(BlockStateProperties.AXIS, pAxis));
		}
	}

	public void placeLog(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction.Axis pAxis, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeLog(pWorldGenLevel, pBlockPos, pAxis);
		}
	}

	public void placeLog(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction.Axis pAxis) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && pWorldGenLevel.getBlockState(pBlockPos.below()).is(BlockTags.DIRT)) {
			this.setBlock(pWorldGenLevel, pBlockPos, this.log.defaultBlockState().setValue(BlockStateProperties.AXIS, pAxis));
		}
	}

	public void placeMoss(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, int pHeight, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeMoss(pWorldGenLevel, pBlockPos, pHeight);
		}
	}

	public void placeMoss(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, int pHeight) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && pWorldGenLevel.getBlockState(pBlockPos.below()).is(BlockTags.DIRT) && this.moss.defaultBlockState().hasProperty(BlockStateProperties.LAYERS)) {
			this.setBlock(pWorldGenLevel, pBlockPos, this.moss.defaultBlockState().setValue(BlockStateProperties.LAYERS, pHeight));
			if (pWorldGenLevel.getBlockState(pBlockPos.below()).is(IcariaBlocks.GRASSY_MARL.get())) {
				this.setBlock(pWorldGenLevel, pBlockPos.below(), IcariaBlocks.GRASSY_MARL.get().defaultBlockState().setValue(IcariaBlockStateProperties.MOSS, this.property));
			}
		}
	}

	public void placeShrooms(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction pDirection, int pChance) {
		if (pWorldGenLevel.getRandom().nextInt(pChance) == 0) {
			this.placeShrooms(pWorldGenLevel, pBlockPos, pDirection);
		}
	}

	public void placeShrooms(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos, Direction pDirection) {
		if (pWorldGenLevel.getBlockState(pBlockPos).isAir() && pWorldGenLevel.getBlockState(pBlockPos.relative(pDirection.getOpposite())).is(BlockTags.LOGS)) {
			this.setBlock(pWorldGenLevel, pBlockPos, shrooms.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, pDirection));
		}
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
