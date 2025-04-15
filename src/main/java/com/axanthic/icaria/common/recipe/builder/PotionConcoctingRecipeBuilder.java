package com.axanthic.icaria.common.recipe.builder;

import com.axanthic.icaria.common.recipe.PotionConcoctingRecipe;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
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

	public Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

	public PotionContents potionContents;

	public RecipeCategory recipeCategory;

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
		var builder = pRecipeOutput.advancement().addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pResourceKey)).requirements(AdvancementRequirements.Strategy.OR).rewards(AdvancementRewards.Builder.recipe(pResourceKey));
		this.criteria.forEach(builder::addCriterion);
		pRecipeOutput.accept(pResourceKey, new PotionConcoctingRecipe(this.radius, this.colour, this.duration, this.time, this.ingredient, this.potionContents), builder.build(pResourceKey.location().withPrefix("recipes" + "/" + this.recipeCategory.getFolderName() + "/")));
	}

	@Override
	public Item getResult() {
		return Items.AIR;
	}

	@Override
	public PotionConcoctingRecipeBuilder group(@Nullable String pName) {
		return this;
	}

	@Override
	public PotionConcoctingRecipeBuilder unlockedBy(String pName, Criterion<?> pCriterion) {
		this.criteria.put(pName, pCriterion);
		return this;
	}

	public static PotionConcoctingRecipeBuilder potionConcocting(RecipeCategory pRecipeCategory, PotionContents pPotionContents, Ingredient pIngredient, float pRadius, int pColour, int pDuration, int pTime) {
		return new PotionConcoctingRecipeBuilder(pRadius, pColour, pDuration, pTime, pIngredient, pPotionContents, pRecipeCategory);
	}
}
