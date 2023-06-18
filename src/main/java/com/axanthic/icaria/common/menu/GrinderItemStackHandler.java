package com.axanthic.icaria.common.menu;

import com.axanthic.icaria.common.entity.GrinderBlockEntity;

import net.minecraftforge.items.ItemStackHandler;

public class GrinderItemStackHandler extends ItemStackHandler {
    public GrinderBlockEntity blockEntity;

    public GrinderItemStackHandler(GrinderBlockEntity pBlockEntity, int pSize) {
        super(pSize);
        this.blockEntity = pBlockEntity;
    }

    @Override
    public void onContentsChanged(int slot) {
        blockEntity.setChanged();
    }
}
