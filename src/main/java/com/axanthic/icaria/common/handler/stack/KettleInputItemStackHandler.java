package com.axanthic.icaria.common.handler.stack;

import com.axanthic.icaria.common.entity.KettleBlockEntity;

import net.neoforged.neoforge.items.ItemStackHandler;

public class KettleInputItemStackHandler extends ItemStackHandler {
    public KettleBlockEntity blockEntity;

    public KettleInputItemStackHandler(int pSize, KettleBlockEntity pBlockEntity) {
        super(pSize);
        this.blockEntity = pBlockEntity;
    }

    @Override
    public void onContentsChanged(int pIndex) {
        this.blockEntity.setChanged();
    }
}
