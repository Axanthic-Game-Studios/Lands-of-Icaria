package com.axanthic.icaria.common.recipe.builder;

import com.axanthic.icaria.common.recipe.builder.result.ConcoctingEntityRecipeBuilderResult;

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

public class ConcoctingEntityRecipeBuilder implements RecipeBuilder {
    public int burnTime;
    public int color;

    public Advancement.Builder advancement = Advancement.Builder.recipeAdvancement();

    public Ingredient ingredientA;
    public Ingredient ingredientB;
    public Ingredient ingredientC;

    public String entity;

    public ConcoctingEntityRecipeBuilder(int pBurnTime, int pColor, Ingredient pIngredientA, Ingredient pIngredientB, Ingredient pIngredientC, String pEntity) {
        this.burnTime = pBurnTime;
        this.color = pColor;
        this.ingredientA = pIngredientA;
        this.ingredientB = pIngredientB;
        this.ingredientC = pIngredientC;
        this.entity = pEntity;
    }

    public static ConcoctingEntityRecipeBuilder concoctingEntity(String pEntity, Ingredient pIngredientA, Ingredient pIngredientB, Ingredient pIngredientC, int pBurnTime, int pColor) {
        return new ConcoctingEntityRecipeBuilder(pBurnTime, pColor, pIngredientA, pIngredientB, pIngredientC, pEntity);
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
        pFinishedRecipeConsumer.accept(new ConcoctingEntityRecipeBuilderResult(this.burnTime, this.color, this.advancement, this.ingredientA, this.ingredientB, this.ingredientC, new ResourceLocation(pRecipeId.getNamespace(),"recipes/" + pRecipeId.getPath()), pRecipeId, this.entity));
    }

    @Override
    public ConcoctingEntityRecipeBuilder group(@Nullable String pGroupName) {
        return this;
    }

    @Override
    public ConcoctingEntityRecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
        this.advancement.addCriterion(pCriterionName, pCriterionTrigger);
        return this;
    }

    @Override
    public Item getResult() {
        return ItemStack.EMPTY.getItem();
    }
}
