package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.recipe.display.FiringRecipeDisplay;
import com.axanthic.icaria.common.recipe.display.ForgingRecipeDisplay;
import com.axanthic.icaria.common.recipe.display.GrindingRecipeDisplay;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.display.RecipeDisplay;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaRecipeDisplays {
	public static final DeferredRegister<RecipeDisplay.Type<?>> RECIPE_DISPLAYS = DeferredRegister.create(Registries.RECIPE_DISPLAY, IcariaKeys.ID);

	public static final DeferredHolder<RecipeDisplay.Type<?>, RecipeDisplay.Type<FiringRecipeDisplay>> FIRING = IcariaRecipeDisplays.RECIPE_DISPLAYS.register("firing", () -> new RecipeDisplay.Type<>(FiringRecipeDisplay.MAP_CODEC, FiringRecipeDisplay.STREAM_CODEC));
	public static final DeferredHolder<RecipeDisplay.Type<?>, RecipeDisplay.Type<ForgingRecipeDisplay>> FORGING = IcariaRecipeDisplays.RECIPE_DISPLAYS.register("forging", () -> new RecipeDisplay.Type<>(ForgingRecipeDisplay.MAP_CODEC, ForgingRecipeDisplay.STREAM_CODEC));
	public static final DeferredHolder<RecipeDisplay.Type<?>, RecipeDisplay.Type<GrindingRecipeDisplay>> GRINDING = IcariaRecipeDisplays.RECIPE_DISPLAYS.register("grinding", () -> new RecipeDisplay.Type<>(GrindingRecipeDisplay.MAP_CODEC, GrindingRecipeDisplay.STREAM_CODEC));
}
