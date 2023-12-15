package com.axanthic.icaria.common.recipe.builder.result;

import com.axanthic.icaria.common.registry.IcariaRecipeSerializers;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.Advancement;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ConcoctingEntityRecipeBuilderResult implements FinishedRecipe {
    public int burnTime;
    public int color;

    public Advancement.Builder advancement;

    public Ingredient ingredientA;
    public Ingredient ingredientB;
    public Ingredient ingredientC;

    public ResourceLocation advancementId;
    public ResourceLocation id;

    public String entity;

    public ConcoctingEntityRecipeBuilderResult(int pBurnTime, int pColor, Advancement.Builder pAdvancement, Ingredient pIngredientA, Ingredient pIngredientB, Ingredient pIngredientC, ResourceLocation pAdvancementId, ResourceLocation pId, String pEntity) {
        this.burnTime = pBurnTime;
        this.color = pColor;
        this.advancement = pAdvancement;
        this.ingredientA = pIngredientA;
        this.ingredientB = pIngredientB;
        this.ingredientC = pIngredientC;
        this.advancementId = pAdvancementId;
        this.id = pId;
        this.entity = pEntity;
    }

    @Override
    public void serializeRecipeData(JsonObject pJson) {
        var jsonArray = new JsonArray();

        jsonArray.add(this.ingredientA.toJson());
        jsonArray.add(this.ingredientB.toJson());
        jsonArray.add(this.ingredientC.toJson());

        pJson.addProperty("burnTime", this.burnTime);
        pJson.addProperty("color", this.color);

        pJson.add("ingredients", jsonArray);

        pJson.addProperty("entity", this.entity);
    }

    @Override
    public JsonObject serializeAdvancement() {
        return this.advancement.serializeToJson();
    }

    @Override
    public RecipeSerializer<?> getType() {
        return IcariaRecipeSerializers.CONCOCTING_ENTITY.get();
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
