package com.axanthic.icaria.common.effect;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class LifestealMobEffect extends MobEffect {
	public LifestealMobEffect(MobEffectCategory pMobEffectCategory, int pColor) {
		super(pMobEffectCategory, pColor);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
		return true;
	}
}
