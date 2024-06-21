package com.axanthic.icaria.common.recipe.serializer;

import com.axanthic.icaria.common.recipe.FiringRecipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FiringRecipeSerializer implements RecipeSerializer<FiringRecipe> {
    public static final MapCodec<FiringRecipe> CODEC = RecordCodecBuilder.mapCodec(
        instance -> instance.group(
            Codec.FLOAT.fieldOf("experience").forGetter(recipe -> recipe.experience),
            Codec.INT.fieldOf("burnTime").forGetter(recipe -> recipe.burnTime),
            Ingredient.LIST_CODEC.fieldOf("ingredients").forGetter(recipe -> recipe.ingredients),
            ItemStack.CODEC.fieldOf("output").forGetter(recipe -> recipe.output)
        ).apply(instance, FiringRecipe::new)
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, FiringRecipe> STREAM_CODEC = StreamCodec.of(
        FiringRecipeSerializer::toNetwork,
        FiringRecipeSerializer::fromNetwork
    );

    @Override
    public MapCodec<FiringRecipe> codec() {
        return CODEC;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, FiringRecipe> streamCodec() {
        return STREAM_CODEC;
    }

    public static FiringRecipe fromNetwork(RegistryFriendlyByteBuf pBuffer) {
        float experience = pBuffer.readFloat();
        int burnTime = pBuffer.readInt();
        var output = ItemStack.OPTIONAL_STREAM_CODEC.decode(pBuffer);
        var ingredients = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);
        for (int i = 0; i < ingredients.size(); i++) {
            ingredients.set(i, Ingredient.CONTENTS_STREAM_CODEC.decode(pBuffer));
        }

        return new FiringRecipe(experience, burnTime, ingredients, output);
    }

    public static void toNetwork(RegistryFriendlyByteBuf pBuffer, FiringRecipe pRecipe) {
        pBuffer.writeFloat(pRecipe.experience);
        pBuffer.writeInt(pRecipe.burnTime);
        ItemStack.OPTIONAL_STREAM_CODEC.encode(pBuffer, pRecipe.output);
        pBuffer.writeInt(pRecipe.getIngredients().size());
        for (var ingredient : pRecipe.getIngredients()) {
            Ingredient.CONTENTS_STREAM_CODEC.encode(pBuffer, ingredient);
        }
    }
}
