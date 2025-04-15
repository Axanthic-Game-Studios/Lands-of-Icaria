package com.axanthic.icaria.common.handler.stack;

import com.axanthic.icaria.common.entity.GrinderBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;

import net.neoforged.neoforge.items.ItemStackHandler;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrinderInputItemStackHandler extends ItemStackHandler {
	public GrinderBlockEntity blockEntity;

	public GrinderInputItemStackHandler(int pSize, GrinderBlockEntity pBlockEntity) {
		super(pSize);
		this.blockEntity = pBlockEntity;
	}

	@Override
	public void onContentsChanged(int pIndex) {
		this.blockEntity.setChanged();
	}
}
