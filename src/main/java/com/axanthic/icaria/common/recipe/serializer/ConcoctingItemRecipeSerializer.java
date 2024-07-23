package com.axanthic.icaria.common.recipe.serializer;

import com.axanthic.icaria.common.recipe.ConcoctingItemRecipe;

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

public class ConcoctingItemRecipeSerializer implements RecipeSerializer<ConcoctingItemRecipe> {
	public static final MapCodec<ConcoctingItemRecipe> CODEC = RecordCodecBuilder.mapCodec(
		instance -> instance.group(
			Codec.INT.fieldOf("burnTime").forGetter(recipe -> recipe.burnTime),
			Codec.INT.fieldOf("color").forGetter(recipe -> recipe.color),
			ItemStack.CODEC.fieldOf("output").forGetter(recipe -> recipe.output),
			Ingredient.LIST_CODEC.fieldOf("ingredients").forGetter(recipe -> recipe.ingredients)
		).apply(instance, ConcoctingItemRecipe::new)
	);

	public static final StreamCodec<RegistryFriendlyByteBuf, ConcoctingItemRecipe> STREAM_CODEC = StreamCodec.of(
		ConcoctingItemRecipeSerializer::toNetwork,
		ConcoctingItemRecipeSerializer::fromNetwork
	);

	@Override
	public MapCodec<ConcoctingItemRecipe> codec() {
		return CODEC;
	}

	@Override
	public StreamCodec<RegistryFriendlyByteBuf, ConcoctingItemRecipe> streamCodec() {
		return STREAM_CODEC;
	}

	public static ConcoctingItemRecipe fromNetwork(RegistryFriendlyByteBuf pBuffer) {
		int burnTime = pBuffer.readInt();
		int color = pBuffer.readInt();
		var output = ItemStack.OPTIONAL_STREAM_CODEC.decode(pBuffer);
		var ingredients = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);
		for (int i = 0; i < ingredients.size(); i++) {
			ingredients.set(i, Ingredient.CONTENTS_STREAM_CODEC.decode(pBuffer));
		}

		return new ConcoctingItemRecipe(burnTime, color, output, ingredients);
	}

	public static void toNetwork(RegistryFriendlyByteBuf pBuffer, ConcoctingItemRecipe pRecipe) {
		pBuffer.writeInt(pRecipe.burnTime);
		pBuffer.writeInt(pRecipe.color);
		ItemStack.OPTIONAL_STREAM_CODEC.encode(pBuffer, pRecipe.output);
		pBuffer.writeInt(pRecipe.getIngredients().size());
		for (var ingredient : pRecipe.getIngredients()) {
			Ingredient.CONTENTS_STREAM_CODEC.encode(pBuffer, ingredient);
		}
	}
}
