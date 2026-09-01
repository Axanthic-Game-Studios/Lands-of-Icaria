package com.axanthic.icaria.common.effect;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FreezingMobEffect extends MobEffect {
	public FreezingMobEffect(MobEffectCategory pMobEffectCategory, int pColor) {
		super(pMobEffectCategory, pColor);
	}

	@Override
	public boolean applyEffectTick(ServerLevel pServerLevel, LivingEntity pLivingEntity, int pAmplifier) {
		pLivingEntity.setTicksFrozen(100);
		return true;
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
		return true;
	}
}
