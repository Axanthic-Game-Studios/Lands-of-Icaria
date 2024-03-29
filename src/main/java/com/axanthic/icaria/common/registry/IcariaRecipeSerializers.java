package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.recipe.*;
import com.axanthic.icaria.common.recipe.serializer.*;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class IcariaRecipeSerializers {
	public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, IcariaInfo.ID);

	public static final RegistryObject<RecipeSerializer<ConcoctingEntityRecipe>> CONCOCTING_ENTITY = IcariaRecipeSerializers.RECIPE_SERIALIZERS.register("concocting_entity", ConcoctingEntityRecipeSerializer::new);
	public static final RegistryObject<RecipeSerializer<ConcoctingExplosionsRecipe>> CONCOCTING_EXPLOSIONS = IcariaRecipeSerializers.RECIPE_SERIALIZERS.register("concocting_explosions", ConcoctingExplosionsRecipeSerializer::new);
	public static final RegistryObject<RecipeSerializer<ConcoctingItemRecipe>> CONCOCTING_ITEM = IcariaRecipeSerializers.RECIPE_SERIALIZERS.register("concocting_item", ConcoctingItemRecipeSerializer::new);
	public static final RegistryObject<RecipeSerializer<ConcoctingPotionRecipe>> CONCOCTING_POTION = IcariaRecipeSerializers.RECIPE_SERIALIZERS.register("concocting_potion", ConcoctingPotionRecipeSerializer::new);
	public static final RegistryObject<RecipeSerializer<FiringRecipe>> FIRING = IcariaRecipeSerializers.RECIPE_SERIALIZERS.register("firing", FiringRecipeSerializer::new);
	public static final RegistryObject<RecipeSerializer<ForgingRecipe>> FORGING = IcariaRecipeSerializers.RECIPE_SERIALIZERS.register("forging", ForgingRecipeSerializer::new);
	public static final RegistryObject<RecipeSerializer<GrindingRecipe>> GRINDING = IcariaRecipeSerializers.RECIPE_SERIALIZERS.register("grinding", GrindingRecipeSerializer::new);
}
