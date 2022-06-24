package com.axanthic.icaria.common.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;

public class IcariaFuelItem extends Item {
	public int burntime;

	public IcariaFuelItem(Properties pProperties, int pBurntime) {
		super(pProperties);
		this.burntime = pBurntime;
	}

	@Override
	public int getBurnTime(ItemStack pStack, RecipeType<?> pType) {
		return burntime;
	}
}
