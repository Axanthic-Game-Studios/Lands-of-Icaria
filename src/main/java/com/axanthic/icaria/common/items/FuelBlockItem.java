package com.axanthic.icaria.common.items;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;

public class FuelBlockItem extends BlockItem {
	public int burntime;

	public FuelBlockItem(Block block, Properties properties, int burntime) {
		super(block, properties);
		this.burntime = burntime;
	}

	@Override
	public int getBurnTime(ItemStack stack, RecipeType<?> type) {
		return burntime;
	}
}
