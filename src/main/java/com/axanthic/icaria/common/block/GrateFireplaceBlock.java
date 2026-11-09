package com.axanthic.icaria.common.block;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.shapes.GrateFireplaceVoxelShapes;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrateFireplaceBlock extends FireplaceBlock {
	public GrateFireplaceBlock(float pItemHeight, Properties pProperties) {
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
			case NORTH -> GrateFireplaceVoxelShapes.BOTTOM_NORTH;
			case EAST -> GrateFireplaceVoxelShapes.BOTTOM_EAST;
			case SOUTH -> GrateFireplaceVoxelShapes.BOTTOM_SOUTH;
			case WEST -> GrateFireplaceVoxelShapes.BOTTOM_WEST;
			default -> Shapes.block();
		};
	}

	public VoxelShape getTop(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> GrateFireplaceVoxelShapes.TOP_NORTH;
			case EAST -> GrateFireplaceVoxelShapes.TOP_EAST;
			case SOUTH -> GrateFireplaceVoxelShapes.TOP_SOUTH;
			case WEST -> GrateFireplaceVoxelShapes.TOP_WEST;
			default -> Shapes.block();
		};
	}
}
