package com.axanthic.icaria.common.recipe.serializer;

import com.axanthic.icaria.common.recipe.ConcoctingExplosionsRecipe;

import com.google.gson.JsonObject;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ConcoctingExplosionsRecipeSerializer implements RecipeSerializer<ConcoctingExplosionsRecipe> {
    @Override
    public ConcoctingExplosionsRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
        float radius = GsonHelper.getAsFloat(pSerializedRecipe, "radius");
        int burnTime = GsonHelper.getAsInt(pSerializedRecipe, "burnTime");
        int color = GsonHelper.getAsInt(pSerializedRecipe, "color");
        var ingredients = NonNullList.withSize(3, Ingredient.EMPTY);
        for (int i = 0; i < ingredients.size(); i++) {
            ingredients.set(i, Ingredient.fromJson(GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients").get(i)));
        }

        return new ConcoctingExplosionsRecipe(radius, burnTime, color, ingredients, pRecipeId);
    }

    @Override
    public ConcoctingExplosionsRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
        float radius = pBuffer.readFloat();
        int burnTime = pBuffer.readInt();
        int color = pBuffer.readInt();
        var ingredients = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);
        for (int i = 0; i < ingredients.size(); i++) {
            ingredients.set(i, Ingredient.fromNetwork(pBuffer));
        }

        return new ConcoctingExplosionsRecipe(radius, burnTime, color, ingredients, pRecipeId);
    }

    @Override
    public void toNetwork(FriendlyByteBuf pBuffer, ConcoctingExplosionsRecipe pRecipe) {
        pBuffer.writeFloat(pRecipe.radius);
        pBuffer.writeInt(pRecipe.burnTime);
        pBuffer.writeInt(pRecipe.color);
        pBuffer.writeInt(pRecipe.getIngredients().size());
        for (var ingredient : pRecipe.getIngredients()) {
            ingredient.toNetwork(pBuffer);
        }
    }
}
