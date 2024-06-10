package com.axanthic.icaria.common.recipe.builder;

import com.axanthic.icaria.common.recipe.builder.result.FiringRecipeBuilderResult;

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
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FiringRecipeBuilder implements RecipeBuilder {
    public float experience;

    public int burnTime;
    public int count;

    public RecipeCategory category;

    public Ingredient ingredient;

    public Item output;

    public Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

    public FiringRecipeBuilder(float pExperience, int pBurnTime, int pCount, Ingredient pIngredients, ItemLike pOutput, RecipeCategory pCategory) {
        this.experience = pExperience;
        this.burnTime = pBurnTime;
        this.count = pCount;
        this.ingredient = pIngredients;
        this.output = pOutput.asItem();
        this.category = pCategory;
    }

    public static FiringRecipeBuilder firing(RecipeCategory pCategory, ItemLike pOutput, Ingredient pIngredient, float pExperience, int pBurnTime, int pCount) {
        return new FiringRecipeBuilder(pExperience, pBurnTime, pCount, pIngredient, pOutput, pCategory);
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
        pRecipeOutput.accept(new FiringRecipeBuilderResult(this.experience, this.burnTime, this.count, builder.build(pRecipeId.withPrefix("recipes" + "/" + this.category.getFolderName() + "/")), this.ingredient, this.output, new ResourceLocation(pRecipeId.getNamespace(),"recipes" + "/" + pRecipeId.getPath()), pRecipeId));
    }

    @Override
    public FiringRecipeBuilder group(@Nullable String pGroupName) {
        return this;
    }

    @Override
    public FiringRecipeBuilder unlockedBy(String pName, Criterion<?> pCriterion) {
        this.criteria.put(pName, pCriterion);
        return this;
    }

    @Override
    public Item getResult() {
        return this.output;
    }
}
