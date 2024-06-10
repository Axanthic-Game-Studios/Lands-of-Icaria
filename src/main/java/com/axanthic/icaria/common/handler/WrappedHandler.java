package com.axanthic.icaria.common.handler;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.items.IItemHandlerModifiable;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class WrappedHandler implements IItemHandlerModifiable {
    public IItemHandlerModifiable handler;

    public Predicate<Integer> extract;

    public BiPredicate<Integer, ItemStack> insert;

    public WrappedHandler(IItemHandlerModifiable pHandler, Predicate<Integer> pExtract, BiPredicate<Integer, ItemStack> pInsert) {
        this.handler = pHandler;
        this.extract = pExtract;
        this.insert = pInsert;
    }

    @Override
    public boolean isItemValid(int pIndex, ItemStack pStack) {
        return this.insert.test(pIndex, pStack) && this.handler.isItemValid(pIndex, pStack);
    }

    @Override
    public int getSlotLimit(int pIndex) {
        return this.handler.getSlotLimit(pIndex);
    }

    @Override
    public int getSlots() {
        return this.handler.getSlots();
    }

    @Override
    public void setStackInSlot(int pIndex, ItemStack pStack) {
        this.handler.setStackInSlot(pIndex, pStack);
    }

    @Override
    public ItemStack getStackInSlot(int pIndex) {
        return this.handler.getStackInSlot(pIndex);
    }

    @Override
    public ItemStack extractItem(int pIndex, int pCount, boolean pSimulate) {
        return this.extract.test(pIndex) ? this.handler.extractItem(pIndex, pCount, pSimulate) : ItemStack.EMPTY;
    }

    @Override
    public ItemStack insertItem(int pIndex, ItemStack pStack, boolean pSimulate) {
        return this.insert.test(pIndex, pStack) ? this.handler.insertItem(pIndex, pStack, pSimulate) : pStack;
    }
}
