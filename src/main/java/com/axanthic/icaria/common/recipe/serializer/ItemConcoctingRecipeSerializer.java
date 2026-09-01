package com.axanthic.icaria.common.recipe.serializer;

import com.axanthic.icaria.common.recipe.ItemConcoctingRecipe;

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

public class ItemConcoctingRecipeSerializer implements RecipeSerializer<ItemConcoctingRecipe> {
	public static final MapCodec<ItemConcoctingRecipe> CODEC = RecordCodecBuilder.mapCodec(
		instance -> instance.group(
			Codec.INT.fieldOf("colour").forGetter(ItemConcoctingRecipe::colour),
			Codec.INT.fieldOf("time").forGetter(ItemConcoctingRecipe::time),
			Ingredient.CODEC.fieldOf("ingredient").forGetter(ItemConcoctingRecipe::ingredient),
			ItemStack.CODEC.fieldOf("result").forGetter(ItemConcoctingRecipe::result)
		).apply(instance, ItemConcoctingRecipe::new)
	);

	public static final StreamCodec<RegistryFriendlyByteBuf, ItemConcoctingRecipe> STREAM_CODEC = StreamCodec.of(
		ItemConcoctingRecipeSerializer::toNetwork,
		ItemConcoctingRecipeSerializer::fromNetwork
	);

	public static void toNetwork(RegistryFriendlyByteBuf pRegistryFriendlyByteBuf, ItemConcoctingRecipe pRecipe) {
		pRegistryFriendlyByteBuf.writeInt(pRecipe.time());
		pRegistryFriendlyByteBuf.writeInt(pRecipe.colour());
		Ingredient.CONTENTS_STREAM_CODEC.encode(pRegistryFriendlyByteBuf, pRecipe.ingredient());
		ItemStack.STREAM_CODEC.encode(pRegistryFriendlyByteBuf, pRecipe.result());
	}

	public static ItemConcoctingRecipe fromNetwork(RegistryFriendlyByteBuf pRegistryFriendlyByteBuf) {
		var colour = pRegistryFriendlyByteBuf.readInt();
		var time = pRegistryFriendlyByteBuf.readInt();
		var ingredient = Ingredient.CONTENTS_STREAM_CODEC.decode(pRegistryFriendlyByteBuf);
		var result = ItemStack.STREAM_CODEC.decode(pRegistryFriendlyByteBuf);
		return new ItemConcoctingRecipe(colour, time, ingredient, result);
	}

	@Override
	public MapCodec<ItemConcoctingRecipe> codec() {
		return ItemConcoctingRecipeSerializer.CODEC;
	}

	@Override
	public StreamCodec<RegistryFriendlyByteBuf, ItemConcoctingRecipe> streamCodec() {
		return ItemConcoctingRecipeSerializer.STREAM_CODEC;
	}
}
