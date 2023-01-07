package com.axanthic.icaria.common.recipe;

import java.util.function.Consumer;

import com.axanthic.icaria.common.registry.IcariaRecipeTypes;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

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

public class GrinderRecipeBuilder implements RecipeBuilder {

	private final Item result;
	private final int count;
	private final Ingredient gear;
	private final Ingredient ingredient;
	private final int burnTime;
	
	private final Advancement.Builder advancement = Advancement.Builder.advancement();

	public GrinderRecipeBuilder(ItemLike gear, Ingredient ingredient, ItemLike result, int count,int burnTime) {
		this.result = result.asItem();
		this.count = count;
		this.gear = Ingredient.of(gear);
		this.ingredient = ingredient;
		this.burnTime = burnTime;
	}
	
	public static GrinderRecipeBuilder grind(ItemLike gear, Ingredient ingredient, ItemLike result, int count) {
		return new GrinderRecipeBuilder(gear, ingredient, result, count,200);
	}
	
	public static GrinderRecipeBuilder grind(ItemLike gear, Ingredient ingredient, ItemLike result, int count,int burnTime) {
		return new GrinderRecipeBuilder(gear, ingredient, result, count,burnTime);
	}

	public GrinderRecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
		this.advancement.addCriterion(pCriterionName, pCriterionTrigger);
		return this;
	}

	public GrinderRecipeBuilder group(String pGroupName) {
		return this;
	}

	public Item getResult() {
		return this.result;
	}

	public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ResourceLocation pRecipeId) {
		this.ensureValid(pRecipeId);
		this.advancement.parent(ROOT_RECIPE_ADVANCEMENT)
				.addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pRecipeId))
				.rewards(AdvancementRewards.Builder.recipe(pRecipeId)).requirements(RequirementsStrategy.OR);
		
		pFinishedRecipeConsumer.accept(new Result(pRecipeId, this.result, this.count,this.ingredient, this.gear, this.burnTime, this.advancement,
				new ResourceLocation(pRecipeId.getNamespace(),"recipes/" + this.result.getItemCategory().getRecipeFolderName() + "/" + pRecipeId.getPath())));
	}

	private void ensureValid(ResourceLocation Id) {
		if (this.advancement.getCriteria().isEmpty()) {
			throw new IllegalStateException("No way of obtaining recipe " + Id);
		}
	}

	public static class Result implements FinishedRecipe {

		private final ResourceLocation id;
		private final Item result;
		private final int count;
		private final Ingredient ingredient;
		private final Ingredient gear;
		private final int burnTime;
		
		private final Advancement.Builder advancement;
		private final ResourceLocation advancementId;

		public Result(ResourceLocation pId, Item pResult, int pCount, Ingredient ingredient,
				Ingredient gear, int burnTime, Advancement.Builder pAdvancement, ResourceLocation pAdvancementId) {
			this.id = pId;
			this.result = pResult;
			this.count = pCount;
			this.ingredient = ingredient;
			this.gear = gear;
			this.burnTime = burnTime;
			this.advancement = pAdvancement;
			this.advancementId = pAdvancementId;
		}

		@Override
		public void serializeRecipeData(JsonObject pJson) {
			
			JsonArray jsonarray = new JsonArray();
			jsonarray.add(ingredient.toJson());
			
			pJson.add("ingredients", jsonarray);

			JsonObject jsonobject = new JsonObject();
			jsonobject.addProperty("item", ForgeRegistries.ITEMS.getKey(result).toString());
			if (this.count > 1) {
				jsonobject.addProperty("count", this.count);
			}

			pJson.add("output", jsonobject);

			pJson.add("gear", gear.toJson());

			pJson.addProperty("burnTime", burnTime);
		}

		@Override
		public ResourceLocation getId() {
			return id;
		}

		@Override
		public RecipeSerializer<?> getType() {
			return IcariaRecipeTypes.GRINDER_SERIALIZER.get();
		}

		@Override
		public JsonObject serializeAdvancement() {
			return advancement.serializeToJson();
		}

		@Override
		public ResourceLocation getAdvancementId() {
			return advancementId;
		}

	}

}
