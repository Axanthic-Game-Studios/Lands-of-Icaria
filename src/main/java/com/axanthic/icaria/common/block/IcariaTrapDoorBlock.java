package com.axanthic.icaria.common.block;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.helper.IcariaCommonHelper;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaFluids;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.PathComputationType;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaTrapDoorBlock extends TrapDoorBlock implements MediterraneanWaterloggedBlock {
	public IcariaTrapDoorBlock(BlockSetType pBlockSetType, Properties pProperties) {
		super(pBlockSetType, pProperties);
		this.registerDefaultState(this.getStateDefinition().any().setValue(BlockStateProperties.HALF, Half.BOTTOM).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(BlockStateProperties.OPEN, false).setValue(BlockStateProperties.POWERED, false).setValue(BlockStateProperties.WATERLOGGED, false));
	}

	@Override
	public boolean isPathfindable(BlockState pBlockState, PathComputationType pPathComputationType) {
		return super.isPathfindable(pBlockState, pPathComputationType) || pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) && pPathComputationType == PathComputationType.WATER;
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.HALF, BlockStateProperties.HORIZONTAL_FACING, IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, BlockStateProperties.OPEN, BlockStateProperties.POWERED, BlockStateProperties.WATERLOGGED);
	}

	@Override
	public void onPlace(BlockState pBlockStateNew, Level pLevel, BlockPos pBlockPos, BlockState pBlockStateOld, boolean pMovedByPiston) {
		super.onPlace(pBlockStateNew, pLevel, pBlockPos, pBlockStateOld, pMovedByPiston);
		IcariaCommonHelper.scheduleTick(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pBlockPos, pBlockStateNew, IcariaFluids.MEDITERRANEAN_WATER.get(), pLevel, pLevel);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pBlockPlaceContext) {
		return super.getStateForPlacement(pBlockPlaceContext).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pBlockPlaceContext.getLevel().getFluidState(pBlockPlaceContext.getClickedPos()).getType() == IcariaFluids.MEDITERRANEAN_WATER.get());
	}

	@Override
	public BlockState updateShape(BlockState pBlockState, LevelReader pLevelReader, ScheduledTickAccess pScheduledTickAccess, BlockPos pBlockPos, Direction pDirection, BlockPos pBlockPosFaced, BlockState pBlockStateFaced, RandomSource pRandomSource) {
		IcariaCommonHelper.scheduleTick(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pBlockPos, pBlockState, IcariaFluids.MEDITERRANEAN_WATER.get(), pLevelReader, pScheduledTickAccess);
		return super.updateShape(pBlockState, pLevelReader, pScheduledTickAccess, pBlockPos, pDirection, pBlockPosFaced, pBlockStateFaced, pRandomSource);
	}

	@Override
	public FluidState getFluidState(BlockState pBlockState) {
		return pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) ? IcariaFluids.MEDITERRANEAN_WATER.get().getSource(false) : super.getFluidState(pBlockState);
	}
}
