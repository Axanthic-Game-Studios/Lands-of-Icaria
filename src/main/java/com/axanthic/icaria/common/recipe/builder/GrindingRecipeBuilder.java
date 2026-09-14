package com.axanthic.icaria.common.recipe.builder;

import com.axanthic.icaria.common.recipe.GrindingRecipe;

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

public class GrindingRecipeBuilder implements RecipeBuilder {
	public float experience;

	public int time;

	public Ingredient gear;
	public Ingredient ingredient;

	public ItemStackTemplate result;

	public RecipeCategory recipeCategory;

	public RecipeUnlockAdvancementBuilder recipeUnlockAdvancementBuilder = new RecipeUnlockAdvancementBuilder();

	public GrindingRecipeBuilder(float pExperience, int pTime, Ingredient pGear, Ingredient pIngredient, ItemStackTemplate pResult, RecipeCategory pRecipeCategory) {
		this.experience = pExperience;
		this.time = pTime;
		this.gear = pGear;
		this.ingredient = pIngredient;
		this.result = pResult;
		this.recipeCategory = pRecipeCategory;
	}

	@Override
	public void save(RecipeOutput pRecipeOutput, ResourceKey<Recipe<?>> pResourceKey) {
		pRecipeOutput.accept(pResourceKey, new GrindingRecipe(this.experience, this.time, this.gear, this.ingredient, this.result), this.recipeUnlockAdvancementBuilder.build(pRecipeOutput, pResourceKey, this.recipeCategory));
	}

	@Override
	public GrindingRecipeBuilder group(@Nullable String pName) {
		return this;
	}

	@Override
	public GrindingRecipeBuilder unlockedBy(String pName, Criterion<?> pCriterion) {
		this.recipeUnlockAdvancementBuilder.unlockedBy(pName, pCriterion);
		return this;
	}

	@Override
	public ResourceKey<Recipe<?>> defaultId() {
		return ResourceKey.create(Registries.RECIPE, this.result.typeHolder().unwrapKey().orElseThrow().identifier());
	}

	public static GrindingRecipeBuilder grinding(RecipeCategory pRecipeCategory, ItemStackTemplate pResult, Ingredient pGear, Ingredient pIngredient, float pExperience, int pTime) {
		return new GrindingRecipeBuilder(pExperience, pTime, pGear, pIngredient, pResult, pRecipeCategory);
	}
}
