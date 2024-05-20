package com.axanthic.icaria.mixin;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;
import java.util.Optional;

@SuppressWarnings("unused")

@Mixin(RecipeManager.class)
public class RecipeManagerMixin {
	@Inject(at = @At("HEAD"), method = "getRecipeFor(Lnet/minecraft/world/item/crafting/RecipeType;Lnet/minecraft/world/Container;Lnet/minecraft/world/level/Level;)Ljava/util/Optional;", cancellable = true)
	private <C extends Container, T extends Recipe<C>> void getRecipeFor(RecipeType<T> pType, C pContainer, Level pLevel, CallbackInfoReturnable<Optional<T>> pReturnable) {
		var list = byType(pType).values().stream().filter(type -> type.matches(pContainer, pLevel)).toList();
		if (list.size() > 1) {
			var optional = list.stream().filter(type -> type.getId().getNamespace().equals("landsoficaria")).findFirst();
			if (optional.isPresent()) {
				pReturnable.setReturnValue(optional);
			}
		}
	}

	@Shadow
	private <C extends Container, T extends Recipe<C>> Map<ResourceLocation, T> byType(RecipeType<T> pType) {
		throw new IllegalArgumentException("Recipe Manager Mixin failed.");
	}
}
