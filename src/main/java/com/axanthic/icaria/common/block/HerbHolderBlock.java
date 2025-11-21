package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.shapes.HerbHolderVoxelShapes;

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

public class HerbHolderBlock extends HolderBlock {
	public HerbHolderBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> HerbHolderVoxelShapes.NORTH;
			case EAST -> HerbHolderVoxelShapes.EAST;
			case SOUTH -> HerbHolderVoxelShapes.SOUTH;
			default -> HerbHolderVoxelShapes.WEST;
		};
	}
}
