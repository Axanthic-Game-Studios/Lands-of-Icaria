package com.axanthic.icaria.common.slot;

import net.minecraft.world.item.ItemStack;

import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaOutputSlot extends SlotItemHandler {
	public IcariaOutputSlot(IItemHandler pItemHandler, int pIndex, int pX, int pY) {
		super(pItemHandler, pIndex, pX, pY);
	}

	@Override
	public boolean mayPlace(ItemStack pStack) {
		return false;
	}
}
