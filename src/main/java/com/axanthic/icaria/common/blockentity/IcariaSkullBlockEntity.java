package com.axanthic.icaria.common.blockentity;

import com.axanthic.icaria.common.registry.IcariaBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class IcariaSkullBlockEntity extends BlockEntity {
    public IcariaSkullBlockEntity(BlockPos pPos, BlockState pState) {
        super(IcariaBlockEntities.SKULL.get(), pPos, pState);
    }
}
