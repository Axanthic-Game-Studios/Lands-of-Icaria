package com.axanthic.icaria.common.recipe;

import com.axanthic.icaria.common.registry.IcariaRecipeBookCategories;
import com.axanthic.icaria.common.registry.IcariaRecipeSerializers;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ItemConcoctingRecipe implements Recipe<RecipeInput> {
	public int colour;
	public int time;

	public Ingredient ingredient;

	public ItemStack result;

	public ItemConcoctingRecipe(int pColour, int pTime, Ingredient pIngredient, ItemStack pResult) {
		this.time = pTime;
		this.colour = pColour;
		this.ingredient = pIngredient;
		this.result = pResult;
	}

	@Override
	public boolean matches(RecipeInput pRecipeInput, Level pLevel) {
		return this.ingredient.items().size() < 3 ? this.ingredient.items().size() < 2 ? this.matchesSingle(pRecipeInput) : this.matchesDouble(pRecipeInput) : this.matchesTriple(pRecipeInput);
	}

	public boolean matchesSingle(RecipeInput pRecipeInput) {
		return this.ingredient.items().getFirst().value() == pRecipeInput.getItem(0).getItem() && pRecipeInput.getItem(1).isEmpty() && pRecipeInput.getItem(2).isEmpty();
	}

	public boolean matchesDouble(RecipeInput pRecipeInput) {
		return this.ingredient.items().get(0).value() == pRecipeInput.getItem(0).getItem() && this.ingredient.items().get(1).value() == pRecipeInput.getItem(1).getItem() && pRecipeInput.getItem(2).isEmpty();
	}

	public boolean matchesTriple(RecipeInput pRecipeInput) {
		return this.ingredient.items().get(0).value() == pRecipeInput.getItem(0).getItem() && this.ingredient.items().get(1).value() == pRecipeInput.getItem(1).getItem() && this.ingredient.items().get(2).value() == pRecipeInput.getItem(2).getItem();
	}

	public int colour() {
		return this.colour;
	}

	public int time() {
		return this.time;
	}

	public void performRecipe(BlockPos pBlockPos, Level pLevel) {
		pLevel.playSound(null, pBlockPos, IcariaSoundEvents.KETTLE_POP, SoundSource.BLOCKS);
	}

	public Ingredient ingredient() {
		return this.ingredient;
	}

	@Override
	public ItemStack assemble(RecipeInput pRecipeInput, HolderLookup.Provider pProvider) {
		return this.result.copy();
	}

	public ItemStack result() {
		return this.result;
	}

	@Override
	public PlacementInfo placementInfo() {
		return PlacementInfo.create(this.ingredient);
	}

	@Override
	public RecipeBookCategory recipeBookCategory() {
		return IcariaRecipeBookCategories.KETTLE_ITEM.get();
	}

	@Override
	public RecipeSerializer<? extends Recipe<RecipeInput>> getSerializer() {
		return IcariaRecipeSerializers.ITEM_CONCOCTING.get();
	}

	@Override
	public RecipeType<? extends Recipe<RecipeInput>> getType() {
		return IcariaRecipeTypes.ITEM_CONCOCTING.get();
	}
}
