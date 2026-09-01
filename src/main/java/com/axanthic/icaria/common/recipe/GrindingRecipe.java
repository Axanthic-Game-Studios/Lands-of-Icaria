package com.axanthic.icaria.common.recipe;

import com.axanthic.icaria.common.display.GrinderFuelSlotDisplay;
import com.axanthic.icaria.common.recipe.display.GrindingRecipeDisplay;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaRecipeBookCategories;
import com.axanthic.icaria.common.registry.IcariaRecipeSerializers;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
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

	public ItemStack result;

	public GrindingRecipe(float pExperience, int pTime, Ingredient pGear, Ingredient pIngredient, ItemStack pResult) {
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
	public ItemStack assemble(RecipeInput pRecipeInput, HolderLookup.Provider pProvider) {
		return this.result().copy();
	}

	public ItemStack result() {
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
}
