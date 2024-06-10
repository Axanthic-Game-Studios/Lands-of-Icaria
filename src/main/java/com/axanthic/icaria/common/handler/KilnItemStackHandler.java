package com.axanthic.icaria.common.handler;

import com.axanthic.icaria.common.entity.KilnBlockEntity;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;

import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.common.CommonHooks;
import net.neoforged.neoforge.items.ItemStackHandler;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class KilnItemStackHandler extends ItemStackHandler {
    public KilnBlockEntity blockEntity;

    public KilnItemStackHandler(int pSize, KilnBlockEntity pBlockEntity) {
        super(pSize);
        this.blockEntity = pBlockEntity;
    }

    @Override
    public boolean isItemValid(int pIndex, ItemStack pStack) {
        return switch (pIndex) {
            case 0 -> CommonHooks.getBurnTime(pStack, IcariaRecipeTypes.FIRING.get()) <= 0;
            case 1 -> CommonHooks.getBurnTime(pStack, IcariaRecipeTypes.FIRING.get()) > 0;
            case 2 -> false;
            default -> super.isItemValid(pIndex, pStack);
        };
    }

    @Override
    public void onContentsChanged(int pIndex) {
        this.blockEntity.setChanged();
    }
}
