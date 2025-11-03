package com.axanthic.icaria.common.handler.stack;

import com.axanthic.icaria.common.entity.GrinderBlockEntity;
import com.axanthic.icaria.data.provider.tags.IcariaItemTagsProvider;

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
		return pItemStack.is(IcariaItemTagsProvider.GRINDER_GEARS);
	}

	@Override
	public void onContentsChanged(int pIndex) {
		this.blockEntity.setChanged();
	}
}
