package com.axanthic.icaria.common.util;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.Vec3i;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaUtil {
	public static final Vec3i DOWN = new Vec3i(0, -1, 0);
	public static final Vec3i UP = new Vec3i(0, 1, 0);
}
