package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.recipe.GrinderRecipe;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class IcariaRecipeTypes {
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister
			.create(ForgeRegistries.RECIPE_SERIALIZERS, IcariaInfo.MODID);

	public static final RegistryObject<RecipeSerializer<GrinderRecipe>> GRINDER_SERIALIZER = SERIALIZERS
			.register("grinder", () -> GrinderRecipe.Serializer.INSTANCE);

}
