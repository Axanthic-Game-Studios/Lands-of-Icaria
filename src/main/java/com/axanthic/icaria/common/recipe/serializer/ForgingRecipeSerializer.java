package com.axanthic.icaria.common.recipe.serializer;

import com.axanthic.icaria.common.recipe.ForgingRecipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ForgingRecipeSerializer implements RecipeSerializer<ForgingRecipe> {
    public static final Codec<ForgingRecipe> CODEC = RecordCodecBuilder.create(
        instance -> instance.group(
            Codec.FLOAT.fieldOf("experience").forGetter(recipe -> recipe.experience),
            Codec.INT.fieldOf("burnTime").forGetter(recipe -> recipe.burnTime),
            Ingredient.LIST_CODEC.fieldOf("ingredients").forGetter(recipe -> recipe.ingredients),
            ItemStack.CODEC.fieldOf("output").forGetter(recipe -> recipe.output)
        ).apply(instance, ForgingRecipe::new)
    );

    @Override
    public Codec<ForgingRecipe> codec() {
        return CODEC;
    }

    @Override
    public ForgingRecipe fromNetwork(FriendlyByteBuf pBuffer) {
        float experience = pBuffer.readFloat();
        int burnTime = pBuffer.readInt();
        var output = pBuffer.readItem();
        var ingredients = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);
        for (int i = 0; i < ingredients.size(); i++) {
            ingredients.set(i, Ingredient.fromNetwork(pBuffer));
        }

        return new ForgingRecipe(experience, burnTime, ingredients, output);
    }

    @Override
    public void toNetwork(FriendlyByteBuf pBuffer, ForgingRecipe pRecipe) {
        pBuffer.writeFloat(pRecipe.experience);
        pBuffer.writeInt(pRecipe.burnTime);
        pBuffer.writeItem(pRecipe.getResultItem(null));
        pBuffer.writeInt(pRecipe.getIngredients().size());
        for (var ingredient : pRecipe.getIngredients()) {
            ingredient.toNetwork(pBuffer);
        }
    }
}
