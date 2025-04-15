package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.recipe.*;
import com.axanthic.icaria.common.recipe.type.*;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeType;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaRecipeTypes {
	public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, IcariaIdents.ID);

	public static final DeferredHolder<RecipeType<?>, RecipeType<EntityConcoctingRecipe>> ENTITY_CONCOCTING = IcariaRecipeTypes.RECIPE_TYPES.register("entity_concocting", EntityConcoctingRecipeType::new);
	public static final DeferredHolder<RecipeType<?>, RecipeType<ExplosionConcoctingRecipe>> EXPLOSION_CONCOCTING = IcariaRecipeTypes.RECIPE_TYPES.register("explosion_concocting", ExplosionConcoctingRecipeType::new);
	public static final DeferredHolder<RecipeType<?>, RecipeType<FiringRecipe>> FIRING = IcariaRecipeTypes.RECIPE_TYPES.register("firing", FiringRecipeType::new);
	public static final DeferredHolder<RecipeType<?>, RecipeType<ForgingRecipe>> FORGING = IcariaRecipeTypes.RECIPE_TYPES.register("forging", ForgingRecipeType::new);
	public static final DeferredHolder<RecipeType<?>, RecipeType<GrindingRecipe>> GRINDING = IcariaRecipeTypes.RECIPE_TYPES.register("grinding", GrindingRecipeType::new);
	public static final DeferredHolder<RecipeType<?>, RecipeType<ItemConcoctingRecipe>> ITEM_CONCOCTING = IcariaRecipeTypes.RECIPE_TYPES.register("item_concocting", ItemConcoctingRecipeType::new);
	public static final DeferredHolder<RecipeType<?>, RecipeType<PotionConcoctingRecipe>> POTION_CONCOCTING = IcariaRecipeTypes.RECIPE_TYPES.register("potion_concocting", PotionConcoctingRecipeType::new);
}
