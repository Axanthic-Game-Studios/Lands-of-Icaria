package com.axanthic.icaria.common.handler.stack;

import com.axanthic.icaria.common.entity.FireplaceBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;

import net.neoforged.neoforge.items.ItemStackHandler;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FireplaceInputItemStackHandler extends ItemStackHandler {
	public FireplaceBlockEntity blockEntity;

	public FireplaceInputItemStackHandler(int pSize, FireplaceBlockEntity pBlockEntity) {
		super(pSize);
		this.blockEntity = pBlockEntity;
	}

	@Override
	public void onContentsChanged(int pIndex) {
		this.blockEntity.setChanged();
	}
}
