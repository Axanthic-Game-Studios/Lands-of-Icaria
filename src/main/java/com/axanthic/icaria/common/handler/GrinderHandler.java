package com.axanthic.icaria.common.handler;

import com.axanthic.icaria.common.entity.GrinderBlockEntity;
import com.axanthic.icaria.common.registry.IcariaDataMapTypes;
import com.axanthic.icaria.data.provider.tags.IcariaItemTagsProvider;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.item.ItemStacksResourceHandler;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrinderHandler extends ItemStacksResourceHandler {
	public GrinderBlockEntity blockEntity;

	public GrinderHandler(GrinderBlockEntity pBlockEntity) {
		super(pBlockEntity.getSize());
		this.blockEntity = pBlockEntity;
	}

	@Override
	public boolean isValid(int pIndex, ItemResource pItemResource) {
		var grinderFuel = pItemResource.getHolder().getData(IcariaDataMapTypes.GRINDER_FUELS);
		return switch (pIndex) {
			case 0 -> grinderFuel != null && grinderFuel.burnTime() > 0;
			case 1 -> pItemResource.is(IcariaItemTagsProvider.GRINDER_GEARS);
			case 2 -> true;
			default -> false;
		};
	}

	@Override
	public void onContentsChanged(int pIndex, ItemStack pItemStack) {
		this.blockEntity.setChanged();
	}
}
