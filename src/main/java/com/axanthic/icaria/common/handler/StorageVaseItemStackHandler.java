package com.axanthic.icaria.common.handler;

import com.axanthic.icaria.common.entity.StorageVaseBlockEntity;

import net.minecraftforge.items.ItemStackHandler;

public class StorageVaseItemStackHandler extends ItemStackHandler {
    public StorageVaseBlockEntity blockEntity;

    public StorageVaseItemStackHandler(int pSize, StorageVaseBlockEntity pBlockEntity) {
        super(pSize);
        this.blockEntity = pBlockEntity;
    }

    @Override
    public void onContentsChanged(int pIndex) {
        this.blockEntity.setChanged();
    }
}
