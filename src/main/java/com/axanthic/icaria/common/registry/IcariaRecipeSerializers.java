package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.recipe.*;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaRecipeSerializers {
	public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, IcariaKeys.ID);

	public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<EntityConcoctingRecipe>> ENTITY_CONCOCTING = IcariaRecipeSerializers.RECIPE_SERIALIZERS.register("entity_concocting", () -> new RecipeSerializer<>(EntityConcoctingRecipe.CODEC, EntityConcoctingRecipe.STREAM_CODEC));
	public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<ExplosionConcoctingRecipe>> EXPLOSION_CONCOCTING = IcariaRecipeSerializers.RECIPE_SERIALIZERS.register("explosion_concocting", () -> new RecipeSerializer<>(ExplosionConcoctingRecipe.CODEC, ExplosionConcoctingRecipe.STREAM_CODEC));
	public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<FiringRecipe>> FIRING = IcariaRecipeSerializers.RECIPE_SERIALIZERS.register("firing", () -> new RecipeSerializer<>(FiringRecipe.CODEC, FiringRecipe.STREAM_CODEC));
	public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<ForgingRecipe>> FORGING = IcariaRecipeSerializers.RECIPE_SERIALIZERS.register("forging", () -> new RecipeSerializer<>(ForgingRecipe.CODEC, ForgingRecipe.STREAM_CODEC));
	public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<GrillingRecipe>> GRILLING = IcariaRecipeSerializers.RECIPE_SERIALIZERS.register("grilling", () -> new RecipeSerializer<>(GrillingRecipe.CODEC, GrillingRecipe.STREAM_CODEC));
	public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<GrindingRecipe>> GRINDING = IcariaRecipeSerializers.RECIPE_SERIALIZERS.register("grinding", () -> new RecipeSerializer<>(GrindingRecipe.CODEC, GrindingRecipe.STREAM_CODEC));
	public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<ItemConcoctingRecipe>> ITEM_CONCOCTING = IcariaRecipeSerializers.RECIPE_SERIALIZERS.register("item_concocting", () -> new RecipeSerializer<>(ItemConcoctingRecipe.CODEC, ItemConcoctingRecipe.STREAM_CODEC));
	public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<PotionConcoctingRecipe>> POTION_CONCOCTING = IcariaRecipeSerializers.RECIPE_SERIALIZERS.register("potion_concocting", () -> new RecipeSerializer<>(PotionConcoctingRecipe.CODEC, PotionConcoctingRecipe.STREAM_CODEC));
}
