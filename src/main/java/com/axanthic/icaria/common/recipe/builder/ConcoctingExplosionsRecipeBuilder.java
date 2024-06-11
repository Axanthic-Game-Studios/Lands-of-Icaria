package com.axanthic.icaria.common.recipe.builder;

import com.axanthic.icaria.common.recipe.ConcoctingExplosionsRecipe;

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

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ConcoctingExplosionsRecipeBuilder implements RecipeBuilder {
    public float radius;

    public int burnTime;
    public int color;

    public RecipeCategory category;

    public Ingredient ingredientA;
    public Ingredient ingredientB;
    public Ingredient ingredientC;

    public Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

    public ConcoctingExplosionsRecipeBuilder(float pRadius, int pBurnTime, int pColor, Ingredient pIngredientA, Ingredient pIngredientB, Ingredient pIngredientC, RecipeCategory pCategory) {
        this.radius = pRadius;
        this.burnTime = pBurnTime;
        this.color = pColor;
        this.ingredientA = pIngredientA;
        this.ingredientB = pIngredientB;
        this.ingredientC = pIngredientC;
        this.category = pCategory;
    }

    public static ConcoctingExplosionsRecipeBuilder concoctingExplosions(RecipeCategory pCategory, Ingredient pIngredientA, Ingredient pIngredientB, Ingredient pIngredientC, float pRadius, int pBurnTime, int pColor) {
        return new ConcoctingExplosionsRecipeBuilder(pRadius, pBurnTime, pColor, pIngredientA, pIngredientB, pIngredientC, pCategory);
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
        var recipe = new ConcoctingExplosionsRecipe(this.radius, this.burnTime, this.color, List.of(this.ingredientA, this.ingredientB, this.ingredientC));
        pRecipeOutput.accept(pRecipeId, recipe, builder.build(pRecipeId.withPrefix("recipes" + "/" + this.category.getFolderName() + "/")));
    }

    @Override
    public ConcoctingExplosionsRecipeBuilder group(@Nullable String pGroupName) {
        return this;
    }

    @Override
    public ConcoctingExplosionsRecipeBuilder unlockedBy(String pName, Criterion<?> pCriterion) {
        this.criteria.put(pName, pCriterion);
        return this;
    }

    @Override
    public Item getResult() {
        return ItemStack.EMPTY.getItem();
    }
}
