package com.axanthic.icaria.common.recipe.serializer;

import com.axanthic.icaria.common.recipe.GrillingRecipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrillingRecipeSerializer implements RecipeSerializer<GrillingRecipe> {
	public static final MapCodec<GrillingRecipe> CODEC = RecordCodecBuilder.mapCodec(
		instance -> instance.group(
			Codec.INT.fieldOf("time").forGetter(GrillingRecipe::time),
			Ingredient.CODEC.fieldOf("ingredient").forGetter(GrillingRecipe::ingredient),
			ItemStack.CODEC.fieldOf("result").forGetter(GrillingRecipe::result)
		).apply(instance, GrillingRecipe::new)
	);

	public static final StreamCodec<RegistryFriendlyByteBuf, GrillingRecipe> STREAM_CODEC = StreamCodec.of(
		GrillingRecipeSerializer::toNetwork,
		GrillingRecipeSerializer::fromNetwork
	);

	public static void toNetwork(RegistryFriendlyByteBuf pRegistryFriendlyByteBuf, GrillingRecipe pRecipe) {
		pRegistryFriendlyByteBuf.writeInt(pRecipe.time());
		Ingredient.CONTENTS_STREAM_CODEC.encode(pRegistryFriendlyByteBuf, pRecipe.ingredient());
		ItemStack.STREAM_CODEC.encode(pRegistryFriendlyByteBuf, pRecipe.result());
	}

	public static GrillingRecipe fromNetwork(RegistryFriendlyByteBuf pRegistryFriendlyByteBuf) {
		var time = pRegistryFriendlyByteBuf.readInt();
		var ingredient = Ingredient.CONTENTS_STREAM_CODEC.decode(pRegistryFriendlyByteBuf);
		var result = ItemStack.STREAM_CODEC.decode(pRegistryFriendlyByteBuf);
		return new GrillingRecipe(time, ingredient, result);
	}

	@Override
	public MapCodec<GrillingRecipe> codec() {
		return GrillingRecipeSerializer.CODEC;
	}

	@Override
	public StreamCodec<RegistryFriendlyByteBuf, GrillingRecipe> streamCodec() {
		return GrillingRecipeSerializer.STREAM_CODEC;
	}
}
