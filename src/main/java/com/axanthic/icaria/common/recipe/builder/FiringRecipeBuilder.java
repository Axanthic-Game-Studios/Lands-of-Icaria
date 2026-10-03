package com.axanthic.icaria.common.recipe.builder;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.recipe.FiringRecipe;

import javax.annotation.Nullable;

import net.minecraft.advancements.triggers.Criterion;
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

public class FiringRecipeBuilder implements RecipeBuilder {
	public float experience;

	public int time;

	public Ingredient ingredient;

	public ItemStackTemplate result;

	public RecipeCategory recipeCategory;

	public RecipeUnlockAdvancementBuilder recipeUnlockAdvancementBuilder = new RecipeUnlockAdvancementBuilder();

	public FiringRecipeBuilder(float pExperience, int pTime, Ingredient pIngredient, ItemStackTemplate pResult, RecipeCategory pRecipeCategory) {
		this.experience = pExperience;
		this.time = pTime;
		this.ingredient = pIngredient;
		this.result = pResult;
		this.recipeCategory = pRecipeCategory;
	}

	@Override
	public void save(RecipeOutput pRecipeOutput, ResourceKey<Recipe<?>> pResourceKey) {
		pRecipeOutput.accept(pResourceKey, new FiringRecipe(this.experience, this.time, this.ingredient, this.result), this.recipeUnlockAdvancementBuilder.build(pRecipeOutput, pResourceKey, this.recipeCategory));
	}

	@Override
	public FiringRecipeBuilder group(@Nullable String pName) {
		return this;
	}

	@Override
	public FiringRecipeBuilder unlockedBy(String pName, Criterion<?> pCriterion) {
		this.recipeUnlockAdvancementBuilder.unlockedBy(pName, pCriterion);
		return this;
	}

	@Override
	public ResourceKey<Recipe<?>> defaultId() {
		return ResourceKey.create(Registries.RECIPE, this.result.typeHolder().unwrapKey().orElseThrow().identifier());
	}

	public static FiringRecipeBuilder firing(RecipeCategory pRecipeCategory, ItemStackTemplate pResult, Ingredient pIngredient, float pExperience, int pTime) {
		return new FiringRecipeBuilder(pExperience, pTime, pIngredient, pResult, pRecipeCategory);
	}
}
