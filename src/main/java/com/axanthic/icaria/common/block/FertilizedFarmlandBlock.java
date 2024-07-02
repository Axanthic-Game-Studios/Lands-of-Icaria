package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.registry.IcariaShapes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import net.neoforged.neoforge.common.util.TriState;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FertilizedFarmlandBlock extends Block {
	public FertilizedFarmlandBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public boolean useShapeForLightOcclusion(BlockState pState) {
		return true;
	}

	@Override
	public TriState canSustainPlant(BlockState pState, BlockGetter pLevel, BlockPos pPos, Direction pDirection, BlockState pPlant) {
		return pPlant.is(BlockTags.MAINTAINS_FARMLAND) ? TriState.TRUE : TriState.DEFAULT;
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return IcariaShapes.Y15;
	}
}
