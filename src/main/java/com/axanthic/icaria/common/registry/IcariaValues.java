package com.axanthic.icaria.common.registry;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.util.Mth;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaValues {
	public static final float DUSK_INIT = 1.3539146F;
	public static final float DUSK_EXIT = 1.6314344F;
	public static final float DAWN_INIT = 4.6517510F;
	public static final float DAWN_EXIT = 4.9292707F;

	public static final float HALFSQRT3 = Mth.sqrt(3.0F) / 2.0F;
}
