package com.axanthic.icaria.mixin;

import com.llamalad7.mixinextras.injector.ModifyReceiver;

import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.stream.Stream;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")

@ParametersAreNonnullByDefault

@Mixin(RecipeManager.class)
public class RecipeManagerMixin {

	@ModifyReceiver(at = @At(value = "INVOKE", target = "java/util/stream/Stream.findFirst()Ljava/util/Optional;"), method = "getRecipeFor(Lnet/minecraft/world/item/crafting/RecipeType;Lnet/minecraft/world/Container;Lnet/minecraft/world/level/Level;)Ljava/util/Optional;")
	private <C extends Container, T extends Recipe<C>> Stream<RecipeHolder<T>> modifyFoundRecipes(Stream<RecipeHolder<T>> pStream) {
		var recipes = pStream.toList();
		if (recipes.size() > 1) {
			var icariaRecipes = recipes.stream().filter(recipe -> recipe.id().getNamespace().equals("landsoficaria")).toList();
			if (!icariaRecipes.isEmpty())
				return icariaRecipes.stream();
		}

		return recipes.stream();
	}
}
