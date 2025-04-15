package com.axanthic.icaria.common.handler.stack;

import com.axanthic.icaria.common.entity.KilnBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;

import net.neoforged.neoforge.items.ItemStackHandler;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class KilnInputItemStackHandler extends ItemStackHandler {
	public KilnBlockEntity blockEntity;

	public KilnInputItemStackHandler(int pSize, KilnBlockEntity pBlockEntity) {
		super(pSize);
		this.blockEntity = pBlockEntity;
	}

	@Override
	public void onContentsChanged(int pIndex) {
		this.blockEntity.setChanged();
	}
}
