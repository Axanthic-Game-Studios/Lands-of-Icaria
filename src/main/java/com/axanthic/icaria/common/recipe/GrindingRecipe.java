package com.axanthic.icaria.common.recipe;

import com.axanthic.icaria.common.registry.IcariaRecipeSerializers;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrindingRecipe implements Recipe<SimpleContainer> {
	public float experience;

	public int burnTime;

	public Ingredient gear;

	public List<Ingredient> ingredients;

	public ItemStack output;

	public GrindingRecipe(float pExperience, int pBurnTime, Ingredient pGear, List<Ingredient> pIngredients, ItemStack pOutput) {
		this.experience = pExperience;
		this.burnTime = pBurnTime;
		this.gear = pGear;
		this.ingredients = pIngredients;
		this.output = pOutput;
	}

	@Override
	public boolean canCraftInDimensions(int pWidth, int pHeight) {
		return true;
	}

	@Override
	public boolean matches(SimpleContainer pContainer, Level pLevel) {
		return !pLevel.isClientSide() && this.gear.test(pContainer.getItem(1)) && this.ingredients.get(0).test(pContainer.getItem(2));
	}

	public float getExperience() {
		return this.experience;
	}

	public int getBurnTime() {
		return this.burnTime;
	}

	@Override
	public ItemStack assemble(SimpleContainer pContainer, HolderLookup.Provider pProvider) {
		return this.output;
	}

	@Override
	public ItemStack getResultItem(HolderLookup.Provider pProvider) {
		return this.output.copy();
	}

	public Ingredient getGear() {
		return this.gear;
	}

	@Override
	public NonNullList<Ingredient> getIngredients() {
		var list = NonNullList.<Ingredient>create();
		list.addAll(this.ingredients);
		return list;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return IcariaRecipeSerializers.GRINDING.get();
	}

	@Override
	public RecipeType<?> getType() {
		return IcariaRecipeTypes.GRINDING.get();
	}
}
