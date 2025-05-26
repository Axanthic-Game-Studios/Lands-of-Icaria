package com.axanthic.icaria.common.recipe.serializer;

import com.axanthic.icaria.common.recipe.FiringRecipe;

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

public class FiringRecipeSerializer implements RecipeSerializer<FiringRecipe> {
	public static final MapCodec<FiringRecipe> CODEC = RecordCodecBuilder.mapCodec(
		instance -> instance.group(
			Codec.FLOAT.fieldOf("experience").forGetter(FiringRecipe::experience),
			Codec.INT.fieldOf("time").forGetter(FiringRecipe::time),
			Ingredient.CODEC.fieldOf("ingredient").forGetter(FiringRecipe::ingredient),
			ItemStack.CODEC.fieldOf("result").forGetter(FiringRecipe::result)
		).apply(instance, FiringRecipe::new)
	);

	public static final StreamCodec<RegistryFriendlyByteBuf, FiringRecipe> STREAM_CODEC = StreamCodec.of(
		FiringRecipeSerializer::toNetwork,
		FiringRecipeSerializer::fromNetwork
	);

	public static void toNetwork(RegistryFriendlyByteBuf pRegistryFriendlyByteBuf, FiringRecipe pRecipe) {
		pRegistryFriendlyByteBuf.writeFloat(pRecipe.experience());
		pRegistryFriendlyByteBuf.writeInt(pRecipe.time());
		Ingredient.CONTENTS_STREAM_CODEC.encode(pRegistryFriendlyByteBuf, pRecipe.ingredient());
		ItemStack.STREAM_CODEC.encode(pRegistryFriendlyByteBuf, pRecipe.result());
	}

	public static FiringRecipe fromNetwork(RegistryFriendlyByteBuf pRegistryFriendlyByteBuf) {
		var experience = pRegistryFriendlyByteBuf.readFloat();
		var time = pRegistryFriendlyByteBuf.readInt();
		var ingredient = Ingredient.CONTENTS_STREAM_CODEC.decode(pRegistryFriendlyByteBuf);
		var result = ItemStack.STREAM_CODEC.decode(pRegistryFriendlyByteBuf);
		return new FiringRecipe(experience, time, ingredient, result);
	}

	@Override
	public MapCodec<FiringRecipe> codec() {
		return FiringRecipeSerializer.CODEC;
	}

	@Override
	public StreamCodec<RegistryFriendlyByteBuf, FiringRecipe> streamCodec() {
		return FiringRecipeSerializer.STREAM_CODEC;
	}
}
