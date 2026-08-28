package com.axanthic.icaria.client.registry;

import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.RenderStateShard;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaRenderStateShards {
	public static final RenderStateShard.TextureStateShard SPELL_TEXTURE = new RenderStateShard.TextureStateShard(IcariaResourceLocations.SPELL, false);
}
