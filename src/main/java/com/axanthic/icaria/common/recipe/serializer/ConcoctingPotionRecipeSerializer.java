package com.axanthic.icaria.common.recipe.serializer;

import com.axanthic.icaria.common.recipe.ConcoctingPotionRecipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ConcoctingPotionRecipeSerializer implements RecipeSerializer<ConcoctingPotionRecipe> {
	public static final MapCodec<ConcoctingPotionRecipe> CODEC = RecordCodecBuilder.mapCodec(
			instance -> instance.group(
					Codec.FLOAT.fieldOf("potionRadius").forGetter(recipe -> recipe.potionRadius),
					Codec.INT.fieldOf("burnTime").forGetter(recipe -> recipe.burnTime),
					Codec.INT.fieldOf("color").forGetter(recipe -> recipe.color),
					Codec.INT.fieldOf("potionDuration").forGetter(recipe -> recipe.potionDuration),
					Ingredient.LIST_CODEC.fieldOf("ingredients").forGetter(recipe -> recipe.ingredients),
					PotionContents.CODEC.fieldOf("potion").forGetter(recipe -> recipe.potion)
			).apply(instance, ConcoctingPotionRecipe::new)
	);

	public static final StreamCodec<RegistryFriendlyByteBuf, ConcoctingPotionRecipe> STREAM_CODEC = StreamCodec.of(
			ConcoctingPotionRecipeSerializer::toNetwork,
			ConcoctingPotionRecipeSerializer::fromNetwork
	);

	@Override
	public MapCodec<ConcoctingPotionRecipe> codec() {
		return CODEC;
	}

	@Override
	public StreamCodec<RegistryFriendlyByteBuf, ConcoctingPotionRecipe> streamCodec() {
		return STREAM_CODEC;
	}

	public static ConcoctingPotionRecipe fromNetwork(RegistryFriendlyByteBuf pBuffer) {
		float potionRadius = pBuffer.readFloat();
		int burnTime = pBuffer.readInt();
		int color = pBuffer.readInt();
		int potionDuration = pBuffer.readInt();
		var potion = PotionContents.STREAM_CODEC.decode(pBuffer);
		var ingredients = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);
		for (int i = 0; i < ingredients.size(); i++) {
			ingredients.set(i, Ingredient.CONTENTS_STREAM_CODEC.decode(pBuffer));
		}

		return new ConcoctingPotionRecipe(potionRadius, burnTime, color, potionDuration, ingredients, potion);
	}

	public static void toNetwork(RegistryFriendlyByteBuf pBuffer, ConcoctingPotionRecipe pRecipe) {
		pBuffer.writeFloat(pRecipe.potionRadius);
		pBuffer.writeInt(pRecipe.burnTime);
		pBuffer.writeInt(pRecipe.color);
		pBuffer.writeInt(pRecipe.potionDuration);
		PotionContents.STREAM_CODEC.encode(pBuffer, pRecipe.potion);
		pBuffer.writeInt(pRecipe.getIngredients().size());
		for (var ingredient : pRecipe.getIngredients()) {
			Ingredient.CONTENTS_STREAM_CODEC.encode(pBuffer, ingredient);
		}
	}
}
