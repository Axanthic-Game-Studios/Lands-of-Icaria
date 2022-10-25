package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.blockentity.IcariaSkullBlockEntity;

import com.axanthic.icaria.common.util.IcariaSkullBlockType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Wearable;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@ParametersAreNonnullByDefault

public class IcariaAbstractSkullBlock extends BaseEntityBlock implements Wearable {
    public IcariaSkullBlockType type;
    public float offset;

    public IcariaAbstractSkullBlock(float pOffset, IcariaSkullBlockType pType, Properties pProperties) {
        super(pProperties);
        this.type = pType;
        this.offset = pOffset;
    }

    @Override
    public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
        return false;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new IcariaSkullBlockEntity(pPos, pState);
    }

    public float getOffset() {
        return this.offset;
    }

    public IcariaSkullBlockType getType() {
        return this.type;
    }
}