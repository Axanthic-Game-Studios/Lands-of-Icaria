package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.effect.BlindnessImmunityEffect;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class IcariaEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, IcariaInfo.MODID);

    public static final RegistryObject<MobEffect> BLINDNESS_IMMUNITY = EFFECTS.register("blindness_immunity", () -> new BlindnessImmunityEffect(MobEffectCategory.BENEFICIAL, 16777215));
}
