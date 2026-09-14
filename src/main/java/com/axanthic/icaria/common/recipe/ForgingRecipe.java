package com.axanthic.icaria.common.recipe;

import com.axanthic.icaria.common.recipe.display.ForgingRecipeDisplay;
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

public class ForgingRecipe implements Recipe<RecipeInput> {
	public float experience;

	public int time;

	public Ingredient ingredient;

	public ItemStackTemplate result;

	public static final MapCodec<ForgingRecipe> CODEC = RecordCodecBuilder.mapCodec(instance ->
		instance.group(
			Codec.FLOAT.fieldOf("experience").forGetter(ForgingRecipe::experience),
			Codec.INT.fieldOf("time").forGetter(ForgingRecipe::time),
			Ingredient.CODEC.fieldOf("ingredient").forGetter(ForgingRecipe::ingredient),
			ItemStackTemplate.CODEC.fieldOf("result").forGetter(ForgingRecipe::result)
		).apply(instance, ForgingRecipe::new)
	);

	public static final StreamCodec<RegistryFriendlyByteBuf, ForgingRecipe> STREAM_CODEC = StreamCodec.composite(
		ByteBufCodecs.FLOAT, ForgingRecipe::experience,
		ByteBufCodecs.INT, ForgingRecipe::time,
		Ingredient.CONTENTS_STREAM_CODEC, ForgingRecipe::ingredient,
		ItemStackTemplate.STREAM_CODEC, ForgingRecipe::result,
		ForgingRecipe::new
	);

	public ForgingRecipe(float pExperience, int pTime, Ingredient pIngredient, ItemStackTemplate pResult) {
		this.experience = pExperience;
		this.time = pTime;
		this.ingredient = pIngredient;
		this.result = pResult;
	}

	@Override
	public boolean matches(RecipeInput pRecipeInput, Level pLevel) {
		return this.ingredient().getValues().size() < 3 ? this.ingredient().getValues().size() < 2 ? this.matchesSingle(pRecipeInput) : this.matchesDouble(pRecipeInput) : this.matchesTriple(pRecipeInput);
	}

	public boolean matchesSingle(RecipeInput pRecipeInput) {
		return (this.ingredient().getValues().get(0).value() == pRecipeInput.getItem(0).getItem() && pRecipeInput.getItem(1).isEmpty() && pRecipeInput.getItem(2).isEmpty()) || (this.ingredient().getValues().get(0).value() == pRecipeInput.getItem(0).getItem() && pRecipeInput.getItem(2).isEmpty() && pRecipeInput.getItem(1).isEmpty()) || (this.ingredient().getValues().get(0).value() == pRecipeInput.getItem(1).getItem() && pRecipeInput.getItem(0).isEmpty() && pRecipeInput.getItem(2).isEmpty()) || (this.ingredient().getValues().get(0).value() == pRecipeInput.getItem(1).getItem() && pRecipeInput.getItem(2).isEmpty() && pRecipeInput.getItem(0).isEmpty()) || (this.ingredient().getValues().get(0).value() == pRecipeInput.getItem(2).getItem() && pRecipeInput.getItem(0).isEmpty() && pRecipeInput.getItem(1).isEmpty()) || (this.ingredient().getValues().get(0).value() == pRecipeInput.getItem(2).getItem() && pRecipeInput.getItem(1).isEmpty() && pRecipeInput.getItem(0).isEmpty());
	}

	public boolean matchesDouble(RecipeInput pRecipeInput) {
		return (this.ingredient().getValues().get(0).value() == pRecipeInput.getItem(0).getItem() && this.ingredient().getValues().get(1).value() == pRecipeInput.getItem(1).getItem() && pRecipeInput.getItem(2).isEmpty()) || (this.ingredient().getValues().get(0).value() == pRecipeInput.getItem(0).getItem() && this.ingredient().getValues().get(1).value() == pRecipeInput.getItem(2).getItem() && pRecipeInput.getItem(1).isEmpty()) || (this.ingredient().getValues().get(0).value() == pRecipeInput.getItem(1).getItem() && this.ingredient().getValues().get(1).value() == pRecipeInput.getItem(0).getItem() && pRecipeInput.getItem(2).isEmpty()) || (this.ingredient().getValues().get(0).value() == pRecipeInput.getItem(1).getItem() && this.ingredient().getValues().get(1).value() == pRecipeInput.getItem(2).getItem() && pRecipeInput.getItem(0).isEmpty()) || (this.ingredient().getValues().get(0).value() == pRecipeInput.getItem(2).getItem() && this.ingredient().getValues().get(1).value() == pRecipeInput.getItem(0).getItem() && pRecipeInput.getItem(1).isEmpty()) || (this.ingredient().getValues().get(0).value() == pRecipeInput.getItem(2).getItem() && this.ingredient().getValues().get(1).value() == pRecipeInput.getItem(1).getItem() && pRecipeInput.getItem(0).isEmpty());
	}

