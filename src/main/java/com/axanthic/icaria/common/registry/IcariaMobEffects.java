package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.effect.BlindnessImmunityEffect;
import com.axanthic.icaria.common.effect.LifestealEffect;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class IcariaMobEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, IcariaInfo.ID);

    public static final RegistryObject<MobEffect> BLINDNESS_IMMUNITY = IcariaMobEffects.MOB_EFFECTS.register("blindness_immunity", () -> new BlindnessImmunityEffect(MobEffectCategory.BENEFICIAL, 14737628));
    public static final RegistryObject<MobEffect> LIFESTEAL = IcariaMobEffects.MOB_EFFECTS.register("lifesteal", () -> new LifestealEffect(MobEffectCategory.BENEFICIAL, 14893141));
}
