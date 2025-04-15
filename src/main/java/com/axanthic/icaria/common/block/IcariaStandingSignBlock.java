package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.entity.IcariaSignBlockEntity;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaFluids;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.FluidState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaStandingSignBlock extends StandingSignBlock implements MediterraneanWaterloggedBlock {
	public IcariaStandingSignBlock(WoodType pWoodType, Properties pProperties) {
		super(pWoodType, pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(BlockStateProperties.ROTATION_16, 0).setValue(BlockStateProperties.WATERLOGGED, false));
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, BlockStateProperties.ROTATION_16, BlockStateProperties.WATERLOGGED);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pBlockPos, BlockState pBlockState) {
		return new IcariaSignBlockEntity(pBlockPos, pBlockState);
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
