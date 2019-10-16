package com.axanthic.loi.utils;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class GrinderRecipeDust extends GrinderRecipe {

	public GrinderRecipeDust() {
		super("recipe_dust", null, null);
	}

	@Override
	public ItemStack getOutput(ItemStack input) {
		for (int id : OreDictionary.getOreIDs(input)) {
			String name = OreDictionary.getOreName(id);

			if (name.startsWith("ingot"))
				if (OreDictionary.doesOreNameExist(name.replace("ingot", "dust")))
					return OreDictionary.getOres(name.replace("ingot", "dust")).get(0);

			if (name.startsWith("ore"))
				if (OreDictionary.doesOreNameExist(name.replace("ore", "dust"))) {
					ItemStack returnstack = OreDictionary.getOres(name.replace("ore", "dust")).get(0);
					returnstack.setCount(2);
					return returnstack;
				}
		}
		return ItemStack.EMPTY;
	}

	@Override
	public boolean matches(ItemStack ingredient) {
		return !this.getOutput(ingredient).isEmpty();
	}
}
