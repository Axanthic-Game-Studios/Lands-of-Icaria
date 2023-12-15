package com.axanthic.icaria.common.recipe.serializer;

import com.axanthic.icaria.common.recipe.ConcoctingEntityRecipe;

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

public class ConcoctingEntityRecipeSerializer implements RecipeSerializer<ConcoctingEntityRecipe> {
    @Override
    public ConcoctingEntityRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
        int burnTime = GsonHelper.getAsInt(pSerializedRecipe, "burnTime");
        int color = GsonHelper.getAsInt(pSerializedRecipe, "color");
        var entity = GsonHelper.getAsString(pSerializedRecipe, "entity");
        var ingredients = NonNullList.withSize(3, Ingredient.EMPTY);
        for (int i = 0; i < ingredients.size(); i++) {
            ingredients.set(i, Ingredient.fromJson(GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients").get(i)));
        }

        return new ConcoctingEntityRecipe(burnTime, color, ingredients, pRecipeId, entity);
    }

    @Override
    public ConcoctingEntityRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
        int burnTime = pBuffer.readInt();
        int color = pBuffer.readInt();
        var entity = pBuffer.readUtf();
        var ingredients = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);
        for (int i = 0; i < ingredients.size(); i++) {
            ingredients.set(i, Ingredient.fromNetwork(pBuffer));
        }

        return new ConcoctingEntityRecipe(burnTime, color, ingredients, pRecipeId, entity);
    }

    @Override
    public void toNetwork(FriendlyByteBuf pBuffer, ConcoctingEntityRecipe pRecipe) {
        pBuffer.writeInt(pRecipe.burnTime);
        pBuffer.writeInt(pRecipe.color);
        pBuffer.writeUtf(pRecipe.entity);
        pBuffer.writeInt(pRecipe.getIngredients().size());
        for (var ingredient : pRecipe.getIngredients()) {
            ingredient.toNetwork(pBuffer);
        }
    }
}
