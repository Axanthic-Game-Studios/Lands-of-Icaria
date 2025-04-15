package com.axanthic.icaria.common.effect;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class BlindnessImmunityEffect extends MobEffect {
	public BlindnessImmunityEffect(MobEffectCategory pMobEffectCategory, int pColor) {
		super(pMobEffectCategory, pColor);
	}

	@Override
	public boolean applyEffectTick(ServerLevel pServerLevel, LivingEntity pLivingEntity, int pAmplifier) {
		pLivingEntity.removeEffect(MobEffects.BLINDNESS);
		pLivingEntity.removeEffect(MobEffects.DARKNESS);
		return true;
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
		return true;
	}
}
