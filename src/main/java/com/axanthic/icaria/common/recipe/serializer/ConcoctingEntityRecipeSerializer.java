package com.axanthic.icaria.common.recipe.serializer;

import com.axanthic.icaria.common.recipe.ConcoctingEntityRecipe;

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

public class ConcoctingEntityRecipeSerializer implements RecipeSerializer<ConcoctingEntityRecipe> {
    public static final Codec<ConcoctingEntityRecipe> CODEC = RecordCodecBuilder.create(
        instance -> instance.group(
            Codec.INT.fieldOf("burnTime").forGetter(recipe -> recipe.burnTime),
            Codec.INT.fieldOf("color").forGetter(recipe -> recipe.color),
            Ingredient.LIST_CODEC_NONEMPTY.fieldOf("ingredients").forGetter(recipe -> recipe.ingredients),
            Codec.STRING.fieldOf("entity").forGetter(recipe -> recipe.entity)
        ).apply(instance, ConcoctingEntityRecipe::new)
    );

    @Override
    public Codec<ConcoctingEntityRecipe> codec() {
        return CODEC;
    }

    @Override
    public ConcoctingEntityRecipe fromNetwork(FriendlyByteBuf pBuffer) {
        int burnTime = pBuffer.readInt();
        int color = pBuffer.readInt();
        var entity = pBuffer.readUtf();
        var ingredients = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);
        for (int i = 0; i < ingredients.size(); i++) {
            ingredients.set(i, Ingredient.fromNetwork(pBuffer));
        }

        return new ConcoctingEntityRecipe(burnTime, color, ingredients, entity);
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
