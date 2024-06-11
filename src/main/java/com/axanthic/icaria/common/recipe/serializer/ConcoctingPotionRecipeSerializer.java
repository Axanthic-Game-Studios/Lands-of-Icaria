package com.axanthic.icaria.common.recipe.serializer;

import com.axanthic.icaria.common.recipe.ConcoctingPotionRecipe;

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

public class ConcoctingPotionRecipeSerializer implements RecipeSerializer<ConcoctingPotionRecipe> {
    public static final Codec<ConcoctingPotionRecipe> CODEC = RecordCodecBuilder.create(
        instance -> instance.group(
            Codec.FLOAT.fieldOf("potionRadius").forGetter(recipe -> recipe.potionRadius),
            Codec.INT.fieldOf("burnTime").forGetter(recipe -> recipe.burnTime),
            Codec.INT.fieldOf("color").forGetter(recipe -> recipe.color),
            Codec.INT.fieldOf("potionDuration").forGetter(recipe -> recipe.potionDuration),
            Ingredient.LIST_CODEC.fieldOf("ingredients").forGetter(recipe -> recipe.ingredients),
            Codec.STRING.fieldOf("potion").forGetter(recipe -> recipe.potion)
        ).apply(instance, ConcoctingPotionRecipe::new)
    );

    @Override
    public Codec<ConcoctingPotionRecipe> codec() {
        return CODEC;
    }

    @Override
    public ConcoctingPotionRecipe fromNetwork(FriendlyByteBuf pBuffer) {
        float potionRadius = pBuffer.readFloat();
        int burnTime = pBuffer.readInt();
        int color = pBuffer.readInt();
        int potionDuration = pBuffer.readInt();
        var potion = pBuffer.readUtf();
        var ingredients = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);
        for (int i = 0; i < ingredients.size(); i++) {
            ingredients.set(i, Ingredient.fromNetwork(pBuffer));
        }

        return new ConcoctingPotionRecipe(potionRadius, burnTime, color, potionDuration, ingredients, potion);
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
