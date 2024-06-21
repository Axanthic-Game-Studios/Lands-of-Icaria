package com.axanthic.icaria.common.handler.stack;

import com.axanthic.icaria.common.entity.GrinderBlockEntity;
import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.items.ItemStackHandler;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class GrinderFuelItemStackHandler extends ItemStackHandler {
	public GrinderBlockEntity blockEntity;

	public GrinderFuelItemStackHandler(int pSize, GrinderBlockEntity pBlockEntity) {
		super(pSize);
		this.blockEntity = pBlockEntity;
	}

	@Override
	public boolean isItemValid(int pIndex, ItemStack pStack) {
		return pStack.getItem() == IcariaItems.SLIVER.get() || pStack.getItem() == IcariaItems.SLIVER_BLOCK.get();
	}

	@Override
	public void onContentsChanged(int pIndex) {
		this.blockEntity.setChanged();
	}
}
