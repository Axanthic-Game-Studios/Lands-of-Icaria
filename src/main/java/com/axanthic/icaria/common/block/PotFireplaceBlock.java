package com.axanthic.icaria.common.block;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.shapes.PotFireplaceVoxelShapes;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class PotFireplaceBlock extends FireplaceBlock {
	public PotFireplaceBlock(float pItemHeight, Properties pProperties) {
		super(pItemHeight, pProperties);
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		return switch (pBlockState.getValue(IcariaBlockStateProperties.HEIGHT_PAIR)) {
			case BOTTOM -> this.getBottom(pBlockState);
			case TOP -> this.getTop(pBlockState);
		};
	}

	public VoxelShape getBottom(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> PotFireplaceVoxelShapes.BOTTOM_NORTH;
			case EAST -> PotFireplaceVoxelShapes.BOTTOM_EAST;
			case SOUTH -> PotFireplaceVoxelShapes.BOTTOM_SOUTH;
			default -> PotFireplaceVoxelShapes.BOTTOM_WEST;
		};
	}

	public VoxelShape getTop(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> PotFireplaceVoxelShapes.TOP_NORTH;
			case EAST -> PotFireplaceVoxelShapes.TOP_EAST;
			case SOUTH -> PotFireplaceVoxelShapes.TOP_SOUTH;
			default -> PotFireplaceVoxelShapes.TOP_WEST;
		};
	}
}
