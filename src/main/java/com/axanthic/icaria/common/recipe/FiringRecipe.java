package com.axanthic.icaria.common.recipe;

import com.axanthic.icaria.common.recipe.display.FiringRecipeDisplay;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaRecipeBookCategories;
import com.axanthic.icaria.common.registry.IcariaRecipeSerializers;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.minecraft.world.item.crafting.display.SlotDisplay;
import net.minecraft.world.level.Level;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FiringRecipe implements Recipe<RecipeInput> {
	public float experience;

	public int time;

	public Ingredient ingredient;

	public ItemStackTemplate result;

	public static final MapCodec<FiringRecipe> CODEC = RecordCodecBuilder.mapCodec(instance ->
		instance.group(
			Codec.FLOAT.fieldOf("experience").forGetter(FiringRecipe::experience),
			Codec.INT.fieldOf("time").forGetter(FiringRecipe::time),
			Ingredient.CODEC.fieldOf("ingredient").forGetter(FiringRecipe::ingredient),
			ItemStackTemplate.CODEC.fieldOf("result").forGetter(FiringRecipe::result)
		).apply(instance, FiringRecipe::new)
	);

	public static final StreamCodec<RegistryFriendlyByteBuf, FiringRecipe> STREAM_CODEC = StreamCodec.composite(
		ByteBufCodecs.FLOAT, FiringRecipe::experience,
		ByteBufCodecs.INT, FiringRecipe::time,
		Ingredient.CONTENTS_STREAM_CODEC, FiringRecipe::ingredient,
		ItemStackTemplate.STREAM_CODEC, FiringRecipe::result,
		FiringRecipe::new
	);

	public FiringRecipe(float pExperience, int pTime, Ingredient pIngredient, ItemStackTemplate pResult) {
		this.experience = pExperience;
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

	public float experience() {
		return this.experience;
	}

	public int time() {
		return this.time;
	}

	public Ingredient ingredient() {
		return this.ingredient;
	}

	public Item craftingStation() {
		return IcariaItems.KILN.get();
	}

	@Override
	public ItemStack assemble(RecipeInput pRecipeInput) {
		return this.result.create();
	}

	public ItemStackTemplate result() {
		return this.result;
	}

	@Override
	public List<RecipeDisplay> display() {
		return List.of(new FiringRecipeDisplay(new SlotDisplay.ItemStackSlotDisplay(this.result()), new SlotDisplay.ItemSlotDisplay(this.craftingStation()), this.ingredient().display(), SlotDisplay.AnyFuel.INSTANCE, this.time(), this.experience()));
	}

	@Override
	public PlacementInfo placementInfo() {
		return PlacementInfo.create(this.ingredient());
	}

	@Override
	public RecipeBookCategory recipeBookCategory() {
		return IcariaRecipeBookCategories.FIRING.get();
	}

	@Override
	public RecipeSerializer<? extends Recipe<RecipeInput>> getSerializer() {
		return IcariaRecipeSerializers.FIRING.get();
	}

	@Override
	public RecipeType<? extends Recipe<RecipeInput>> getType() {
		return IcariaRecipeTypes.FIRING.get();
	}

	@Override
	public String group() {
		return "";
	}
}
