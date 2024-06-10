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

public class ConcoctingItemRecipeBuilderResult implements FinishedRecipe {
    public int burnTime;
    public int color;
    public int count;

    public AdvancementHolder advancement;

    public Ingredient ingredientA;
    public Ingredient ingredientB;
    public Ingredient ingredientC;

    public Item output;

    public ResourceLocation advancementId;
    public ResourceLocation id;

    public ConcoctingItemRecipeBuilderResult(int pBurnTime, int pColor, int pCount, AdvancementHolder pAdvancement, Ingredient pIngredientA, Ingredient pIngredientB, Ingredient pIngredientC, Item pOutput, ResourceLocation pAdvancementId, ResourceLocation pId) {
        this.burnTime = pBurnTime;
        this.color = pColor;
        this.count = pCount;
        this.advancement = pAdvancement;
        this.ingredientA = pIngredientA;
        this.ingredientB = pIngredientB;
        this.ingredientC = pIngredientC;
        this.output = pOutput;
        this.advancementId = pAdvancementId;
        this.id = pId;
    }

    @Override
    public void serializeRecipeData(JsonObject pJson) {
        var jsonArray = new JsonArray();
        var jsonObject = new JsonObject();

        jsonArray.add(this.ingredientA.toJson(true));
        jsonArray.add(this.ingredientB.toJson(true));
        jsonArray.add(this.ingredientC.toJson(true));

        jsonObject.addProperty("Count", this.count);
        jsonObject.addProperty("id", BuiltInRegistries.ITEM.getKey(this.output).toString());

        pJson.addProperty("burnTime", this.burnTime);
        pJson.addProperty("color", this.color);

        pJson.add("ingredients", jsonArray);
        pJson.add("output", jsonObject);
    }

    @Override
    public RecipeSerializer<?> type() {
        return IcariaRecipeSerializers.CONCOCTING_ITEM.get();
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
