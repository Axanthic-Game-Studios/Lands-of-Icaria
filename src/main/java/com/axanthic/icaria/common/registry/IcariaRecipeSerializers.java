package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.recipe.*;
import com.axanthic.icaria.common.recipe.serializer.*;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaRecipeSerializers {
	public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, IcariaIdents.ID);

	public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<EntityConcoctingRecipe>> ENTITY_CONCOCTING = IcariaRecipeSerializers.RECIPE_SERIALIZERS.register("entity_concocting", EntityConcoctingRecipeSerializer::new);
	public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<ExplosionConcoctingRecipe>> EXPLOSION_CONCOCTING = IcariaRecipeSerializers.RECIPE_SERIALIZERS.register("explosion_concocting", ExplosionConcoctingSerializer::new);
	public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<FiringRecipe>> FIRING = IcariaRecipeSerializers.RECIPE_SERIALIZERS.register("firing", FiringRecipeSerializer::new);
	public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<ForgingRecipe>> FORGING = IcariaRecipeSerializers.RECIPE_SERIALIZERS.register("forging", ForgingRecipeSerializer::new);
	public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<GrillingRecipe>> GRILLING = IcariaRecipeSerializers.RECIPE_SERIALIZERS.register("grilling", GrillingRecipeSerializer::new);
	public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<GrindingRecipe>> GRINDING = IcariaRecipeSerializers.RECIPE_SERIALIZERS.register("grinding", GrindingRecipeSerializer::new);
	public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<ItemConcoctingRecipe>> ITEM_CONCOCTING = IcariaRecipeSerializers.RECIPE_SERIALIZERS.register("item_concocting", ItemConcoctingRecipeSerializer::new);
	public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<PotionConcoctingRecipe>> POTION_CONCOCTING = IcariaRecipeSerializers.RECIPE_SERIALIZERS.register("potion_concocting", PotionConcoctingRecipeSerializer::new);
}
