package com.axanthic.icaria.common.recipe.input;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

@MethodsReturnNonnullByDefault

public class TripleRecipeInput implements RecipeInput {
	public ItemStack itemStackA;
	public ItemStack itemStackB;
	public ItemStack itemStackC;

	public TripleRecipeInput(ItemStack pItemStackA, ItemStack pItemStackB, ItemStack pItemStackC) {
		this.itemStackA = pItemStackA;
		this.itemStackB = pItemStackB;
		this.itemStackC = pItemStackC;
	}

	@Override
	public boolean isEmpty() {
		return this.itemStackA.isEmpty() && this.itemStackB.isEmpty() && this.itemStackC.isEmpty();
	}

	@Override
	public int size() {
		return 3;
	}

	@Override
	public ItemStack getItem(int pIndex) {
		return switch (pIndex) {
			case 0 -> this.itemStackA;
			case 1 -> this.itemStackB;
			case 2 -> this.itemStackC;
			default -> throw new IllegalArgumentException("No item for index " + pIndex);
		};
	}
}
