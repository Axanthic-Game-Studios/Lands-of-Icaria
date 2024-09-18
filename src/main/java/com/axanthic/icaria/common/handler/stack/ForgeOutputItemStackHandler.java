package com.axanthic.icaria.common.handler.stack;

import com.axanthic.icaria.common.entity.ForgeBlockEntity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.items.ItemStackHandler;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ForgeOutputItemStackHandler extends ItemStackHandler {
	public ForgeBlockEntity blockEntity;

	public ForgeOutputItemStackHandler(int pSize, ForgeBlockEntity pBlockEntity) {
		super(pSize);
		this.blockEntity = pBlockEntity;
	}

	@Override
	public boolean isItemValid(int pIndex, ItemStack pStack) {
		return false;
	}

	@Override
	public void onContentsChanged(int pIndex) {
		this.blockEntity.setChanged();
	}
}
