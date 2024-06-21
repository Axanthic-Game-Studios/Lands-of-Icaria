package com.axanthic.icaria.common.recipe.serializer;

import com.axanthic.icaria.common.recipe.ConcoctingExplosionsRecipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ConcoctingExplosionsRecipeSerializer implements RecipeSerializer<ConcoctingExplosionsRecipe> {
    public static final MapCodec<ConcoctingExplosionsRecipe> CODEC = RecordCodecBuilder.mapCodec(
        instance -> instance.group(
            Codec.FLOAT.fieldOf("radius").forGetter(recipe -> recipe.radius),
            Codec.INT.fieldOf("burnTime").forGetter(recipe -> recipe.burnTime),
            Codec.INT.fieldOf("color").forGetter(recipe -> recipe.color),
            Ingredient.LIST_CODEC.fieldOf("ingredients").forGetter(recipe -> recipe.ingredients)
        ).apply(instance, ConcoctingExplosionsRecipe::new)
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, ConcoctingExplosionsRecipe> STREAM_CODEC = StreamCodec.of(
        ConcoctingExplosionsRecipeSerializer::toNetwork,
        ConcoctingExplosionsRecipeSerializer::fromNetwork
    );

    @Override
    public MapCodec<ConcoctingExplosionsRecipe> codec() {
        return CODEC;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, ConcoctingExplosionsRecipe> streamCodec() {
        return STREAM_CODEC;
    }

    public static ConcoctingExplosionsRecipe fromNetwork(RegistryFriendlyByteBuf pBuffer) {
        float radius = pBuffer.readFloat();
        int burnTime = pBuffer.readInt();
        int color = pBuffer.readInt();
        var ingredients = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);
        for (int i = 0; i < ingredients.size(); i++) {
            ingredients.set(i, Ingredient.CONTENTS_STREAM_CODEC.decode(pBuffer));
        }

        return new ConcoctingExplosionsRecipe(radius, burnTime, color, ingredients);
    }

    public static void toNetwork(RegistryFriendlyByteBuf pBuffer, ConcoctingExplosionsRecipe pRecipe) {
        pBuffer.writeFloat(pRecipe.radius);
        pBuffer.writeInt(pRecipe.burnTime);
        pBuffer.writeInt(pRecipe.color);
        pBuffer.writeInt(pRecipe.getIngredients().size());
        for (var ingredient : pRecipe.getIngredients()) {
            Ingredient.CONTENTS_STREAM_CODEC.encode(pBuffer, ingredient);
        }
    }
}
