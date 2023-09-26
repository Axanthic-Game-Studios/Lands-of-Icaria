package com.axanthic.icaria.common.recipe.builder.result;

import com.axanthic.icaria.common.registry.IcariaRecipeSerializers;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.Advancement;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ForgingRecipeBuilderResult implements FinishedRecipe {
    public float experience;

    public int burnTime;
    public int count;

    public Advancement.Builder advancement;

    public Ingredient ingredientFirst;
    public Ingredient ingredientSecond;
    public Ingredient ingredientThird;

    public Item output;

    public ResourceLocation advancementId;
    public ResourceLocation id;

    public ForgingRecipeBuilderResult(float pExperience, int pBurnTime, int pCount, Advancement.Builder pAdvancement, Ingredient pIngredientFirst, Ingredient pIngredientSecond, Ingredient pIngredientThird, Item pOutput, ResourceLocation pAdvancementId, ResourceLocation pId) {
        this.experience = pExperience;
        this.burnTime = pBurnTime;
        this.count = pCount;
        this.advancement = pAdvancement;
        this.ingredientFirst = pIngredientFirst;
        this.ingredientSecond = pIngredientSecond;
        this.ingredientThird = pIngredientThird;
        this.output = pOutput;
        this.advancementId = pAdvancementId;
        this.id = pId;
    }

    @Override
    public void serializeRecipeData(JsonObject pJson) {
        var jsonArray = new JsonArray();
        var jsonObject = new JsonObject();

        jsonArray.add(this.ingredientFirst.toJson());
        jsonArray.add(this.ingredientSecond.toJson());
        jsonArray.add(this.ingredientThird.toJson());
        jsonObject.addProperty("count", this.count);
        jsonObject.addProperty("item", ForgeRegistries.ITEMS.getKey(this.output).toString());

        pJson.addProperty("experience", this.experience);
        pJson.addProperty("burnTime", this.burnTime);
        pJson.add("ingredients", jsonArray);
        pJson.add("output", jsonObject);
    }

    @Override
    public JsonObject serializeAdvancement() {
        return this.advancement.serializeToJson();
    }

    @Override
    public RecipeSerializer<?> getType() {
        return IcariaRecipeSerializers.FORGING.get();
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
