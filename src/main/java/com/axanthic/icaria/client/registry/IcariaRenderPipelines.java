package com.axanthic.icaria.client.registry;

import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.RenderPipelines;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaRenderPipelines {
	public static final RenderPipeline ADDITIVE = RenderPipeline.builder(RenderPipelines.MATRICES_FOG_SNIPPET)
		.withDepthWrite(false)
		.withBlend(IcariaBlendFunctions.ADDITIVE)
		.withFragmentShader(IcariaResourceLocations.ADDITIVE_SHADER)
		.withVertexShader(IcariaResourceLocations.ADDITIVE_SHADER)
		.withLocation(IcariaResourceLocations.ADDITIVE_RENDER_PIPELINE)
		.withVertexFormat(DefaultVertexFormat.POSITION_COLOR, VertexFormat.Mode.QUADS)
		.build();

	public static final RenderPipeline ADDITIVE_TEXTURED = RenderPipeline.builder(RenderPipelines.MATRICES_FOG_SNIPPET)
		.withDepthWrite(false)
		.withSampler("Sampler0")
		.withBlend(IcariaBlendFunctions.ADDITIVE)
		.withFragmentShader(IcariaResourceLocations.ADDITIVE_TEXTURED_SHADER)
		.withVertexShader(IcariaResourceLocations.ADDITIVE_TEXTURED_SHADER)
		.withLocation(IcariaResourceLocations.ADDITIVE_TEXTURED_RENDER_PIPELINE)
		.withVertexFormat(DefaultVertexFormat.POSITION_TEX_COLOR, VertexFormat.Mode.QUADS)
		.build();
}
