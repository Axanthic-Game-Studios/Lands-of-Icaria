package com.axanthic.icaria.common.data;

import com.axanthic.icaria.common.entity.GrinderBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.inventory.ContainerData;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrinderContainerData implements ContainerData {
	public GrinderBlockEntity blockEntity;

	public GrinderContainerData(GrinderBlockEntity pBlockEntity) {
		this.blockEntity = pBlockEntity;
	}

	@Override
	public int get(int pIndex) {
		return switch (pIndex) {
			case 0 -> this.blockEntity.fuel;
			case 1 -> this.blockEntity.maxFuel;
			case 2 -> this.blockEntity.progress;
			case 3 -> this.blockEntity.maxProgress;
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
			case 0 -> this.blockEntity.fuel = pValue;
			case 1 -> this.blockEntity.maxFuel = pValue;
			case 2 -> this.blockEntity.progress = pValue;
			case 3 -> this.blockEntity.maxProgress = pValue;
		}
	}
}
