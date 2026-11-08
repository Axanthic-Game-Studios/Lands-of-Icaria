package com.axanthic.icaria.common.block;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.shapes.RuinedPedestalVoxelShapes;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class RuinedPedestalBlock extends PedestalBlock {
	public RuinedPedestalBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		return switch (pBlockState.getValue(IcariaBlockStateProperties.PEDESTAL)) {
			case SINGLE -> this.getSingle(pBlockState);
			case BOTTOM -> this.getBottom(pBlockState);
			case CENTER -> this.getCenter(pBlockState);
			case TOP -> this.getTop(pBlockState);
		};
	}

	public VoxelShape getSingle(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> RuinedPedestalVoxelShapes.SINGLE_NORTH;
			case EAST -> RuinedPedestalVoxelShapes.SINGLE_EAST;
			case SOUTH -> RuinedPedestalVoxelShapes.SINGLE_SOUTH;
			default -> RuinedPedestalVoxelShapes.SINGLE_WEST;
		};
	}

	public VoxelShape getBottom(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> RuinedPedestalVoxelShapes.BOTTOM_NORTH;
			case EAST -> RuinedPedestalVoxelShapes.BOTTOM_EAST;
			case SOUTH -> RuinedPedestalVoxelShapes.BOTTOM_SOUTH;
			default -> RuinedPedestalVoxelShapes.BOTTOM_WEST;
		};
	}

	public VoxelShape getCenter(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> RuinedPedestalVoxelShapes.CENTER_NORTH;
			case EAST -> RuinedPedestalVoxelShapes.CENTER_EAST;
			case SOUTH -> RuinedPedestalVoxelShapes.CENTER_SOUTH;
			default -> RuinedPedestalVoxelShapes.CENTER_WEST;
		};
	}

	public VoxelShape getTop(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> RuinedPedestalVoxelShapes.TOP_NORTH;
			case EAST -> RuinedPedestalVoxelShapes.TOP_EAST;
			case SOUTH -> RuinedPedestalVoxelShapes.TOP_SOUTH;
			default -> RuinedPedestalVoxelShapes.TOP_WEST;
		};
	}
}
