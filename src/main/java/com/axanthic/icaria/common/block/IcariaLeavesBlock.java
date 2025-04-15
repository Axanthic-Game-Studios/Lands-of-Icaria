package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaFluids;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.FluidState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaLeavesBlock extends LeavesBlock implements MediterraneanWaterloggedBlock {
	public IcariaLeavesBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.DISTANCE, 7).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(BlockStateProperties.PERSISTENT, false).setValue(BlockStateProperties.WATERLOGGED, false));
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.DISTANCE, IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, BlockStateProperties.PERSISTENT, BlockStateProperties.WATERLOGGED);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pBlockPlaceContext) {
		return super.getStateForPlacement(pBlockPlaceContext).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pBlockPlaceContext.getLevel().getFluidState(pBlockPlaceContext.getClickedPos()).getType() == IcariaFluids.MEDITERRANEAN_WATER.get());
	}

	@Override
	public FluidState getFluidState(BlockState pBlockState) {
		return pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) ? IcariaFluids.MEDITERRANEAN_WATER.get().getSource(false) : super.getFluidState(pBlockState);
	}
}
