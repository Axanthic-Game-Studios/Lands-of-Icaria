package com.axanthic.icaria.common.handler.stack;

import com.axanthic.icaria.common.block.entity.ForgeBlockEntity;

import net.minecraft.MethodsReturnNonnullByDefault;

import net.neoforged.neoforge.items.ItemStackHandler;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ForgeInputItemStackHandler extends ItemStackHandler {
	public ForgeBlockEntity blockEntity;

	public ForgeInputItemStackHandler(int pSize, ForgeBlockEntity pBlockEntity) {
		super(pSize);
		this.blockEntity = pBlockEntity;
	}

	@Override
	public void onContentsChanged(int pIndex) {
		this.blockEntity.setChanged();
	}
}
