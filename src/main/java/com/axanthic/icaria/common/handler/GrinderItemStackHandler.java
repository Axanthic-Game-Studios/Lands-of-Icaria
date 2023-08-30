package com.axanthic.icaria.common.handler;

import com.axanthic.icaria.common.entity.GrinderBlockEntity;
import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.world.item.ItemStack;

import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class GrinderItemStackHandler extends ItemStackHandler {
    public GrinderBlockEntity blockEntity;

    public GrinderItemStackHandler(int pSize, GrinderBlockEntity pBlockEntity) {
        super(pSize);
        this.blockEntity = pBlockEntity;
    }

    @Override
    public boolean isItemValid(int pIndex, ItemStack pStack) {
        return switch (pIndex) {
            case 0 -> pStack.getItem() != IcariaItems.SLIVER.get() && pStack.getItem() != IcariaItems.SLIVER_BLOCK.get() && pStack.getItem() != IcariaItems.YELLOWSTONE_GEAR.get() && pStack.getItem() != IcariaItems.LOAM_GEAR.get() && pStack.getItem() != IcariaItems.VOIDSHALE_GEAR.get() && pStack.getItem() != IcariaItems.VANADIUM_GEAR.get() && pStack.getItem() != IcariaItems.DAEDALIAN_GEAR.get();
            case 1 -> pStack.getItem() == IcariaItems.SLIVER.get() || pStack.getItem() == IcariaItems.SLIVER_BLOCK.get();
            case 2 -> pStack.getItem() == IcariaItems.YELLOWSTONE_GEAR.get() || pStack.getItem() == IcariaItems.LOAM_GEAR.get() || pStack.getItem() == IcariaItems.VOIDSHALE_GEAR.get() || pStack.getItem() == IcariaItems.VANADIUM_GEAR.get() || pStack.getItem() == IcariaItems.DAEDALIAN_GEAR.get();
            case 3, 4, 5 -> false;
            default -> super.isItemValid(pIndex, pStack);
        };
    }

    @Override
    public void onContentsChanged(int pIndex) {
        this.blockEntity.setChanged();
    }
}
