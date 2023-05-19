package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.recipe.GrindingRecipe;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class IcariaRecipeSerializers {
	public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, IcariaInfo.ID);

	public static final RegistryObject<RecipeSerializer<GrindingRecipe>> GRINDING_RECIPE = RECIPE_SERIALIZERS.register("grinding", () -> GrindingRecipe.Serializer.INSTANCE);
}
