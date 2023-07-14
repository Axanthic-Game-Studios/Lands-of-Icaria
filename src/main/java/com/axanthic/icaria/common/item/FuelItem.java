package com.axanthic.icaria.common.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;

public class FuelItem extends Item {
	public int burnTime;

	public FuelItem(Properties pProperties, int pBurnTime) {
		super(pProperties);
		this.burnTime = pBurnTime;
	}

	@Override
	public int getBurnTime(ItemStack pStack, RecipeType<?> pType) {
		return this.burnTime;
	}
}
