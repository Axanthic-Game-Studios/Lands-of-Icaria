package com.axanthic.icaria.common.block;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.helper.IcariaCommonHelper;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaFluids;
import com.axanthic.icaria.common.shapes.ChoppingBlockVoxelShapes;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ChoppingBlock extends Block {
	public ChoppingBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.getStateDefinition().any().setValue(IcariaBlockStateProperties.CHOPPING_BLOCK_VARIANT, 0).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(BlockStateProperties.WATERLOGGED, false));
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(IcariaBlockStateProperties.CHOPPING_BLOCK_VARIANT, BlockStateProperties.HORIZONTAL_FACING, IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, BlockStateProperties.WATERLOGGED);
	}

	public BlockState getStateForPlacement(BlockPlaceContext pBlockPlaceContext) {
		var blockPos = pBlockPlaceContext.getClickedPos();
		var level = pBlockPlaceContext.getLevel();
		var fluid = level.getFluidState(blockPos).getType();
		var random = IcariaCommonHelper.getRandomSource(blockPos);
		return this.defaultBlockState().setValue(IcariaBlockStateProperties.CHOPPING_BLOCK_VARIANT, random.nextInt(4)).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.Plane.HORIZONTAL.getRandomDirection(random)).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, fluid == IcariaFluids.MEDITERRANEAN_WATER.get()).setValue(BlockStateProperties.WATERLOGGED, fluid == Fluids.WATER);
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
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> this.getNorth(pBlockState);
			case EAST -> this.getEast(pBlockState);
			case SOUTH -> this.getSouth(pBlockState);
			case WEST -> this.getWest(pBlockState);
			default -> Shapes.block();
		};
	}

	public VoxelShape getNorth(BlockState pBlockState) {
		return switch (pBlockState.getValue(IcariaBlockStateProperties.CHOPPING_BLOCK_VARIANT)) {
			case 0 -> ChoppingBlockVoxelShapes.NORTH_0;
			case 1 -> ChoppingBlockVoxelShapes.NORTH_1;
			case 2 -> ChoppingBlockVoxelShapes.NORTH_2;
			case 3 -> ChoppingBlockVoxelShapes.NORTH_3;
			default -> Shapes.block();
		};
	}

	public VoxelShape getEast(BlockState pBlockState) {
		return switch (pBlockState.getValue(IcariaBlockStateProperties.CHOPPING_BLOCK_VARIANT)) {
			case 0 -> ChoppingBlockVoxelShapes.EAST_0;
			case 1 -> ChoppingBlockVoxelShapes.EAST_1;
			case 2 -> ChoppingBlockVoxelShapes.EAST_2;
			case 3 -> ChoppingBlockVoxelShapes.EAST_3;
			default -> Shapes.block();
		};
	}

	public VoxelShape getSouth(BlockState pBlockState) {
		return switch (pBlockState.getValue(IcariaBlockStateProperties.CHOPPING_BLOCK_VARIANT)) {
			case 0 -> ChoppingBlockVoxelShapes.SOUTH_0;
			case 1 -> ChoppingBlockVoxelShapes.SOUTH_1;
			case 2 -> ChoppingBlockVoxelShapes.SOUTH_2;
			case 3 -> ChoppingBlockVoxelShapes.SOUTH_3;
			default -> Shapes.block();
		};
	}

	public VoxelShape getWest(BlockState pBlockState) {
		return switch (pBlockState.getValue(IcariaBlockStateProperties.CHOPPING_BLOCK_VARIANT)) {
			case 0 -> ChoppingBlockVoxelShapes.WEST_0;
			case 1 -> ChoppingBlockVoxelShapes.WEST_1;
			case 2 -> ChoppingBlockVoxelShapes.WEST_2;
			case 3 -> ChoppingBlockVoxelShapes.WEST_3;
			default -> Shapes.block();
		};
	}
}
