package com.axanthic.icaria.common.recipe.serializer;

import com.axanthic.icaria.common.recipe.GrindingRecipe;

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

public class GrindingRecipeSerializer implements RecipeSerializer<GrindingRecipe> {
	public static final MapCodec<GrindingRecipe> CODEC = RecordCodecBuilder.mapCodec(
		instance -> instance.group(
			Codec.FLOAT.fieldOf("experience").forGetter(recipe -> recipe.experience),
			Codec.INT.fieldOf("burnTime").forGetter(recipe -> recipe.burnTime),
			Ingredient.CODEC.fieldOf("gear").forGetter(recipe -> recipe.gear),
			Ingredient.LIST_CODEC.fieldOf("ingredients").forGetter(recipe -> recipe.ingredients),
			ItemStack.CODEC.fieldOf("output").forGetter(recipe -> recipe.output)
		).apply(instance, GrindingRecipe::new)
	);

	public static final StreamCodec<RegistryFriendlyByteBuf, GrindingRecipe> STREAM_CODEC = StreamCodec.of(
		GrindingRecipeSerializer::toNetwork,
		GrindingRecipeSerializer::fromNetwork
	);

	@Override
	public MapCodec<GrindingRecipe> codec() {
		return CODEC;
	}

	@Override
	public StreamCodec<RegistryFriendlyByteBuf, GrindingRecipe> streamCodec() {
		return STREAM_CODEC;
	}

	public static GrindingRecipe fromNetwork(RegistryFriendlyByteBuf pBuffer) {
		float experience = pBuffer.readFloat();
		int burnTime = pBuffer.readInt();
		var gear = Ingredient.CONTENTS_STREAM_CODEC.decode(pBuffer);
		var output = ItemStack.OPTIONAL_STREAM_CODEC.decode(pBuffer);
		var ingredients = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);
		for (int i = 0; i < ingredients.size(); i++) {
			ingredients.set(i, Ingredient.CONTENTS_STREAM_CODEC.decode(pBuffer));
		}

		return new GrindingRecipe(experience, burnTime, gear, ingredients, output);
	}

	public static void toNetwork(RegistryFriendlyByteBuf pBuffer, GrindingRecipe pRecipe) {
		pBuffer.writeFloat(pRecipe.experience);
		pBuffer.writeInt(pRecipe.burnTime);
		Ingredient.CONTENTS_STREAM_CODEC.encode(pBuffer, pRecipe.gear);
		ItemStack.OPTIONAL_STREAM_CODEC.encode(pBuffer, pRecipe.output);
		pBuffer.writeInt(pRecipe.getIngredients().size());
		for (var ingredient : pRecipe.getIngredients()) {
			Ingredient.CONTENTS_STREAM_CODEC.encode(pBuffer, ingredient);
		}
	}
}
