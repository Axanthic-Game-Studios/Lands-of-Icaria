package com.axanthic.icaria.common.handler.stack;

import com.axanthic.icaria.common.entity.FireplaceBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.items.ItemStackHandler;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FireplaceOutputItemStackHandler extends ItemStackHandler {
	public FireplaceBlockEntity blockEntity;

	public FireplaceOutputItemStackHandler(int pSize, FireplaceBlockEntity pBlockEntity) {
		super(pSize);
		this.blockEntity = pBlockEntity;
	}

	@Override
	public boolean isItemValid(int pIndex, ItemStack pItemStack) {
		return false;
	}

	@Override
	public void onContentsChanged(int pIndex) {
		this.blockEntity.setChanged();
	}
}
