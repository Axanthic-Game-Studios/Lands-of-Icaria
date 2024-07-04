package com.axanthic.icaria.common.block.entity;

import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

import net.neoforged.neoforge.items.IItemHandler;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class KilnRedirectorBlockEntity extends BlockEntity {
    public KilnRedirectorBlockEntity(BlockPos pPos, BlockState pState) {
        super(IcariaBlockEntityTypes.KILN_REDIRECTOR.get(), pPos, pState);
    }

    public static @Nullable IItemHandler getCapability(KilnRedirectorBlockEntity pBlockEntity, Direction pDirection) {
        var blockPos = pBlockEntity.getBlockPos();
        var level = pBlockEntity.getLevel();
        if (level != null) {
            if (level.getBlockEntity(blockPos.below()) instanceof KilnBlockEntity kilnBlockEntity) {
                if (level.getBlockState(blockPos).getValue(BlockStateProperties.HORIZONTAL_FACING).getClockWise() == pDirection) {
                    if (level.getBlockState(blockPos).getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.UPPER) {
                        return kilnBlockEntity.inputHandler;
                    }
                }
            }
        }

        return null;
    }
}
