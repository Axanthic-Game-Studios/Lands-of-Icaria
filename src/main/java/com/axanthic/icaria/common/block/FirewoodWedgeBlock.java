package com.axanthic.icaria.common.block;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.enums.Wedge;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaFluids;
import com.axanthic.icaria.common.shapes.FirewoodWedgeVoxelShapes;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FirewoodWedgeBlock extends Block implements MediterraneanWaterloggedBlock, SimpleWaterloggedBlock {
	public FirewoodWedgeBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.getStateDefinition().any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(BlockStateProperties.WATERLOGGED, false).setValue(IcariaBlockStateProperties.WEDGE, Wedge.JAGGED));
	}

	@Override
	public boolean isPathfindable(BlockState pBlockState, PathComputationType pPathComputationType) {
		return false;
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.HORIZONTAL_FACING, IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, BlockStateProperties.WATERLOGGED, IcariaBlockStateProperties.WEDGE);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pBlockPlaceContext) {
		var blockPos = pBlockPlaceContext.getClickedPos();
		var direction = pBlockPlaceContext.getHorizontalDirection();
		var level = pBlockPlaceContext.getLevel();
		var player = pBlockPlaceContext.getPlayer();

		var fluidState = level.getFluidState(blockPos);
		var fluid = fluidState.getType();

		var blockState = this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, direction.getOpposite()).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, fluid == IcariaFluids.MEDITERRANEAN_WATER.get()).setValue(BlockStateProperties.WATERLOGGED, fluid == Fluids.WATER);

		if (player != null) {
			return blockState.setValue(IcariaBlockStateProperties.WEDGE, player.isShiftKeyDown() ? Wedge.SMOOTH : Wedge.JAGGED);
		} else {
			return blockState;
		}
	}

	@Override
	public BlockState mirror(BlockState pBlockState, Mirror pMirror) {
		return pBlockState.setValue(BlockStateProperties.HORIZONTAL_FACING, pMirror.mirror(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
	}

	@Override
	public BlockState rotate(BlockState pBlockState, Rotation pRotation) {
		return pBlockState.setValue(BlockStateProperties.HORIZONTAL_FACING, pRotation.rotate(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
	}

	@Override
	public FluidState getFluidState(BlockState pBlockState) {
		return pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) ? IcariaFluids.MEDITERRANEAN_WATER.get().getSource(false) : pBlockState.getValue(BlockStateProperties.WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pBlockState);
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		return switch (pBlockState.getValue(IcariaBlockStateProperties.WEDGE)) {
			case JAGGED -> this.getJagged(pBlockState);
			case SMOOTH -> this.getSmooth(pBlockState);
		};
	}

	public VoxelShape getJagged(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> FirewoodWedgeVoxelShapes.JAGGED_NORTH;
			case EAST -> FirewoodWedgeVoxelShapes.JAGGED_EAST;
			case SOUTH -> FirewoodWedgeVoxelShapes.JAGGED_SOUTH;
			default -> FirewoodWedgeVoxelShapes.JAGGED_WEST;
		};
	}

	public VoxelShape getSmooth(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> FirewoodWedgeVoxelShapes.SMOOTH_NORTH;
			case EAST -> FirewoodWedgeVoxelShapes.SMOOTH_EAST;
			case SOUTH -> FirewoodWedgeVoxelShapes.SMOOTH_SOUTH;
			default -> FirewoodWedgeVoxelShapes.SMOOTH_WEST;
		};
	}
}
