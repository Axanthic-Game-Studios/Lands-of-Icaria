package com.axanthic.icaria.common.recipe.builder;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.recipe.ExplosionConcoctingRecipe;
import com.axanthic.icaria.common.registry.IcariaIds;

import javax.annotation.Nullable;

import net.minecraft.advancements.triggers.Criterion;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeUnlockAdvancementBuilder;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ExplosionConcoctingRecipeBuilder implements RecipeBuilder {
	public float radius;

	public int colour;
	public int time;

	public Ingredient ingredient;

	public RecipeCategory recipeCategory;

	public RecipeUnlockAdvancementBuilder recipeUnlockAdvancementBuilder = new RecipeUnlockAdvancementBuilder();

	public ExplosionConcoctingRecipeBuilder(float pRadius, int pColour, int pTime, Ingredient pIngredient, RecipeCategory pRecipeCategory) {
		this.radius = pRadius;
		this.colour = pColour;
		this.time = pTime;
		this.ingredient = pIngredient;
		this.recipeCategory = pRecipeCategory;
	}

	@Override
	public void save(RecipeOutput pRecipeOutput, ResourceKey<Recipe<?>> pResourceKey) {
		pRecipeOutput.accept(pResourceKey, new ExplosionConcoctingRecipe(this.radius, this.colour, this.time, this.ingredient), this.recipeUnlockAdvancementBuilder.build(pRecipeOutput, pResourceKey, this.recipeCategory));
	}

	@Override
	public ExplosionConcoctingRecipeBuilder group(@Nullable String pName) {
		return this;
	}

	@Override
	public ExplosionConcoctingRecipeBuilder unlockedBy(String pName, Criterion<?> pCriterion) {
		this.recipeUnlockAdvancementBuilder.unlockedBy(pName, pCriterion);
		return this;
	}

	@Override
	public ResourceKey<Recipe<?>> defaultId() {
		return ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(IcariaIds.ID, "explosion"));
	}

	public static ExplosionConcoctingRecipeBuilder explosionConcocting(RecipeCategory pRecipeCategory, Ingredient pIngredient, float pRadius, int pColour, int pTime) {
		return new ExplosionConcoctingRecipeBuilder(pRadius, pColour, pTime, pIngredient, pRecipeCategory);
	}
}
