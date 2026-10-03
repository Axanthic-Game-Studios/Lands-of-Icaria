package com.axanthic.icaria.common.effect;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class LifestealMobEffect extends MobEffect {
	public LifestealMobEffect(MobEffectCategory pMobEffectCategory, int pColor) {
		super(pMobEffectCategory, pColor);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int pTickCount, int pAmplification) {
		return true;
	}
}
