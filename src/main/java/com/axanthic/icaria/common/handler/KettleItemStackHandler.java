package com.axanthic.icaria.common.handler;

import com.axanthic.icaria.common.entity.KettleBlockEntity;

import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.items.ItemStackHandler;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class KettleItemStackHandler extends ItemStackHandler {
    public KettleBlockEntity blockEntity;

    public KettleItemStackHandler(int pSize, KettleBlockEntity pBlockEntity) {
        super(pSize);
        this.blockEntity = pBlockEntity;
    }

    @Override
    public boolean isItemValid(int pIndex, ItemStack pStack) {
        return switch (pIndex) {
            case 0, 1, 2 -> true;
            case 3 -> false;
            default -> super.isItemValid(pIndex, pStack);
        };
    }

    @Override
    public void onContentsChanged(int pIndex) {
        this.blockEntity.setChanged();
    }
}
