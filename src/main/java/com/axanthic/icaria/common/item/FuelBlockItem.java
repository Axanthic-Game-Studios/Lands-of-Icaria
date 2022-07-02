package com.axanthic.icaria.common.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;

public class FuelBlockItem extends BlockItem {
	public int burntime;

	public FuelBlockItem(Block pBlock, Properties pProperties, int pBurntime) {
		super(pBlock, pProperties);
		this.burntime = pBurntime;
	}

	@Override
	public int getBurnTime(ItemStack pStack, RecipeType<?> pType) {
		return burntime;
	}
}
