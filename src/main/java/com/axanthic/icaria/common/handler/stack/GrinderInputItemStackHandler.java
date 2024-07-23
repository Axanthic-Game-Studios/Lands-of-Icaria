package com.axanthic.icaria.common.handler.stack;

import com.axanthic.icaria.common.block.entity.GrinderBlockEntity;
import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.items.ItemStackHandler;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrinderInputItemStackHandler extends ItemStackHandler {
	public GrinderBlockEntity blockEntity;

	public GrinderInputItemStackHandler(int pSize, GrinderBlockEntity pBlockEntity) {
		super(pSize);
		this.blockEntity = pBlockEntity;
	}

	@Override
	public boolean isItemValid(int pIndex, ItemStack pStack) {
		return pStack.getItem() != IcariaItems.SLIVER.get() && pStack.getItem() != IcariaItems.SLIVER_BLOCK.get() && pStack.getItem() != IcariaItems.YELLOWSTONE_GEAR.get() && pStack.getItem() != IcariaItems.LOAM_GEAR.get() && pStack.getItem() != IcariaItems.VOIDSHALE_GEAR.get() && pStack.getItem() != IcariaItems.VANADIUM_GEAR.get() && pStack.getItem() != IcariaItems.DAEDALIAN_GEAR.get();
	}

	@Override
	public void onContentsChanged(int pIndex) {
		this.blockEntity.setChanged();
	}
}
