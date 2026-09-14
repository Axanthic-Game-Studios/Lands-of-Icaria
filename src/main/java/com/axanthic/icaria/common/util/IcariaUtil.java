package com.axanthic.icaria.common.util;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.Vec3i;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaUtil {
	public static final Vec3i DOWN = new Vec3i(0, -1, 0);
	public static final Vec3i UP = new Vec3i(0, 1, 0);
}
