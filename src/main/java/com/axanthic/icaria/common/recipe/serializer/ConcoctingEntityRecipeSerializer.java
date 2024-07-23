package com.axanthic.icaria.common.recipe.serializer;

import com.axanthic.icaria.common.recipe.ConcoctingEntityRecipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ConcoctingEntityRecipeSerializer implements RecipeSerializer<ConcoctingEntityRecipe> {
	public static final MapCodec<ConcoctingEntityRecipe> MAP_CODEC = RecordCodecBuilder.mapCodec(
			instance -> instance.group(
					Codec.INT.fieldOf("burnTime").forGetter(recipe -> recipe.burnTime),
					Codec.INT.fieldOf("color").forGetter(recipe -> recipe.color),
					Ingredient.LIST_CODEC.fieldOf("ingredients").forGetter(recipe -> recipe.ingredients),
					Codec.STRING.fieldOf("entity").forGetter(recipe -> recipe.entity)
			).apply(instance, ConcoctingEntityRecipe::new)
	);

	public static final StreamCodec<RegistryFriendlyByteBuf, ConcoctingEntityRecipe> STREAM_CODEC = StreamCodec.of(
			ConcoctingEntityRecipeSerializer::toNetwork,
			ConcoctingEntityRecipeSerializer::fromNetwork
	);

	@Override
	public MapCodec<ConcoctingEntityRecipe> codec() {
		return MAP_CODEC;
	}

	@Override
	public StreamCodec<RegistryFriendlyByteBuf, ConcoctingEntityRecipe> streamCodec() {
		return STREAM_CODEC;
	}

	public static ConcoctingEntityRecipe fromNetwork(RegistryFriendlyByteBuf pBuffer) {
		int burnTime = pBuffer.readInt();
		int color = pBuffer.readInt();
		var entity = pBuffer.readUtf();
		var ingredients = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);
		for (int i = 0; i < ingredients.size(); i++) {
			ingredients.set(i, Ingredient.CONTENTS_STREAM_CODEC.decode(pBuffer));
		}

		return new ConcoctingEntityRecipe(burnTime, color, ingredients, entity);
	}

	public static void toNetwork(RegistryFriendlyByteBuf pBuffer, ConcoctingEntityRecipe pRecipe) {
		pBuffer.writeInt(pRecipe.burnTime);
		pBuffer.writeInt(pRecipe.color);
		pBuffer.writeUtf(pRecipe.entity);
		pBuffer.writeInt(pRecipe.getIngredients().size());
		for (var ingredient : pRecipe.getIngredients()) {
			Ingredient.CONTENTS_STREAM_CODEC.encode(pBuffer, ingredient);
		}
	}
}
