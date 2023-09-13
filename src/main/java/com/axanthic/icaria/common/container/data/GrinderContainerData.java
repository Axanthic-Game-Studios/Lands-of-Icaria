package com.axanthic.icaria.common.container.data;

import com.axanthic.icaria.common.entity.GrinderBlockEntity;

import net.minecraft.world.inventory.ContainerData;

public class GrinderContainerData implements ContainerData {
    public GrinderBlockEntity blockEntity;

    public GrinderContainerData(GrinderBlockEntity pBlockEntity) {
        this.blockEntity = pBlockEntity;
    }

    @Override
    public int get(int pIndex) {
        return switch (pIndex) {
            case 0 -> this.blockEntity.maxFuel;
            case 1 -> this.blockEntity.fuel;
            case 2 -> this.blockEntity.maxProgress;
            case 3 -> this.blockEntity.progress;
            default -> 0;
        };
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public void set(int pIndex, int pValue) {
        switch (pIndex) {
            case 0 -> this.blockEntity.maxFuel = pValue;
            case 1 -> this.blockEntity.fuel = pValue;
            case 2 -> this.blockEntity.maxProgress = pValue;
            case 3 -> this.blockEntity.progress = pValue;
        }
    }
}
