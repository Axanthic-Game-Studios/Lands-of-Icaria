package com.axanthic.icaria.common.recipe.serializer;

import com.axanthic.icaria.common.recipe.ConcoctingItemRecipe;

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

public class ConcoctingItemRecipeSerializer implements RecipeSerializer<ConcoctingItemRecipe> {
    public static final Codec<ConcoctingItemRecipe> CODEC = RecordCodecBuilder.create(
        instance -> instance.group(
            Codec.INT.fieldOf("burnTime").forGetter(recipe -> recipe.burnTime),
            Codec.INT.fieldOf("color").forGetter(recipe -> recipe.color),
            ItemStack.CODEC.fieldOf("output").forGetter(recipe -> recipe.output),
            Ingredient.LIST_CODEC.fieldOf("ingredients").forGetter(recipe -> recipe.ingredients)
        ).apply(instance, ConcoctingItemRecipe::new)
    );

    @Override
    public Codec<ConcoctingItemRecipe> codec() {
        return CODEC;
    }

    @Override
    public ConcoctingItemRecipe fromNetwork(FriendlyByteBuf pBuffer) {
        int burnTime = pBuffer.readInt();
        int color = pBuffer.readInt();
        var output = pBuffer.readItem();
        var ingredients = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);
        for (int i = 0; i < ingredients.size(); i++) {
            ingredients.set(i, Ingredient.fromNetwork(pBuffer));
        }

        return new ConcoctingItemRecipe(burnTime, color, output, ingredients);
    }

    @Override
    public void toNetwork(FriendlyByteBuf pBuffer, ConcoctingItemRecipe pRecipe) {
        pBuffer.writeInt(pRecipe.burnTime);
        pBuffer.writeInt(pRecipe.color);
        pBuffer.writeItem(pRecipe.getResultItem(null));
        pBuffer.writeInt(pRecipe.getIngredients().size());
        for (var ingredient : pRecipe.getIngredients()) {
            ingredient.toNetwork(pBuffer);
        }
    }
}
