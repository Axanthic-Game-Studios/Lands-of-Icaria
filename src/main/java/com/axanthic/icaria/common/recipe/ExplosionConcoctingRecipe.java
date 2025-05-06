package com.axanthic.icaria.common.recipe;

import com.axanthic.icaria.common.registry.IcariaRecipeBookCategories;
import com.axanthic.icaria.common.registry.IcariaRecipeSerializers;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ExplosionConcoctingRecipe implements Recipe<RecipeInput> {
	public float radius;

	public int colour;
	public int time;

	public Ingredient ingredient;

	public ExplosionConcoctingRecipe(float pRadius, int pColour, int pTime, Ingredient pIngredient) {
		this.radius = pRadius;
		this.colour = pColour;
		this.time = pTime;
		this.ingredient = pIngredient;
	}

	@Override
	public boolean matches(RecipeInput pRecipeInput, Level pLevel) {
		return this.ingredient.getValues().size() < 3 ? this.ingredient.getValues().size() < 2 ? this.matchesSingle(pRecipeInput) : this.matchesDouble(pRecipeInput) : this.matchesTriple(pRecipeInput);
	}

	public boolean matchesSingle(RecipeInput pRecipeInput) {
		return this.ingredient.getValues().get(0).value() == pRecipeInput.getItem(0).getItem() && pRecipeInput.getItem(1).isEmpty() && pRecipeInput.getItem(2).isEmpty();
	}

	public boolean matchesDouble(RecipeInput pRecipeInput) {
		return this.ingredient.getValues().get(0).value() == pRecipeInput.getItem(0).getItem() && this.ingredient.getValues().get(1).value() == pRecipeInput.getItem(1).getItem() && pRecipeInput.getItem(2).isEmpty();
	}

	public boolean matchesTriple(RecipeInput pRecipeInput) {
		return this.ingredient.getValues().get(0).value() == pRecipeInput.getItem(0).getItem() && this.ingredient.getValues().get(1).value() == pRecipeInput.getItem(1).getItem() && this.ingredient.getValues().get(2).value() == pRecipeInput.getItem(2).getItem();
	}

	public int colour() {
		return this.colour;
	}

	public int time() {
		return this.time;
	}

	public void performRecipe(BlockPos pBlockPos, Level pLevel) {
		pLevel.explode(null, pBlockPos.getX() + 0.5D, pBlockPos.getY() + 0.75D, pBlockPos.getZ() + 0.5D, this.radius, Level.ExplosionInteraction.NONE);
	}

	public Ingredient ingredient() {
		return this.ingredient;
	}

	@Override
	public ItemStack assemble(RecipeInput pInput, HolderLookup.Provider pProvider) {
		return ItemStack.EMPTY;
	}

	public ItemStack result() {
		return ItemStack.EMPTY;
	}

	@Override
	public PlacementInfo placementInfo() {
		return PlacementInfo.create(this.ingredient);
	}

	@Override
	public RecipeBookCategory recipeBookCategory() {
		return IcariaRecipeBookCategories.KETTLE_EXPLOSION.get();
	}

	@Override
	public RecipeSerializer<? extends Recipe<RecipeInput>> getSerializer() {
		return IcariaRecipeSerializers.EXPLOSION_CONCOCTING.get();
	}

	@Override
	public RecipeType<? extends Recipe<RecipeInput>> getType() {
		return IcariaRecipeTypes.EXPLOSION_CONCOCTING.get();
	}
}
