package com.axanthic.icaria.common.recipe.builder;

import com.axanthic.icaria.common.recipe.GrillingRecipe;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.criterion.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrillingRecipeBuilder implements RecipeBuilder {
	public int amount;
	public int time;

	public Ingredient ingredient;

	public ItemLike result;

	public Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

	public RecipeCategory recipeCategory;

	public GrillingRecipeBuilder(int pAmount, int pTime, Ingredient pIngredient, ItemLike pResult, RecipeCategory pRecipeCategory) {
		this.amount = pAmount;
		this.time = pTime;
		this.ingredient = pIngredient;
		this.result = pResult;
		this.recipeCategory = pRecipeCategory;
	}

	@Override
	public void save(RecipeOutput pRecipeOutput, ResourceKey<Recipe<?>> pResourceKey) {
		var builder = pRecipeOutput.advancement().addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pResourceKey)).requirements(AdvancementRequirements.Strategy.OR).rewards(AdvancementRewards.Builder.recipe(pResourceKey));
		this.criteria.forEach(builder::addCriterion);
		pRecipeOutput.accept(pResourceKey, new GrillingRecipe(this.time, this.ingredient, new ItemStack(this.result, this.amount)), builder.build(pResourceKey.identifier().withPrefix("recipes" + "/" + this.recipeCategory.getFolderName() + "/")));
	}

	@Override
	public Item getResult() {
		return this.result.asItem();
	}

	@Override
	public GrillingRecipeBuilder group(@Nullable String pName) {
		return this;
	}

	@Override
	public GrillingRecipeBuilder unlockedBy(String pName, Criterion<?> pCriterion) {
		this.criteria.put(pName, pCriterion);
		return this;
	}

	public static GrillingRecipeBuilder grilling(RecipeCategory pRecipeCategory, ItemLike pResult, Ingredient pIngredient, int pAmount, int pTime) {
		return new GrillingRecipeBuilder(pAmount, pTime, pIngredient, pResult, pRecipeCategory);
	}
}
