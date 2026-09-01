package com.axanthic.icaria.common.registry;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaValues {
	public static final float DUSK_INIT = 12000.0F;
	public static final float DUSK_EXIT = 13000.0F;
	public static final float DAWN_INIT = 23000.0F;
	public static final float DAWN_EXIT = 24000.0F;

	public static final float DEG_2_RAD = 0.0174532925199433F;
	public static final float HALFSQRT3 = 0.8660254037844386F;

	public static final float[] CHERRY_CHANCES = {0.05F, 0.06666666666F, 0.08333333333F, 0.1F};
	public static final float[] GARLIC_CHANCES = {0.05F, 0.06666666666F, 0.08333333333F, 0.1F};
	public static final float[] SAPLING_CHANCES = {0.05F, 0.06666666666F, 0.08333333333F, 0.1F};
	public static final float[] SEED_CHANCES = {0.05F, 0.06666666666F, 0.08333333333F, 0.1F};
	public static final float[] STICK_CHANCES = {0.05F, 0.06666666666F, 0.08333333333F, 0.1F};
}
