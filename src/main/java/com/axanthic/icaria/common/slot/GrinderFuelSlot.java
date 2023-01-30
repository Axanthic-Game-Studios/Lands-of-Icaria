package com.axanthic.icaria.common.slot;

import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.world.item.ItemStack;

import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class GrinderFuelSlot extends SlotItemHandler {
	public GrinderFuelSlot(IItemHandler pItemHandler, int pIndex, int pX, int pY) {
		super(pItemHandler, pIndex, pX, pY);
	}

	@Override
	public boolean mayPlace(ItemStack pStack) {
		return pStack.getItem() == IcariaItems.SLIVER.get() || pStack.getItem() == IcariaItems.SLIVER_BLOCK.get();
	}
}