	public boolean matchesTriple(RecipeInput pRecipeInput) {
		return (this.ingredient().getValues().get(0).value() == pRecipeInput.getItem(0).getItem() && this.ingredient().getValues().get(1).value() == pRecipeInput.getItem(1).getItem() && this.ingredient().getValues().get(2).value() == pRecipeInput.getItem(2).getItem()) || (this.ingredient().getValues().get(0).value() == pRecipeInput.getItem(0).getItem() && this.ingredient().getValues().get(1).value() == pRecipeInput.getItem(2).getItem() && this.ingredient().getValues().get(2).value() == pRecipeInput.getItem(1).getItem()) || (this.ingredient().getValues().get(0).value() == pRecipeInput.getItem(1).getItem() && this.ingredient().getValues().get(1).value() == pRecipeInput.getItem(0).getItem() && this.ingredient().getValues().get(2).value() == pRecipeInput.getItem(2).getItem()) || (this.ingredient().getValues().get(0).value() == pRecipeInput.getItem(1).getItem() && this.ingredient().getValues().get(1).value() == pRecipeInput.getItem(2).getItem() && this.ingredient().getValues().get(2).value() == pRecipeInput.getItem(0).getItem()) || (this.ingredient().getValues().get(0).value() == pRecipeInput.getItem(2).getItem() && this.ingredient().getValues().get(1).value() == pRecipeInput.getItem(0).getItem() && this.ingredient().getValues().get(2).value() == pRecipeInput.getItem(1).getItem()) || (this.ingredient().getValues().get(0).value() == pRecipeInput.getItem(2).getItem() && this.ingredient().getValues().get(1).value() == pRecipeInput.getItem(1).getItem() && this.ingredient().getValues().get(2).value() == pRecipeInput.getItem(0).getItem());
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
		return IcariaItems.FORGE.get();
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
	public List<RecipeDisplay> display() {
		if (this.ingredient().getValues().size() == 3) {
			return this.displayTriple();
		} else if (this.ingredient().getValues().size() == 2) {
			return this.displayDouble();
		} else {
			return this.displaySingle();
		}
	}

	public List<RecipeDisplay> displaySingle() {
		return List.of(new ForgingRecipeDisplay(new SlotDisplay.ItemStackSlotDisplay(this.result()), new SlotDisplay.ItemSlotDisplay(this.craftingStation()), new SlotDisplay.ItemSlotDisplay(this.ingredient().getValues().get(0).value()), SlotDisplay.Empty.INSTANCE, SlotDisplay.Empty.INSTANCE, SlotDisplay.AnyFuel.INSTANCE, this.time(), this.experience()));
	}

	public List<RecipeDisplay> displayDouble() {
		return List.of(new ForgingRecipeDisplay(new SlotDisplay.ItemStackSlotDisplay(this.result()), new SlotDisplay.ItemSlotDisplay(this.craftingStation()), new SlotDisplay.ItemSlotDisplay(this.ingredient().getValues().get(0).value()), new SlotDisplay.ItemSlotDisplay(this.ingredient().getValues().get(1).value()), SlotDisplay.Empty.INSTANCE, SlotDisplay.AnyFuel.INSTANCE, this.time(), this.experience()));
	}

	public List<RecipeDisplay> displayTriple() {
		return List.of(new ForgingRecipeDisplay(new SlotDisplay.ItemStackSlotDisplay(this.result()), new SlotDisplay.ItemSlotDisplay(this.craftingStation()), new SlotDisplay.ItemSlotDisplay(this.ingredient().getValues().get(0).value()), new SlotDisplay.ItemSlotDisplay(this.ingredient().getValues().get(1).value()), new SlotDisplay.ItemSlotDisplay(this.ingredient().getValues().get(2).value()), SlotDisplay.AnyFuel.INSTANCE, this.time(), this.experience()));
	}

	@Override
	public RecipeBookCategory recipeBookCategory() {
		return IcariaRecipeBookCategories.FORGING.get();
	}

	@Override
	public RecipeSerializer<? extends Recipe<RecipeInput>> getSerializer() {
		return IcariaRecipeSerializers.FORGING.get();
	}

	@Override
	public RecipeType<? extends Recipe<RecipeInput>> getType() {
		return IcariaRecipeTypes.FORGING.get();
	}

	@Override
	public String group() {
		return "";
	}
}
