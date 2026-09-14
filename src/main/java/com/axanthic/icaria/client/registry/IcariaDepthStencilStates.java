package com.axanthic.icaria.client.registry;

import com.mojang.blaze3d.pipeline.DepthStencilState;
import com.mojang.blaze3d.platform.CompareOp;
import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaDepthStencilStates {
	public static final DepthStencilState ADDITIVE = new DepthStencilState(CompareOp.LESS_THAN_OR_EQUAL, false);
}
