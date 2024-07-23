package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class TotemItem extends Item {
	public TotemItem(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public boolean isEnchantable(ItemStack pStack) {
		return false;
	}

	@Override
	public boolean isValidRepairItem(ItemStack pStack, ItemStack pRepairCandidate) {
		return pRepairCandidate.is(IcariaItems.BLURIDIUM_NUGGET.get());
	}
}
