package com.axanthic.icaria.common.recipe.builder;

import com.axanthic.icaria.common.recipe.ItemConcoctingRecipe;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.advancements.Criterion;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeUnlockAdvancementBuilder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ItemConcoctingRecipeBuilder implements RecipeBuilder {
	public int colour;
	public int time;

	public Ingredient ingredient;

	public ItemStackTemplate result;

	public RecipeCategory recipeCategory;

	public RecipeUnlockAdvancementBuilder recipeUnlockAdvancementBuilder = new RecipeUnlockAdvancementBuilder();

	public ItemConcoctingRecipeBuilder(int pColour, int pTime, Ingredient pIngredient, ItemStackTemplate pResult, RecipeCategory pRecipeCategory) {
		this.colour = pColour;
		this.time = pTime;
		this.ingredient = pIngredient;
		this.result = pResult;
		this.recipeCategory = pRecipeCategory;
	}

	@Override
	public void save(RecipeOutput pRecipeOutput, ResourceKey<Recipe<?>> pResourceKey) {
		pRecipeOutput.accept(pResourceKey, new ItemConcoctingRecipe(this.colour, this.time, this.ingredient, this.result), this.recipeUnlockAdvancementBuilder.build(pRecipeOutput, pResourceKey, this.recipeCategory));
	}

	@Override
	public ItemConcoctingRecipeBuilder group(@Nullable String pName) {
		return this;
	}

	@Override
	public ItemConcoctingRecipeBuilder unlockedBy(String pName, Criterion<?> pCriterion) {
		this.recipeUnlockAdvancementBuilder.unlockedBy(pName, pCriterion);
		return this;
	}

	@Override
	public ResourceKey<Recipe<?>> defaultId() {
		return ResourceKey.create(Registries.RECIPE, this.result.typeHolder().unwrapKey().orElseThrow().identifier());
	}

	public static ItemConcoctingRecipeBuilder itemConcocting(RecipeCategory pRecipeCategory, ItemStackTemplate pResult, Ingredient pIngredient, int pColour, int pTime) {
		return new ItemConcoctingRecipeBuilder(pColour, pTime, pIngredient, pResult, pRecipeCategory);
	}
}
