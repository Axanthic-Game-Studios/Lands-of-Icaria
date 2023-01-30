package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class IcariaSkullBlockEntity extends BlockEntity {
    public IcariaSkullBlockEntity(BlockPos pPos, BlockState pState) {
        super(IcariaBlockEntityTypes.SKULL.get(), pPos, pState);
    }
}
