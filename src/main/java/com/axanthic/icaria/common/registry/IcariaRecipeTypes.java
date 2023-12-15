package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.recipe.*;
import com.axanthic.icaria.common.recipe.type.*;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeType;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class IcariaRecipeTypes {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, IcariaInfo.ID);

    public static final RegistryObject<RecipeType<ConcoctingEntityRecipe>> CONCOCTING_ENTITY = IcariaRecipeTypes.RECIPE_TYPES.register("concocting_entity", ConcoctingEntityRecipeType::new);
    public static final RegistryObject<RecipeType<ConcoctingExplosionsRecipe>> CONCOCTING_EXPLOSIONS = IcariaRecipeTypes.RECIPE_TYPES.register("concocting_explosions", ConcoctingExplosionsRecipeType::new);
    public static final RegistryObject<RecipeType<ConcoctingItemRecipe>> CONCOCTING_ITEM = IcariaRecipeTypes.RECIPE_TYPES.register("concocting_item", ConcoctingItemRecipeType::new);
    public static final RegistryObject<RecipeType<ConcoctingPotionRecipe>> CONCOCTING_POTION = IcariaRecipeTypes.RECIPE_TYPES.register("concocting_potion", ConcoctingPotionRecipeType::new);
    public static final RegistryObject<RecipeType<FiringRecipe>> FIRING = IcariaRecipeTypes.RECIPE_TYPES.register("firing", FiringRecipeType::new);
    public static final RegistryObject<RecipeType<ForgingRecipe>> FORGING = IcariaRecipeTypes.RECIPE_TYPES.register("forging", ForgingRecipeType::new);
    public static final RegistryObject<RecipeType<GrindingRecipe>> GRINDING = IcariaRecipeTypes.RECIPE_TYPES.register("grinding", GrindingRecipeType::new);
}
