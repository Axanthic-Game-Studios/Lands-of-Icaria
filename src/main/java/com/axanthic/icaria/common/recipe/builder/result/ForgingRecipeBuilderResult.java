package com.axanthic.icaria.common.recipe.builder.result;

import com.axanthic.icaria.common.registry.IcariaRecipeSerializers;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ForgingRecipeBuilderResult implements FinishedRecipe {
    public float experience;

    public int burnTime;
    public int count;

    public AdvancementHolder advancement;

    public Ingredient ingredientFirst;
    public Ingredient ingredientSecond;
    public Ingredient ingredientThird;

    public Item output;

    public ResourceLocation advancementId;
    public ResourceLocation id;

    public ForgingRecipeBuilderResult(float pExperience, int pBurnTime, int pCount, AdvancementHolder pAdvancement, Ingredient pIngredientFirst, Ingredient pIngredientSecond, Ingredient pIngredientThird, Item pOutput, ResourceLocation pAdvancementId, ResourceLocation pId) {
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

        jsonArray.add(this.ingredientFirst.toJson(true));
        jsonArray.add(this.ingredientSecond.toJson(true));
        jsonArray.add(this.ingredientThird.toJson(true));
        jsonObject.addProperty("Count", this.count);
        jsonObject.addProperty("id", BuiltInRegistries.ITEM.getKey(this.output).toString());

        pJson.addProperty("experience", this.experience);
        pJson.addProperty("burnTime", this.burnTime);
        pJson.add("ingredients", jsonArray);
        pJson.add("output", jsonObject);
    }

    @Override
    public RecipeSerializer<?> type() {
        return IcariaRecipeSerializers.FORGING.get();
    }

    @Override
    public AdvancementHolder advancement() {
        return this.advancement;
    }

    @Override
    public ResourceLocation id() {
        return this.id;
    }
}
