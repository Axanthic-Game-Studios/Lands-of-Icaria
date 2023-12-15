package com.axanthic.icaria.common.recipe.builder;

import com.axanthic.icaria.common.recipe.builder.result.ConcoctingExplosionsRecipeBuilderResult;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Consumer;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ConcoctingExplosionsRecipeBuilder implements RecipeBuilder {
    public float radius;

    public int burnTime;
    public int color;

    public Advancement.Builder advancement = Advancement.Builder.recipeAdvancement();

    public Ingredient ingredientA;
    public Ingredient ingredientB;
    public Ingredient ingredientC;

    public ConcoctingExplosionsRecipeBuilder(float pRadius, int pBurnTime, int pColor, Ingredient pIngredientA, Ingredient pIngredientB, Ingredient pIngredientC) {
        this.radius = pRadius;
        this.burnTime = pBurnTime;
        this.color = pColor;
        this.ingredientA = pIngredientA;
        this.ingredientB = pIngredientB;
        this.ingredientC = pIngredientC;
    }

    public static ConcoctingExplosionsRecipeBuilder concoctingExplosions(Ingredient pIngredientA, Ingredient pIngredientB, Ingredient pIngredientC, float pRadius, int pBurnTime, int pColor) {
        return new ConcoctingExplosionsRecipeBuilder(pRadius, pBurnTime, pColor, pIngredientA, pIngredientB, pIngredientC);
    }

    public void ensureValid(ResourceLocation pId) {
        if (this.advancement.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + pId);
        }
    }

    @Override
    public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ResourceLocation pRecipeId) {
        this.advancement.addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pRecipeId)).parent(RecipeBuilder.ROOT_RECIPE_ADVANCEMENT).requirements(RequirementsStrategy.OR).rewards(AdvancementRewards.Builder.recipe(pRecipeId));
        this.ensureValid(pRecipeId);
        pFinishedRecipeConsumer.accept(new ConcoctingExplosionsRecipeBuilderResult(this.radius, this.burnTime, this.color, this.advancement, this.ingredientA, this.ingredientB, this.ingredientC, new ResourceLocation(pRecipeId.getNamespace(),"recipes/" + pRecipeId.getPath()), pRecipeId));
    }

    @Override
    public ConcoctingExplosionsRecipeBuilder group(@Nullable String pGroupName) {
        return this;
    }

    @Override
    public ConcoctingExplosionsRecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
        this.advancement.addCriterion(pCriterionName, pCriterionTrigger);
        return this;
    }

    @Override
    public Item getResult() {
        return ItemStack.EMPTY.getItem();
    }
}
