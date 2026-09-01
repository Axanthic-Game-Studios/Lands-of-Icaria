package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaFluids;
import com.axanthic.icaria.common.registry.IcariaItems;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import java.util.Optional;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public interface MediterraneanWaterloggedBlock extends SimpleWaterloggedBlock {

	@Override
	default boolean canPlaceLiquid(@Nullable LivingEntity pLivingEntity, BlockGetter pBlockGetter, BlockPos pBlockPos, BlockState pBlockState, Fluid pFluid) {
		return pFluid == IcariaFluids.MEDITERRANEAN_WATER.get();
	}

	@Override
	default boolean placeLiquid(LevelAccessor pLevelAccessor, BlockPos pBlockPos, BlockState pBlockState, FluidState pFluidState) {
		if (!pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) && pFluidState.getType() == IcariaFluids.MEDITERRANEAN_WATER.get()) {
			this.placeFluid(pBlockPos, pBlockState, pFluidState.getType(), pLevelAccessor);
			return true;
		} else {
			return false;
		}
	}

	default void breakFluid(BlockPos pBlockPos, BlockState pBlockState, LevelAccessor pLevelAccessor) {
		pLevelAccessor.setBlock(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false), Block.UPDATE_ALL);
		if (!pBlockState.canSurvive(pLevelAccessor, pBlockPos)) {
			pLevelAccessor.destroyBlock(pBlockPos, true);
		}
	}

	default void placeFluid(BlockPos pBlockPos, BlockState pBlockState, Fluid pFluid, LevelAccessor pLevelAccessor) {
		pLevelAccessor.setBlock(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, true), Block.UPDATE_ALL);
		if (!pLevelAccessor.isClientSide()) {
			pLevelAccessor.scheduleTick(pBlockPos, pFluid, pFluid.getTickDelay(pLevelAccessor));
		}
	}

	@Override
	default ItemStack pickupBlock(@Nullable LivingEntity pLivingEntity, LevelAccessor pLevelAccessor, BlockPos pBlockPos, BlockState pBlockState) {
		if (pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)) {
			this.breakFluid(pBlockPos, pBlockState, pLevelAccessor);
			return new ItemStack(IcariaItems.MEDITERRANEAN_WATER_BUCKET.get());
		} else {
			return ItemStack.EMPTY;
		}
	}

	@Override
	default Optional<SoundEvent> getPickupSound() {
		return IcariaFluids.MEDITERRANEAN_WATER.get().getPickupSound();
	}
}
