package com.axanthic.loi.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class GrinderRecipe extends IForgeRegistryEntry.Impl<GrinderRecipe> {

	public static Map<ItemStack, Float> experienceList = new HashMap<ItemStack, Float>();

	public Ingredient recipeInput;
	public ItemStack recipeOutput;
	public float experience;

	public GrinderRecipe(ResourceLocation name, Ingredient input, float xp, ItemStack output) {
		this.setRegistryName(name);
		this.recipeInput = input;
		this.recipeOutput = output;
		this.experience = xp;
		experienceList.put(output, xp);
	}

	public GrinderRecipe(String name, Ingredient input, float xp, ItemStack output) {
		this.setRegistryName(name);
		this.recipeInput = input;
		this.recipeOutput = output;
		this.experience = xp;
		experienceList.put(output, xp);
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

	public static float getGrindingExperience(ItemStack stack) {
		float ret = stack.getItem().getSmeltingExperience(stack);
		if (ret != -1) return ret;

		for (Entry<ItemStack, Float> entry : experienceList.entrySet()) {
			if (ItemStack.areItemsEqual(stack, entry.getKey())) {
				return ((Float)entry.getValue()).floatValue();
			}
		}
		return 0.0F;
	}
}
