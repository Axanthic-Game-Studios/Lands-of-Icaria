package com.axanthic.icaria.common.recipe.serializer;

import com.axanthic.icaria.common.recipe.GrindingRecipe;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrindingRecipeSerializer implements RecipeSerializer<GrindingRecipe> {
	public static final MapCodec<GrindingRecipe> CODEC = RecordCodecBuilder.mapCodec(
		instance -> instance.group(
			Codec.FLOAT.fieldOf("experience").forGetter(GrindingRecipe::experience),
			Codec.INT.fieldOf("time").forGetter(GrindingRecipe::time),
			Ingredient.CODEC.fieldOf("gear").forGetter(GrindingRecipe::gear),
			Ingredient.CODEC.fieldOf("ingredient").forGetter(GrindingRecipe::ingredient),
			ItemStack.CODEC.fieldOf("result").forGetter(GrindingRecipe::result)
		).apply(instance, GrindingRecipe::new)
	);

	public static final StreamCodec<RegistryFriendlyByteBuf, GrindingRecipe> STREAM_CODEC = StreamCodec.of(
		GrindingRecipeSerializer::toNetwork,
		GrindingRecipeSerializer::fromNetwork
	);

	public static void toNetwork(RegistryFriendlyByteBuf pRegistryFriendlyByteBuf, GrindingRecipe pRecipe) {
		pRegistryFriendlyByteBuf.writeFloat(pRecipe.experience());
		pRegistryFriendlyByteBuf.writeInt(pRecipe.time());
		Ingredient.CONTENTS_STREAM_CODEC.encode(pRegistryFriendlyByteBuf, pRecipe.gear());
		Ingredient.CONTENTS_STREAM_CODEC.encode(pRegistryFriendlyByteBuf, pRecipe.ingredient());
		ItemStack.STREAM_CODEC.encode(pRegistryFriendlyByteBuf, pRecipe.result());
	}

	public static GrindingRecipe fromNetwork(RegistryFriendlyByteBuf pRegistryFriendlyByteBuf) {
		var experience = pRegistryFriendlyByteBuf.readFloat();
		var time = pRegistryFriendlyByteBuf.readInt();
		var gear = Ingredient.CONTENTS_STREAM_CODEC.decode(pRegistryFriendlyByteBuf);
		var ingredient = Ingredient.CONTENTS_STREAM_CODEC.decode(pRegistryFriendlyByteBuf);
		var result = ItemStack.STREAM_CODEC.decode(pRegistryFriendlyByteBuf);
		return new GrindingRecipe(experience, time, gear, ingredient, result);
	}

	@Override
	public MapCodec<GrindingRecipe> codec() {
		return GrindingRecipeSerializer.CODEC;
	}

	@Override
	public StreamCodec<RegistryFriendlyByteBuf, GrindingRecipe> streamCodec() {
		return GrindingRecipeSerializer.STREAM_CODEC;
	}
}
