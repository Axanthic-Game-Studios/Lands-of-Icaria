package com.axanthic.icaria.common.recipe.serializer;

import com.axanthic.icaria.common.recipe.GrindingRecipe;

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

public class GrindingRecipeSerializer implements RecipeSerializer<GrindingRecipe> {
    public static final Codec<GrindingRecipe> CODEC = RecordCodecBuilder.create(
        instance -> instance.group(
            Codec.FLOAT.fieldOf("experience").forGetter(recipe -> recipe.experience),
            Codec.INT.fieldOf("burnTime").forGetter(recipe -> recipe.burnTime),
            Ingredient.CODEC.fieldOf("gear").forGetter(recipe -> recipe.gear),
            Ingredient.LIST_CODEC_NONEMPTY.fieldOf("ingredients").forGetter(recipe -> recipe.ingredients),
            ItemStack.CODEC.fieldOf("output").forGetter(recipe -> recipe.output)
        ).apply(instance, GrindingRecipe::new)
    );

    @Override
    public Codec<GrindingRecipe> codec() {
        return CODEC;
    }

    @Override
    public GrindingRecipe fromNetwork(FriendlyByteBuf pBuffer) {
        float experience = pBuffer.readFloat();
        int burnTime = pBuffer.readInt();
        var gear = Ingredient.fromNetwork(pBuffer);
        var output = pBuffer.readItem();
        var ingredients = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);
        for (int i = 0; i < ingredients.size(); i++) {
            ingredients.set(i, Ingredient.fromNetwork(pBuffer));
        }

        return new GrindingRecipe(experience, burnTime, gear, ingredients, output);
    }

    @Override
    public void toNetwork(FriendlyByteBuf pBuffer, GrindingRecipe pRecipe) {
        pBuffer.writeFloat(pRecipe.experience);
        pBuffer.writeInt(pRecipe.burnTime);
        pRecipe.gear.toNetwork(pBuffer);
        pBuffer.writeItemStack(pRecipe.getResultItem(null), false);
        pBuffer.writeInt(pRecipe.getIngredients().size());
        for (var ingredient : pRecipe.getIngredients()) {
            ingredient.toNetwork(pBuffer);
        }
    }
}
