package com.axanthic.icaria.common.handler.stack;

import com.axanthic.icaria.common.entity.ForgeBlockEntity;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.items.ItemStackHandler;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ForgeFuelItemStackHandler extends ItemStackHandler {
	public ForgeBlockEntity blockEntity;

	public ForgeFuelItemStackHandler(int pSize, ForgeBlockEntity pBlockEntity) {
		super(pSize);
		this.blockEntity = pBlockEntity;
	}

	@Override
	public boolean isItemValid(int pIndex, ItemStack pItemStack) {
		return this.blockEntity.getLevel() != null && pItemStack.getBurnTime(IcariaRecipeTypes.FORGING.get(), this.blockEntity.getLevel().fuelValues()) > 0;
	}

	@Override
	public void onContentsChanged(int pIndex) {
		this.blockEntity.setChanged();
	}
}
