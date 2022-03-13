package com.axanthic.icaria.common.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;

public class FuelItem extends Item {
	public int burntime;

	public FuelItem(Properties properties, int burntime) {
		super(properties);
		this.burntime = burntime;
	}

	@Override
	public int getBurnTime(ItemStack stack, RecipeType<?> type) {
		return burntime;
	}
}
