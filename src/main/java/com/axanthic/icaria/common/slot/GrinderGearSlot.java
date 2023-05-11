package com.axanthic.icaria.common.slot;

import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.world.item.ItemStack;

import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class GrinderGearSlot extends SlotItemHandler {
    public GrinderGearSlot(IItemHandler pHandler, int pIndex, int pX, int pY) {
        super(pHandler, pIndex, pX, pY);
    }

    @Override
    public boolean mayPlace(ItemStack pStack) {
        return pStack.getItem() == IcariaItems.GEAR_YELLOWSTONE.get() || pStack.getItem() == IcariaItems.GEAR_LOAM.get() || pStack.getItem() == IcariaItems.GEAR_VOIDSHALE.get() || pStack.getItem() == IcariaItems.GEAR_VANADIUM.get() || pStack.getItem() == IcariaItems.GEAR_DAEDALIAN.get();
    }
}
