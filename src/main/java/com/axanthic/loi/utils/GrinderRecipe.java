package com.axanthic.loi.utils;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class GrinderRecipe extends IForgeRegistryEntry.Impl<GrinderRecipe> {

	public Ingredient recipeInput;
	public ItemStack recipeOutput;

	public GrinderRecipe(ResourceLocation name, Ingredient input, ItemStack output) {
		this.setRegistryName(name);
		this.recipeInput = input;
		this.recipeOutput = output;
	}

	public GrinderRecipe(String name, Ingredient input, ItemStack output) {
		this.setRegistryName(name);
		this.recipeInput = input;
		this.recipeOutput = output;
	}

	public ItemStack getOutput(ItemStack input) {
		return this.recipeOutput;
	}

	public Ingredient getInput() {
		return this.recipeInput;
	}

	public boolean matches(ItemStack ingredient) {
		return this.recipeInput.apply(ingredient);
	}
}
