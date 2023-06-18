package com.axanthic.icaria.common.recipe;

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
    public static final GrindingRecipeSerializer INSTANCE = new GrindingRecipeSerializer();

    @Override
    public GrindingRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
        int burnTime = pSerializedRecipe.get("burnTime").getAsInt();
        var gear = Ingredient.fromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "gear"));
        var result = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "result"));
        var ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients");
        var inputs = NonNullList.withSize(1, Ingredient.EMPTY);
        for (int i = 0; i < inputs.size(); i++) {
            inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
        }

        return new GrindingRecipe(pRecipeId, result, inputs, gear, burnTime);
    }

    @Override
    public GrindingRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
        int burnTime = pBuffer.readInt();
        var ingredients = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);
        var result = pBuffer.readItem();
        var gear = Ingredient.fromNetwork(pBuffer);
        ingredients.replaceAll(pIngredient -> Ingredient.fromNetwork(pBuffer));
        return new GrindingRecipe(pRecipeId, result, ingredients, gear, burnTime);
    }

    @Override
    public void toNetwork(FriendlyByteBuf pBuffer, GrindingRecipe pRecipe) {
        pBuffer.writeInt(pRecipe.burnTime);
        pBuffer.writeInt(pRecipe.getIngredients().size());
        pBuffer.writeItemStack(pRecipe.result.copy(), false);
        pRecipe.gear.toNetwork(pBuffer);
        for (Ingredient ingredient : pRecipe.getIngredients()) {
            ingredient.toNetwork(pBuffer);
        }
    }
}
