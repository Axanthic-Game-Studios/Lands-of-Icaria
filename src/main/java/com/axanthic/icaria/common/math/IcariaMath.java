package com.axanthic.icaria.common.math;

import com.axanthic.icaria.common.registry.IcariaValues;

import net.minecraft.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaMath {
	public static float rad(float pDeg) {
		return pDeg * IcariaValues.DEG_2_RAD;
	}
}
