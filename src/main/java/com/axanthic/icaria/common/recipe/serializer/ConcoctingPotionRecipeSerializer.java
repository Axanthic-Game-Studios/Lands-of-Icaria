package com.axanthic.icaria.common.recipe.serializer;

import com.axanthic.icaria.common.recipe.ConcoctingPotionRecipe;

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

public class ConcoctingPotionRecipeSerializer implements RecipeSerializer<ConcoctingPotionRecipe> {
    @Override
    public ConcoctingPotionRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
        float potionRadius = GsonHelper.getAsFloat(pSerializedRecipe, "potionRadius");
        int burnTime = GsonHelper.getAsInt(pSerializedRecipe, "burnTime");
        int color = GsonHelper.getAsInt(pSerializedRecipe, "color");
        int potionDuration = GsonHelper.getAsInt(pSerializedRecipe, "potionDuration");
        var potion = GsonHelper.getAsString(pSerializedRecipe, "potion");
        var ingredients = NonNullList.withSize(3, Ingredient.EMPTY);
        for (int i = 0; i < ingredients.size(); i++) {
            ingredients.set(i, Ingredient.fromJson(GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients").get(i)));
        }

        return new ConcoctingPotionRecipe(potionRadius, burnTime, color, potionDuration, ingredients, pRecipeId, potion);
    }

    @Override
    public ConcoctingPotionRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
        float potionRadius = pBuffer.readFloat();
        int burnTime = pBuffer.readInt();
        int color = pBuffer.readInt();
        int potionDuration = pBuffer.readInt();
        var potion = pBuffer.readUtf();
        var ingredients = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);
        for (int i = 0; i < ingredients.size(); i++) {
            ingredients.set(i, Ingredient.fromNetwork(pBuffer));
        }

        return new ConcoctingPotionRecipe(potionRadius, burnTime, color, potionDuration, ingredients, pRecipeId, potion);
    }

    @Override
    public void toNetwork(FriendlyByteBuf pBuffer, ConcoctingPotionRecipe pRecipe) {
        pBuffer.writeFloat(pRecipe.potionRadius);
        pBuffer.writeInt(pRecipe.burnTime);
        pBuffer.writeInt(pRecipe.color);
        pBuffer.writeInt(pRecipe.potionDuration);
        pBuffer.writeUtf(pRecipe.potion);
        pBuffer.writeInt(pRecipe.getIngredients().size());
        for (var ingredient : pRecipe.getIngredients()) {
            ingredient.toNetwork(pBuffer);
        }
    }
}
