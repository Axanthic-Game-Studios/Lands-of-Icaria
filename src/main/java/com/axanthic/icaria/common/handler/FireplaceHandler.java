package com.axanthic.icaria.common.handler;

import com.axanthic.icaria.common.entity.FireplaceBlockEntity;
import com.axanthic.icaria.data.provider.tags.IcariaItemTagsProvider;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.item.ItemStacksResourceHandler;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FireplaceHandler extends ItemStacksResourceHandler {
	public FireplaceBlockEntity blockEntity;

	public FireplaceHandler(FireplaceBlockEntity pBlockEntity) {
		super(pBlockEntity.getSize());
		this.blockEntity = pBlockEntity;
	}

	@Override
	public boolean isValid(int pIndex, ItemResource pItemResource) {
		return switch (pIndex) {
			case 0 -> pItemResource.is(IcariaItemTagsProvider.FIREPLACE_ITEMS);
			default -> false;
		};
	}

	@Override
	public void onContentsChanged(int pIndex, ItemStack pItemStack) {
		this.blockEntity.setChanged();
	}
}
