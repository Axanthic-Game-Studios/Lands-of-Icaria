package com.axanthic.icaria.common.recipe.serializer;

import com.axanthic.icaria.common.recipe.ExplosionConcoctingRecipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ExplosionConcoctingSerializer implements RecipeSerializer<ExplosionConcoctingRecipe> {
	public static final MapCodec<ExplosionConcoctingRecipe> CODEC = RecordCodecBuilder.mapCodec(
		instance -> instance.group(
			Codec.FLOAT.fieldOf("radius").forGetter(ExplosionConcoctingRecipe::radius),
			Codec.INT.fieldOf("colour").forGetter(ExplosionConcoctingRecipe::colour),
			Codec.INT.fieldOf("time").forGetter(ExplosionConcoctingRecipe::time),
			Ingredient.CODEC.fieldOf("ingredient").forGetter(ExplosionConcoctingRecipe::ingredient)
		).apply(instance, ExplosionConcoctingRecipe::new)
	);

	public static final StreamCodec<RegistryFriendlyByteBuf, ExplosionConcoctingRecipe> STREAM_CODEC = StreamCodec.of(
		ExplosionConcoctingSerializer::toNetwork,
		ExplosionConcoctingSerializer::fromNetwork
	);

	public static void toNetwork(RegistryFriendlyByteBuf pRegistryFriendlyByteBuf, ExplosionConcoctingRecipe pRecipe) {
		pRegistryFriendlyByteBuf.writeFloat(pRecipe.radius());
		pRegistryFriendlyByteBuf.writeInt(pRecipe.colour());
		pRegistryFriendlyByteBuf.writeInt(pRecipe.time());
		Ingredient.CONTENTS_STREAM_CODEC.encode(pRegistryFriendlyByteBuf, pRecipe.ingredient());
	}

	public static ExplosionConcoctingRecipe fromNetwork(RegistryFriendlyByteBuf pRegistryFriendlyByteBuf) {
		var radius = pRegistryFriendlyByteBuf.readFloat();
		var colour = pRegistryFriendlyByteBuf.readInt();
		var time = pRegistryFriendlyByteBuf.readInt();
		var ingredient = Ingredient.CONTENTS_STREAM_CODEC.decode(pRegistryFriendlyByteBuf);
		return new ExplosionConcoctingRecipe(radius, colour, time, ingredient);
	}

	@Override
	public MapCodec<ExplosionConcoctingRecipe> codec() {
		return ExplosionConcoctingSerializer.CODEC;
	}

	@Override
	public StreamCodec<RegistryFriendlyByteBuf, ExplosionConcoctingRecipe> streamCodec() {
		return ExplosionConcoctingSerializer.STREAM_CODEC;
	}
}
