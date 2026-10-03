package com.axanthic.icaria.client.registry;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import com.mojang.blaze3d.pipeline.DepthStencilState;
import com.mojang.blaze3d.platform.CompareOp;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaDepthStencilStates {
	public static final DepthStencilState ADDITIVE = new DepthStencilState(CompareOp.GREATER_THAN_OR_EQUAL, false);
}
