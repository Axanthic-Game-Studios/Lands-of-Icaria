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

public class ForgingRecipe implements Recipe<RecipeInput> {
	public float experience;

	public int time;

	public Ingredient ingredient;

	public ItemStack result;

	public ForgingRecipe(float pExperience, int pTime, Ingredient pIngredient, ItemStack pResult) {
		this.experience = pExperience;
		this.time = pTime;
		this.ingredient = pIngredient;
		this.result = pResult;
	}

	@Override
	public boolean matches(RecipeInput pRecipeInput, Level pLevel) {
		return this.ingredient.items().size() < 3 ? this.ingredient.items().size() < 2 ? this.matchesSingle(pRecipeInput) : this.matchesDouble(pRecipeInput) : this.matchesTriple(pRecipeInput);
	}

	public boolean matchesSingle(RecipeInput pRecipeInput) {
		return (this.ingredient.items().getFirst().value() == pRecipeInput.getItem(0).getItem() && pRecipeInput.getItem(1).isEmpty() && pRecipeInput.getItem(2).isEmpty()) || (this.ingredient.items().getFirst().value() == pRecipeInput.getItem(0).getItem() && pRecipeInput.getItem(2).isEmpty() && pRecipeInput.getItem(1).isEmpty()) || (this.ingredient.items().getFirst().value() == pRecipeInput.getItem(1).getItem() && pRecipeInput.getItem(0).isEmpty() && pRecipeInput.getItem(2).isEmpty()) || (this.ingredient.items().getFirst().value() == pRecipeInput.getItem(1).getItem() && pRecipeInput.getItem(2).isEmpty() && pRecipeInput.getItem(0).isEmpty()) || (this.ingredient.items().getFirst().value() == pRecipeInput.getItem(2).getItem() && pRecipeInput.getItem(0).isEmpty() && pRecipeInput.getItem(1).isEmpty()) || (this.ingredient.items().getFirst().value() == pRecipeInput.getItem(2).getItem() && pRecipeInput.getItem(1).isEmpty() && pRecipeInput.getItem(0).isEmpty());
	}

	public boolean matchesDouble(RecipeInput pRecipeInput) {
		return (this.ingredient.items().get(0).value() == pRecipeInput.getItem(0).getItem() && this.ingredient.items().get(1).value() == pRecipeInput.getItem(1).getItem() && pRecipeInput.getItem(2).isEmpty()) || (this.ingredient.items().get(0).value() == pRecipeInput.getItem(0).getItem() && this.ingredient.items().get(1).value() == pRecipeInput.getItem(2).getItem() && pRecipeInput.getItem(1).isEmpty()) || (this.ingredient.items().get(0).value() == pRecipeInput.getItem(1).getItem() && this.ingredient.items().get(1).value() == pRecipeInput.getItem(0).getItem() && pRecipeInput.getItem(2).isEmpty()) || (this.ingredient.items().get(0).value() == pRecipeInput.getItem(1).getItem() && this.ingredient.items().get(1).value() == pRecipeInput.getItem(2).getItem() && pRecipeInput.getItem(0).isEmpty()) || (this.ingredient.items().get(0).value() == pRecipeInput.getItem(2).getItem() && this.ingredient.items().get(1).value() == pRecipeInput.getItem(0).getItem() && pRecipeInput.getItem(1).isEmpty()) || (this.ingredient.items().get(0).value() == pRecipeInput.getItem(2).getItem() && this.ingredient.items().get(1).value() == pRecipeInput.getItem(1).getItem() && pRecipeInput.getItem(0).isEmpty());
	}

	public boolean matchesTriple(RecipeInput pRecipeInput) {
		return (this.ingredient.items().get(0).value() == pRecipeInput.getItem(0).getItem() && this.ingredient.items().get(1).value() == pRecipeInput.getItem(1).getItem() && this.ingredient.items().get(2).value() == pRecipeInput.getItem(2).getItem()) || (this.ingredient.items().get(0).value() == pRecipeInput.getItem(0).getItem() && this.ingredient.items().get(1).value() == pRecipeInput.getItem(2).getItem() && this.ingredient.items().get(2).value() == pRecipeInput.getItem(1).getItem()) || (this.ingredient.items().get(0).value() == pRecipeInput.getItem(1).getItem() && this.ingredient.items().get(1).value() == pRecipeInput.getItem(0).getItem() && this.ingredient.items().get(2).value() == pRecipeInput.getItem(2).getItem()) || (this.ingredient.items().get(0).value() == pRecipeInput.getItem(1).getItem() && this.ingredient.items().get(1).value() == pRecipeInput.getItem(2).getItem() && this.ingredient.items().get(2).value() == pRecipeInput.getItem(0).getItem()) || (this.ingredient.items().get(0).value() == pRecipeInput.getItem(2).getItem() && this.ingredient.items().get(1).value() == pRecipeInput.getItem(0).getItem() && this.ingredient.items().get(2).value() == pRecipeInput.getItem(1).getItem()) || (this.ingredient.items().get(0).value() == pRecipeInput.getItem(2).getItem() && this.ingredient.items().get(1).value() == pRecipeInput.getItem(1).getItem() && this.ingredient.items().get(2).value() == pRecipeInput.getItem(0).getItem());
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
		return IcariaRecipeBookCategories.FORGE.get();
	}

	@Override
	public RecipeSerializer<? extends Recipe<RecipeInput>> getSerializer() {
		return IcariaRecipeSerializers.FORGING.get();
	}

	@Override
	public RecipeType<? extends Recipe<RecipeInput>> getType() {
		return IcariaRecipeTypes.FORGING.get();
	}
}
