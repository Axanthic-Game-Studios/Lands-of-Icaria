package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaTrappedChestBlockEntity extends IcariaChestBlockEntity {
    public IcariaTrappedChestBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(IcariaBlockEntityTypes.TRAPPED_CHEST.get(), pPos, pBlockState);
    }

    @Override
    public void signalOpenCount(Level pLevel, BlockPos pPos, BlockState pState, int pEventId, int pEventParam) {
        super.signalOpenCount(pLevel, pPos, pState, pEventId, pEventParam);
        if (pEventId != pEventParam) {
            var block = pState.getBlock();
            pLevel.updateNeighborsAt(pPos, block);
            pLevel.updateNeighborsAt(pPos.below(), block);
        }
    }
}
