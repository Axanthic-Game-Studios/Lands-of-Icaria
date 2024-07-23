package com.axanthic.icaria.common.recipe.builder;

import com.axanthic.icaria.common.recipe.ConcoctingPotionRecipe;
import com.axanthic.icaria.common.recipe.helper.IcariaRecipeHelper;

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
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ConcoctingPotionRecipeBuilder implements RecipeBuilder {
	public float potionRadius;

	public int burnTime;
	public int color;
	public int potionDuration;

	public RecipeCategory category;

	public Ingredient ingredientA;
	public Ingredient ingredientB;
	public Ingredient ingredientC;

	public Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

	public PotionContents potion;

	public ConcoctingPotionRecipeBuilder(float pPotionRadius, int pBurnTime, int pColor, int pPotionDuration, Ingredient pIngredientA, Ingredient pIngredientB, Ingredient pIngredientC, PotionContents pPotion, RecipeCategory pCategory) {
		this.potionRadius = pPotionRadius;
		this.burnTime = pBurnTime;
		this.color = pColor;
		this.potionDuration = pPotionDuration;
		this.ingredientA = pIngredientA;
		this.ingredientB = pIngredientB;
		this.ingredientC = pIngredientC;
		this.potion = pPotion;
		this.category = pCategory;
	}

	public static ConcoctingPotionRecipeBuilder concoctingPotion(RecipeCategory pCategory, PotionContents pPotion, Ingredient pIngredientA, Ingredient pIngredientB, Ingredient pIngredientC, float pPotionRadius, int pBurnTime, int pColor, int pPotionDuration) {
		return new ConcoctingPotionRecipeBuilder(pPotionRadius, pBurnTime, pColor, pPotionDuration, pIngredientA, pIngredientB, pIngredientC, pPotion, pCategory);
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
		var recipe = new ConcoctingPotionRecipe(this.potionRadius, this.burnTime, this.color, this.potionDuration, IcariaRecipeHelper.helper(this.ingredientA, this.ingredientB, this.ingredientC), this.potion);
		pRecipeOutput.accept(pRecipeId, recipe, builder.build(pRecipeId.withPrefix("recipes" + "/" + this.category.getFolderName() + "/")));
	}

	@Override
	public ConcoctingPotionRecipeBuilder group(@Nullable String pGroupName) {
		return this;
	}

	@Override
	public ConcoctingPotionRecipeBuilder unlockedBy(String pName, Criterion<?> pCriterion) {
		this.criteria.put(pName, pCriterion);
		return this;
	}

	@Override
	public Item getResult() {
		return ItemStack.EMPTY.getItem();
	}
}
