package com.axanthic.icaria.common.recipe.builder;

import com.axanthic.icaria.common.recipe.ItemConcoctingRecipe;

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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ItemConcoctingRecipeBuilder implements RecipeBuilder {
	public int amount;
	public int colour;
	public int time;

	public Ingredient ingredient;

	public ItemLike result;

	public Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

	public RecipeCategory recipeCategory;

	public ItemConcoctingRecipeBuilder(int pAmount, int pColour, int pTime, Ingredient pIngredient, ItemLike pResult, RecipeCategory pRecipeCategory) {
		this.amount = pAmount;
		this.colour = pColour;
		this.time = pTime;
		this.ingredient = pIngredient;
		this.result = pResult;
		this.recipeCategory = pRecipeCategory;
	}

	@Override
	public void save(RecipeOutput pRecipeOutput, ResourceKey<Recipe<?>> pResourceKey) {
		var builder = pRecipeOutput.advancement().addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pResourceKey)).requirements(AdvancementRequirements.Strategy.OR).rewards(AdvancementRewards.Builder.recipe(pResourceKey));
		this.criteria.forEach(builder::addCriterion);
		pRecipeOutput.accept(pResourceKey, new ItemConcoctingRecipe(this.colour, this.time, this.ingredient, new ItemStack(this.result, this.amount)), builder.build(pResourceKey.location().withPrefix("recipes" + "/" + this.recipeCategory.getFolderName() + "/")));
	}

	@Override
	public Item getResult() {
		return this.result.asItem();
	}

	@Override
	public ItemConcoctingRecipeBuilder group(@Nullable String pName) {
		return this;
	}

	@Override
	public ItemConcoctingRecipeBuilder unlockedBy(String pName, Criterion<?> pCriterion) {
		this.criteria.put(pName, pCriterion);
		return this;
	}

	public static ItemConcoctingRecipeBuilder itemConcocting(RecipeCategory pRecipeCategory, ItemLike pResult, Ingredient pIngredient, int pAmount, int pColour, int pTime) {
		return new ItemConcoctingRecipeBuilder(pAmount, pColour, pTime, pIngredient, pResult, pRecipeCategory);
	}
}
