package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.recipe.FiringRecipe;
import com.axanthic.icaria.common.recipe.GrindingRecipe;
import com.axanthic.icaria.common.recipe.type.FiringRecipeType;
import com.axanthic.icaria.common.recipe.type.GrindingRecipeType;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeType;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class IcariaRecipeTypes {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, IcariaInfo.ID);

    public static final RegistryObject<RecipeType<FiringRecipe>> FIRING = IcariaRecipeTypes.RECIPE_TYPES.register("firing", FiringRecipeType::new);
    public static final RegistryObject<RecipeType<GrindingRecipe>> GRINDING = IcariaRecipeTypes.RECIPE_TYPES.register("grinding", GrindingRecipeType::new);
}
