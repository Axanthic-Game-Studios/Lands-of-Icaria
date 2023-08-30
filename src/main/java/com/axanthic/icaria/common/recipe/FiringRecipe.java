package com.axanthic.icaria.common.recipe;

import com.axanthic.icaria.common.registry.IcariaRecipeSerializers;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FiringRecipe implements Recipe<SimpleContainer> {
    public float experience;

    public int burnTime;

    public NonNullList<Ingredient> ingredients;

    public ItemStack output;

    public ResourceLocation id;

    public FiringRecipe(float pExperience, int pBurnTime, NonNullList<Ingredient> pIngredients, ItemStack pOutput, ResourceLocation pId) {
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
        return !pLevel.isClientSide() && this.ingredients.get(0).test(pContainer.getItem(0));
    }

    public int getBurnTime() {
        return this.burnTime;
    }

    public float getExperience() {
        return this.experience;
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
        return IcariaRecipeSerializers.FIRING.get();
    }

    @Override
    public RecipeType<?> getType() {
        return IcariaRecipeTypes.FIRING.get();
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }
}
