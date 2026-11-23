package com.axanthic.icaria.common.block;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.helper.IcariaCommonHelper;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaFluids;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.material.Fluid;
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
	public boolean canPlaceLiquid(@Nullable LivingEntity pLivingEntity, BlockGetter pBlockGetter, BlockPos pBlockPos, BlockState pBlockState, Fluid pFluid) {
		return pBlockState.getValue(BlockStateProperties.SLAB_TYPE) != SlabType.DOUBLE && MediterraneanWaterloggedBlock.super.canPlaceLiquid(pLivingEntity, pBlockGetter, pBlockPos, pBlockState, pFluid);
	}

	@Override
	public boolean placeLiquid(LevelAccessor pLevelAccessor, BlockPos pBlockPos, BlockState pBlockState, FluidState pFluidState) {
		return pBlockState.getValue(BlockStateProperties.SLAB_TYPE) != SlabType.DOUBLE && MediterraneanWaterloggedBlock.super.placeLiquid(pLevelAccessor, pBlockPos, pBlockState, pFluidState);
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
	public BlockState updateShape(BlockState pBlockState, LevelReader pLevelReader, ScheduledTickAccess pScheduledTickAccess, BlockPos pBlockPos, Direction pDirection, BlockPos pBlockPosFaced, BlockState pBlockStateFaced, RandomSource pRandomSource) {
		IcariaCommonHelper.scheduleTick(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pBlockPos, pBlockState, IcariaFluids.MEDITERRANEAN_WATER.get(), pLevelReader, pScheduledTickAccess);
		return super.updateShape(pBlockState, pLevelReader, pScheduledTickAccess, pBlockPos, pDirection, pBlockPosFaced, pBlockStateFaced, pRandomSource);
	}

	@Override
	public FluidState getFluidState(BlockState pBlockState) {
		return pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) ? IcariaFluids.MEDITERRANEAN_WATER.get().getSource(false) : super.getFluidState(pBlockState);
	}
}
