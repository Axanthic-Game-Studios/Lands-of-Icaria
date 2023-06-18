package com.axanthic.icaria.common.util;

import com.axanthic.icaria.common.entity.IcariaSpawnerBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BaseSpawner;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.SpawnData;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaBaseSpawner extends BaseSpawner {
    public IcariaSpawnerBlockEntity blockEntity;

    public BlockState blockState;

    public IcariaBaseSpawner(IcariaSpawnerBlockEntity pBlockEntity, BlockState pBlockState) {
        this.blockEntity = pBlockEntity;
        this.blockState = pBlockState;
    }

    @Override
    public void broadcastEvent(Level pLevel, BlockPos pPos, int pEventId) {
        pLevel.blockEvent(pPos, this.blockState.getBlock(), pEventId, 0);
    }

    @Override
    public void setNextSpawnData(@Nullable Level pLevel, BlockPos pPos, SpawnData pNextSpawnData) {
        super.setNextSpawnData(pLevel, pPos, pNextSpawnData);
        if (pLevel != null) {
            var blockState = pLevel.getBlockState(pPos);
            pLevel.sendBlockUpdated(pPos, blockState, blockState, 4);
        }
    }

    @Override
    public BlockEntity getSpawnerBlockEntity() {
        return this.blockEntity;
    }
}
