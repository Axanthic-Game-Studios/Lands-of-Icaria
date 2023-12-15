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

public class ConcoctingItemRecipeBuilderResult implements FinishedRecipe {
    public int burnTime;
    public int color;
    public int count;

    public Advancement.Builder advancement;

    public Ingredient ingredientA;
    public Ingredient ingredientB;
    public Ingredient ingredientC;

    public Item output;

    public ResourceLocation advancementId;
    public ResourceLocation id;

    public ConcoctingItemRecipeBuilderResult(int pBurnTime, int pColor, int pCount, Advancement.Builder pAdvancement, Ingredient pIngredientA, Ingredient pIngredientB, Ingredient pIngredientC, Item pOutput, ResourceLocation pAdvancementId, ResourceLocation pId) {
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

        jsonArray.add(this.ingredientA.toJson());
        jsonArray.add(this.ingredientB.toJson());
        jsonArray.add(this.ingredientC.toJson());

        jsonObject.addProperty("count", this.count);
        jsonObject.addProperty("item", ForgeRegistries.ITEMS.getKey(this.output).toString());

        pJson.addProperty("burnTime", this.burnTime);
        pJson.addProperty("color", this.color);

        pJson.add("ingredients", jsonArray);
        pJson.add("output", jsonObject);
    }

    @Override
    public JsonObject serializeAdvancement() {
        return this.advancement.serializeToJson();
    }

    @Override
    public RecipeSerializer<?> getType() {
        return IcariaRecipeSerializers.CONCOCTING_ITEM.get();
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
