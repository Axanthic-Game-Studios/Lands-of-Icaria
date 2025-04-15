package com.axanthic.icaria.mixin;

import java.util.Optional;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

@Mixin(RecipeManager.class)
public class RecipeManagerMixin {

	@Inject(at = @At("HEAD"), method = "getRecipeFor(Lnet/minecraft/world/item/crafting/RecipeType;Lnet/minecraft/world/item/crafting/RecipeInput;Lnet/minecraft/world/level/Level;Lnet/minecraft/world/item/crafting/RecipeHolder;)Ljava/util/Optional;", cancellable = true)
	private <I extends RecipeInput, T extends Recipe<I>> void getRecipeFor(RecipeType<T> pRecipeType, I pRecipeInput, Level pLevel, RecipeHolder<T> pRecipeHolder, CallbackInfoReturnable<Optional<RecipeHolder<T>>> pCallbackInfoReturnable) {
		if (pLevel instanceof ServerLevel serverLevel) {
			var list = serverLevel.recipeAccess().recipeMap().byType(pRecipeType).stream().filter((recipeHolder) -> recipeHolder.value().matches(pRecipeInput, pLevel)).toList();
			if (list.size() > 1) {
				var optional = list.stream().filter((recipeHolder) -> recipeHolder.id().location().getNamespace().equals("landsoficaria")).findFirst();
				if (optional.isPresent()) {
					pCallbackInfoReturnable.setReturnValue(optional);
				}
			}
		}
	}
}
