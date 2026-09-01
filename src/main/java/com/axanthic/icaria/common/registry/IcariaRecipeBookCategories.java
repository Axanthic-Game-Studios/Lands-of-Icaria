package com.axanthic.icaria.common.registry;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeBookCategory;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaRecipeBookCategories {
	public static final DeferredRegister<RecipeBookCategory> RECIPE_BOOK_CATEGORIES = DeferredRegister.create(Registries.RECIPE_BOOK_CATEGORY, IcariaKeys.ID);

	public static final DeferredHolder<RecipeBookCategory, RecipeBookCategory> ENTITY_CONCOCTING = IcariaRecipeBookCategories.RECIPE_BOOK_CATEGORIES.register("entity_concocting", RecipeBookCategory::new);
	public static final DeferredHolder<RecipeBookCategory, RecipeBookCategory> EXPLOSION_CONCOCTING = IcariaRecipeBookCategories.RECIPE_BOOK_CATEGORIES.register("explosion_concocting", RecipeBookCategory::new);
	public static final DeferredHolder<RecipeBookCategory, RecipeBookCategory> FIRING = IcariaRecipeBookCategories.RECIPE_BOOK_CATEGORIES.register("firing", RecipeBookCategory::new);
	public static final DeferredHolder<RecipeBookCategory, RecipeBookCategory> FORGING = IcariaRecipeBookCategories.RECIPE_BOOK_CATEGORIES.register("forging", RecipeBookCategory::new);
	public static final DeferredHolder<RecipeBookCategory, RecipeBookCategory> GRILLING = IcariaRecipeBookCategories.RECIPE_BOOK_CATEGORIES.register("grilling", RecipeBookCategory::new);
	public static final DeferredHolder<RecipeBookCategory, RecipeBookCategory> GRINDING = IcariaRecipeBookCategories.RECIPE_BOOK_CATEGORIES.register("grinding", RecipeBookCategory::new);
	public static final DeferredHolder<RecipeBookCategory, RecipeBookCategory> ITEM_CONCOCTING = IcariaRecipeBookCategories.RECIPE_BOOK_CATEGORIES.register("item_concocting", RecipeBookCategory::new);
	public static final DeferredHolder<RecipeBookCategory, RecipeBookCategory> POTION_CONCOCTING = IcariaRecipeBookCategories.RECIPE_BOOK_CATEGORIES.register("potion_concocting", RecipeBookCategory::new);
}
