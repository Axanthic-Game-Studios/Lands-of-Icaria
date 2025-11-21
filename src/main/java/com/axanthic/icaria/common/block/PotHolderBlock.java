package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.shapes.PotHolderVoxelShapes;

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

public class PotHolderBlock extends HolderBlock {
	public PotHolderBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> PotHolderVoxelShapes.NORTH;
			case EAST -> PotHolderVoxelShapes.EAST;
			case SOUTH -> PotHolderVoxelShapes.SOUTH;
			default -> PotHolderVoxelShapes.WEST;
		};
	}
}
