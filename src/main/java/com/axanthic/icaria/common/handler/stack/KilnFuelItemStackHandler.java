package com.axanthic.icaria.common.handler.stack;

import com.axanthic.icaria.common.entity.KilnBlockEntity;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;

import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.items.ItemStackHandler;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class KilnFuelItemStackHandler extends ItemStackHandler {
	public KilnBlockEntity blockEntity;

	public KilnFuelItemStackHandler(int pSize, KilnBlockEntity pBlockEntity) {
		super(pSize);
		this.blockEntity = pBlockEntity;
	}

	@Override
	public boolean isItemValid(int pIndex, ItemStack pStack) {
		return pStack.getBurnTime(IcariaRecipeTypes.FIRING.get()) > 0;
	}

	@Override
	public void onContentsChanged(int pIndex) {
		this.blockEntity.setChanged();
	}
}
