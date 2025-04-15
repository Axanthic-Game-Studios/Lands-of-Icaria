package com.axanthic.icaria.common.registry;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeBookCategory;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaRecipeBookCategories {
	public static final DeferredRegister<RecipeBookCategory> RECIPE_BOOK_CATEGORIES = DeferredRegister.create(Registries.RECIPE_BOOK_CATEGORY, IcariaIdents.ID);

	public static final DeferredHolder<RecipeBookCategory, RecipeBookCategory> FORGE = IcariaRecipeBookCategories.RECIPE_BOOK_CATEGORIES.register("forge", RecipeBookCategory::new);
	public static final DeferredHolder<RecipeBookCategory, RecipeBookCategory> GRINDER = IcariaRecipeBookCategories.RECIPE_BOOK_CATEGORIES.register("grinder", RecipeBookCategory::new);
	public static final DeferredHolder<RecipeBookCategory, RecipeBookCategory> KETTLE_ENTITY = IcariaRecipeBookCategories.RECIPE_BOOK_CATEGORIES.register("kettle_entity", RecipeBookCategory::new);
	public static final DeferredHolder<RecipeBookCategory, RecipeBookCategory> KETTLE_EXPLOSION = IcariaRecipeBookCategories.RECIPE_BOOK_CATEGORIES.register("kettle_explosion", RecipeBookCategory::new);
	public static final DeferredHolder<RecipeBookCategory, RecipeBookCategory> KETTLE_ITEM = IcariaRecipeBookCategories.RECIPE_BOOK_CATEGORIES.register("kettle_item", RecipeBookCategory::new);
	public static final DeferredHolder<RecipeBookCategory, RecipeBookCategory> KETTLE_POTION = IcariaRecipeBookCategories.RECIPE_BOOK_CATEGORIES.register("kettle_potion", RecipeBookCategory::new);
	public static final DeferredHolder<RecipeBookCategory, RecipeBookCategory> KILN = IcariaRecipeBookCategories.RECIPE_BOOK_CATEGORIES.register("kiln", RecipeBookCategory::new);
}
