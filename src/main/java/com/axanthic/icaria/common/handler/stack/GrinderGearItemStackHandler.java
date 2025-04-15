package com.axanthic.icaria.common.handler.stack;

import com.axanthic.icaria.common.entity.GrinderBlockEntity;
import com.axanthic.icaria.common.registry.IcariaItems;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.items.ItemStackHandler;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrinderGearItemStackHandler extends ItemStackHandler {
	public GrinderBlockEntity blockEntity;

	public GrinderGearItemStackHandler(int pSize, GrinderBlockEntity pBlockEntity) {
		super(pSize);
		this.blockEntity = pBlockEntity;
	}

	@Override
	public boolean isItemValid(int pIndex, ItemStack pItemStack) {
		return pItemStack.getItem() == IcariaItems.YELLOWSTONE_GEAR.get() || pItemStack.getItem() == IcariaItems.LOAM_GEAR.get() || pItemStack.getItem() == IcariaItems.VOIDSHALE_GEAR.get() || pItemStack.getItem() == IcariaItems.VANADIUM_GEAR.get() || pItemStack.getItem() == IcariaItems.DAEDALIAN_GEAR.get();
	}

	@Override
	public void onContentsChanged(int pIndex) {
		this.blockEntity.setChanged();
	}
}
