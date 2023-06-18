package com.axanthic.icaria.common.recipe;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrindingRecipe implements Recipe<SimpleContainer> {
	public int burnTime;

	public Ingredient gear;

	public ItemStack result;

	public NonNullList<Ingredient> ingredients;

	public ResourceLocation id;

	public GrindingRecipe(ResourceLocation pId, ItemStack pResult, NonNullList<Ingredient> pIngredients, Ingredient pGear, int pBurnTime) {
		this.id = pId;
		this.result = pResult;
		this.ingredients = pIngredients;
		this.gear = pGear;
		this.burnTime = pBurnTime;
	}

	@Override
	public boolean canCraftInDimensions(int pWidth, int pHeight) {
		return true;
	}

	@Override
	public boolean matches(SimpleContainer pContainer, Level pLevel) {
		if (!pLevel.isClientSide) {
			if (this.gear.test(pContainer.getItem(2))) {
				return this.ingredients.get(0).test(pContainer.getItem(0));
			}
		}

		return false;
	}

	public int getBurnTime() {
		return this.burnTime;
	}

	@Override
	public ItemStack assemble(SimpleContainer pContainer, RegistryAccess pAccess) {
		return ItemStack.EMPTY;
	}

	@Override
	public ItemStack getResultItem(RegistryAccess pAccess) {
		return ItemStack.EMPTY;
	}

	@Override
	public NonNullList<Ingredient> getIngredients() {
		return this.ingredients;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return GrindingRecipeSerializer.INSTANCE;
	}

	@Override
	public RecipeType<?> getType() {
		return GrindingRecipeType.INSTANCE;
	}

	@Override
	public ResourceLocation getId() {
		return this.id;
	}
}
