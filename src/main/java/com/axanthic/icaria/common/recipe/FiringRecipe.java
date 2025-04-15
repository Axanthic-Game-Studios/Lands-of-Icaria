package com.axanthic.icaria.common.recipe;

import com.axanthic.icaria.common.registry.IcariaRecipeBookCategories;
import com.axanthic.icaria.common.registry.IcariaRecipeSerializers;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FiringRecipe implements Recipe<RecipeInput> {
	public float experience;

	public int time;

	public Ingredient ingredient;

	public ItemStack result;

	public FiringRecipe(float pExperience, int pTime, Ingredient pIngredient, ItemStack pResult) {
		this.experience = pExperience;
		this.time = pTime;
		this.ingredient = pIngredient;
		this.result = pResult;
	}

	@Override
	public boolean matches(RecipeInput pRecipeInput, Level pLevel) {
		return this.ingredient.test(pRecipeInput.getItem(0));
	}

	public float experience() {
		return this.experience;
	}

	public int time() {
		return this.time;
	}

	public Ingredient ingredient() {
		return this.ingredient;
	}

	@Override
	public ItemStack assemble(RecipeInput pRecipeInput, HolderLookup.Provider pProvider) {
		return this.result.copy();
	}

	public ItemStack result() {
		return this.result;
	}

	@Override
	public PlacementInfo placementInfo() {
		return PlacementInfo.create(this.ingredient);
	}

	@Override
	public RecipeBookCategory recipeBookCategory() {
		return IcariaRecipeBookCategories.KILN.get();
	}

	@Override
	public RecipeSerializer<? extends Recipe<RecipeInput>> getSerializer() {
		return IcariaRecipeSerializers.FIRING.get();
	}

	@Override
	public RecipeType<? extends Recipe<RecipeInput>> getType() {
		return IcariaRecipeTypes.FIRING.get();
	}
}
