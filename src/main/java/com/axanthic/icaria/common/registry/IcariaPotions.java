package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;

import net.neoforged.neoforge.registries.DeferredRegister;

public class IcariaPotions {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(Registries.POTION, IcariaInfo.ID);

    public static final Holder<Potion> BLINDNESS = IcariaPotions.POTIONS.register("blindness", () -> new Potion("blindness", new MobEffectInstance(MobEffects.BLINDNESS, 900)));
    public static final Holder<Potion> NAUSEA = IcariaPotions.POTIONS.register("nausea", () -> new Potion("nausea", new MobEffectInstance(MobEffects.CONFUSION, 900)));
    public static final Holder<Potion> WITHER = IcariaPotions.POTIONS.register("wither", () -> new Potion("wither", new MobEffectInstance(MobEffects.WITHER, 900)));
}
