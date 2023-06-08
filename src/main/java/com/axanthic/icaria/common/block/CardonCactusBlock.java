package com.axanthic.icaria.common.block;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.pathfinder.BlockPathTypes;

import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CardonCactusBlock extends PipeBlock implements IPlantable {
	public static final BooleanProperty NORTH = PipeBlock.NORTH;
	public static final BooleanProperty EAST = PipeBlock.EAST;
	public static final BooleanProperty SOUTH = PipeBlock.SOUTH;
	public static final BooleanProperty WEST = PipeBlock.WEST;
	public static final BooleanProperty UP = PipeBlock.UP;
	public static final BooleanProperty DOWN = PipeBlock.DOWN;

	public CardonCactusBlock(Properties pProperties) {
		super(0.3125F, pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(NORTH, false).setValue(EAST, false).setValue(SOUTH, false).setValue(WEST, false).setValue(UP, false).setValue(DOWN, false));
	}

	@Override
	public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
		BlockState blockState = pLevel.getBlockState(pPos.below());
		for (Direction direction : Direction.Plane.HORIZONTAL) {
			BlockPos blockPos = pPos.relative(direction);
			BlockState stateRelative = pLevel.getBlockState(blockPos);
			if (stateRelative.is(this)) {
				BlockState stateBelow = pLevel.getBlockState(blockPos.below());
				if (stateBelow.is(this) || stateBelow.is(BlockTags.SAND)) {
					return true;
				}
			}
		}

		return blockState.is(this) || blockState.is(BlockTags.SAND);
	}

	public boolean shouldConnectDown(BlockState pState) {
		return pState.getBlock().equals(this) || pState.is(BlockTags.SAND);
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(NORTH, EAST, SOUTH, WEST, UP, DOWN);
	}

	@Override
	public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
		pEntity.hurt(pLevel.damageSources().cactus(), 1.0F);
	}

	@Override
	public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
		var direction = Direction.Plane.HORIZONTAL.getRandomDirection(pRandom);
		if (pLevel.isAreaLoaded(pPos, 1)) {
			if (pRandom.nextInt(4) == 0) {
				if (pLevel.getBlockState(pPos.above()).isAir()) {
					if (!pLevel.getBlockState(pPos.below(4)).is(this) && !pLevel.getBlockState(pPos.north()).is(this) && !pLevel.getBlockState(pPos.east()).is(this) && !pLevel.getBlockState(pPos.south()).is(this) && !pLevel.getBlockState(pPos.west()).is(this)) {
						pLevel.setBlock(pPos.above(), this.defaultBlockState().setValue(NORTH, pState.getValue(NORTH)).setValue(EAST, pState.getValue(EAST)).setValue(SOUTH, pState.getValue(SOUTH)).setValue(WEST, pState.getValue(WEST)).setValue(UP, pState.getValue(UP)).setValue(DOWN, pState.getValue(DOWN)), 2);
					}
				}

				if (pLevel.getBlockState(pPos.relative(direction)).isAir() && pLevel.getBlockState(pPos.above().relative(direction)).isAir()) {
					if (pLevel.getBlockState(pPos.above(2)).is(this) && pLevel.getBlockState(pPos.below()).is(this)) {
						pLevel.setBlock(pPos.relative(direction), this.defaultBlockState().setValue(NORTH, pState.getValue(NORTH)).setValue(EAST, pState.getValue(EAST)).setValue(SOUTH, pState.getValue(SOUTH)).setValue(WEST, pState.getValue(WEST)).setValue(UP, pState.getValue(UP)).setValue(DOWN, pState.getValue(DOWN)), 2);
						pLevel.setBlock(pPos.above().relative(direction), this.defaultBlockState().setValue(NORTH, pState.getValue(NORTH)).setValue(EAST, pState.getValue(EAST)).setValue(SOUTH, pState.getValue(SOUTH)).setValue(WEST, pState.getValue(WEST)).setValue(UP, pState.getValue(UP)).setValue(DOWN, pState.getValue(DOWN)), 2);
					}
				}
			}
		}
	}

	@Override
	public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
		if (!pState.canSurvive(pLevel, pPos)) {
			pLevel.destroyBlock(pPos, true);
		}
	}

	@Override
	public BlockPathTypes getBlockPathType(BlockState pState, BlockGetter pLevel, BlockPos pPos, @Nullable Mob pMob) {
		return BlockPathTypes.DAMAGE_OTHER;
	}

	@Override
	public BlockState getPlant(BlockGetter pLevel, BlockPos pPos) {
		return pLevel.getBlockState(pPos);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		return this.getStateForPlacement(pContext.getLevel(), pContext.getClickedPos());
	}

	public BlockState getStateForPlacement(BlockGetter pLevel, BlockPos pPos) {
		BlockState stateBelow = pLevel.getBlockState(pPos.below());
		BlockState stateAbove = pLevel.getBlockState(pPos.above());
		return this.defaultBlockState().setValue(DOWN, stateBelow.is(this) || stateBelow.is(BlockTags.SAND)).setValue(UP, stateAbove.is(this));
	}

	@Override
	public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
		if (!pState.canSurvive(pLevel, pCurrentPos)) {
			pLevel.scheduleTick(pCurrentPos, this, 1);
			return super.updateShape(pState, pDirection, pNeighborState, pLevel, pCurrentPos, pNeighborPos);
		}

		BlockState blockState = pLevel.getBlockState(pCurrentPos.below());
		boolean north = pLevel.getBlockState(pCurrentPos.north()).getBlock().equals(this);
		boolean east = pLevel.getBlockState(pCurrentPos.east()).getBlock().equals(this);
		boolean south = pLevel.getBlockState(pCurrentPos.south()).getBlock().equals(this);
		boolean west = pLevel.getBlockState(pCurrentPos.west()).getBlock().equals(this);
		boolean up = pLevel.getBlockState(pCurrentPos.above()).getBlock().equals(this);
		boolean down = this.shouldConnectDown(blockState);
		if (down) {
			north = north && !this.shouldConnectDown(pLevel.getBlockState(pCurrentPos.north().below()));
			east = east && !this.shouldConnectDown(pLevel.getBlockState(pCurrentPos.east().below()));
			south = south && !this.shouldConnectDown(pLevel.getBlockState(pCurrentPos.south().below()));
			west = west && !this.shouldConnectDown(pLevel.getBlockState(pCurrentPos.west().below()));
		}

		return pState.setValue(NORTH, north).setValue(EAST, east).setValue(SOUTH, south).setValue(WEST, west).setValue(UP, up).setValue(DOWN, down);
	}

	@Override
	public PlantType getPlantType(BlockGetter pLevel, BlockPos pPos) {
		return PlantType.DESERT;
	}
}
