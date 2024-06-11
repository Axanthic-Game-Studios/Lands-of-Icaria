package com.axanthic.icaria.common.recipe.builder;

import com.axanthic.icaria.common.recipe.ConcoctingItemRecipe;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ConcoctingItemRecipeBuilder implements RecipeBuilder {
    public int burnTime;
    public int color;
    public int count;

    public RecipeCategory category;

    public Ingredient ingredientA;
    public Ingredient ingredientB;
    public Ingredient ingredientC;

    public Item output;

    public Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

    public ConcoctingItemRecipeBuilder(int pBurnTime, int pColor, int pCount, Ingredient pIngredientA, Ingredient pIngredientB, Ingredient pIngredientC, ItemLike pOutput, RecipeCategory pCategory) {
        this.burnTime = pBurnTime;
        this.color = pColor;
        this.count = pCount;
        this.ingredientA = pIngredientA;
        this.ingredientB = pIngredientB;
        this.ingredientC = pIngredientC;
        this.output = pOutput.asItem();
        this.category = pCategory;
    }

    public static ConcoctingItemRecipeBuilder concoctingItem(RecipeCategory pCategory, ItemLike pOutput, Ingredient pIngredientA, Ingredient pIngredientB, Ingredient pIngredientC, int pBurnTime, int pColor, int pCount) {
        return new ConcoctingItemRecipeBuilder(pBurnTime, pColor, pCount, pIngredientA, pIngredientB, pIngredientC, pOutput, pCategory);
    }

    public void ensureValid(ResourceLocation pId) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + pId);
        }
    }

    @Override
    public void save(RecipeOutput pRecipeOutput, ResourceLocation pRecipeId) {
        this.ensureValid(pRecipeId);
        var builder = pRecipeOutput.advancement().addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pRecipeId)).requirements(AdvancementRequirements.Strategy.OR).rewards(AdvancementRewards.Builder.recipe(pRecipeId));
        var recipe = new ConcoctingItemRecipe(this.burnTime, this.color, new ItemStack(this.output, this.count), List.of(this.ingredientA, this.ingredientB, this.ingredientC));
        pRecipeOutput.accept(pRecipeId, recipe, builder.build(pRecipeId.withPrefix("recipes" + "/" + this.category.getFolderName() + "/")));
    }

    @Override
    public ConcoctingItemRecipeBuilder group(@Nullable String pGroupName) {
        return this;
    }

    @Override
    public ConcoctingItemRecipeBuilder unlockedBy(String pName, Criterion<?> pCriterion) {
        this.criteria.put(pName, pCriterion);
        return this;
    }

    @Override
    public Item getResult() {
        return this.output;
    }
}
