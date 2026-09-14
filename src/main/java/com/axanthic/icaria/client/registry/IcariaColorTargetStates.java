package com.axanthic.icaria.client.registry;

import com.mojang.blaze3d.pipeline.ColorTargetState;
import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaColorTargetStates {
	public static final ColorTargetState ADDITIVE = new ColorTargetState(IcariaBlendFunctions.ADDITIVE);
}
