package com.axanthic.icaria.common.block;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaFluids;
import com.axanthic.icaria.common.registry.IcariaItems;

import java.util.Optional;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public interface MediterraneanWaterloggedBlock extends SimpleWaterloggedBlock {

	@Override
	default boolean canPlaceLiquid(@Nullable LivingEntity pLivingEntity, BlockGetter pBlockGetter, BlockPos pBlockPos, BlockState pBlockState, Fluid pFluid) {
		return pFluid == IcariaFluids.MEDITERRANEAN_WATER.get() || pFluid == Fluids.WATER;
	}

	@Override
	default boolean placeLiquid(LevelAccessor pLevelAccessor, BlockPos pBlockPos, BlockState pBlockState, FluidState pFluidState) {
		var fluid = pFluidState.getType();
		if (fluid == IcariaFluids.MEDITERRANEAN_WATER.get() && !pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)) {
			this.placeFluid(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, BlockStateProperties.WATERLOGGED, pBlockPos, pBlockState, fluid, pLevelAccessor);
			return true;
		} else if (fluid == Fluids.WATER && !pBlockState.getValue(BlockStateProperties.WATERLOGGED)) {
			this.placeFluid(BlockStateProperties.WATERLOGGED, IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pBlockPos, pBlockState, fluid, pLevelAccessor);
			return true;
		} else {
			return false;
		}
	}

	default void breakFluid(BooleanProperty pBooleanProperty, BlockPos pBlockPos, BlockState pBlockState, LevelAccessor pLevelAccessor) {
		pLevelAccessor.setBlockAndUpdate(pBlockPos, pBlockState.setValue(pBooleanProperty, false));
		if (!pBlockState.canSurvive(pLevelAccessor, pBlockPos)) {
			pLevelAccessor.destroyBlock(pBlockPos, true);
		}
	}

	default void placeFluid(BooleanProperty pPlaced, BooleanProperty pReplaced, BlockPos pBlockPos, BlockState pBlockState, Fluid pFluid, LevelAccessor pLevelAccessor) {
		pLevelAccessor.setBlockAndUpdate(pBlockPos, pBlockState.setValue(pPlaced, true).setValue(pReplaced, false));
		if (!pLevelAccessor.isClientSide()) {
			pLevelAccessor.scheduleTick(pBlockPos, pFluid, pFluid.getTickDelay(pLevelAccessor));
		}
	}

	@Override
	default ItemStack pickupBlock(@Nullable LivingEntity pLivingEntity, LevelAccessor pLevelAccessor, BlockPos pBlockPos, BlockState pBlockState) {
		if (pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)) {
			this.breakFluid(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pBlockPos, pBlockState, pLevelAccessor);
			return new ItemStack(IcariaItems.MEDITERRANEAN_WATER_BUCKET.get());
		} else if (pBlockState.getValue(BlockStateProperties.WATERLOGGED)) {
			this.breakFluid(BlockStateProperties.WATERLOGGED, pBlockPos, pBlockState, pLevelAccessor);
			return new ItemStack(Items.WATER_BUCKET);
		} else {
			return ItemStack.EMPTY;
		}
	}

	@Override
	default Optional<SoundEvent> getPickupSound(BlockState pBlockState) {
		if (pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)) {
			return IcariaFluids.MEDITERRANEAN_WATER.get().getPickupSound();
		} else if (pBlockState.getValue(BlockStateProperties.WATERLOGGED)) {
			return Fluids.WATER.getPickupSound();
		} else {
			return Optional.empty();
		}
	}
}
