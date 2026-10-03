package com.axanthic.icaria.common.recipe;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.recipe.display.GrindingRecipeDisplay;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaRecipeBookCategories;
import com.axanthic.icaria.common.registry.IcariaRecipeSerializers;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;
import com.axanthic.icaria.common.slot.display.GrinderFuelSlotDisplay;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.List;

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

public class GrindingRecipe implements Recipe<RecipeInput> {
	public float experience;

	public int time;

	public Ingredient gear;
	public Ingredient ingredient;

	public ItemStackTemplate result;

	public static final MapCodec<GrindingRecipe> CODEC = RecordCodecBuilder.mapCodec(instance ->
		instance.group(
			Codec.FLOAT.fieldOf("experience").forGetter(GrindingRecipe::experience),
			Codec.INT.fieldOf("time").forGetter(GrindingRecipe::time),
			Ingredient.CODEC.fieldOf("gear").forGetter(GrindingRecipe::gear),
			Ingredient.CODEC.fieldOf("ingredient").forGetter(GrindingRecipe::ingredient),
			ItemStackTemplate.CODEC.fieldOf("result").forGetter(GrindingRecipe::result)
		).apply(instance, GrindingRecipe::new)
	);

	public static final StreamCodec<RegistryFriendlyByteBuf, GrindingRecipe> STREAM_CODEC = StreamCodec.composite(
		ByteBufCodecs.FLOAT, GrindingRecipe::experience,
		ByteBufCodecs.INT, GrindingRecipe::time,
		Ingredient.CONTENTS_STREAM_CODEC, GrindingRecipe::gear,
		Ingredient.CONTENTS_STREAM_CODEC, GrindingRecipe::ingredient,
		ItemStackTemplate.STREAM_CODEC, GrindingRecipe::result,
		GrindingRecipe::new
	);

	public GrindingRecipe(float pExperience, int pTime, Ingredient pGear, Ingredient pIngredient, ItemStackTemplate pResult) {
		this.experience = pExperience;
		this.time = pTime;
		this.gear = pGear;
		this.ingredient = pIngredient;
		this.result = pResult;
	}

	@Override
	public boolean matches(RecipeInput pRecipeInput, Level pLevel) {
		return this.gear().test(pRecipeInput.getItem(0)) && this.ingredient().test(pRecipeInput.getItem(1));
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

	public Ingredient gear() {
		return this.gear;
	}

	public Ingredient ingredient() {
		return this.ingredient;
	}

	public Item craftingStation() {
		return IcariaItems.GRINDER.get();
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
		return List.of(new GrindingRecipeDisplay(new SlotDisplay.ItemStackSlotDisplay(this.result()), new SlotDisplay.ItemSlotDisplay(this.craftingStation()), this.ingredient().display(), this.gear().display(), GrinderFuelSlotDisplay.INSTANCE, this.time(), this.experience()));
	}

	@Override
	public PlacementInfo placementInfo() {
		return PlacementInfo.create(this.ingredient());
	}

	@Override
	public RecipeBookCategory recipeBookCategory() {
		return IcariaRecipeBookCategories.GRINDING.get();
	}

	@Override
	public RecipeSerializer<? extends Recipe<RecipeInput>> getSerializer() {
		return IcariaRecipeSerializers.GRINDING.get();
	}

	@Override
	public RecipeType<? extends Recipe<RecipeInput>> getType() {
		return IcariaRecipeTypes.GRINDING.get();
	}

	@Override
	public String group() {
		return "";
	}
}
