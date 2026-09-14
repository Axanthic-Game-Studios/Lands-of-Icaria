package com.axanthic.icaria.common.recipe;

import com.axanthic.icaria.common.registry.IcariaRecipeBookCategories;
import com.axanthic.icaria.common.registry.IcariaRecipeSerializers;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrillingRecipe implements Recipe<RecipeInput> {
	public int time;

	public Ingredient ingredient;

	public ItemStackTemplate result;

	public static final MapCodec<GrillingRecipe> CODEC = RecordCodecBuilder.mapCodec(instance ->
		instance.group(
			Codec.INT.fieldOf("time").forGetter(GrillingRecipe::time),
			Ingredient.CODEC.fieldOf("ingredient").forGetter(GrillingRecipe::ingredient),
			ItemStackTemplate.CODEC.fieldOf("result").forGetter(GrillingRecipe::result)
		).apply(instance, GrillingRecipe::new)
	);

	public static final StreamCodec<RegistryFriendlyByteBuf, GrillingRecipe> STREAM_CODEC = StreamCodec.composite(
		ByteBufCodecs.INT, GrillingRecipe::time,
		Ingredient.CONTENTS_STREAM_CODEC, GrillingRecipe::ingredient,
		ItemStackTemplate.STREAM_CODEC, GrillingRecipe::result,
		GrillingRecipe::new
	);

	public GrillingRecipe(int pTime, Ingredient pIngredient, ItemStackTemplate pResult) {
		this.time = pTime;
		this.ingredient = pIngredient;
		this.result = pResult;
	}

	@Override
	public boolean matches(RecipeInput pRecipeInput, Level pLevel) {
		return this.ingredient().test(pRecipeInput.getItem(0));
	}

	@Override
	public boolean showNotification() {
		return false;
	}

	public int time() {
		return this.time;
	}

	public Ingredient ingredient() {
		return this.ingredient;
	}

	@Override
	public ItemStack assemble(RecipeInput pRecipeInput) {
		return this.result.create();
	}

	public ItemStackTemplate result() {
		return this.result;
	}

	@Override
	public PlacementInfo placementInfo() {
		return PlacementInfo.create(this.ingredient());
	}

	@Override
	public RecipeBookCategory recipeBookCategory() {
		return IcariaRecipeBookCategories.GRILLING.get();
	}

	@Override
	public RecipeSerializer<? extends Recipe<RecipeInput>> getSerializer() {
		return IcariaRecipeSerializers.GRILLING.get();
	}

	@Override
	public RecipeType<? extends Recipe<RecipeInput>> getType() {
		return IcariaRecipeTypes.GRILLING.get();
	}

	@Override
	public String group() {
		return "";
	}
}
