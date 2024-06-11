package com.axanthic.icaria.common.recipe.builder;

import com.axanthic.icaria.common.recipe.GrindingRecipe;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrindingRecipeBuilder implements RecipeBuilder {
	public float experience;

	public int burnTime;
	public int count;

	public RecipeCategory category;

	public Ingredient gear;
	public Ingredient ingredient;

	public Item output;

	public Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

	public GrindingRecipeBuilder(float pExperience, int pBurnTime, int pCount, ItemLike pGear, Ingredient pIngredient, ItemLike pOutput, RecipeCategory pCategory) {
		this.experience = pExperience;
		this.burnTime = pBurnTime;
		this.count = pCount;
		this.gear = Ingredient.of(pGear);
		this.ingredient = pIngredient;
		this.output = pOutput.asItem();
		this.category = pCategory;
	}

	public static GrindingRecipeBuilder grinding(RecipeCategory pCategory, ItemLike pGear, Ingredient pIngredient, ItemLike pOutput, float pExperience, int pBurnTime, int pCount) {
		return new GrindingRecipeBuilder(pExperience, pBurnTime, pCount, pGear, pIngredient, pOutput, pCategory);
	}

	public void ensureValid(ResourceLocation pId) {
		if (this.criteria.isEmpty()) {
			throw new IllegalStateException("No way of obtaining recipe " + pId);
		}
	}

	@Override
	public void save(RecipeOutput pRecipeOutput, ResourceLocation pRecipeId) {
		this.ensureValid(pRecipeId);
		var builder = pRecipeOutput.advancement().addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pRecipeId)).requirements(AdvancementRequirements.Strategy.OR).rewards(AdvancementRewards.Builder.recipe(pRecipeId));
		var recipe = new GrindingRecipe(this.experience, this.burnTime, this.gear, List.of(this.ingredient), new ItemStack(this.output, this.count));
		pRecipeOutput.accept(pRecipeId, recipe, builder.build(pRecipeId.withPrefix("recipes" + "/" + this.category.getFolderName() + "/")));
	}

	@Override
	public GrindingRecipeBuilder group(@Nullable String pGroupName) {
		return this;
	}

	@Override
	public GrindingRecipeBuilder unlockedBy(String pName, Criterion<?> pCriterion) {
		this.criteria.put(pName, pCriterion);
		return this;
	}

	@Override
	public Item getResult() {
		return this.output;
	}
}
