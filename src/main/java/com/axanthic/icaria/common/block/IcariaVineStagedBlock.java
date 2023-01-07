package com.axanthic.icaria.common.block;

import com.google.common.collect.ImmutableMap;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaVineStagedBlock extends Block {
	public static final BooleanProperty NORTH = PipeBlock.NORTH;
	public static final BooleanProperty EAST = PipeBlock.EAST;
	public static final BooleanProperty SOUTH = PipeBlock.SOUTH;
	public static final BooleanProperty WEST = PipeBlock.WEST;
	public static final BooleanProperty UP = PipeBlock.UP;

	public static final Map<Direction, BooleanProperty> PROPERTY_BY_DIRECTION = PipeBlock.PROPERTY_BY_DIRECTION.entrySet().stream().filter((entry) -> entry.getKey() != Direction.DOWN).collect(Util.toMap());

	public static final VoxelShape NORTH_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D);
	public static final VoxelShape EAST_AABB = Block.box(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	public static final VoxelShape SOUTH_AABB = Block.box(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D);
	public static final VoxelShape WEST_AABB = Block.box(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D);
	public static final VoxelShape UP_AABB = Block.box(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D);

	public Map<BlockState, VoxelShape> map;

	public Block growing;
	public Block vine;
	public Block dead;

	public IcariaVineStagedBlock(Properties pProperties, Block growing, Block vine, Block dead) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(NORTH, Boolean.FALSE).setValue(EAST, Boolean.FALSE).setValue(SOUTH, Boolean.FALSE).setValue(WEST, Boolean.FALSE).setValue(UP, Boolean.FALSE));
		this.map = ImmutableMap.copyOf(this.stateDefinition.getPossibleStates().stream().collect(Collectors.toMap(Function.identity(), IcariaVineStagedBlock::calculateShape)));
		this.growing = growing;
		this.vine = vine;
		this.dead = dead;
	}

	@Override
	public boolean canBeReplaced(BlockState pState, BlockPlaceContext pUseContext) {
		BlockState blockState = pUseContext.getLevel().getBlockState(pUseContext.getClickedPos());
		if (blockState.is(this)) {
			return this.countFaces(blockState) < PROPERTY_BY_DIRECTION.size();
		} else {
			return super.canBeReplaced(pState, pUseContext);
		}
	}

	public boolean canSpread(BlockGetter pLevel, BlockPos pPos) {
		Iterable<BlockPos> iterable = BlockPos.betweenClosed(pPos.getX() - 4, pPos.getY() - 1, pPos.getZ() - 4, pPos.getX() + 4, pPos.getY() + 1, pPos.getZ() + 4);
		int j = 5;
		for (BlockPos blockPos : iterable) {
			if (pLevel.getBlockState(blockPos).is(this)) {
				--j;
				if (j <= 0) {
					return false;
				}
			}
		}

		return true;
	}

	public boolean canSupportAtFace(BlockGetter pLevel, BlockPos pPos, Direction pDirection) {
		if (pDirection == Direction.DOWN) {
			return false;
		} else {
			BlockPos blockPos = pPos.relative(pDirection);
			if (this.isAcceptableNeighbour(pLevel, blockPos, pDirection)) {
				return true;
			} else if (pDirection.getAxis() == Direction.Axis.Y) {
				return false;
			} else {
				BlockState blockState = pLevel.getBlockState(pPos.above());
				return blockState.is(BlockTags.CLIMBABLE) && blockState.getValue(PROPERTY_BY_DIRECTION.get(pDirection));
			}
		}
	}

	@Override
	public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
		return this.hasFaces(this.getUpdatedState(pState, pLevel, pPos));
	}

	public boolean hasFaces(BlockState pState) {
		return this.countFaces(pState) > 0;
	}

	public boolean hasHorizontalConnection(BlockState pState) {
		return pState.getValue(NORTH) || pState.getValue(EAST) || pState.getValue(SOUTH) || pState.getValue(WEST);
	}

	public boolean isAcceptableNeighbour(BlockGetter pLevel, BlockPos pPos, Direction pDirection) {
		return Block.isFaceFull(pLevel.getBlockState(pPos).getCollisionShape(pLevel, pPos), pDirection.getOpposite());
	}

	@Override
	public boolean propagatesSkylightDown(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
		return true;
	}

	public int countFaces(BlockState pState) {
		int i = 0;
		for (BooleanProperty booleanProperty : PROPERTY_BY_DIRECTION.values()) {
			if (pState.getValue(booleanProperty)) {
				++i;
			}
		}

		return i;
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(NORTH, EAST, SOUTH, WEST, UP);
	}

	@Override
	public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
		if (pLevel.random.nextInt(4) == 0) {
			if (pLevel.isAreaLoaded(pPos, 4)) {
				BlockPos posAbove = pPos.above();
				Direction directionRandom = Direction.getRandom(pRandom);
				if (directionRandom.getAxis().isHorizontal() && !pState.getValue(this.getPropertyForFace(directionRandom))) {
					if (this.canSpread(pLevel, pPos)) {
						BlockPos posRelative = pPos.relative(directionRandom);
						BlockState stateRelative = pLevel.getBlockState(posRelative);
						if (stateRelative.isAir()) {
							Direction directionClockWise = directionRandom.getClockWise();
							Direction directionCounterClockWise = directionRandom.getCounterClockWise();
							BlockPos posClockWise = posRelative.relative(directionClockWise);
							BlockPos posCounterClockWise = posRelative.relative(directionCounterClockWise);
							boolean flagClockWise = pState.getValue(this.getPropertyForFace(directionClockWise));
							boolean flagCounterClockWise = pState.getValue(this.getPropertyForFace(directionCounterClockWise));
							if (flagClockWise && this.isAcceptableNeighbour(pLevel, posClockWise, directionClockWise)) {
								pLevel.setBlock(posRelative, this.defaultBlockState().setValue(this.getPropertyForFace(directionClockWise), Boolean.TRUE), 2);
							} else if (flagCounterClockWise && this.isAcceptableNeighbour(pLevel, posCounterClockWise, directionCounterClockWise)) {
								pLevel.setBlock(posRelative, this.defaultBlockState().setValue(this.getPropertyForFace(directionCounterClockWise), Boolean.TRUE), 2);
							} else {
								Direction directionOpposite = directionRandom.getOpposite();
								if (flagClockWise && pLevel.isEmptyBlock(posClockWise) && this.isAcceptableNeighbour(pLevel, pPos.relative(directionClockWise), directionOpposite)) {
									pLevel.setBlock(posClockWise, this.defaultBlockState().setValue(this.getPropertyForFace(directionOpposite), Boolean.TRUE), 2);
								} else if (flagCounterClockWise && pLevel.isEmptyBlock(posCounterClockWise) && this.isAcceptableNeighbour(pLevel, pPos.relative(directionCounterClockWise), directionOpposite)) {
									pLevel.setBlock(posCounterClockWise, this.defaultBlockState().setValue(this.getPropertyForFace(directionOpposite), Boolean.TRUE), 2);
								} else if (pRandom.nextFloat() < 0.05D && this.isAcceptableNeighbour(pLevel, posRelative.above(), Direction.UP)) {
									pLevel.setBlock(posRelative, this.defaultBlockState().setValue(UP, Boolean.TRUE), 2);
								}
							}
						} else if (this.isAcceptableNeighbour(pLevel, posRelative, directionRandom)) {
							pLevel.setBlock(pPos, pState.setValue(this.getPropertyForFace(directionRandom), Boolean.TRUE), 2);
						}
					}
				} else {
					if (directionRandom == Direction.UP) {
						if (pPos.getY() < pLevel.getMaxBuildHeight() - 1) {
							if (this.canSupportAtFace(pLevel, pPos, directionRandom)) {
								pLevel.setBlock(pPos, pState.setValue(UP, Boolean.TRUE), 2);
								return;
							}

							if (pLevel.isEmptyBlock(posAbove)) {
								BlockState blockState = pState;
								if (!this.canSpread(pLevel, pPos)) {
									return;
								}

								for (Direction direction : Direction.Plane.HORIZONTAL) {
									if (pRandom.nextBoolean() || !this.isAcceptableNeighbour(pLevel, posAbove.relative(direction), direction)) {
										blockState = blockState.setValue(this.getPropertyForFace(direction), Boolean.FALSE);
									}
								}

								if (this.hasHorizontalConnection(blockState)) {
									pLevel.setBlock(posAbove, blockState, 2);
								}

								return;
							}
						}
					}

					if (!pLevel.getBlockState(pPos).equals(this.defaultBlockState().setValue(UP, pState.getValue(UP)))) {
						if (pLevel.getBlockState(pPos.below()).isAir()) {
							if (pRandom.nextInt(8) == 0) {
								pLevel.setBlock(pPos.below(), this.dead.defaultBlockState().setValue(NORTH, pState.getValue(NORTH)).setValue(EAST, pState.getValue(EAST)).setValue(SOUTH, pState.getValue(SOUTH)).setValue(WEST, pState.getValue(WEST)), 2);
							} else {
								pLevel.setBlock(pPos.below(), this.growing.defaultBlockState().setValue(NORTH, pState.getValue(NORTH)).setValue(EAST, pState.getValue(EAST)).setValue(SOUTH, pState.getValue(SOUTH)).setValue(WEST, pState.getValue(WEST)), 2);
							}
						}

						if (pLevel.getBlockState(pPos.below()).equals(this.growing.defaultBlockState().setValue(NORTH, pState.getValue(NORTH)).setValue(EAST, pState.getValue(EAST)).setValue(SOUTH, pState.getValue(SOUTH)).setValue(WEST, pState.getValue(WEST)))) {
							if (pLevel.getBlockState(pPos.below().below()).isAir()) {
								if (pRandom.nextInt(8) == 0) {
									pLevel.setBlock(pPos.below().below(), this.dead.defaultBlockState().setValue(NORTH, pState.getValue(NORTH)).setValue(EAST, pState.getValue(EAST)).setValue(SOUTH, pState.getValue(SOUTH)).setValue(WEST, pState.getValue(WEST)), 2);
								} else {
									pLevel.setBlock(pPos.below().below(), this.growing.defaultBlockState().setValue(NORTH, pState.getValue(NORTH)).setValue(EAST, pState.getValue(EAST)).setValue(SOUTH, pState.getValue(SOUTH)).setValue(WEST, pState.getValue(WEST)), 2);
								}

								pLevel.setBlock(pPos.below(), this.defaultBlockState().setValue(NORTH, pState.getValue(NORTH)).setValue(EAST, pState.getValue(EAST)).setValue(SOUTH, pState.getValue(SOUTH)).setValue(WEST, pState.getValue(WEST)), 2);
							}
						}
					}
				}

				if (pRandom.nextInt(8) == 0) {
					if (pState == this.defaultBlockState().setValue(NORTH, pState.getValue(NORTH)).setValue(EAST, pState.getValue(EAST)).setValue(SOUTH, pState.getValue(SOUTH)).setValue(WEST, pState.getValue(WEST))) {
						pLevel.setBlock(pPos, this.vine.defaultBlockState().setValue(NORTH, pState.getValue(NORTH)).setValue(EAST, pState.getValue(EAST)).setValue(SOUTH, pState.getValue(SOUTH)).setValue(WEST, pState.getValue(WEST)), 2);
					}
				}
			}
		}
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		BlockState stateOne = pContext.getLevel().getBlockState(pContext.getClickedPos());
		boolean flagOne = stateOne.is(this);
		BlockState stateTwo = flagOne ? stateOne : this.defaultBlockState();
		for (Direction direction : pContext.getNearestLookingDirections()) {
			if (direction != Direction.DOWN) {
				BooleanProperty booleanProperty = this.getPropertyForFace(direction);
				boolean flagTwo = flagOne && stateOne.getValue(booleanProperty);
				if (!flagTwo && this.canSupportAtFace(pContext.getLevel(), pContext.getClickedPos(), direction)) {
					return stateTwo.setValue(booleanProperty, Boolean.TRUE);
				}
			}
		}

		return flagOne ? stateTwo : null;
	}

	public BlockState getUpdatedState(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
		BlockPos blockPos = pPos.above();
		if (pState.getValue(UP)) {
			pState = pState.setValue(UP, this.isAcceptableNeighbour(pLevel, blockPos, Direction.DOWN));
		}

		BlockState blockState = null;
		for (Direction direction : Direction.Plane.HORIZONTAL) {
			BooleanProperty booleanProperty = this.getPropertyForFace(direction);
			if (pState.getValue(booleanProperty)) {
				boolean flag = this.canSupportAtFace(pLevel, pPos, direction);
				if (!flag) {
					if (blockState == null) {
						blockState = pLevel.getBlockState(blockPos);
					}

					flag = (blockState.is(this)) && blockState.getValue(booleanProperty);
				}

				pState = pState.setValue(booleanProperty, flag);
			}
		}

		return pState;
	}

	@Override
	public BlockState mirror(BlockState pState, Mirror pMirror) {
		switch(pMirror) {
			case LEFT_RIGHT:
				return pState.setValue(NORTH, pState.getValue(SOUTH)).setValue(SOUTH, pState.getValue(NORTH));
			case FRONT_BACK:
				return pState.setValue(EAST, pState.getValue(WEST)).setValue(WEST, pState.getValue(EAST));
			default:
				return super.mirror(pState, pMirror);
		}
	}

	@Override
	public BlockState rotate(BlockState pState, Rotation pRotate) {
		switch(pRotate) {
			case CLOCKWISE_180:
				return pState.setValue(NORTH, pState.getValue(SOUTH)).setValue(EAST, pState.getValue(WEST)).setValue(SOUTH, pState.getValue(NORTH)).setValue(WEST, pState.getValue(EAST));
			case COUNTERCLOCKWISE_90:
				return pState.setValue(NORTH, pState.getValue(EAST)).setValue(EAST, pState.getValue(SOUTH)).setValue(SOUTH, pState.getValue(WEST)).setValue(WEST, pState.getValue(NORTH));
			case CLOCKWISE_90:
				return pState.setValue(NORTH, pState.getValue(WEST)).setValue(EAST, pState.getValue(NORTH)).setValue(SOUTH, pState.getValue(EAST)).setValue(WEST, pState.getValue(SOUTH));
			default:
				return pState;
		}
	}

	@Override
	public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
		if (pFacing == Direction.DOWN) {
			return super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
		} else {
			BlockState blockState = this.getUpdatedState(pState, pLevel, pCurrentPos);
			return !this.hasFaces(blockState) ? Blocks.AIR.defaultBlockState() : blockState;
		}
	}

	public BooleanProperty getPropertyForFace(Direction pFace) {
		return PROPERTY_BY_DIRECTION.get(pFace);
	}

	public static VoxelShape calculateShape(BlockState pState) {
		VoxelShape voxelShape = Shapes.empty();
		if (pState.getValue(NORTH)) {
			voxelShape = Shapes.or(voxelShape, NORTH_AABB);
		} else if (pState.getValue(EAST)) {
			voxelShape = Shapes.or(voxelShape, EAST_AABB);
		} else if (pState.getValue(SOUTH)) {
			voxelShape = Shapes.or(voxelShape, SOUTH_AABB);
		} else if (pState.getValue(WEST)) {
			voxelShape = Shapes.or(voxelShape, WEST_AABB);
		} else if (pState.getValue(UP)) {
			voxelShape = UP_AABB;
		}

		return voxelShape.isEmpty() ? Shapes.block() : voxelShape;
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return this.map.get(pState);
	}
}
