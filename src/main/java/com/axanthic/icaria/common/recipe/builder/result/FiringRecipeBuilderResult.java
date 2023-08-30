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

public class FiringRecipeBuilderResult implements FinishedRecipe {
    public final float experience;

    public final int burnTime;

    public final Advancement.Builder advancement;

    public final Ingredient ingredient;

    public final Item output;

    public final ResourceLocation advancementId;
    public final ResourceLocation id;

    public FiringRecipeBuilderResult(float pExperience, int pBurnTime, Advancement.Builder pAdvancement, Ingredient pIngredient, Item pOutput, ResourceLocation pAdvancementId, ResourceLocation pId) {
        this.experience = pExperience;
        this.burnTime = pBurnTime;
        this.advancement = pAdvancement;
        this.ingredient = pIngredient;
        this.output = pOutput;
        this.advancementId = pAdvancementId;
        this.id = pId;
    }

    @Override
    public void serializeRecipeData(JsonObject pJson) {
        var jsonArray = new JsonArray();
        var jsonObject = new JsonObject();

        jsonArray.add(this.ingredient.toJson());
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
        return IcariaRecipeSerializers.FIRING.get();
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
