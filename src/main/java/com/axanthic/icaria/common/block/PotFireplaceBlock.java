package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.shapes.PotFireplaceVoxelShapes;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
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
		return switch (pBlockState.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF)) {
			case LOWER -> this.getLower(pBlockState);
			case UPPER -> this.getUpper(pBlockState);
		};
	}

	public VoxelShape getLower(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> PotFireplaceVoxelShapes.LOWER_NORTH;
			case EAST -> PotFireplaceVoxelShapes.LOWER_EAST;
			case SOUTH -> PotFireplaceVoxelShapes.LOWER_SOUTH;
			default -> PotFireplaceVoxelShapes.LOWER_WEST;
		};
	}

	public VoxelShape getUpper(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> PotFireplaceVoxelShapes.UPPER_NORTH;
			case EAST -> PotFireplaceVoxelShapes.UPPER_EAST;
			case SOUTH -> PotFireplaceVoxelShapes.UPPER_SOUTH;
			default -> PotFireplaceVoxelShapes.UPPER_WEST;
		};
	}
}
