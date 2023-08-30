package com.axanthic.icaria.common.recipe.serializer;

import com.axanthic.icaria.common.recipe.FiringRecipe;

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

public class FiringRecipeSerializer implements RecipeSerializer<FiringRecipe> {
    @Override
    public FiringRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
        float experience = GsonHelper.getAsFloat(pSerializedRecipe, "experience");
        int burnTime = GsonHelper.getAsInt(pSerializedRecipe, "burnTime");
        var output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "output"));
        var ingredients = NonNullList.withSize(1, Ingredient.EMPTY);
        for (int i = 0; i < ingredients.size(); i++) {
            ingredients.set(i, Ingredient.fromJson(GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients").get(i)));
        }

        return new FiringRecipe(experience, burnTime, ingredients, output, pRecipeId);
    }

    @Override
    public FiringRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
        float experience = pBuffer.readFloat();
        int burnTime = pBuffer.readInt();
        var output = pBuffer.readItem();
        var ingredients = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);
        for (int i = 0; i < ingredients.size(); i++) {
            ingredients.set(i, Ingredient.fromNetwork(pBuffer));
        }

        return new FiringRecipe(experience, burnTime, ingredients, output, pRecipeId);
    }

    @Override
    public void toNetwork(FriendlyByteBuf pBuffer, FiringRecipe pRecipe) {
        pBuffer.writeFloat(pRecipe.experience);
        pBuffer.writeInt(pRecipe.burnTime);
        pBuffer.writeItemStack(pRecipe.getResultItem(null), false);
        pBuffer.writeInt(pRecipe.getIngredients().size());
        for (var ingredient : pRecipe.getIngredients()) {
            ingredient.toNetwork(pBuffer);
        }
    }
}
