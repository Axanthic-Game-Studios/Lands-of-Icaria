package com.axanthic.icaria.common.effect;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class LifestealEffect extends MobEffect {
	public LifestealEffect(MobEffectCategory pMobEffectCategory, int pColor) {
		super(pMobEffectCategory, pColor);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
		return true;
	}
}
