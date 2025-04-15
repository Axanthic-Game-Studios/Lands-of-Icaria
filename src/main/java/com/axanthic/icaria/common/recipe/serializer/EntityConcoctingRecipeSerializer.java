package com.axanthic.icaria.common.recipe.serializer;

import com.axanthic.icaria.common.recipe.EntityConcoctingRecipe;

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

public class EntityConcoctingRecipeSerializer implements RecipeSerializer<EntityConcoctingRecipe> {
	public static final MapCodec<EntityConcoctingRecipe> CODEC = RecordCodecBuilder.mapCodec(
		instance -> instance.group(
			Codec.INT.fieldOf("color").forGetter(recipe -> recipe.colour),
			Codec.INT.fieldOf("time").forGetter(recipe -> recipe.time),
			Ingredient.CODEC.fieldOf("ingredient").forGetter(recipe -> recipe.ingredient),
			Codec.STRING.fieldOf("entity").forGetter(recipe -> recipe.entity)
		).apply(instance, EntityConcoctingRecipe::new)
	);

	public static final StreamCodec<RegistryFriendlyByteBuf, EntityConcoctingRecipe> STREAM_CODEC = StreamCodec.of(
		EntityConcoctingRecipeSerializer::toNetwork,
		EntityConcoctingRecipeSerializer::fromNetwork
	);

	public static void toNetwork(RegistryFriendlyByteBuf pRegistryFriendlyByteBuf, EntityConcoctingRecipe pRecipe) {
		pRegistryFriendlyByteBuf.writeInt(pRecipe.colour);
		pRegistryFriendlyByteBuf.writeInt(pRecipe.time);
		Ingredient.CONTENTS_STREAM_CODEC.encode(pRegistryFriendlyByteBuf, pRecipe.ingredient);
		pRegistryFriendlyByteBuf.writeUtf(pRecipe.entity);
	}

	public static EntityConcoctingRecipe fromNetwork(RegistryFriendlyByteBuf pRegistryFriendlyByteBuf) {
		var colour = pRegistryFriendlyByteBuf.readInt();
		var time = pRegistryFriendlyByteBuf.readInt();
		var ingredient = Ingredient.CONTENTS_STREAM_CODEC.decode(pRegistryFriendlyByteBuf);
		var entity = pRegistryFriendlyByteBuf.readUtf();
		return new EntityConcoctingRecipe(colour, time, ingredient, entity);
	}

	@Override
	public MapCodec<EntityConcoctingRecipe> codec() {
		return EntityConcoctingRecipeSerializer.CODEC;
	}

	@Override
	public StreamCodec<RegistryFriendlyByteBuf, EntityConcoctingRecipe> streamCodec() {
		return EntityConcoctingRecipeSerializer.STREAM_CODEC;
	}
}
