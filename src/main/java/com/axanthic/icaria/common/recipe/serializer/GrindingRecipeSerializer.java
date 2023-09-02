package com.axanthic.icaria.common.recipe.serializer;

import com.axanthic.icaria.common.recipe.GrindingRecipe;

import com.google.gson.JsonObject;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrindingRecipeSerializer implements RecipeSerializer<GrindingRecipe> {
    @Override
    public GrindingRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
        float experience = GsonHelper.getAsFloat(pSerializedRecipe, "experience");
        int burnTime = pSerializedRecipe.get("burnTime").getAsInt();
        var gear = Ingredient.fromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "gear"));
        var output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "output"));
        var ingredients = NonNullList.withSize(1, Ingredient.EMPTY);
        for (int i = 0; i < ingredients.size(); i++) {
            ingredients.set(i, Ingredient.fromJson(GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients").get(i)));
        }

        return new GrindingRecipe(experience, burnTime, gear, ingredients, output, pRecipeId);
    }

    @Override
    public GrindingRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
        float experience = pBuffer.readFloat();
        int burnTime = pBuffer.readInt();
        var gear = Ingredient.fromNetwork(pBuffer);
        var output = pBuffer.readItem();
        var ingredients = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);
        for (int i = 0; i < ingredients.size(); i++) {
            ingredients.set(i, Ingredient.fromNetwork(pBuffer));
        }

        return new GrindingRecipe(experience, burnTime, gear, ingredients, output, pRecipeId);
    }

    @Override
    public void toNetwork(FriendlyByteBuf pBuffer, GrindingRecipe pRecipe) {
        pBuffer.writeFloat(pRecipe.experience);
        pBuffer.writeInt(pRecipe.burnTime);
        pRecipe.gear.toNetwork(pBuffer);
        pBuffer.writeItemStack(pRecipe.output.copy(), false);
        pBuffer.writeInt(pRecipe.getIngredients().size());
        for (var ingredient : pRecipe.getIngredients()) {
            ingredient.toNetwork(pBuffer);
        }
    }
}
