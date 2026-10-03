package com.axanthic.icaria.common.recipe.builder;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.recipe.PotionConcoctingRecipe;

import javax.annotation.Nullable;

import net.minecraft.advancements.triggers.Criterion;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeUnlockAdvancementBuilder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class PotionConcoctingRecipeBuilder implements RecipeBuilder {
	public float radius;

	public int colour;
	public int duration;
	public int time;

	public Ingredient ingredient;

	public PotionContents potionContents;

	public RecipeCategory recipeCategory;

	public RecipeUnlockAdvancementBuilder recipeUnlockAdvancementBuilder = new RecipeUnlockAdvancementBuilder();

	public PotionConcoctingRecipeBuilder(float pRadius, int pColour, int pDuration, int pTime, Ingredient pIngredient, PotionContents pPotionContents, RecipeCategory pRecipeCategory) {
		this.radius = pRadius;
		this.colour = pColour;
		this.duration = pDuration;
		this.time = pTime;
		this.ingredient = pIngredient;
		this.potionContents = pPotionContents;
		this.recipeCategory = pRecipeCategory;
	}

	@Override
	public void save(RecipeOutput pRecipeOutput, ResourceKey<Recipe<?>> pResourceKey) {
		pRecipeOutput.accept(pResourceKey, new PotionConcoctingRecipe(this.radius, this.colour, this.duration, this.time, this.ingredient, this.potionContents), this.recipeUnlockAdvancementBuilder.build(pRecipeOutput, pResourceKey, this.recipeCategory));
	}

	@Override
	public PotionConcoctingRecipeBuilder group(@Nullable String pName) {
		return this;
	}

	@Override
	public PotionConcoctingRecipeBuilder unlockedBy(String pName, Criterion<?> pCriterion) {
		this.recipeUnlockAdvancementBuilder.unlockedBy(pName, pCriterion);
		return this;
	}

	@Override
	public ResourceKey<Recipe<?>> defaultId() {
		return ResourceKey.create(Registries.RECIPE, this.potionContents.potion().orElseThrow().unwrapKey().orElseThrow().identifier());
	}

	public static PotionConcoctingRecipeBuilder potionConcocting(RecipeCategory pRecipeCategory, PotionContents pPotionContents, Ingredient pIngredient, float pRadius, int pColour, int pDuration, int pTime) {
		return new PotionConcoctingRecipeBuilder(pRadius, pColour, pDuration, pTime, pIngredient, pPotionContents, pRecipeCategory);
	}
}
