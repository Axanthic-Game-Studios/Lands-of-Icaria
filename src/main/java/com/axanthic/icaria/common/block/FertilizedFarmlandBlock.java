package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.shapes.LayerShapes;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import net.neoforged.neoforge.common.util.TriState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FertilizedFarmlandBlock extends Block {
	public FertilizedFarmlandBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public boolean isPathfindable(BlockState pBlockState, PathComputationType pPathComputationType) {
		return false;
	}

	@Override
	public boolean useShapeForLightOcclusion(BlockState pBlockState) {
		return true;
	}

	@Override
	public TriState canSustainPlant(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, Direction pDirection, BlockState pBlockStatePlant) {
		return pBlockStatePlant.is(BlockTags.MAINTAINS_FARMLAND) ? TriState.TRUE : TriState.DEFAULT;
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		return LayerShapes.Y_15;
	}
}
