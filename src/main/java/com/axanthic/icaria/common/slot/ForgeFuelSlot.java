package com.axanthic.icaria.common.slot;

import com.axanthic.icaria.common.registry.IcariaRecipeTypes;

import net.minecraft.world.item.ItemStack;

import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class ForgeFuelSlot extends SlotItemHandler {
    public ForgeFuelSlot(IItemHandler pHandler, int pIndex, int pX, int pY) {
        super(pHandler, pIndex, pX, pY);
    }

    @Override
    public boolean mayPlace(ItemStack pStack) {
        return ForgeHooks.getBurnTime(pStack, IcariaRecipeTypes.FORGING.get()) > 0;
    }
}
