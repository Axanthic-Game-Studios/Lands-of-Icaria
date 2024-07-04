package com.axanthic.icaria.common.handler.stack;

import com.axanthic.icaria.common.block.entity.ForgeBlockEntity;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.items.ItemStackHandler;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ForgeFuelItemStackHandler extends ItemStackHandler {
	public ForgeBlockEntity blockEntity;

	public ForgeFuelItemStackHandler(int pSize, ForgeBlockEntity pBlockEntity) {
		super(pSize);
		this.blockEntity = pBlockEntity;
	}

	@Override
	public boolean isItemValid(int pIndex, ItemStack pStack) {
		return pStack.getBurnTime(IcariaRecipeTypes.FIRING.get()) > 0;
	}

	@Override
	public void onContentsChanged(int pIndex) {
		this.blockEntity.setChanged();
	}
}
