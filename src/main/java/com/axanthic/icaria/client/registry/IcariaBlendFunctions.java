package com.axanthic.icaria.client.registry;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import com.mojang.renderpearl.api.pipeline.BlendFactor;
import com.mojang.renderpearl.api.pipeline.BlendFunction;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBlendFunctions {
	public static final BlendFunction ADDITIVE = new BlendFunction(BlendFactor.SRC_ALPHA, BlendFactor.ONE);
}
