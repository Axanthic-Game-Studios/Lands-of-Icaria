package com.axanthic.icaria.common.recipe.serializer;

import com.axanthic.icaria.common.recipe.ForgingRecipe;

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

public class ForgingRecipeSerializer implements RecipeSerializer<ForgingRecipe> {
	public static final MapCodec<ForgingRecipe> CODEC = RecordCodecBuilder.mapCodec(
		instance -> instance.group(
			Codec.FLOAT.fieldOf("experience").forGetter(ForgingRecipe::experience),
			Codec.INT.fieldOf("time").forGetter(ForgingRecipe::time),
			Ingredient.CODEC.fieldOf("ingredient").forGetter(ForgingRecipe::ingredient),
			ItemStack.CODEC.fieldOf("result").forGetter(ForgingRecipe::result)
		).apply(instance, ForgingRecipe::new)
	);

	public static final StreamCodec<RegistryFriendlyByteBuf, ForgingRecipe> STREAM_CODEC = StreamCodec.of(
		ForgingRecipeSerializer::toNetwork,
		ForgingRecipeSerializer::fromNetwork
	);

	public static void toNetwork(RegistryFriendlyByteBuf pRegistryFriendlyByteBuf, ForgingRecipe pRecipe) {
		pRegistryFriendlyByteBuf.writeFloat(pRecipe.experience());
		pRegistryFriendlyByteBuf.writeInt(pRecipe.time());
		Ingredient.CONTENTS_STREAM_CODEC.encode(pRegistryFriendlyByteBuf, pRecipe.ingredient());
		ItemStack.STREAM_CODEC.encode(pRegistryFriendlyByteBuf, pRecipe.result());
	}

	public static ForgingRecipe fromNetwork(RegistryFriendlyByteBuf pRegistryFriendlyByteBuf) {
		var experience = pRegistryFriendlyByteBuf.readFloat();
		var time = pRegistryFriendlyByteBuf.readInt();
		var ingredient = Ingredient.CONTENTS_STREAM_CODEC.decode(pRegistryFriendlyByteBuf);
		var result = ItemStack.STREAM_CODEC.decode(pRegistryFriendlyByteBuf);
		return new ForgingRecipe(experience, time, ingredient, result);
	}

	@Override
	public MapCodec<ForgingRecipe> codec() {
		return ForgingRecipeSerializer.CODEC;
	}

	@Override
	public StreamCodec<RegistryFriendlyByteBuf, ForgingRecipe> streamCodec() {
		return ForgingRecipeSerializer.STREAM_CODEC;
	}
}
