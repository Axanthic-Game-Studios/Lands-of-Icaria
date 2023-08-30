package com.axanthic.icaria.common.recipe;

import com.axanthic.icaria.common.registry.IcariaRecipeSerializers;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;

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

	public NonNullList<Ingredient> ingredients;

	public ItemStack output;

	public ResourceLocation id;

	public GrindingRecipe(int pBurnTime, Ingredient pGear, NonNullList<Ingredient> pIngredients, ItemStack pOutput, ResourceLocation pId) {
		this.burnTime = pBurnTime;
		this.gear = pGear;
		this.ingredients = pIngredients;
		this.output = pOutput;
		this.id = pId;
	}

	@Override
	public boolean canCraftInDimensions(int pWidth, int pHeight) {
		return true;
	}

	@Override
	public boolean matches(SimpleContainer pContainer, Level pLevel) {
		return !pLevel.isClientSide() && this.ingredients.get(0).test(pContainer.getItem(0)) && this.gear.test(pContainer.getItem(2));
	}

	public int getBurnTime() {
		return this.burnTime;
	}

	@Override
	public ItemStack assemble(SimpleContainer pContainer, RegistryAccess pAccess) {
		return this.output;
	}

	@Override
	public ItemStack getResultItem(RegistryAccess pAccess) {
		return this.output.copy();
	}

	public Ingredient getGear() {
		return this.gear;
	}

	@Override
	public NonNullList<Ingredient> getIngredients() {
		return this.ingredients;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return IcariaRecipeSerializers.GRINDING.get();
	}

	@Override
	public RecipeType<?> getType() {
		return IcariaRecipeTypes.GRINDING.get();
	}

	@Override
	public ResourceLocation getId() {
		return this.id;
	}
}
