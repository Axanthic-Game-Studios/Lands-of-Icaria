package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.recipe.GrindingRecipe;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.world.item.crafting.RecipeSerializer;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class IcariaRecipeTypes {
	public static final DeferredRegister<RecipeSerializer<?>> RECIPE_TYPES = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, IcariaInfo.MODID);

	public static final RegistryObject<RecipeSerializer<GrindingRecipe>> GRINDING_RECIPE = RECIPE_TYPES.register("grinding", () -> GrindingRecipe.Serializer.INSTANCE);
}
