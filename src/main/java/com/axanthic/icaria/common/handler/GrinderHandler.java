package com.axanthic.icaria.common.handler;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.entity.GrinderBlockEntity;
import com.axanthic.icaria.common.registry.IcariaDataMapTypes;
import com.axanthic.icaria.common.tags.IcariaItemTags;

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
		return switch (pIndex) {
			case 0 -> pItemResource.typeHolder().getData(IcariaDataMapTypes.GRINDER_FUELS) != null;
			case 1 -> pItemResource.is(IcariaItemTags.GRINDER_GEARS);
			case 2 -> true;
			default -> false;
		};
	}

	@Override
	public void onContentsChanged(int pIndex, ItemStack pItemStack) {
		this.blockEntity.setChanged();
	}
}
