package com.axanthic.icaria.common.recipe.builder;

import com.axanthic.icaria.common.recipe.builder.result.ConcoctingPotionRecipeBuilderResult;

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
import java.util.Map;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ConcoctingPotionRecipeBuilder implements RecipeBuilder {
    public float potionRadius;

    public int burnTime;
    public int color;
    public int potionDuration;

    public RecipeCategory category;

    public Ingredient ingredientA;
    public Ingredient ingredientB;
    public Ingredient ingredientC;

    public String potion;

    public Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

    public ConcoctingPotionRecipeBuilder(float pPotionRadius, int pBurnTime, int pColor, int pPotionDuration, Ingredient pIngredientA, Ingredient pIngredientB, Ingredient pIngredientC, RecipeCategory pCategory, String pPotion) {
        this.potionRadius = pPotionRadius;
        this.burnTime = pBurnTime;
        this.color = pColor;
        this.potionDuration = pPotionDuration;
        this.ingredientA = pIngredientA;
        this.ingredientB = pIngredientB;
        this.ingredientC = pIngredientC;
        this.category = pCategory;
        this.potion = pPotion;
    }

    public static ConcoctingPotionRecipeBuilder concoctingPotion(String pPotion, RecipeCategory pCategory, Ingredient pIngredientA, Ingredient pIngredientB, Ingredient pIngredientC, float pPotionRadius, int pBurnTime, int pColor, int pPotionDuration) {
        return new ConcoctingPotionRecipeBuilder(pPotionRadius, pBurnTime, pColor, pPotionDuration, pIngredientA, pIngredientB, pIngredientC, pCategory, pPotion);
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
        pRecipeOutput.accept(new ConcoctingPotionRecipeBuilderResult(this.potionRadius, this.burnTime, this.color, this.potionDuration, builder.build(pRecipeId.withPrefix("recipes" + "/" + this.category.getFolderName() + "/")), this.ingredientA, this.ingredientB, this.ingredientC, new ResourceLocation(pRecipeId.getNamespace(),"recipes" + "/" + pRecipeId.getPath()), pRecipeId, this.potion));
    }

    @Override
    public ConcoctingPotionRecipeBuilder group(@Nullable String pGroupName) {
        return this;
    }

    @Override
    public ConcoctingPotionRecipeBuilder unlockedBy(String pName, Criterion<?> pCriterion) {
        this.criteria.put(pName, pCriterion);
        return this;
    }

    @Override
    public Item getResult() {
        return ItemStack.EMPTY.getItem();
    }
}
