package com.axanthic.icaria.client.registry;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import com.mojang.renderpearl.api.pipeline.BindGroupLayout;
import com.mojang.renderpearl.api.pipeline.UniformType;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBindGroupLayouts {
	public static final BindGroupLayout TEXTURE = BindGroupLayout.builder().withUniform("Texture", UniformType.COMBINED_IMAGE_SAMPLER).build();
}
