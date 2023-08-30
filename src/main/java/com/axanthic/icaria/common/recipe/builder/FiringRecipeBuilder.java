package com.axanthic.icaria.common.recipe.builder;

import com.axanthic.icaria.common.recipe.builder.result.FiringRecipeBuilderResult;

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

public class FiringRecipeBuilder implements RecipeBuilder {
    public float experience;

    public int burnTime;

    public Advancement.Builder advancement = Advancement.Builder.recipeAdvancement();

    public Ingredient ingredient;

    public Item output;

    public FiringRecipeBuilder(float pExperience, int pBurnTime, Ingredient pIngredients, ItemLike pOutput) {
        this.experience = pExperience;
        this.burnTime = pBurnTime;
        this.ingredient = pIngredients;
        this.output = pOutput.asItem();
    }

    public static FiringRecipeBuilder firing(ItemLike pOutput, Ingredient pIngredient, float pExperience, int pBurnTime) {
        return new FiringRecipeBuilder(pExperience, pBurnTime, pIngredient, pOutput);
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
        pFinishedRecipeConsumer.accept(new FiringRecipeBuilderResult(this.experience, this.burnTime, this.advancement, this.ingredient, this.output, new ResourceLocation(pRecipeId.getNamespace(),"recipes/" + pRecipeId.getPath()), pRecipeId));
    }

    @Override
    public FiringRecipeBuilder group(@Nullable String pGroupName) {
        return this;
    }

    @Override
    public FiringRecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
        this.advancement.addCriterion(pCriterionName, pCriterionTrigger);
        return this;
    }

    @Override
    public Item getResult() {
        return this.output;
    }
}
