package com.axanthic.icaria.common.recipe;

import com.axanthic.icaria.common.registry.IcariaRecipeSerializers;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ForgingRecipe implements Recipe<RecipeInput> {
	public float experience;

	public int burnTime;

	public List<Ingredient> ingredients;

	public ItemStack output;

	public ForgingRecipe(float pExperience, int pBurnTime, List<Ingredient> pIngredients, ItemStack pOutput) {
		this.experience = pExperience;
		this.burnTime = pBurnTime;
		this.ingredients = pIngredients;
		this.output = pOutput;
	}

	@Override
	public boolean canCraftInDimensions(int pWidth, int pHeight) {
		return true;
	}

	@Override
	public boolean matches(RecipeInput pInput, Level pLevel) {
		return this.matches(pInput) && !pLevel.isClientSide();
	}

	public boolean matches(RecipeInput pInput) {
		return this.ingredients.size() < 3 ? this.ingredients.size() < 2 ? this.matchesSingle(pInput) : this.matchesDouble(pInput) : this.matchesTriple(pInput);
	}

	public boolean matchesSingle(RecipeInput pInput) {
		return (this.ingredients.get(0).test(pInput.getItem(0)) && pInput.getItem(1).isEmpty() && pInput.getItem(2).isEmpty()) || (this.ingredients.get(0).test(pInput.getItem(0)) && pInput.getItem(2).isEmpty() && pInput.getItem(1).isEmpty()) || (this.ingredients.get(0).test(pInput.getItem(1)) && pInput.getItem(0).isEmpty() && pInput.getItem(2).isEmpty()) || (this.ingredients.get(0).test(pInput.getItem(1)) && pInput.getItem(2).isEmpty() && pInput.getItem(0).isEmpty()) || (this.ingredients.get(0).test(pInput.getItem(2)) && pInput.getItem(0).isEmpty() && pInput.getItem(1).isEmpty()) || (this.ingredients.get(0).test(pInput.getItem(2)) && pInput.getItem(1).isEmpty() && pInput.getItem(0).isEmpty());
	}

	public boolean matchesDouble(RecipeInput pInput) {
		return (this.ingredients.get(0).test(pInput.getItem(0)) && this.ingredients.get(1).test(pInput.getItem(1)) && pInput.getItem(2).isEmpty()) || (this.ingredients.get(0).test(pInput.getItem(0)) && this.ingredients.get(1).test(pInput.getItem(2)) && pInput.getItem(1).isEmpty()) || (this.ingredients.get(0).test(pInput.getItem(1)) && this.ingredients.get(1).test(pInput.getItem(0)) && pInput.getItem(2).isEmpty()) || (this.ingredients.get(0).test(pInput.getItem(1)) && this.ingredients.get(1).test(pInput.getItem(2)) && pInput.getItem(0).isEmpty()) || (this.ingredients.get(0).test(pInput.getItem(2)) && this.ingredients.get(1).test(pInput.getItem(0)) && pInput.getItem(1).isEmpty()) || (this.ingredients.get(0).test(pInput.getItem(2)) && this.ingredients.get(1).test(pInput.getItem(1)) && pInput.getItem(0).isEmpty());
	}

	public boolean matchesTriple(RecipeInput pInput) {
		return (this.ingredients.get(0).test(pInput.getItem(0)) && this.ingredients.get(1).test(pInput.getItem(1)) && this.ingredients.get(2).test(pInput.getItem(2))) || (this.ingredients.get(0).test(pInput.getItem(0)) && this.ingredients.get(1).test(pInput.getItem(2)) && this.ingredients.get(2).test(pInput.getItem(1))) || (this.ingredients.get(0).test(pInput.getItem(1)) && this.ingredients.get(1).test(pInput.getItem(0)) && this.ingredients.get(2).test(pInput.getItem(2))) || (this.ingredients.get(0).test(pInput.getItem(1)) && this.ingredients.get(1).test(pInput.getItem(2)) && this.ingredients.get(2).test(pInput.getItem(0))) || (this.ingredients.get(0).test(pInput.getItem(2)) && this.ingredients.get(1).test(pInput.getItem(0)) && this.ingredients.get(2).test(pInput.getItem(1))) || (this.ingredients.get(0).test(pInput.getItem(2)) && this.ingredients.get(1).test(pInput.getItem(1)) && this.ingredients.get(2).test(pInput.getItem(0)));
	}

	public float getExperience() {
		return this.experience;
	}

	public int getBurnTime() {
		return this.burnTime;
	}

	@Override
	public ItemStack assemble(RecipeInput pInput, HolderLookup.Provider pProvider) {
		return this.output;
	}

	@Override
	public ItemStack getResultItem(HolderLookup.Provider pProvider) {
		return this.output.copy();
	}

	@Override
	public NonNullList<Ingredient> getIngredients() {
		var list = NonNullList.<Ingredient>create();
		list.addAll(this.ingredients);
		return list;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return IcariaRecipeSerializers.FORGING.get();
	}

	@Override
	public RecipeType<?> getType() {
		return IcariaRecipeTypes.FORGING.get();
	}
}
