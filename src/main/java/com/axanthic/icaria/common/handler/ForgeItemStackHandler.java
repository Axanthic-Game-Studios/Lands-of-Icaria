package com.axanthic.icaria.common.handler;

import com.axanthic.icaria.common.entity.ForgeBlockEntity;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;

import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.common.CommonHooks;
import net.neoforged.neoforge.items.ItemStackHandler;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class ForgeItemStackHandler extends ItemStackHandler {
    public ForgeBlockEntity blockEntity;

    public ForgeItemStackHandler(int pSize, ForgeBlockEntity pBlockEntity) {
        super(pSize);
        this.blockEntity = pBlockEntity;
    }

    @Override
    public boolean isItemValid(int pIndex, ItemStack pStack) {
        return switch (pIndex) {
            case 0 -> CommonHooks.getBurnTime(pStack, IcariaRecipeTypes.FORGING.get()) > 0;
            case 1, 2 -> false;
            default -> super.isItemValid(pIndex, pStack);
        };
    }

    @Override
    public void onContentsChanged(int pIndex) {
        this.blockEntity.setChanged();
    }
}
