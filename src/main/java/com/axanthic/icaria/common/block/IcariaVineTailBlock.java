package com.axanthic.icaria.common.block;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
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
	public Map<BlockState, VoxelShape> map;

	public static final Map<Direction, BooleanProperty> PROPERTY_BY_DIRECTION = ImmutableMap.copyOf(Util.make(Maps.newEnumMap(Direction.class), (enumMap) -> {
		enumMap.put(Direction.NORTH, BlockStateProperties.NORTH);
		enumMap.put(Direction.EAST, BlockStateProperties.EAST);
		enumMap.put(Direction.SOUTH, BlockStateProperties.SOUTH);
		enumMap.put(Direction.WEST, BlockStateProperties.WEST);
		enumMap.put(Direction.UP, BlockStateProperties.UP);
	}));

	public static final VoxelShape SHAPE_NORTH = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D);
	public static final VoxelShape SHAPE_EAST = Block.box(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	public static final VoxelShape SHAPE_SOUTH = Block.box(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D);
	public static final VoxelShape SHAPE_WEST = Block.box(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D);
	public static final VoxelShape SHAPE_UP = Block.box(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D);

	public IcariaVineTailBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.NORTH, false).setValue(BlockStateProperties.EAST, false).setValue(BlockStateProperties.SOUTH, false).setValue(BlockStateProperties.WEST, false).setValue(BlockStateProperties.UP, false));
		this.map = ImmutableMap.copyOf(this.stateDefinition.getPossibleStates().stream().collect(Collectors.toMap(Function.identity(), IcariaVineTailBlock::calculateShape)));
	}

	@Override
	public boolean canBeReplaced(BlockState pState, BlockPlaceContext pUseContext) {
		var clickedState = pUseContext.getLevel().getBlockState(pUseContext.getClickedPos());
		if (clickedState.is(this)) {
			return this.countFaces(clickedState) < IcariaVineTailBlock.PROPERTY_BY_DIRECTION.size();
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
				var aboveState = pLevel.getBlockState(pPos.above());
				return aboveState.is(BlockTags.CLIMBABLE) && aboveState.getValue(IcariaVineTailBlock.PROPERTY_BY_DIRECTION.get(pDirection));
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
		for (BooleanProperty booleanProperty : IcariaVineTailBlock.PROPERTY_BY_DIRECTION.values()) {
			if (pState.getValue(booleanProperty)) {
				++i;
			}
		}

		return i;
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.NORTH, BlockStateProperties.EAST, BlockStateProperties.SOUTH, BlockStateProperties.WEST, BlockStateProperties.UP);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		var clickedState = pContext.getLevel().getBlockState(pContext.getClickedPos());
		boolean clickedFlag = clickedState.is(this);
		var blockState = clickedFlag ? clickedState : this.defaultBlockState();
		for (Direction direction : pContext.getNearestLookingDirections()) {
			if (direction != Direction.DOWN) {
				var booleanProperty = this.getPropertyForFace(direction);
				boolean flag = clickedFlag && clickedState.getValue(booleanProperty);
				if (!flag && this.canSupportAtFace(pContext.getLevel(), pContext.getClickedPos(), direction)) {
					return blockState.setValue(booleanProperty, true);
				}
			}
		}

		return clickedFlag ? blockState : null;
	}

	public BlockState getUpdatedState(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
		var abovePos = pPos.above();
		if (pState.getValue(BlockStateProperties.UP)) {
			pState = pState.setValue(BlockStateProperties.UP, this.isAcceptableNeighbour(pLevel, abovePos, Direction.DOWN));
		}

		BlockState blockState = null;
		for (Direction direction : Direction.Plane.HORIZONTAL) {
			var booleanProperty = this.getPropertyForFace(direction);
			if (pState.getValue(booleanProperty)) {
				boolean flag = this.canSupportAtFace(pLevel, pPos, direction);
				if (!flag) {
					if (blockState == null) {
						blockState = pLevel.getBlockState(abovePos);
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
			case LEFT_RIGHT -> pState.setValue(BlockStateProperties.NORTH, pState.getValue(BlockStateProperties.SOUTH)).setValue(BlockStateProperties.SOUTH, pState.getValue(BlockStateProperties.NORTH));
			case FRONT_BACK -> pState.setValue(BlockStateProperties.EAST, pState.getValue(BlockStateProperties.WEST)).setValue(BlockStateProperties.WEST, pState.getValue(BlockStateProperties.EAST));
		};
	}

	@Override
	public BlockState rotate(BlockState pState, Rotation pRotation) {
		return switch (pRotation) {
			default -> pState;
			case CLOCKWISE_90 -> pState.setValue(BlockStateProperties.NORTH, pState.getValue(BlockStateProperties.WEST)).setValue(BlockStateProperties.EAST, pState.getValue(BlockStateProperties.NORTH)).setValue(BlockStateProperties.SOUTH, pState.getValue(BlockStateProperties.EAST)).setValue(BlockStateProperties.WEST, pState.getValue(BlockStateProperties.SOUTH));
			case CLOCKWISE_180 -> pState.setValue(BlockStateProperties.NORTH, pState.getValue(BlockStateProperties.SOUTH)).setValue(BlockStateProperties.EAST, pState.getValue(BlockStateProperties.WEST)).setValue(BlockStateProperties.SOUTH, pState.getValue(BlockStateProperties.NORTH)).setValue(BlockStateProperties.WEST, pState.getValue(BlockStateProperties.EAST));
			case COUNTERCLOCKWISE_90 -> pState.setValue(BlockStateProperties.NORTH, pState.getValue(BlockStateProperties.EAST)).setValue(BlockStateProperties.EAST, pState.getValue(BlockStateProperties.SOUTH)).setValue(BlockStateProperties.SOUTH, pState.getValue(BlockStateProperties.WEST)).setValue(BlockStateProperties.WEST, pState.getValue(BlockStateProperties.NORTH));
		};
	}

	@Override
	public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
		if (pDirection == Direction.DOWN) {
			return super.updateShape(pState, pDirection, pNeighborState, pLevel, pCurrentPos, pNeighborPos);
		} else {
			var blockState = this.getUpdatedState(pState, pLevel, pCurrentPos);
			return !this.hasFaces(blockState) ? Blocks.AIR.defaultBlockState() : blockState;
		}
	}

	public BooleanProperty getPropertyForFace(Direction pDirection) {
		return IcariaVineTailBlock.PROPERTY_BY_DIRECTION.get(pDirection);
	}

	public static VoxelShape calculateShape(BlockState pState) {
		var voxelShape = Shapes.empty();
		if (pState.getValue(BlockStateProperties.NORTH)) {
			voxelShape = Shapes.or(voxelShape, IcariaVineTailBlock.SHAPE_NORTH);
		} else if (pState.getValue(BlockStateProperties.EAST)) {
			voxelShape = Shapes.or(voxelShape, IcariaVineTailBlock.SHAPE_EAST);
		} else if (pState.getValue(BlockStateProperties.SOUTH)) {
			voxelShape = Shapes.or(voxelShape, IcariaVineTailBlock.SHAPE_SOUTH);
		} else if (pState.getValue(BlockStateProperties.WEST)) {
			voxelShape = Shapes.or(voxelShape, IcariaVineTailBlock.SHAPE_WEST);
		} else if (pState.getValue(BlockStateProperties.UP)) {
			voxelShape = IcariaVineTailBlock.SHAPE_UP;
		}

		return voxelShape.isEmpty() ? Shapes.block() : voxelShape;
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return this.map.get(pState);
	}
}
