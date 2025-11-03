package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.helper.IcariaCommonHelper;

import com.mojang.serialization.MapCodec;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.pathfinder.PathType;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CardonCactusBlock extends PipeBlock {
	public static final MapCodec<CardonCactusBlock> CODEC = Block.simpleCodec(CardonCactusBlock::new);

	public CardonCactusBlock(Properties pProperties) {
		super(8.0F, pProperties);
		this.registerDefaultState(this.getStateDefinition().any().setValue(BlockStateProperties.NORTH, false).setValue(BlockStateProperties.EAST, false).setValue(BlockStateProperties.SOUTH, false).setValue(BlockStateProperties.WEST, false).setValue(BlockStateProperties.UP, false).setValue(BlockStateProperties.DOWN, false));
	}

	@Override
	public boolean canSurvive(BlockState pBlockState, LevelReader pLevelReader, BlockPos pBlockPos) {
		var blockState = pLevelReader.getBlockState(pBlockPos.below());
		for (var direction : Direction.Plane.HORIZONTAL) {
			var blockPos = pBlockPos.relative(direction);
			if (pLevelReader.getBlockState(blockPos).is(this)) {
				var blockStateBelow = pLevelReader.getBlockState(blockPos.below());
				if (blockStateBelow.is(BlockTags.SAND) || blockStateBelow.is(this)) {
					return true;
				}
			}
		}

		return blockState.is(BlockTags.SAND) || blockState.is(this);
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.NORTH, BlockStateProperties.EAST, BlockStateProperties.SOUTH, BlockStateProperties.WEST, BlockStateProperties.UP, BlockStateProperties.DOWN);
	}

	@Override
	public void entityInside(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Entity pEntity, InsideBlockEffectApplier pInsideBlockEffectApplier) {
		IcariaCommonHelper.hurt(pLevel.damageSources().cactus(), pEntity, 1.0F);
	}

	@Override
	public void randomTick(BlockState pBlockState, ServerLevel pServerLevel, BlockPos pBlockPos, RandomSource pRandomSource) {
		var direction = Direction.Plane.HORIZONTAL.getRandomDirection(pRandomSource);
		if (pServerLevel.isAreaLoaded(pBlockPos, 1)) {
			if (pRandomSource.nextInt(4) == 0) {
				this.randomTickStem(pBlockPos, pBlockState, pServerLevel);
				this.randomTickLimb(pBlockPos, pBlockState, direction, pServerLevel);
			}
		}
	}

	public void randomTickLimb(BlockPos pBlockPos, BlockState pBlockState, Direction pDirection, ServerLevel pServerLevel) {
		if (pServerLevel.getBlockState(pBlockPos.relative(pDirection)).isAir() && pServerLevel.getBlockState(pBlockPos.above().relative(pDirection)).isAir()) {
			if (pServerLevel.getBlockState(pBlockPos.above(2)).is(this) && pServerLevel.getBlockState(pBlockPos.below()).is(this)) {
				pServerLevel.setBlockAndUpdate(pBlockPos.above().relative(pDirection), this.defaultBlockState().setValue(BlockStateProperties.NORTH, pBlockState.getValue(BlockStateProperties.NORTH)).setValue(BlockStateProperties.EAST, pBlockState.getValue(BlockStateProperties.EAST)).setValue(BlockStateProperties.SOUTH, pBlockState.getValue(BlockStateProperties.SOUTH)).setValue(BlockStateProperties.WEST, pBlockState.getValue(BlockStateProperties.WEST)).setValue(BlockStateProperties.DOWN, pBlockState.getValue(BlockStateProperties.DOWN)));
				pServerLevel.setBlockAndUpdate(pBlockPos.relative(pDirection), this.defaultBlockState().setValue(BlockStateProperties.NORTH, pBlockState.getValue(BlockStateProperties.NORTH)).setValue(BlockStateProperties.EAST, pBlockState.getValue(BlockStateProperties.EAST)).setValue(BlockStateProperties.SOUTH, pBlockState.getValue(BlockStateProperties.SOUTH)).setValue(BlockStateProperties.WEST, pBlockState.getValue(BlockStateProperties.WEST)).setValue(BlockStateProperties.UP, pBlockState.getValue(BlockStateProperties.UP)).setValue(BlockStateProperties.DOWN, pBlockState.getValue(BlockStateProperties.DOWN)));
			}
		}
	}

	public void randomTickStem(BlockPos pBlockPos, BlockState pBlockState, ServerLevel pServerLevel) {
		if (pServerLevel.getBlockState(pBlockPos.above()).isAir()) {
			if (!pServerLevel.getBlockState(pBlockPos.below(4)).is(this) && !pServerLevel.getBlockState(pBlockPos.north()).is(this) && !pServerLevel.getBlockState(pBlockPos.east()).is(this) && !pServerLevel.getBlockState(pBlockPos.south()).is(this) && !pServerLevel.getBlockState(pBlockPos.west()).is(this)) {
				pServerLevel.setBlockAndUpdate(pBlockPos.above(), this.defaultBlockState().setValue(BlockStateProperties.NORTH, pBlockState.getValue(BlockStateProperties.NORTH)).setValue(BlockStateProperties.EAST, pBlockState.getValue(BlockStateProperties.EAST)).setValue(BlockStateProperties.SOUTH, pBlockState.getValue(BlockStateProperties.SOUTH)).setValue(BlockStateProperties.WEST, pBlockState.getValue(BlockStateProperties.WEST)).setValue(BlockStateProperties.DOWN, pBlockState.getValue(BlockStateProperties.DOWN)));
			}
		}
	}

	@Override
	public void tick(BlockState pBlockState, ServerLevel pServerLevel, BlockPos pBlockPos, RandomSource pRandomSource) {
		if (!pBlockState.canSurvive(pServerLevel, pBlockPos)) {
			pServerLevel.destroyBlock(pBlockPos, true);
		}
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pBlockPlaceContext) {
		var blockState = pBlockPlaceContext.getLevel().getBlockState(pBlockPlaceContext.getClickedPos().below());
		return this.defaultBlockState().setValue(BlockStateProperties.DOWN, blockState.is(BlockTags.SAND) || blockState.is(this));
	}

	@Override
	public BlockState updateShape(BlockState pBlockState, LevelReader pLevelReader, ScheduledTickAccess pScheduledTickAccess, BlockPos pBlockPos, Direction pDirection, BlockPos pBlockPosFaced, BlockState pBlockStateFaced, RandomSource pRandomSource) {
		pScheduledTickAccess.scheduleTick(pBlockPos, this, 0);

		var above = pLevelReader.getBlockState(pBlockPos.above()).is(this);
		var below = pLevelReader.getBlockState(pBlockPos.below()).is(BlockTags.SAND) || pLevelReader.getBlockState(pBlockPos.below()).is(this);
		var north = !pLevelReader.getBlockState(pBlockPos.below()).is(BlockTags.SAND) && !pLevelReader.getBlockState(pBlockPos.below()).is(this) && pLevelReader.getBlockState(pBlockPos.north()).is(this);
		var belowNorth = !pLevelReader.getBlockState(pBlockPos.below().north()).is(BlockTags.SAND) && !pLevelReader.getBlockState(pBlockPos.below().north()).is(this) && pLevelReader.getBlockState(pBlockPos.north()).is(this);
		var east = !pLevelReader.getBlockState(pBlockPos.below()).is(BlockTags.SAND) && !pLevelReader.getBlockState(pBlockPos.below()).is(this) && pLevelReader.getBlockState(pBlockPos.east()).is(this);
		var belowEast = !pLevelReader.getBlockState(pBlockPos.below().east()).is(BlockTags.SAND) && !pLevelReader.getBlockState(pBlockPos.below().east()).is(this) && pLevelReader.getBlockState(pBlockPos.east()).is(this);
		var south = !pLevelReader.getBlockState(pBlockPos.below().south()).is(BlockTags.SAND) && !pLevelReader.getBlockState(pBlockPos.below().south()).is(this) && pLevelReader.getBlockState(pBlockPos.south()).is(this);
		var belowSouth = !pLevelReader.getBlockState(pBlockPos.below()).is(BlockTags.SAND) && !pLevelReader.getBlockState(pBlockPos.below()).is(this) && pLevelReader.getBlockState(pBlockPos.south()).is(this);
		var west = !pLevelReader.getBlockState(pBlockPos.below().west()).is(BlockTags.SAND) && !pLevelReader.getBlockState(pBlockPos.below().west()).is(this) && pLevelReader.getBlockState(pBlockPos.west()).is(this);
		var belowWest = !pLevelReader.getBlockState(pBlockPos.below()).is(BlockTags.SAND) && !pLevelReader.getBlockState(pBlockPos.below()).is(this) && pLevelReader.getBlockState(pBlockPos.west()).is(this);

		return this.defaultBlockState().setValue(BlockStateProperties.UP, above).setValue(BlockStateProperties.DOWN, below).setValue(BlockStateProperties.NORTH, north || belowNorth).setValue(BlockStateProperties.EAST, east || belowEast).setValue(BlockStateProperties.SOUTH, south || belowSouth).setValue(BlockStateProperties.WEST, west || belowWest);
	}

	@Override
	public MapCodec<? extends PipeBlock> codec() {
		return CardonCactusBlock.CODEC;
	}

	@Override
	public PathType getBlockPathType(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, @Nullable Mob pMob) {
		return PathType.DAMAGE_OTHER;
	}
}
