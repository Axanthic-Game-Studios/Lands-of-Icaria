package com.axanthic.icaria.client.registry;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import com.mojang.renderpearl.api.pipeline.CompareOp;
import com.mojang.renderpearl.api.pipeline.DepthStencilState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaDepthStencilStates {
	public static final DepthStencilState ADDITIVE = new DepthStencilState(CompareOp.GREATER_THAN_OR_EQUAL, false);
}
