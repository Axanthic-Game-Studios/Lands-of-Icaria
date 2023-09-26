package com.axanthic.icaria.common.recipe.builder;

import com.axanthic.icaria.common.recipe.builder.result.ForgingRecipeBuilderResult;

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
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ForgingRecipeBuilder implements RecipeBuilder {
    public float experience;

    public int burnTime;
    public int count;

    public Advancement.Builder advancement = Advancement.Builder.recipeAdvancement();

    public Ingredient ingredientFirst;
    public Ingredient ingredientSecond;
    public Ingredient ingredientThird;

    public Item output;

    public ForgingRecipeBuilder(float pExperience, int pBurnTime, int pCount, Ingredient pIngredientFirst, Ingredient pIngredientSecond, Ingredient pIngredientThird, ItemLike pOutput) {
        this.experience = pExperience;
        this.burnTime = pBurnTime;
        this.count = pCount;
        this.ingredientFirst = pIngredientFirst;
        this.ingredientSecond = pIngredientSecond;
        this.ingredientThird = pIngredientThird;
        this.output = pOutput.asItem();
    }

    public static ForgingRecipeBuilder forging(ItemLike pOutput, Ingredient pIngredientFirst, Ingredient pIngredientSecond, Ingredient pIngredientThird, float pExperience, int pBurnTime, int pCount) {
        return new ForgingRecipeBuilder(pExperience, pBurnTime, pCount, pIngredientFirst, pIngredientSecond, pIngredientThird, pOutput);
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
        pFinishedRecipeConsumer.accept(new ForgingRecipeBuilderResult(this.experience, this.burnTime, this.count, this.advancement, this.ingredientFirst, this.ingredientSecond, this.ingredientThird, this.output, new ResourceLocation(pRecipeId.getNamespace(),"recipes/" + pRecipeId.getPath()), pRecipeId));
    }

    @Override
    public ForgingRecipeBuilder group(@Nullable String pGroupName) {
        return this;
    }

    @Override
    public ForgingRecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
        this.advancement.addCriterion(pCriterionName, pCriterionTrigger);
        return this;
    }

    @Override
    public Item getResult() {
        return this.output;
    }
}
