package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.entity.IcariaSignBlockEntity;

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
		this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, false).setValue(FACING, Direction.NORTH).setValue(FACE, AttachFace.WALL));
	}

	public boolean canAttach(LevelReader pLevel, BlockPos pPos, Direction pDirection) {
		BlockPos blockpos = pPos.relative(pDirection);
		return pLevel.getBlockState(blockpos).isFaceSturdy(pLevel, blockpos, pDirection.getOpposite());
	}

	@Override
	public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
		return this.canAttach(pLevel, pPos, this.getConnectedDirection(pState).getOpposite());
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
		for (Direction direction : pContext.getNearestLookingDirections()) {
			BlockState blockState;
			if (direction.getAxis() == Direction.Axis.Y) {
				blockState = this.defaultBlockState().setValue(FACE, direction == Direction.UP ? AttachFace.CEILING : AttachFace.FLOOR).setValue(FACING, pContext.getHorizontalDirection()).setValue(WATERLOGGED, pContext.getLevel().getFluidState(pContext.getClickedPos()).getType() == Fluids.WATER);
			} else {
				blockState = this.defaultBlockState().setValue(FACE, AttachFace.WALL).setValue(FACING, direction.getOpposite()).setValue(WATERLOGGED, pContext.getLevel().getFluidState(pContext.getClickedPos()).getType() == Fluids.WATER);
			}

			if (blockState.canSurvive(pContext.getLevel(), pContext.getClickedPos())) {
				return blockState;
			}
		}

		return null;
	}

	@Override
	public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
		return this.getConnectedDirection(pState).getOpposite() == pFacing && !pState.canSurvive(pLevel, pCurrentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
	}

	public Direction getConnectedDirection(BlockState pState) {
		return switch (pState.getValue(FACE)) {
			default -> pState.getValue(FACING);
			case CEILING -> Direction.DOWN;
			case FLOOR -> Direction.UP;
		};
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return switch (pState.getValue(FACE)) {
			default -> switch (pState.getValue(FACING)) {
				default -> CEILING_NORTH;
				case EAST -> CEILING_EAST;
				case SOUTH -> CEILING_SOUTH;
				case WEST -> CEILING_WEST;
			};

			case FLOOR -> switch (pState.getValue(FACING)) {
				default -> FLOOR_NORTH;
				case EAST -> FLOOR_EAST;
				case SOUTH -> FLOOR_SOUTH;
				case WEST -> FLOOR_WEST;
			};

			case WALL -> switch (pState.getValue(FACING)) {
				default -> WALL_NORTH;
				case EAST -> WALL_EAST;
				case SOUTH -> WALL_SOUTH;
				case WEST -> WALL_WEST;
			};
		};
	}
}
