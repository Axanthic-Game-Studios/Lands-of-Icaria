package com.axanthic.icaria.common.handler.stack;

import com.axanthic.icaria.common.entity.KettleBlockEntity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.items.ItemStackHandler;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class KettleOutputItemStackHandler extends ItemStackHandler {
	public KettleBlockEntity blockEntity;

	public KettleOutputItemStackHandler(int pSize, KettleBlockEntity pBlockEntity) {
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
