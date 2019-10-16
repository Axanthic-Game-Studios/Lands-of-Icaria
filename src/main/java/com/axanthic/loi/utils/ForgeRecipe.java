package com.axanthic.loi.utils;

import java.util.ArrayList;
import java.util.Collection;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class ForgeRecipe extends IForgeRegistryEntry.Impl<ForgeRecipe> {

	public static Collection<Ingredient> allInputs = new ArrayList<Ingredient>();

	public NonNullList<Ingredient> recipeInputs;
	public ItemStack recipeOutput;

	public ForgeRecipe(ResourceLocation name, ItemStack output, Ingredient... inputs) {
		this.setRegistryName(name);
		this.recipeOutput = output;
		this.recipeInputs = NonNullList.from(Ingredient.EMPTY, inputs);
		for (Ingredient input : inputs)
			allInputs.add(input);
	}

	public ForgeRecipe(String name, ItemStack output, Ingredient... inputs) {
		this.setRegistryName(name);
		this.recipeOutput = output;
		this.recipeInputs = NonNullList.from(Ingredient.EMPTY, inputs);
		for (Ingredient input : inputs)
			if (!allInputs.contains(input))
				allInputs.add(input);
	}

	public ItemStack getOutput(ItemStack... input) {
		return this.recipeOutput;
	}

	public NonNullList<Ingredient> getInputs() {
		return this.recipeInputs;
	}

	public boolean matches(ItemStack... ingredients) {
		int matches = 0;
		for (ItemStack ingredient : ingredients) {
			for (Ingredient recipeInput : this.recipeInputs) {
				if (recipeInput.apply(ingredient)) {
					++matches;
					break;
				}
			}
		}
		return this.recipeInputs.size() == matches;
	}
}
