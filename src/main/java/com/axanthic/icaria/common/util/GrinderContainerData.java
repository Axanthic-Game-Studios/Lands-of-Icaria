package com.axanthic.icaria.common.util;

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
            default -> 0;
            case 0 -> blockEntity.maxFuel;
            case 1 -> blockEntity.fuel;
            case 2 -> blockEntity.maxProgress;
            case 3 -> blockEntity.progress;
        };
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public void set(int pIndex, int pValue) {
        switch (pIndex) {
            case 0 -> blockEntity.maxFuel = pValue;
            case 1 -> blockEntity.fuel = pValue;
            case 2 -> blockEntity.maxProgress = pValue;
            case 3 -> blockEntity.progress = pValue;
        }
    }
}
