package com.axanthic.icaria.client.registry;

import com.axanthic.icaria.common.registry.IcariaIdentifiers;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.RenderPipelines;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaRenderPipelines {
	public static final RenderPipeline ADDITIVE = RenderPipeline.builder(RenderPipelines.MATRICES_FOG_SNIPPET)
		.withDepthWrite(false)
		.withBlend(IcariaBlendFunctions.ADDITIVE)
		.withFragmentShader(IcariaIdentifiers.ADDITIVE_SHADER)
		.withVertexShader(IcariaIdentifiers.ADDITIVE_SHADER)
		.withLocation(IcariaIdentifiers.ADDITIVE_RENDER_PIPELINE)
		.withVertexFormat(DefaultVertexFormat.POSITION_COLOR, VertexFormat.Mode.QUADS)
		.build();

	public static final RenderPipeline ADDITIVE_TEXTURED = RenderPipeline.builder(RenderPipelines.MATRICES_FOG_SNIPPET)
		.withDepthWrite(false)
		.withSampler("Texture")
		.withBlend(IcariaBlendFunctions.ADDITIVE)
		.withFragmentShader(IcariaIdentifiers.ADDITIVE_TEXTURED_SHADER)
		.withVertexShader(IcariaIdentifiers.ADDITIVE_TEXTURED_SHADER)
		.withLocation(IcariaIdentifiers.ADDITIVE_TEXTURED_RENDER_PIPELINE)
		.withVertexFormat(DefaultVertexFormat.POSITION_TEX_COLOR, VertexFormat.Mode.QUADS)
		.build();
}
