package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.shapes.GrateFireplaceVoxelShapes;

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

public class GrateFireplaceBlock extends FireplaceBlock {
	public GrateFireplaceBlock(float pItemHeight, Properties pProperties) {
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
			case NORTH -> GrateFireplaceVoxelShapes.LOWER_NORTH;
			case EAST -> GrateFireplaceVoxelShapes.LOWER_EAST;
			case SOUTH -> GrateFireplaceVoxelShapes.LOWER_SOUTH;
			default -> GrateFireplaceVoxelShapes.LOWER_WEST;
		};
	}

	public VoxelShape getUpper(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> GrateFireplaceVoxelShapes.UPPER_NORTH;
			case EAST -> GrateFireplaceVoxelShapes.UPPER_EAST;
			case SOUTH -> GrateFireplaceVoxelShapes.UPPER_SOUTH;
			default -> GrateFireplaceVoxelShapes.UPPER_WEST;
		};
	}
}
