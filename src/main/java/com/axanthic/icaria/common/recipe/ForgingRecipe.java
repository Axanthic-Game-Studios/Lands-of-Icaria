package com.axanthic.icaria.common.recipe;

import com.axanthic.icaria.common.registry.IcariaRecipeSerializers;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
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

public class ForgingRecipe implements Recipe<SimpleContainer> {
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
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        return !pLevel.isClientSide() && (this.ingredients.get(0).test(pContainer.getItem(0)) && this.ingredients.get(1).test(pContainer.getItem(1)) && this.ingredients.get(2).test(pContainer.getItem(2))) || (this.ingredients.get(0).test(pContainer.getItem(1)) && this.ingredients.get(1).test(pContainer.getItem(2)) && this.ingredients.get(2).test(pContainer.getItem(0))) || (this.ingredients.get(0).test(pContainer.getItem(2)) && this.ingredients.get(1).test(pContainer.getItem(0)) && this.ingredients.get(2).test(pContainer.getItem(1)));
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
