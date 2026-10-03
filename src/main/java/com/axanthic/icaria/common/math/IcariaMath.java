package com.axanthic.icaria.common.math;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaValues;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaMath {
	public static float rad(float pDeg) {
		return pDeg * IcariaValues.DEG_2_RAD;
	}
}
