package com.axanthic.icaria.common.util;

import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class GrinderFuelSlots extends SlotItemHandler {

	public GrinderFuelSlots(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
		super(itemHandler, index, xPosition, yPosition);
	}

	@Override
	public boolean mayPlace(ItemStack pStack) {
		return pStack.getItem() == IcariaItems.SLIVER.get() || pStack.getItem() == IcariaItems.SLIVER_BLOCK.get();
	}

}
 