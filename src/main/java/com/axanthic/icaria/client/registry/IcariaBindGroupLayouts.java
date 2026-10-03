package com.axanthic.icaria.client.registry;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import com.mojang.blaze3d.pipeline.BindGroupLayout;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBindGroupLayouts {
	public static final BindGroupLayout TEXTURE = BindGroupLayout.builder().withSampler("Texture").build();
}
