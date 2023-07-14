package com.axanthic.icaria.common.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;

public class FuelBlockItem extends BlockItem {
	public int burnTime;

	public FuelBlockItem(Block pBlock, Properties pProperties, int pBurnTime) {
		super(pBlock, pProperties);
		this.burnTime = pBurnTime;
	}

	@Override
	public int getBurnTime(ItemStack pStack, RecipeType<?> pType) {
		return this.burnTime;
	}
}
