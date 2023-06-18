package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaFluids;
import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

import java.util.Optional;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public interface MediterraneanWaterloggedBlock extends SimpleWaterloggedBlock {
    @Override
    default boolean canPlaceLiquid(BlockGetter pLevel, BlockPos pPos, BlockState pState, Fluid pFluid) {
        return pFluid == IcariaFluids.MEDITERRANEAN_WATER.get();
    }

    @Override
    default boolean placeLiquid(LevelAccessor pLevel, BlockPos pPos, BlockState pState, FluidState pFluidState) {
        if (!pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) && pFluidState.getType() == IcariaFluids.MEDITERRANEAN_WATER.get()) {
            if (!pLevel.isClientSide()) {
                pLevel.setBlock(pPos, pState.setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, true), 3);
                pLevel.scheduleTick(pPos, pFluidState.getType(), pFluidState.getType().getTickDelay(pLevel));
            }

            return true;
        } else {
            return false;
        }
    }

    @Override
    default ItemStack pickupBlock(LevelAccessor pLevel, BlockPos pPos, BlockState pState) {
        if (pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED)) {
            pLevel.setBlock(pPos, pState.setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false), 3);
            if (!pState.canSurvive(pLevel, pPos)) {
                pLevel.destroyBlock(pPos, true);
            }

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
