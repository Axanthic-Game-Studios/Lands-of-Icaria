package com.axanthic.icaria.common.container.data;

import com.axanthic.icaria.common.entity.ForgeBlockEntity;

import net.minecraft.world.inventory.ContainerData;

public class ForgeContainerData implements ContainerData {
    public ForgeBlockEntity blockEntity;

    public ForgeContainerData(ForgeBlockEntity pBlockEntity) {
        this.blockEntity = pBlockEntity;
    }

    @Override
    public int get(int index) {
        return switch (index) {
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
    public void set(int index, int value) {
        switch (index) {
            case 0 -> this.blockEntity.maxFuel = value;
            case 1 -> this.blockEntity.fuel = value;
            case 2 -> this.blockEntity.maxProgress = value;
            case 3 -> this.blockEntity.progress = value;
        }
    }
}
