package com.axanthic.icaria.common.recipe.builder;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.recipe.EntityConcoctingRecipe;

import javax.annotation.Nullable;

import net.minecraft.advancements.triggers.Criterion;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeUnlockAdvancementBuilder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class EntityConcoctingRecipeBuilder implements RecipeBuilder {
	public int colour;
	public int time;

	public EntityType<?> entityType;

	public Ingredient ingredient;

	public RecipeCategory recipeCategory;

	public RecipeUnlockAdvancementBuilder recipeUnlockAdvancementBuilder = new RecipeUnlockAdvancementBuilder();

	public EntityConcoctingRecipeBuilder(int pColour, int pTime, EntityType<?> pEntityType, Ingredient pIngredient, RecipeCategory pRecipeCategory) {
		this.colour = pColour;
		this.time = pTime;
		this.entityType = pEntityType;
		this.ingredient = pIngredient;
		this.recipeCategory = pRecipeCategory;
	}

	@Override
	public void save(RecipeOutput pRecipeOutput, ResourceKey<Recipe<?>> pResourceKey) {
		pRecipeOutput.accept(pResourceKey, new EntityConcoctingRecipe(this.colour, this.time, this.entityType, this.ingredient), this.recipeUnlockAdvancementBuilder.build(pRecipeOutput, pResourceKey, this.recipeCategory));
	}

	@Override
	public EntityConcoctingRecipeBuilder group(@Nullable String pName) {
		return this;
	}

	@Override
	public EntityConcoctingRecipeBuilder unlockedBy(String pName, Criterion<?> pCriterion) {
		this.recipeUnlockAdvancementBuilder.unlockedBy(pName, pCriterion);
		return this;
	}

	@Override
	public ResourceKey<Recipe<?>> defaultId() {
		return ResourceKey.create(Registries.RECIPE, EntityType.getKey(this.entityType));
	}

	public static EntityConcoctingRecipeBuilder entityConcocting(RecipeCategory pRecipeCategory, EntityType<?> pEntity, Ingredient pIngredient, int pColour, int pTime) {
		return new EntityConcoctingRecipeBuilder(pColour, pTime, pEntity, pIngredient, pRecipeCategory);
	}
}
