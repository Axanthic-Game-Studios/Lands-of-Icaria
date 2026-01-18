package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaFluids;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaSlabBlock extends SlabBlock implements MediterraneanWaterloggedBlock {
	public IcariaSlabBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.getStateDefinition().any().setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(BlockStateProperties.SLAB_TYPE, SlabType.BOTTOM).setValue(BlockStateProperties.WATERLOGGED, false));
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, BlockStateProperties.SLAB_TYPE, BlockStateProperties.WATERLOGGED);
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
			return blockState.setValue(BlockStateProperties.SLAB_TYPE, SlabType.DOUBLE).setValue(BlockStateProperties.WATERLOGGED, false).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false);
		} else {
			return this.defaultBlockState().setValue(BlockStateProperties.SLAB_TYPE, vec3.y - blockPos.getY() < 0.5D ? SlabType.BOTTOM : SlabType.TOP).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, fluid == IcariaFluids.MEDITERRANEAN_WATER.get()).setValue(BlockStateProperties.WATERLOGGED, fluid == Fluids.WATER);
		}
	}

	@Override
	public FluidState getFluidState(BlockState pBlockState) {
		return pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) ? IcariaFluids.MEDITERRANEAN_WATER.get().getSource(false) : super.getFluidState(pBlockState);
	}
}
