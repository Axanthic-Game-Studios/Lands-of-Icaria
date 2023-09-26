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

public class ForgingRecipe implements Recipe<SimpleContainer> {
    public float experience;

    public int burnTime;

    public NonNullList<Ingredient> ingredients;

    public ItemStack output;

    public ResourceLocation id;

    public ForgingRecipe(float pExperience, int pBurnTime, NonNullList<Ingredient> pIngredients, ItemStack pOutput, ResourceLocation pId) {
        this.experience = pExperience;
        this.burnTime = pBurnTime;
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
        return !pLevel.isClientSide() && this.ingredients.get(0).test(pContainer.getItem(0)) && this.ingredients.get(1).test(pContainer.getItem(1)) && this.ingredients.get(2).test(pContainer.getItem(2));
    }

    public float getExperience() {
        return this.experience;
    }

    public int getBurnTime() {
        return this.burnTime;
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer, RegistryAccess pRegistryAccess) {
        return this.output;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess pRegistryAccess) {
        return this.output.copy();
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return this.ingredients;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return IcariaRecipeSerializers.FORGING.get();
    }

    @Override
    public RecipeType<?> getType() {
        return IcariaRecipeTypes.FORGING.get();
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }
}
