package com.axanthic.icaria.common.recipe.serializer;

import com.axanthic.icaria.common.recipe.PotionConcoctingRecipe;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class PotionConcoctingRecipeSerializer implements RecipeSerializer<PotionConcoctingRecipe> {
	public static final MapCodec<PotionConcoctingRecipe> CODEC = RecordCodecBuilder.mapCodec(
		instance -> instance.group(
			Codec.FLOAT.fieldOf("radius").forGetter(PotionConcoctingRecipe::radius),
			Codec.INT.fieldOf("colour").forGetter(PotionConcoctingRecipe::colour),
			Codec.INT.fieldOf("duration").forGetter(PotionConcoctingRecipe::duration),
			Codec.INT.fieldOf("time").forGetter(PotionConcoctingRecipe::time),
			Ingredient.CODEC.fieldOf("ingredient").forGetter(PotionConcoctingRecipe::ingredient),
			PotionContents.CODEC.fieldOf("potion").forGetter(PotionConcoctingRecipe::potion)
		).apply(instance, PotionConcoctingRecipe::new)
	);

	public static final StreamCodec<RegistryFriendlyByteBuf, PotionConcoctingRecipe> STREAM_CODEC = StreamCodec.of(
		PotionConcoctingRecipeSerializer::toNetwork,
		PotionConcoctingRecipeSerializer::fromNetwork
	);

	public static void toNetwork(RegistryFriendlyByteBuf pRegistryFriendlyByteBuf, PotionConcoctingRecipe pRecipe) {
		pRegistryFriendlyByteBuf.writeFloat(pRecipe.radius());
		pRegistryFriendlyByteBuf.writeInt(pRecipe.colour());
		pRegistryFriendlyByteBuf.writeInt(pRecipe.duration());
		pRegistryFriendlyByteBuf.writeInt(pRecipe.time());
		Ingredient.CONTENTS_STREAM_CODEC.encode(pRegistryFriendlyByteBuf, pRecipe.ingredient());
		PotionContents.STREAM_CODEC.encode(pRegistryFriendlyByteBuf, pRecipe.potion());
	}

	public static PotionConcoctingRecipe fromNetwork(RegistryFriendlyByteBuf pRegistryFriendlyByteBuf) {
		var radius = pRegistryFriendlyByteBuf.readFloat();
		var colour = pRegistryFriendlyByteBuf.readInt();
		var duration = pRegistryFriendlyByteBuf.readInt();
		var time = pRegistryFriendlyByteBuf.readInt();
		var ingredients = Ingredient.CONTENTS_STREAM_CODEC.decode(pRegistryFriendlyByteBuf);
		var potion = PotionContents.STREAM_CODEC.decode(pRegistryFriendlyByteBuf);
		return new PotionConcoctingRecipe(radius, colour, duration, time, ingredients, potion);
	}

	@Override
	public MapCodec<PotionConcoctingRecipe> codec() {
		return PotionConcoctingRecipeSerializer.CODEC;
	}

	@Override
	public StreamCodec<RegistryFriendlyByteBuf, PotionConcoctingRecipe> streamCodec() {
		return PotionConcoctingRecipeSerializer.STREAM_CODEC;
	}
}
