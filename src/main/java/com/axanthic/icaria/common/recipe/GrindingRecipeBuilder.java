package com.axanthic.icaria.common.recipe;

import com.axanthic.icaria.common.registry.IcariaRecipeTypes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

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
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;

import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;
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

	public Item result;

	public GrindingRecipeBuilder(ItemLike pGear, Ingredient pIngredient, ItemLike pResult, int pCount, int pBurnTime) {
		this.gear = Ingredient.of(pGear);
		this.ingredient = pIngredient;
		this.result = pResult.asItem();
		this.count = pCount;
		this.burnTime = pBurnTime;
	}

	public static GrindingRecipeBuilder grinding(ItemLike pGear, Ingredient pIngredient, ItemLike pResult, int pCount, int pBurnTime) {
		return new GrindingRecipeBuilder(pGear, pIngredient, pResult, pCount, pBurnTime);
	}

	@Override
	public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ResourceLocation pRecipeId) {
		this.advancement.parent(ROOT_RECIPE_ADVANCEMENT).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pRecipeId)).rewards(AdvancementRewards.Builder.recipe(pRecipeId)).requirements(RequirementsStrategy.OR);
		this.ensureValid(pRecipeId);
		pFinishedRecipeConsumer.accept(new Result(pRecipeId, this.result, this.count, this.ingredient, this.gear, this.burnTime, this.advancement, new ResourceLocation(pRecipeId.getNamespace(),"recipes/" + pRecipeId.getPath())));
	}

	public void ensureValid(ResourceLocation pId) {
		if (this.advancement.getCriteria().isEmpty()) {
			throw new IllegalStateException("No way of obtaining recipe " + pId);
		}
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
		return this.result;
	}

	public static class Result implements FinishedRecipe {
		public int burnTime;
		public int count;

		public Advancement.Builder advancement;

		public Ingredient ingredient;
		public Ingredient gear;

		public Item result;

		public ResourceLocation advancementId;
		public ResourceLocation id;

		public Result(ResourceLocation pId, Item pResult, int pCount, Ingredient pIngredient, Ingredient pGear, int pBurnTime, Advancement.Builder pAdvancement, ResourceLocation pAdvancementId) {
			this.id = pId;
			this.result = pResult;
			this.count = pCount;
			this.ingredient = pIngredient;
			this.gear = pGear;
			this.burnTime = pBurnTime;
			this.advancement = pAdvancement;
			this.advancementId = pAdvancementId;
		}

		@Override
		public void serializeRecipeData(JsonObject pJson) {
			JsonArray jsonArray = new JsonArray();
			JsonObject jsonObject = new JsonObject();

			jsonArray.add(this.ingredient.toJson());

			if (this.count > 1) {
				jsonObject.addProperty("count", this.count);
			}

			jsonObject.addProperty("item", Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(this.result)).toString());

			pJson.addProperty("burnTime", this.burnTime);
			pJson.add("gear", this.gear.toJson());
			pJson.add("ingredients", jsonArray);
			pJson.add("result", jsonObject);
		}

		@Override
		public JsonObject serializeAdvancement() {
			return this.advancement.serializeToJson();
		}

		@Override
		public RecipeSerializer<?> getType() {
			return IcariaRecipeTypes.GRINDING_RECIPE.get();
		}

		@Override
		public ResourceLocation getAdvancementId() {
			return this.advancementId;
		}

		@Override
		public ResourceLocation getId() {
			return this.id;
		}
	}
}
