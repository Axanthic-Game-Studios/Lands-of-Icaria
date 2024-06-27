package com.axanthic.icaria.common.recipe.input;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

@MethodsReturnNonnullByDefault

public class DoubleRecipeInput implements RecipeInput {
	public ItemStack itemStackA;
	public ItemStack itemStackB;

	public DoubleRecipeInput(ItemStack pItemStackA, ItemStack pItemStackB) {
		this.itemStackA = pItemStackA;
		this.itemStackB = pItemStackB;
	}

	@Override
	public boolean isEmpty() {
		return this.itemStackA.isEmpty() && this.itemStackB.isEmpty();
	}

	@Override
	public int size() {
		return 2;
	}

	@Override
	public ItemStack getItem(int pIndex) {
		return switch (pIndex) {
			case 0 -> this.itemStackA;
			case 1 -> this.itemStackB;
			default -> throw new IllegalArgumentException("No item for index " + pIndex);
		};
	}
}
