package com.axanthic.icaria.client.registry;

import com.axanthic.icaria.client.shard.AdditiveTransparencyStateShard;
import com.axanthic.icaria.client.shard.SubtractiveTransparencyStateShard;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.RenderStateShard;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaRenderStateShards {
	public static final RenderStateShard.TransparencyStateShard ADDITIVE_TRANSPARENCY = new AdditiveTransparencyStateShard("additive_transparency");
	public static final RenderStateShard.TransparencyStateShard SUBTRACTIVE_TRANSPARENCY = new SubtractiveTransparencyStateShard("subtractive_transparency");
}
