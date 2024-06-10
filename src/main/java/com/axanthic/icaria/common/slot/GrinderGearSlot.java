package com.axanthic.icaria.common.slot;

import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.SlotItemHandler;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class GrinderGearSlot extends SlotItemHandler {
    public GrinderGearSlot(IItemHandler pHandler, int pIndex, int pX, int pY) {
        super(pHandler, pIndex, pX, pY);
    }

    @Override
    public boolean mayPlace(ItemStack pStack) {
        return pStack.getItem() == IcariaItems.YELLOWSTONE_GEAR.get() || pStack.getItem() == IcariaItems.LOAM_GEAR.get() || pStack.getItem() == IcariaItems.VOIDSHALE_GEAR.get() || pStack.getItem() == IcariaItems.VANADIUM_GEAR.get() || pStack.getItem() == IcariaItems.DAEDALIAN_GEAR.get();
    }
}
