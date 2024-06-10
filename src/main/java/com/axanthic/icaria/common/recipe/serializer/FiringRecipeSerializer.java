package com.axanthic.icaria.common.recipe.serializer;

import com.axanthic.icaria.common.recipe.FiringRecipe;

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

public class FiringRecipeSerializer implements RecipeSerializer<FiringRecipe> {
    public static final Codec<FiringRecipe> CODEC = RecordCodecBuilder.create(
        instance -> instance.group(
            Codec.FLOAT.fieldOf("experience").forGetter(recipe -> recipe.experience),
            Codec.INT.fieldOf("burnTime").forGetter(recipe -> recipe.burnTime),
            Ingredient.LIST_CODEC_NONEMPTY.fieldOf("ingredients").forGetter(recipe -> recipe.ingredients),
            ItemStack.CODEC.fieldOf("output").forGetter(recipe -> recipe.output)
        ).apply(instance, FiringRecipe::new)
    );

    @Override
    public Codec<FiringRecipe> codec() {
        return CODEC;
    }

    @Override
    public FiringRecipe fromNetwork(FriendlyByteBuf pBuffer) {
        float experience = pBuffer.readFloat();
        int burnTime = pBuffer.readInt();
        var output = pBuffer.readItem();
        var ingredients = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);
        for (int i = 0; i < ingredients.size(); i++) {
            ingredients.set(i, Ingredient.fromNetwork(pBuffer));
        }

        return new FiringRecipe(experience, burnTime, ingredients, output);
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
