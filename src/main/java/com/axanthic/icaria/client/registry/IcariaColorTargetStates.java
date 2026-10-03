package com.axanthic.icaria.client.registry;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import com.mojang.blaze3d.pipeline.ColorTargetState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaColorTargetStates {
	public static final ColorTargetState ADDITIVE = new ColorTargetState(IcariaBlendFunctions.ADDITIVE);
}
