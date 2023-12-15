package com.axanthic.icaria.common.container.data;

import com.axanthic.icaria.common.entity.KettleBlockEntity;

import net.minecraft.world.inventory.ContainerData;

public class KettleContainerData implements ContainerData {
    public KettleBlockEntity blockEntity;

    public KettleContainerData(KettleBlockEntity pBlockEntity) {
        this.blockEntity = pBlockEntity;
    }

    @Override
    public int get(int pIndex) {
        return switch (pIndex) {
            case 0 -> this.blockEntity.maxProgress;
            case 1 -> this.blockEntity.progress;
            default -> 0;
        };
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public void set(int pIndex, int pValue) {
        switch (pIndex) {
            case 0 -> this.blockEntity.maxProgress = pValue;
            case 1 -> this.blockEntity.progress = pValue;
        }
    }
}
