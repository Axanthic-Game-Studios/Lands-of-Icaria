package com.axanthic.icaria.common.math;

import com.axanthic.icaria.common.registry.IcariaValues;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaMath {
	public static float rad(float pDeg) {
		return pDeg * IcariaValues.DEG_2_RAD;
	}
}
