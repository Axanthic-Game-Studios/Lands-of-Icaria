package com.axanthic.icaria.common.handler.stack;

import com.axanthic.icaria.common.entity.ForgeBlockEntity;

import net.neoforged.neoforge.items.ItemStackHandler;

public class ForgeInputItemStackHandler extends ItemStackHandler {
    public ForgeBlockEntity blockEntity;

    public ForgeInputItemStackHandler(int pSize, ForgeBlockEntity pBlockEntity) {
        super(pSize);
        this.blockEntity = pBlockEntity;
    }

    @Override
    public void onContentsChanged(int pIndex) {
        this.blockEntity.setChanged();
    }
}
