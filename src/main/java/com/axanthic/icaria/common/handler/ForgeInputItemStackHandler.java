package com.axanthic.icaria.common.handler;

import com.axanthic.icaria.common.entity.ForgeBlockEntity;

import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

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
