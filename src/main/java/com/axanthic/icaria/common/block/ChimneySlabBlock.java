package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaFluids;
import com.axanthic.icaria.common.shapes.ChimneySlabVoxelShapes;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ChimneySlabBlock extends IcariaSlabBlock {
	public ChimneySlabBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pBlockPlaceContext) {
		var blockPos = pBlockPlaceContext.getClickedPos();
		var level = pBlockPlaceContext.getLevel();
		var vec3 = pBlockPlaceContext.getClickLocation();

		var blockState = level.getBlockState(blockPos);
		var fluidState = level.getFluidState(blockPos);
		var fluid = fluidState.getType();

		if (blockState.is(this)) {
			return blockState.setValue(BlockStateProperties.SLAB_TYPE, SlabType.DOUBLE);
		} else {
			return this.defaultBlockState().setValue(BlockStateProperties.SLAB_TYPE, vec3.y - blockPos.getY() < 0.5D ? SlabType.BOTTOM : SlabType.TOP).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, fluid == IcariaFluids.MEDITERRANEAN_WATER.get()).setValue(BlockStateProperties.WATERLOGGED, fluid == Fluids.WATER);
		}
	}

	@Override
	public VoxelShape getCollisionShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		return switch (pBlockState.getValue(BlockStateProperties.SLAB_TYPE)) {
			case BOTTOM -> ChimneySlabVoxelShapes.COLLISION_SHAPE_BOTTOM;
			case DOUBLE -> ChimneySlabVoxelShapes.COLLISION_SHAPE_DOUBLE;
			case TOP -> ChimneySlabVoxelShapes.COLLISION_SHAPE_TOP;
		};
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		return switch (pBlockState.getValue(BlockStateProperties.SLAB_TYPE)) {
			case BOTTOM -> ChimneySlabVoxelShapes.SHAPE_BOTTOM;
			case DOUBLE -> ChimneySlabVoxelShapes.SHAPE_DOUBLE;
			case TOP -> ChimneySlabVoxelShapes.SHAPE_TOP;
		};
	}
}
