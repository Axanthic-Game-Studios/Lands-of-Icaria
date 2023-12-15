package com.axanthic.icaria.common.recipe.builder;

import com.axanthic.icaria.common.recipe.builder.result.ConcoctingPotionRecipeBuilderResult;

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

public class ConcoctingPotionRecipeBuilder implements RecipeBuilder {
    public float potionRadius;

    public int burnTime;
    public int color;
    public int potionDuration;

    public Advancement.Builder advancement = Advancement.Builder.recipeAdvancement();

    public Ingredient ingredientA;
    public Ingredient ingredientB;
    public Ingredient ingredientC;

    public String potion;

    public ConcoctingPotionRecipeBuilder(float pPotionRadius, int pBurnTime, int pColor, int pPotionDuration, Ingredient pIngredientA, Ingredient pIngredientB, Ingredient pIngredientC, String pPotion) {
        this.potionRadius = pPotionRadius;
        this.burnTime = pBurnTime;
        this.color = pColor;
        this.potionDuration = pPotionDuration;
        this.ingredientA = pIngredientA;
        this.ingredientB = pIngredientB;
        this.ingredientC = pIngredientC;
        this.potion = pPotion;
    }

    public static ConcoctingPotionRecipeBuilder concoctingPotion(String pPotion, Ingredient pIngredientA, Ingredient pIngredientB, Ingredient pIngredientC, float pPotionRadius, int pBurnTime, int pColor, int pPotionDuration) {
        return new ConcoctingPotionRecipeBuilder(pPotionRadius, pBurnTime, pColor, pPotionDuration, pIngredientA, pIngredientB, pIngredientC, pPotion);
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
        pFinishedRecipeConsumer.accept(new ConcoctingPotionRecipeBuilderResult(this.potionRadius, this.burnTime, this.color, this.potionDuration, this.advancement, this.ingredientA, this.ingredientB, this.ingredientC, new ResourceLocation(pRecipeId.getNamespace(),"recipes/" + pRecipeId.getPath()), pRecipeId, this.potion));
    }

    @Override
    public ConcoctingPotionRecipeBuilder group(@Nullable String pGroupName) {
        return this;
    }

    @Override
    public ConcoctingPotionRecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
        this.advancement.addCriterion(pCriterionName, pCriterionTrigger);
        return this;
    }

    @Override
    public Item getResult() {
        return ItemStack.EMPTY.getItem();
    }
}
