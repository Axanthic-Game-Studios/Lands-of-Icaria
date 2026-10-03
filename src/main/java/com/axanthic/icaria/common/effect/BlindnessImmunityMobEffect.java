package com.axanthic.icaria.common.effect;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class BlindnessImmunityMobEffect extends MobEffect {
	public BlindnessImmunityMobEffect(MobEffectCategory pMobEffectCategory, int pColor) {
		super(pMobEffectCategory, pColor);
	}

	@Override
	public boolean applyEffectTick(ServerLevel pServerLevel, LivingEntity pLivingEntity, int pAmplification) {
		pLivingEntity.removeEffect(MobEffects.BLINDNESS);
		pLivingEntity.removeEffect(MobEffects.DARKNESS);
		return true;
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int pTickCount, int pAmplification) {
		return true;
	}
}
