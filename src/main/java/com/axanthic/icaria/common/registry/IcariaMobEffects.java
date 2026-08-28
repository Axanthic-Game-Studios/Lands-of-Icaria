package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.effect.BlindnessImmunityMobEffect;
import com.axanthic.icaria.common.effect.FreezingMobEffect;
import com.axanthic.icaria.common.effect.LifestealMobEffect;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaMobEffects {
	public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, IcariaIdents.ID);

	public static final DeferredHolder<MobEffect, MobEffect> BLINDNESS_IMMUNITY = IcariaMobEffects.MOB_EFFECTS.register("blindness_immunity", () -> new BlindnessImmunityMobEffect(MobEffectCategory.BENEFICIAL, 14737628));
	public static final DeferredHolder<MobEffect, MobEffect> FREEZING = IcariaMobEffects.MOB_EFFECTS.register("freezing", () -> new FreezingMobEffect(MobEffectCategory.HARMFUL, 14277081).addAttributeModifier(Attributes.MOVEMENT_SPEED, IcariaResourceLocations.FREEZING_EFFECT, -10.0F, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));
	public static final DeferredHolder<MobEffect, MobEffect> LIFESTEAL = IcariaMobEffects.MOB_EFFECTS.register("lifesteal", () -> new LifestealMobEffect(MobEffectCategory.BENEFICIAL, 14893141));
}
