package com.axanthic.icaria.common.menu;

import com.axanthic.icaria.common.entity.StorageVaseBlockEntity;

import net.minecraftforge.items.ItemStackHandler;

public class StorageVaseItemStackHandler extends ItemStackHandler {
    public StorageVaseBlockEntity blockEntity;

    public StorageVaseItemStackHandler(StorageVaseBlockEntity pBlockEntity, int pSize) {
        super(pSize);
        this.blockEntity = pBlockEntity;
    }

    @Override
    public void onContentsChanged(int slot) {
        blockEntity.setChanged();
    }
}
