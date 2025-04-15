package com.axanthic.icaria.common.recipe.builder;

import com.axanthic.icaria.common.recipe.EntityConcoctingRecipe;

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
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class EntityConcoctingRecipeBuilder implements RecipeBuilder {
	public int colour;
	public int time;

	public Ingredient ingredient;

	public Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

	public String entity;

	public RecipeCategory recipeCategory;

	public EntityConcoctingRecipeBuilder(int pColour, int pTime, Ingredient pIngredient, String pEntity, RecipeCategory pRecipeCategory) {
		this.colour = pColour;
		this.time = pTime;
		this.ingredient = pIngredient;
		this.entity = pEntity;
		this.recipeCategory = pRecipeCategory;
	}

	@Override
	public void save(RecipeOutput pRecipeOutput, ResourceKey<Recipe<?>> pResourceKey) {
		var builder = pRecipeOutput.advancement().addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pResourceKey)).requirements(AdvancementRequirements.Strategy.OR).rewards(AdvancementRewards.Builder.recipe(pResourceKey));
		this.criteria.forEach(builder::addCriterion);
		pRecipeOutput.accept(pResourceKey, new EntityConcoctingRecipe(this.colour, this.time, this.ingredient, this.entity), builder.build(pResourceKey.location().withPrefix("recipes" + "/" + this.recipeCategory.getFolderName() + "/")));
	}

	@Override
	public Item getResult() {
		return Items.AIR;
	}

	@Override
	public EntityConcoctingRecipeBuilder group(@Nullable String pName) {
		return this;
	}

	@Override
	public EntityConcoctingRecipeBuilder unlockedBy(String pName, Criterion<?> pCriterion) {
		this.criteria.put(pName, pCriterion);
		return this;
	}

	public static EntityConcoctingRecipeBuilder entityConcocting(RecipeCategory pRecipeCategory, String pEntity, Ingredient pIngredient, int pColour, int pTime) {
		return new EntityConcoctingRecipeBuilder(pColour, pTime, pIngredient, pEntity, pRecipeCategory);
	}
}
