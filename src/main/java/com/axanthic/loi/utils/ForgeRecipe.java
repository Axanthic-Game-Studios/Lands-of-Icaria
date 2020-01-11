package com.axanthic.loi.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.axanthic.loi.ModInformation;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class ForgeRecipe extends IForgeRegistryEntry.Impl<ForgeRecipe> {

	public static Collection<Ingredient> allInputs = new ArrayList<Ingredient>();
	public static Map<ItemStack, Float> experienceList = new HashMap<ItemStack, Float>();

	public NonNullList<Ingredient> recipeInputs;
	public ItemStack recipeOutput;
	public float experience;

	public ForgeRecipe(ResourceLocation name, ItemStack output, float xp, Ingredient... inputs) {
		this.setRegistryName(name);
		this.recipeOutput = output;
		this.recipeInputs = NonNullList.from(Ingredient.EMPTY, inputs);
		this.experience = xp;
		experienceList.put(output, xp);
		for (Ingredient input : inputs)
			allInputs.add(input);
	}

	public ForgeRecipe(String name, ItemStack output, float xp, Ingredient... inputs) {
		this(new ResourceLocation(ModInformation.ID, name), output, xp, inputs);
	}

	public ItemStack getOutput(ItemStack... input) {
		return this.recipeOutput;
	}

	public NonNullList<Ingredient> getInputs() {
		return this.recipeInputs;
	}

	public boolean matches(ItemStack... ingredients) {
		int matches = 0;
		NonNullList<Ingredient> unmatchedInputs = NonNullList.create();
		unmatchedInputs.addAll(this.recipeInputs);
		for (ItemStack ingredient : ingredients) {
			for (int i = 0; i < unmatchedInputs.size(); ++i) {
				Ingredient recipeInput = unmatchedInputs.get(i);
				if (recipeInput.apply(ingredient)) {
					unmatchedInputs.remove(i);
					++matches;
					break;
				}
			}
		}
		return this.recipeInputs.size() == matches;
	}

	public static float getSmeltingExperience(ItemStack stack) {
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
