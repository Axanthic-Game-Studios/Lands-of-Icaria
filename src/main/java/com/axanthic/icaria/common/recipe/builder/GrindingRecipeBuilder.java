package com.axanthic.icaria.common.recipe.builder;

import com.axanthic.icaria.common.recipe.builder.result.GrindingRecipeBuilderResult;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrindingRecipeBuilder implements RecipeBuilder {
	public int burnTime;
	public int count;

	public Advancement.Builder advancement = Advancement.Builder.advancement();

	public Ingredient gear;
	public Ingredient ingredient;

	public Item output;

	public GrindingRecipeBuilder(int pBurnTime, int pCount, ItemLike pGear, Ingredient pIngredient, ItemLike pOutput) {
		this.burnTime = pBurnTime;
		this.count = pCount;
		this.gear = Ingredient.of(pGear);
		this.ingredient = pIngredient;
		this.output = pOutput.asItem();
	}

	public static GrindingRecipeBuilder grinding(ItemLike pGear, Ingredient pIngredient, ItemLike pOutput, int pBurnTime, int pCount) {
		return new GrindingRecipeBuilder(pBurnTime, pCount, pGear, pIngredient, pOutput);
	}

	public void ensureValid(ResourceLocation pId) {
		if (this.advancement.getCriteria().isEmpty()) {
			throw new IllegalStateException("No way of obtaining recipe " + pId);
		}
	}

	@Override
	public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ResourceLocation pRecipeId) {
		this.advancement.addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pRecipeId)).parent(RecipeBuilder.ROOT_RECIPE_ADVANCEMENT).requirements(RequirementsStrategy.OR).rewards(AdvancementRewards.Builder.recipe(pRecipeId));
		this.ensureValid(pRecipeId);
		pFinishedRecipeConsumer.accept(new GrindingRecipeBuilderResult(this.burnTime, this.count, this.advancement, this.gear, this.ingredient, this.output, new ResourceLocation(pRecipeId.getNamespace(),"recipes/" + pRecipeId.getPath()), pRecipeId));
	}

	@Override
	public GrindingRecipeBuilder group(@Nullable String pGroupName) {
		return this;
	}

	@Override
	public GrindingRecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
		this.advancement.addCriterion(pCriterionName, pCriterionTrigger);
		return this;
	}

	@Override
	public Item getResult() {
		return this.output;
	}
}
