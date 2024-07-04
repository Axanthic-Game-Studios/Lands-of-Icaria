package com.axanthic.icaria.common.block.entity;

import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import net.neoforged.neoforge.items.IItemHandler;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ForgeRedirectorBlockEntity extends BlockEntity {
    public ForgeRedirectorBlockEntity(BlockPos pPos, BlockState pState) {
        super(IcariaBlockEntityTypes.FORGE_REDIRECTOR.get(), pPos, pState);
    }

    public static @Nullable IItemHandler getCapability(ForgeRedirectorBlockEntity pBlockEntity, Direction pDirection) {
        var blockPos = pBlockEntity.getBlockPos();
        var level = pBlockEntity.getLevel();
        if (level != null) {
            if (pDirection == Direction.UP) {
                if (level.getBlockEntity(blockPos.below()) instanceof ForgeBlockEntity forgeBlockEntity) {
                    return forgeBlockEntity.inputHandlerA;
                } else if (level.getBlockEntity(blockPos.below().relative(level.getBlockState(blockPos).getValue(BlockStateProperties.HORIZONTAL_FACING))) instanceof ForgeBlockEntity forgeBlockEntity) {
                    return forgeBlockEntity.inputHandlerB;
                } else if (level.getBlockEntity(blockPos.below().relative(level.getBlockState(blockPos).getValue(BlockStateProperties.HORIZONTAL_FACING)).relative(level.getBlockState(blockPos).getValue(BlockStateProperties.HORIZONTAL_FACING).getClockWise())) instanceof ForgeBlockEntity forgeBlockEntity) {
                    return forgeBlockEntity.inputHandlerC;
                }
            } else if (pDirection == Direction.DOWN) {
                if (level.getBlockEntity(blockPos.relative(level.getBlockState(blockPos).getValue(BlockStateProperties.HORIZONTAL_FACING))) instanceof ForgeBlockEntity forgeBlockEntity) {
                    return forgeBlockEntity.outputHandler;
                } else if (level.getBlockEntity(blockPos.relative(level.getBlockState(blockPos).getValue(BlockStateProperties.HORIZONTAL_FACING)).relative(level.getBlockState(blockPos).getValue(BlockStateProperties.HORIZONTAL_FACING).getClockWise())) instanceof ForgeBlockEntity forgeBlockEntity) {
                    return forgeBlockEntity.outputHandler;
                } else if (level.getBlockEntity(blockPos.relative(level.getBlockState(blockPos).getValue(BlockStateProperties.HORIZONTAL_FACING).getClockWise())) instanceof ForgeBlockEntity forgeBlockEntity) {
                    return forgeBlockEntity.outputHandler;
                }
            }
        }

        return null;
    }
}
