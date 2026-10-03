package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.ids.IcariaPotionIds;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaPotions {
	public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(Registries.POTION, IcariaIds.ID);

	public static final DeferredHolder<Potion, Potion> BLINDNESS = IcariaPotions.register(IcariaPotionIds.BLINDNESS, new MobEffectInstance(MobEffects.BLINDNESS, 900));
	public static final DeferredHolder<Potion, Potion> NAUSEA = IcariaPotions.register(IcariaPotionIds.NAUSEA, new MobEffectInstance(MobEffects.NAUSEA, 900));
	public static final DeferredHolder<Potion, Potion> WITHER = IcariaPotions.register(IcariaPotionIds.WITHER, new MobEffectInstance(MobEffects.WITHER, 900));

	public static <T extends Potion> DeferredHolder<Potion, Potion> register(ResourceKey<Potion> pResourceKey, MobEffectInstance pMobEffectInstance) {
		return IcariaPotions.POTIONS.register(pResourceKey.identifier().getPath(), () -> new Potion(pResourceKey.identifier().getPath(), pMobEffectInstance));
	}
}
