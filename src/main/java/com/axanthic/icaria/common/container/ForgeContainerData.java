package com.axanthic.icaria.common.container;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.entity.ForgeBlockEntity;

import net.minecraft.world.inventory.ContainerData;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ForgeContainerData implements ContainerData {
	public ForgeBlockEntity blockEntity;

	public ForgeContainerData(ForgeBlockEntity pBlockEntity) {
		this.blockEntity = pBlockEntity;
	}

	@Override
	public int get(int pDataId) {
		return switch (pDataId) {
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
	public void set(int pDataId, int pValue) {
		switch (pDataId) {
			case 0 -> this.blockEntity.fuel = pValue;
			case 1 -> this.blockEntity.maxFuel = pValue;
			case 2 -> this.blockEntity.progress = pValue;
			case 3 -> this.blockEntity.maxProgress = pValue;
		}
	}
}
