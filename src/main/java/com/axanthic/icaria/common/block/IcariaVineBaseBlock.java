package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaItems;

import com.google.common.collect.ImmutableMap;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
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

public class IcariaVineBaseBlock extends Block {
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

	public final Map<BlockState, VoxelShape> shapesCache;

	public Block growing;
	public Block dead;

	public IcariaVineBaseBlock(Properties pProperties, Block growing, Block dead) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(NORTH, Boolean.FALSE).setValue(EAST, Boolean.FALSE).setValue(SOUTH, Boolean.FALSE).setValue(WEST, Boolean.FALSE).setValue(UP, Boolean.FALSE));
		this.shapesCache = ImmutableMap.copyOf(this.stateDefinition.getPossibleStates().stream().collect(Collectors.toMap(Function.identity(), IcariaVineBaseBlock::calculateShape)));
		this.growing = growing;
		this.dead = dead;
	}

	@Override
	public boolean canBeReplaced(BlockState pState, BlockPlaceContext pUseContext) {
		BlockState state = pUseContext.getLevel().getBlockState(pUseContext.getClickedPos());
		if (state.is(this)) {
			return this.countFaces(state) < PROPERTY_BY_DIRECTION.size();
		} else {
			return super.canBeReplaced(pState, pUseContext);
		}
	}

	public boolean canSpread(BlockGetter pBlockReader, BlockPos pPos) {
		Iterable<BlockPos> iterable = BlockPos.betweenClosed(pPos.getX() - 4, pPos.getY() - 1, pPos.getZ() - 4, pPos.getX() + 4, pPos.getY() + 1, pPos.getZ() + 4);
		int j = 5;
		for(BlockPos pos : iterable) {
			if (pBlockReader.getBlockState(pos).is(this)) {
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
			BlockPos pos = pPos.relative(pDirection);
			if (isAcceptableNeighbour(pLevel, pos, pDirection)) {
				return true;
			} else if (pDirection.getAxis() == Direction.Axis.Y) {
				return false;
			} else {
				BlockState state = pLevel.getBlockState(pPos.above());
				return state.is(BlockTags.CLIMBABLE) && state.getValue(PROPERTY_BY_DIRECTION.get(pDirection));
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

	public boolean isAcceptableNeighbour(BlockGetter pBlockReader, BlockPos pLevel, Direction pNeighborPos) {
		return Block.isFaceFull(pBlockReader.getBlockState(pLevel).getCollisionShape(pBlockReader, pLevel), pNeighborPos.getOpposite());
	}

	@Override
	public boolean propagatesSkylightDown(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
		return true;
	}

	public int countFaces(BlockState pState) {
		int i = 0;
		for(BooleanProperty property : PROPERTY_BY_DIRECTION.values()) {
			if (pState.getValue(property)) {
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
		if (pLevel.random.nextInt(4) == 0 && pLevel.isAreaLoaded(pPos, 4)) {
			Direction directionRandom = Direction.getRandom(pRandom);
			BlockPos posAbove = pPos.above();
			if (directionRandom.getAxis().isHorizontal() && !pState.getValue(getPropertyForFace(directionRandom))) {
				if (this.canSpread(pLevel, pPos)) {
					BlockPos posRelative = pPos.relative(directionRandom);
					BlockState stateRelative = pLevel.getBlockState(posRelative);
					if (stateRelative.isAir()) {
						Direction directionClockWise = directionRandom.getClockWise();
						Direction directionCounterClockWise = directionRandom.getCounterClockWise();
						boolean flagClockWise = pState.getValue(getPropertyForFace(directionClockWise));
						boolean flagCounterClockwise = pState.getValue(getPropertyForFace(directionCounterClockWise));
						BlockPos posClockWise = posRelative.relative(directionClockWise);
						BlockPos posCounterClockwise = posRelative.relative(directionCounterClockWise);
						if (flagClockWise && isAcceptableNeighbour(pLevel, posClockWise, directionClockWise)) {
							pLevel.setBlock(posRelative, this.defaultBlockState().setValue(getPropertyForFace(directionClockWise), Boolean.TRUE), 2);
						} else if (flagCounterClockwise && isAcceptableNeighbour(pLevel, posCounterClockwise, directionCounterClockWise)) {
							pLevel.setBlock(posRelative, this.defaultBlockState().setValue(getPropertyForFace(directionCounterClockWise), Boolean.TRUE), 2);
						} else {
							Direction directionOpposite = directionRandom.getOpposite();
							if (flagClockWise && pLevel.isEmptyBlock(posClockWise) && isAcceptableNeighbour(pLevel, pPos.relative(directionClockWise), directionOpposite)) {
								pLevel.setBlock(posClockWise, this.defaultBlockState().setValue(getPropertyForFace(directionOpposite), Boolean.TRUE), 2);
							} else if (flagCounterClockwise && pLevel.isEmptyBlock(posCounterClockwise) && isAcceptableNeighbour(pLevel, pPos.relative(directionCounterClockWise), directionOpposite)) {
								pLevel.setBlock(posCounterClockwise, this.defaultBlockState().setValue(getPropertyForFace(directionOpposite), Boolean.TRUE), 2);
							} else if ((double)pRandom.nextFloat() < 0.05D && isAcceptableNeighbour(pLevel, posRelative.above(), Direction.UP)) {
								pLevel.setBlock(posRelative, this.defaultBlockState().setValue(UP, Boolean.TRUE), 2);
							}
						}

					} else if (isAcceptableNeighbour(pLevel, posRelative, directionRandom)) {
						pLevel.setBlock(pPos, pState.setValue(getPropertyForFace(directionRandom), Boolean.TRUE), 2);
					}
				}

			} else {
				if (directionRandom == Direction.UP && pPos.getY() < pLevel.getMaxBuildHeight() - 1) {
					if (this.canSupportAtFace(pLevel, pPos, directionRandom)) {
						pLevel.setBlock(pPos, pState.setValue(UP, Boolean.TRUE), 2);
						return;
					}
					if (pLevel.isEmptyBlock(posAbove)) {
						if (!this.canSpread(pLevel, pPos)) {
							return;
						}
						BlockState state = pState;
						for (Direction direction : Direction.Plane.HORIZONTAL) {
							if (pRandom.nextBoolean() || !isAcceptableNeighbour(pLevel, posAbove.relative(direction), direction)) {
								state = state.setValue(getPropertyForFace(direction), Boolean.FALSE);
							}
						}
						if (this.hasHorizontalConnection(state)) {
							pLevel.setBlock(posAbove, state, 2);
						}

						return;
					}
				}
				if (!pLevel.getBlockState(pPos).equals(this.defaultBlockState().setValue(UP, pState.getValue(UP)))) {
					if (pLevel.getBlockState(pPos.below()).isAir()) {
						if (pRandom.nextInt(8) == 0) {
							pLevel.setBlock(pPos.below(), dead.defaultBlockState().setValue(NORTH, pState.getValue(NORTH)).setValue(EAST, pState.getValue(EAST)).setValue(SOUTH, pState.getValue(SOUTH)).setValue(WEST, pState.getValue(WEST)), 2);
						} else {
							pLevel.setBlock(pPos.below(), growing.defaultBlockState().setValue(NORTH, pState.getValue(NORTH)).setValue(EAST, pState.getValue(EAST)).setValue(SOUTH, pState.getValue(SOUTH)).setValue(WEST, pState.getValue(WEST)), 2);
						}
					}
					if (pLevel.getBlockState(pPos.below()).equals(growing.defaultBlockState().setValue(NORTH, pState.getValue(NORTH)).setValue(EAST, pState.getValue(EAST)).setValue(SOUTH, pState.getValue(SOUTH)).setValue(WEST, pState.getValue(WEST))) && pLevel.getBlockState(pPos.below().below()).isAir()) {
						if (pRandom.nextInt(8) == 0) {
							pLevel.setBlock(pPos.below().below(), dead.defaultBlockState().setValue(NORTH, pState.getValue(NORTH)).setValue(EAST, pState.getValue(EAST)).setValue(SOUTH, pState.getValue(SOUTH)).setValue(WEST, pState.getValue(WEST)), 2);
						} else {
							pLevel.setBlock(pPos.below().below(), growing.defaultBlockState().setValue(NORTH, pState.getValue(NORTH)).setValue(EAST, pState.getValue(EAST)).setValue(SOUTH, pState.getValue(SOUTH)).setValue(WEST, pState.getValue(WEST)), 2);
						}

						pLevel.setBlock(pPos.below(), this.defaultBlockState().setValue(NORTH, pState.getValue(NORTH)).setValue(EAST, pState.getValue(EAST)).setValue(SOUTH, pState.getValue(SOUTH)).setValue(WEST, pState.getValue(WEST)), 2);
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
		for(Direction direction : pContext.getNearestLookingDirections()) {
			if (direction != Direction.DOWN) {
				BooleanProperty property = getPropertyForFace(direction);
				boolean flagTwo = flagOne && stateOne.getValue(property);
				if (!flagTwo && this.canSupportAtFace(pContext.getLevel(), pContext.getClickedPos(), direction)) {
					return stateTwo.setValue(property, Boolean.TRUE);
				}
			}
		}

		return flagOne ? stateTwo : null;
	}

	public BlockState getUpdatedState(BlockState pState, BlockGetter pBlockReader, BlockPos pPos) {
		BlockPos pos = pPos.above();
		if (pState.getValue(UP)) {
			pState = pState.setValue(UP, isAcceptableNeighbour(pBlockReader, pos, Direction.DOWN));
		}
		BlockState state = null;
		for(Direction direction : Direction.Plane.HORIZONTAL) {
			BooleanProperty property = getPropertyForFace(direction);
			if (pState.getValue(property)) {
				boolean flag = this.canSupportAtFace(pBlockReader, pPos, direction);
				if (!flag) {
					if (state == null) {
						state = pBlockReader.getBlockState(pos);
					}

					flag = (state.is(this)) && state.getValue(property);
				}

				pState = pState.setValue(property, flag);
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
			BlockState state = this.getUpdatedState(pState, pLevel, pCurrentPos);
			return !this.hasFaces(state) ? Blocks.AIR.defaultBlockState() : state;
		}
	}

	public BooleanProperty getPropertyForFace(Direction pFace) {
		return PROPERTY_BY_DIRECTION.get(pFace);
	}

	@Override
	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
		if (pLevel.getBlockState(pPos).equals(IcariaBlocks.RIPE_BLOOMY_VINE.get().defaultBlockState().setValue(NORTH, pState.getValue(NORTH)).setValue(EAST, pState.getValue(EAST)).setValue(SOUTH, pState.getValue(SOUTH)).setValue(WEST, pState.getValue(WEST)).setValue(UP, pState.getValue(UP)))) {
			popResource(pLevel, pPos, new ItemStack(IcariaItems.VINEBERRIES.get(), 1));
			pLevel.playSound(pPlayer, pPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + pLevel.random.nextFloat() * 0.4F);
			pLevel.setBlock(pPos, IcariaBlocks.BLOOMY_VINE.get().defaultBlockState().setValue(NORTH, pState.getValue(NORTH)).setValue(EAST, pState.getValue(EAST)).setValue(SOUTH, pState.getValue(SOUTH)).setValue(WEST, pState.getValue(WEST)).setValue(UP, pState.getValue(UP)), 2);
			return InteractionResult.sidedSuccess(pLevel.isClientSide);
		} else if (pLevel.getBlockState(pPos).equals(IcariaBlocks.RIPE_BRUSHY_VINE.get().defaultBlockState().setValue(NORTH, pState.getValue(NORTH)).setValue(EAST, pState.getValue(EAST)).setValue(SOUTH, pState.getValue(SOUTH)).setValue(WEST, pState.getValue(WEST)).setValue(UP, pState.getValue(UP)))) {
			popResource(pLevel, pPos, new ItemStack(IcariaItems.VINE_SPROUT.get(), 1));
			pLevel.playSound(pPlayer, pPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + pLevel.random.nextFloat() * 0.4F);
			pLevel.setBlock(pPos, IcariaBlocks.BRUSHY_VINE.get().defaultBlockState().setValue(NORTH, pState.getValue(NORTH)).setValue(EAST, pState.getValue(EAST)).setValue(SOUTH, pState.getValue(SOUTH)).setValue(WEST, pState.getValue(WEST)).setValue(UP, pState.getValue(UP)), 2);
			return InteractionResult.sidedSuccess(pLevel.isClientSide);
		} else return InteractionResult.PASS;
	}

	public static VoxelShape calculateShape(BlockState pState) {
		VoxelShape shape = Shapes.empty();
		if (pState.getValue(NORTH)) {
			shape = Shapes.or(shape, NORTH_AABB);
		}
		if (pState.getValue(EAST)) {
			shape = Shapes.or(shape, EAST_AABB);
		}
		if (pState.getValue(SOUTH)) {
			shape = Shapes.or(shape, SOUTH_AABB);
		}
		if (pState.getValue(WEST)) {
			shape = Shapes.or(shape, WEST_AABB);
		}
		if (pState.getValue(UP)) {
			shape = UP_AABB;
		}

		return shape.isEmpty() ? Shapes.block() : shape;
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return this.shapesCache.get(pState);
	}
}
