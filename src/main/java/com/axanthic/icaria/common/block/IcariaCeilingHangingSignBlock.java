package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.entity.IcariaHangingSignBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaCeilingHangingSignBlock extends CeilingHangingSignBlock {
    public IcariaCeilingHangingSignBlock(Properties pProperties, WoodType pType) {
        super(pProperties, pType);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new IcariaHangingSignBlockEntity(pPos, pState);
    }
}
