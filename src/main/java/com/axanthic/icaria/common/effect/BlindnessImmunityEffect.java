package com.axanthic.icaria.common.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class BlindnessImmunityEffect extends MobEffect {
    public BlindnessImmunityEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
        return true;
    }

    @Override
    public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        pLivingEntity.removeEffect(MobEffects.BLINDNESS);
        pLivingEntity.removeEffect(MobEffects.DARKNESS);
        return true;
    }
}
