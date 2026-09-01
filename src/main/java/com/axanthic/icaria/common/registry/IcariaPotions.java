package com.axanthic.icaria.common.registry;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaPotions {
	public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(Registries.POTION, IcariaKeys.ID);

	public static final DeferredHolder<Potion, Potion> BLINDNESS = IcariaPotions.POTIONS.register("blindness", () -> new Potion("blindness", new MobEffectInstance(MobEffects.BLINDNESS, 900)));
	public static final DeferredHolder<Potion, Potion> NAUSEA = IcariaPotions.POTIONS.register("nausea", () -> new Potion("nausea", new MobEffectInstance(MobEffects.NAUSEA, 900)));
	public static final DeferredHolder<Potion, Potion> WITHER = IcariaPotions.POTIONS.register("wither", () -> new Potion("wither", new MobEffectInstance(MobEffects.WITHER, 900)));
}
