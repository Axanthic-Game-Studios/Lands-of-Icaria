package com.axanthic.icaria.common.recipe.serializer;

import com.axanthic.icaria.common.recipe.ConcoctingExplosionsRecipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ConcoctingExplosionsRecipeSerializer implements RecipeSerializer<ConcoctingExplosionsRecipe> {
    public static final Codec<ConcoctingExplosionsRecipe> CODEC = RecordCodecBuilder.create(
        instance -> instance.group(
            Codec.FLOAT.fieldOf("radius").forGetter(recipe -> recipe.radius),
            Codec.INT.fieldOf("burnTime").forGetter(recipe -> recipe.burnTime),
            Codec.INT.fieldOf("color").forGetter(recipe -> recipe.color),
            Ingredient.LIST_CODEC_NONEMPTY.fieldOf("ingredients").forGetter(recipe -> recipe.ingredients)
        ).apply(instance, ConcoctingExplosionsRecipe::new)
    );

    @Override
    public Codec<ConcoctingExplosionsRecipe> codec() {
        return CODEC;
    }

    @Override
    public ConcoctingExplosionsRecipe fromNetwork(FriendlyByteBuf pBuffer) {
        float radius = pBuffer.readFloat();
        int burnTime = pBuffer.readInt();
        int color = pBuffer.readInt();
        var ingredients = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);
        for (int i = 0; i < ingredients.size(); i++) {
            ingredients.set(i, Ingredient.fromNetwork(pBuffer));
        }

        return new ConcoctingExplosionsRecipe(radius, burnTime, color, ingredients);
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
