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

public class GrindingRecipe implements Recipe<RecipeInput> {
	public float experience;

	public int time;

	public Ingredient gear;
	public Ingredient ingredient;

	public ItemStack result;

	public GrindingRecipe(float pExperience, int pTime, Ingredient pGear, Ingredient pIngredient, ItemStack pResult) {
		this.experience = pExperience;
		this.time = pTime;
		this.gear = pGear;
		this.ingredient = pIngredient;
		this.result = pResult;
	}

	@Override
	public boolean matches(RecipeInput pRecipeInput, Level pLevel) {
		return this.gear.test(pRecipeInput.getItem(0)) && this.ingredient.test(pRecipeInput.getItem(1));
	}

	public float experience() {
		return this.experience;
	}

	public int time() {
		return this.time;
	}

	public Ingredient gear() {
		return this.gear;
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
		return IcariaRecipeBookCategories.GRINDER.get();
	}

	@Override
	public RecipeSerializer<? extends Recipe<RecipeInput>> getSerializer() {
		return IcariaRecipeSerializers.GRINDING.get();
	}

	@Override
	public RecipeType<? extends Recipe<RecipeInput>> getType() {
		return IcariaRecipeTypes.GRINDING.get();
	}
}
