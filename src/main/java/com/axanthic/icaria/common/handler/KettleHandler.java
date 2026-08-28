package com.axanthic.icaria.common.handler;

import com.axanthic.icaria.common.entity.KettleBlockEntity;
import com.axanthic.icaria.data.provider.tags.IcariaItemTagsProvider;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.item.ItemStacksResourceHandler;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class KettleHandler extends ItemStacksResourceHandler {
	public KettleBlockEntity blockEntity;

	public KettleHandler(KettleBlockEntity pBlockEntity) {
		super(pBlockEntity.getSize());
		this.blockEntity = pBlockEntity;
	}

	@Override
	public boolean isValid(int pIndex, ItemResource pItemResource) {
		return switch (pIndex) {
			case 0, 1, 2 -> pItemResource.is(IcariaItemTagsProvider.KETTLE_ITEMS);
			default -> false;
		};
	}

	@Override
	public void onContentsChanged(int pIndex, ItemStack pItemStack) {
		this.blockEntity.setChanged();
	}
}
