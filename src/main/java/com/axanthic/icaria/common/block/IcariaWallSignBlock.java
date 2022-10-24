package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.blockentity.IcariaSignBlockEntity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaWallSignBlock extends WallSignBlock implements EntityBlock {
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	public static final EnumProperty<AttachFace> FACE = BlockStateProperties.ATTACH_FACE;

	public static final VoxelShape CEILING_NORTH = Block.box(0.0D, 14.0D, 4.5D, 16.0D, 16.0D, 12.5D);
	public static final VoxelShape CEILING_EAST = Block.box(3.5D, 14.0D, 0.0D, 11.5D, 16.0D, 16.0D);
	public static final VoxelShape CEILING_SOUTH = Block.box(0.0D, 14.0D, 3.5D, 16.0D, 16.0D, 11.5D);
	public static final VoxelShape CEILING_WEST = Block.box(4.5D, 14.0D, 0.0D, 12.5D, 16.0D, 16.0D);

	public static final VoxelShape FLOOR_NORTH = Block.box(0.0D, 0.0D, 3.5D, 16.0D, 2.0D, 11.5D);
	public static final VoxelShape FLOOR_EAST = Block.box(4.5D, 0.0D, 0.0D, 12.5D, 2.0D, 16.0D);
	public static final VoxelShape FLOOR_SOUTH = Block.box(0.0D, 0.0D, 4.5D, 16.0D, 2.0D, 12.5D);
	public static final VoxelShape FLOOR_WEST = Block.box(3.5D, 0.0D, 0.0D, 11.5D, 2.0D, 16.0D);

	public static final VoxelShape WALL_NORTH = Block.box(0.0D, 4.5D, 14.0D, 16.0D, 12.5D, 16.0D);
	public static final VoxelShape WALL_EAST = Block.box(0.0D, 4.5D, 0.0D, 2.0D, 12.5D, 16.0D);
	public static final VoxelShape WALL_SOUTH = Block.box(0.0D, 4.5D, 0.0D, 16.0D, 12.5D, 2.0D);
	public static final VoxelShape WALL_WEST = Block.box(14.0D, 4.5D, 0.0D, 16.0D, 12.5D, 16.0D);

	public IcariaWallSignBlock(Properties pProperties, WoodType pWoodType) {
		super(pProperties, pWoodType);
		this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, Boolean.FALSE).setValue(FACING, Direction.NORTH).setValue(FACE, AttachFace.WALL));
	}

	public static boolean canAttach(LevelReader pReader, BlockPos pPos, Direction pDirection) {
		BlockPos blockpos = pPos.relative(pDirection);
		return pReader.getBlockState(blockpos).isFaceSturdy(pReader, blockpos, pDirection.getOpposite());
	}

	@Override
	public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
		return canAttach(pLevel, pPos, getConnectedDirection(pState).getOpposite());
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(FACE, FACING, WATERLOGGED);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		return new IcariaSignBlockEntity(pPos, pState);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		for(Direction direction : pContext.getNearestLookingDirections()) {
			BlockState blockstate;
			if (direction.getAxis() == Direction.Axis.Y) {
				blockstate = this.defaultBlockState().setValue(FACE, direction == Direction.UP ? AttachFace.CEILING : AttachFace.FLOOR).setValue(FACING, pContext.getHorizontalDirection()).setValue(WATERLOGGED, pContext.getLevel().getFluidState(pContext.getClickedPos()).getType() == Fluids.WATER);
			} else {
				blockstate = this.defaultBlockState().setValue(FACE, AttachFace.WALL).setValue(FACING, direction.getOpposite()).setValue(WATERLOGGED, pContext.getLevel().getFluidState(pContext.getClickedPos()).getType() == Fluids.WATER);
			}

			if (blockstate.canSurvive(pContext.getLevel(), pContext.getClickedPos())) {
				return blockstate;
			}
		}

		return null;
	}

	@Override
	public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
		return getConnectedDirection(pState).getOpposite() == pFacing && !pState.canSurvive(pLevel, pCurrentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
	}

	public Direction getConnectedDirection(BlockState pState) {
		switch(pState.getValue(FACE)) {
			case CEILING:
				return Direction.DOWN;
			case FLOOR:
				return Direction.UP;
			default:
				return pState.getValue(FACING);
		}
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		switch(pState.getValue(FACE)) {
			case CEILING:
			default:
				switch(pState.getValue(FACING)) {
					case NORTH:
					default:
						return CEILING_NORTH;
					case EAST:
						return CEILING_EAST;
					case SOUTH:
						return CEILING_SOUTH;
					case WEST:
						return CEILING_WEST;
				}
			case FLOOR:
				switch(pState.getValue(FACING)) {
					case NORTH:
					default:
						return FLOOR_NORTH;
					case EAST:
						return FLOOR_EAST;
					case SOUTH:
						return FLOOR_SOUTH;
					case WEST:
						return FLOOR_WEST;
				}
			case WALL:
				switch(pState.getValue(FACING)) {
					case NORTH:
					default:
						return WALL_NORTH;
					case EAST:
						return WALL_EAST;
					case SOUTH:
						return WALL_SOUTH;
					case WEST:
						return WALL_WEST;
				}

		}
	}
}
