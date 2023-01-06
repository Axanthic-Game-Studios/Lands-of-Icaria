package com.axanthic.icaria.common.block;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
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
		this.registerDefaultState(this.stateDefinition.any().setValue(NORTH, Boolean.FALSE).setValue(EAST, Boolean.FALSE).setValue(SOUTH, Boolean.FALSE).setValue(WEST, Boolean.FALSE).setValue(UP, Boolean.FALSE).setValue(DOWN, Boolean.FALSE));
	}

	public boolean canSpread(BlockGetter pLevel, BlockPos pPos) {
		Iterable<BlockPos> iterable = BlockPos.betweenClosed(pPos.getX() - 2, pPos.getY() - 8, pPos.getZ() - 2, pPos.getX() + 2, pPos.getY() + 8, pPos.getZ() + 2);
		int j = 8;
		for (BlockPos pos : iterable) {
			if (pLevel.getBlockState(pos).is(this)) {
				--j;
				if (j <= 0) {
					return false;
				}
			}
		}

		return true;
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
		pEntity.hurt(DamageSource.CACTUS, 1.0F);
	}

	@Override
	public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
		if (this.canSpread(pLevel, pPos)) {
			if (pLevel.isAreaLoaded(pPos, 4)) {
				if (pRandom.nextInt(4) == 0) {
					if (pLevel.getBlockState(pPos.above()).isAir()) {
						pLevel.setBlock(pPos.above(), this.defaultBlockState().setValue(DOWN, pState.getValue(DOWN)).setValue(UP, pState.getValue(UP)).setValue(NORTH, pState.getValue(NORTH)).setValue(EAST, pState.getValue(EAST)).setValue(SOUTH, pState.getValue(SOUTH)).setValue(WEST, pState.getValue(WEST)), 2);
					}
				}

				if (!pLevel.getBlockState(pPos.above(2)).equals(this.defaultBlockState().setValue(DOWN, pState.getValue(DOWN)).setValue(UP, pState.getValue(UP)).setValue(NORTH, pState.getValue(NORTH)).setValue(EAST, pState.getValue(EAST)).setValue(SOUTH, pState.getValue(SOUTH)).setValue(WEST, pState.getValue(WEST)))) {
					if (!pLevel.getBlockState(pPos.below(2)).equals(this.defaultBlockState().setValue(DOWN, pState.getValue(DOWN)).setValue(UP, pState.getValue(UP)).setValue(NORTH, pState.getValue(NORTH)).setValue(EAST, pState.getValue(EAST)).setValue(SOUTH, pState.getValue(SOUTH)).setValue(WEST, pState.getValue(WEST)))) {
						if (pLevel.getBlockState(pPos.above()).equals(this.defaultBlockState().setValue(DOWN, pState.getValue(DOWN)).setValue(UP, pState.getValue(UP)).setValue(NORTH, pState.getValue(NORTH)).setValue(EAST, pState.getValue(EAST)).setValue(SOUTH, pState.getValue(SOUTH)).setValue(WEST, pState.getValue(WEST)))) {
							if (pLevel.getBlockState(pPos.below()).equals(this.defaultBlockState().setValue(DOWN, pState.getValue(DOWN)).setValue(UP, pState.getValue(UP)).setValue(NORTH, pState.getValue(NORTH)).setValue(EAST, pState.getValue(EAST)).setValue(SOUTH, pState.getValue(SOUTH)).setValue(WEST, pState.getValue(WEST)))) {
								if (pRandom.nextInt(4) == 0) {
									if (pLevel.getBlockState(pPos.north()).isAir()) {
										if (pLevel.getBlockState(pPos.north().above()).isAir()) {
											pLevel.setBlock(pPos.north(), this.defaultBlockState().setValue(DOWN, pState.getValue(DOWN)).setValue(UP, pState.getValue(UP)).setValue(NORTH, pState.getValue(NORTH)).setValue(EAST, pState.getValue(EAST)).setValue(SOUTH, pState.getValue(SOUTH)).setValue(WEST, pState.getValue(WEST)), 2);
											pLevel.setBlock(pPos.north().above(), this.defaultBlockState().setValue(DOWN, pState.getValue(DOWN)).setValue(UP, pState.getValue(UP)).setValue(NORTH, pState.getValue(NORTH)).setValue(EAST, pState.getValue(EAST)).setValue(SOUTH, pState.getValue(SOUTH)).setValue(WEST, pState.getValue(WEST)), 2);
										}
									}
								}

								if (pRandom.nextInt(4) == 0) {
									if (pLevel.getBlockState(pPos.east()).isAir()) {
										if (pLevel.getBlockState(pPos.east().above()).isAir()) {
											pLevel.setBlock(pPos.east(), this.defaultBlockState().setValue(DOWN, pState.getValue(DOWN)).setValue(UP, pState.getValue(UP)).setValue(NORTH, pState.getValue(NORTH)).setValue(EAST, pState.getValue(EAST)).setValue(SOUTH, pState.getValue(SOUTH)).setValue(WEST, pState.getValue(WEST)), 2);
											pLevel.setBlock(pPos.east().above(), this.defaultBlockState().setValue(DOWN, pState.getValue(DOWN)).setValue(UP, pState.getValue(UP)).setValue(NORTH, pState.getValue(NORTH)).setValue(EAST, pState.getValue(EAST)).setValue(SOUTH, pState.getValue(SOUTH)).setValue(WEST, pState.getValue(WEST)), 2);
										}
									}
								}

								if (pRandom.nextInt(4) == 0) {
									if (pLevel.getBlockState(pPos.south()).isAir()) {
										if (pLevel.getBlockState(pPos.south().above()).isAir()) {
											pLevel.setBlock(pPos.south(), this.defaultBlockState().setValue(DOWN, pState.getValue(DOWN)).setValue(UP, pState.getValue(UP)).setValue(NORTH, pState.getValue(NORTH)).setValue(EAST, pState.getValue(EAST)).setValue(SOUTH, pState.getValue(SOUTH)).setValue(WEST, pState.getValue(WEST)), 2);
											pLevel.setBlock(pPos.south().above(), this.defaultBlockState().setValue(DOWN, pState.getValue(DOWN)).setValue(UP, pState.getValue(UP)).setValue(NORTH, pState.getValue(NORTH)).setValue(EAST, pState.getValue(EAST)).setValue(SOUTH, pState.getValue(SOUTH)).setValue(WEST, pState.getValue(WEST)), 2);
										}
									}
								}

								if (pRandom.nextInt(4) == 0) {
									if (pLevel.getBlockState(pPos.west()).isAir()) {
										if (pLevel.getBlockState(pPos.west().above()).isAir()) {
											pLevel.setBlock(pPos.west(), this.defaultBlockState().setValue(DOWN, pState.getValue(DOWN)).setValue(UP, pState.getValue(UP)).setValue(NORTH, pState.getValue(NORTH)).setValue(EAST, pState.getValue(EAST)).setValue(SOUTH, pState.getValue(SOUTH)).setValue(WEST, pState.getValue(WEST)), 2);
											pLevel.setBlock(pPos.west().above(), this.defaultBlockState().setValue(DOWN, pState.getValue(DOWN)).setValue(UP, pState.getValue(UP)).setValue(NORTH, pState.getValue(NORTH)).setValue(EAST, pState.getValue(EAST)).setValue(SOUTH, pState.getValue(SOUTH)).setValue(WEST, pState.getValue(WEST)), 2);
										}
									}
								}
							}
						}
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
		return BlockPathTypes.DAMAGE_CACTUS;
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
