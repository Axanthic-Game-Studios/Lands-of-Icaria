package com.axanthic.icaria.common.recipe.serializer;

import com.axanthic.icaria.common.recipe.ConcoctingItemRecipe;

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

public class ConcoctingItemRecipeSerializer implements RecipeSerializer<ConcoctingItemRecipe> {
    @Override
    public ConcoctingItemRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
        int burnTime = GsonHelper.getAsInt(pSerializedRecipe, "burnTime");
        int color = GsonHelper.getAsInt(pSerializedRecipe, "color");
        var output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "output"));
        var ingredients = NonNullList.withSize(3, Ingredient.EMPTY);
        for (int i = 0; i < ingredients.size(); i++) {
            ingredients.set(i, Ingredient.fromJson(GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients").get(i)));
        }

        return new ConcoctingItemRecipe(burnTime, color, output, ingredients, pRecipeId);
    }

    @Override
    public ConcoctingItemRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
        int burnTime = pBuffer.readInt();
        int color = pBuffer.readInt();
        var output = pBuffer.readItem();
        var ingredients = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);
        for (int i = 0; i < ingredients.size(); i++) {
            ingredients.set(i, Ingredient.fromNetwork(pBuffer));
        }

        return new ConcoctingItemRecipe(burnTime, color, output, ingredients, pRecipeId);
    }

    @Override
    public void toNetwork(FriendlyByteBuf pBuffer, ConcoctingItemRecipe pRecipe) {
        pBuffer.writeInt(pRecipe.burnTime);
        pBuffer.writeInt(pRecipe.color);
        pBuffer.writeItemStack(pRecipe.getResultItem(null), false);
        pBuffer.writeInt(pRecipe.getIngredients().size());
        for (var ingredient : pRecipe.getIngredients()) {
            ingredient.toNetwork(pBuffer);
        }
    }
}
