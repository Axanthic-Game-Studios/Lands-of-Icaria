package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.recipe.FiringRecipe;
import com.axanthic.icaria.common.recipe.ForgingRecipe;
import com.axanthic.icaria.common.recipe.GrindingRecipe;
import com.axanthic.icaria.common.recipe.serializer.FiringRecipeSerializer;
import com.axanthic.icaria.common.recipe.serializer.ForgingRecipeSerializer;
import com.axanthic.icaria.common.recipe.serializer.GrindingRecipeSerializer;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class IcariaRecipeSerializers {
	public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, IcariaInfo.ID);

	public static final RegistryObject<RecipeSerializer<FiringRecipe>> FIRING = IcariaRecipeSerializers.RECIPE_SERIALIZERS.register("firing", FiringRecipeSerializer::new);
	public static final RegistryObject<RecipeSerializer<ForgingRecipe>> FORGING = IcariaRecipeSerializers.RECIPE_SERIALIZERS.register("forging", ForgingRecipeSerializer::new);
	public static final RegistryObject<RecipeSerializer<GrindingRecipe>> GRINDING = IcariaRecipeSerializers.RECIPE_SERIALIZERS.register("grinding", GrindingRecipeSerializer::new);
}
