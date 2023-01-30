package com.axanthic.icaria.common.block;

import com.google.common.collect.ImmutableMap;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
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

public class IcariaVineTailBlock extends Block {
	public static final BooleanProperty NORTH = PipeBlock.NORTH;
	public static final BooleanProperty EAST = PipeBlock.EAST;
	public static final BooleanProperty SOUTH = PipeBlock.SOUTH;
	public static final BooleanProperty WEST = PipeBlock.WEST;
	public static final BooleanProperty UP = PipeBlock.UP;

	public Map<BlockState, VoxelShape> map;
	public static final Map<Direction, BooleanProperty> PROPERTY_BY_DIRECTION = PipeBlock.PROPERTY_BY_DIRECTION.entrySet().stream().filter((pEntry) -> pEntry.getKey() != Direction.DOWN).collect(Util.toMap());

	public static final VoxelShape SHAPE_NORTH = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D);
	public static final VoxelShape SHAPE_EAST = Block.box(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	public static final VoxelShape SHAPE_SOUTH = Block.box(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D);
	public static final VoxelShape SHAPE_WEST = Block.box(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D);
	public static final VoxelShape SHAPE_UP = Block.box(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D);

	public IcariaVineTailBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(NORTH, false).setValue(EAST, false).setValue(SOUTH, false).setValue(WEST, false).setValue(UP, false));
		this.map = ImmutableMap.copyOf(this.stateDefinition.getPossibleStates().stream().collect(Collectors.toMap(Function.identity(), IcariaVineTailBlock::calculateShape)));
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

	public boolean canSupportAtFace(BlockGetter pLevel, BlockPos pPos, Direction pDirection) {
		if (pDirection == Direction.DOWN) {
			return false;
		} else {
			if (this.isAcceptableNeighbour(pLevel, pPos.relative(pDirection), pDirection)) {
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
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		BlockState stateOne = pContext.getLevel().getBlockState(pContext.getClickedPos());
		boolean flagOne = stateOne.is(this);
		BlockState stateTwo = flagOne ? stateOne : this.defaultBlockState();
		for (Direction direction : pContext.getNearestLookingDirections()) {
			if (direction != Direction.DOWN) {
				BooleanProperty booleanProperty = this.getPropertyForFace(direction);
				boolean flagTwo = flagOne && stateOne.getValue(booleanProperty);
				if (!flagTwo && this.canSupportAtFace(pContext.getLevel(), pContext.getClickedPos(), direction)) {
					return stateTwo.setValue(booleanProperty, true);
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

					flag = blockState.is(this) && blockState.getValue(booleanProperty);
				}

				pState = pState.setValue(booleanProperty, flag);
			}
		}

		return pState;
	}

	@Override
	public BlockState mirror(BlockState pState, Mirror pMirror) {
		return switch (pMirror) {
			default -> super.mirror(pState, pMirror);
			case LEFT_RIGHT -> pState.setValue(NORTH, pState.getValue(SOUTH)).setValue(SOUTH, pState.getValue(NORTH));
			case FRONT_BACK -> pState.setValue(EAST, pState.getValue(WEST)).setValue(WEST, pState.getValue(EAST));
		};
	}

	@Override
	public BlockState rotate(BlockState pState, Rotation pRotation) {
		return switch (pRotation) {
			default -> pState;
			case CLOCKWISE_90 -> pState.setValue(NORTH, pState.getValue(WEST)).setValue(EAST, pState.getValue(NORTH)).setValue(SOUTH, pState.getValue(EAST)).setValue(WEST, pState.getValue(SOUTH));
			case CLOCKWISE_180 -> pState.setValue(NORTH, pState.getValue(SOUTH)).setValue(EAST, pState.getValue(WEST)).setValue(SOUTH, pState.getValue(NORTH)).setValue(WEST, pState.getValue(EAST));
			case COUNTERCLOCKWISE_90 -> pState.setValue(NORTH, pState.getValue(EAST)).setValue(EAST, pState.getValue(SOUTH)).setValue(SOUTH, pState.getValue(WEST)).setValue(WEST, pState.getValue(NORTH));
		};
	}

	@Override
	public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
		if (pDirection == Direction.DOWN) {
			return super.updateShape(pState, pDirection, pNeighborState, pLevel, pCurrentPos, pNeighborPos);
		} else {
			BlockState blockState = this.getUpdatedState(pState, pLevel, pCurrentPos);
			return !this.hasFaces(blockState) ? Blocks.AIR.defaultBlockState() : blockState;
		}
	}

	public BooleanProperty getPropertyForFace(Direction pDirection) {
		return PROPERTY_BY_DIRECTION.get(pDirection);
	}

	public static VoxelShape calculateShape(BlockState pState) {
		VoxelShape voxelShape = Shapes.empty();
		if (pState.getValue(NORTH)) {
			voxelShape = Shapes.or(voxelShape, SHAPE_NORTH);
		} else if (pState.getValue(EAST)) {
			voxelShape = Shapes.or(voxelShape, SHAPE_EAST);
		} else if (pState.getValue(SOUTH)) {
			voxelShape = Shapes.or(voxelShape, SHAPE_SOUTH);
		} else if (pState.getValue(WEST)) {
			voxelShape = Shapes.or(voxelShape, SHAPE_WEST);
		} else if (pState.getValue(UP)) {
			voxelShape = SHAPE_UP;
		}

		return voxelShape.isEmpty() ? Shapes.block() : voxelShape;
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return this.map.get(pState);
	}
}
