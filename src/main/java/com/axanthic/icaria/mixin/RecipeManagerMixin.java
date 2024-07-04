package com.axanthic.icaria.mixin;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

@Mixin(RecipeManager.class)
public class RecipeManagerMixin {

	@Inject(at = @At("HEAD"), method = "getRecipeFor(Lnet/minecraft/world/item/crafting/RecipeType;Lnet/minecraft/world/item/crafting/RecipeInput;Lnet/minecraft/world/level/Level;Lnet/minecraft/world/item/crafting/RecipeHolder;)Ljava/util/Optional;", cancellable = true)
	private <I extends RecipeInput, T extends Recipe<I>> void getRecipeFor(RecipeType<T> pType, I pInput, Level pLevel, RecipeHolder<T> pHolder, CallbackInfoReturnable<Optional<RecipeHolder<T>>> pReturnable) {
		var list = this.byType(pType).stream().filter((holder) -> holder.value().matches(pInput, pLevel)).toList();
		if (list.size() > 1) {
			var optional = list.stream().filter((holder) -> holder.id().getNamespace().equals("landsoficaria")).findFirst();
			if (optional.isPresent()) {
				pReturnable.setReturnValue(optional);
			}
		}
	}

	@Shadow
	private <I extends RecipeInput, T extends Recipe<I>> Collection<RecipeHolder<T>> byType(RecipeType<T> pType) {
		throw new IllegalArgumentException("Recipe Manager Mixin failed.");
	}
}
