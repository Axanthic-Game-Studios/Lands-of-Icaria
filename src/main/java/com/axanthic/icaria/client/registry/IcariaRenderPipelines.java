package com.axanthic.icaria.client.registry;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaIdentifiers;

import com.mojang.blaze3d.PrimitiveTopology;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;

import net.minecraft.client.renderer.RenderPipelines;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaRenderPipelines {
	public static final RenderPipeline ADDITIVE = RenderPipeline.builder(RenderPipelines.MATRICES_FOG_SNIPPET)
		.withColorTargetState(IcariaColorTargetStates.ADDITIVE)
		.withDepthStencilState(IcariaDepthStencilStates.ADDITIVE)
		.withFragmentShader(IcariaIdentifiers.ADDITIVE_SHADER)
		.withVertexShader(IcariaIdentifiers.ADDITIVE_SHADER)
		.withLocation(IcariaIdentifiers.ADDITIVE_RENDER_PIPELINE)
		.withPrimitiveTopology(PrimitiveTopology.QUADS)
		.withVertexBinding(0, DefaultVertexFormat.POSITION_COLOR)
		.build();

	public static final RenderPipeline ADDITIVE_TEXTURED = RenderPipeline.builder(RenderPipelines.MATRICES_FOG_SNIPPET)
		.withBindGroupLayout(IcariaBindGroupLayouts.TEXTURE)
		.withColorTargetState(IcariaColorTargetStates.ADDITIVE)
		.withDepthStencilState(IcariaDepthStencilStates.ADDITIVE)
		.withFragmentShader(IcariaIdentifiers.ADDITIVE_TEXTURED_SHADER)
		.withVertexShader(IcariaIdentifiers.ADDITIVE_TEXTURED_SHADER)
		.withLocation(IcariaIdentifiers.ADDITIVE_TEXTURED_RENDER_PIPELINE)
		.withPrimitiveTopology(PrimitiveTopology.QUADS)
		.withVertexBinding(0, DefaultVertexFormat.POSITION_TEX_COLOR)
		.build();
}
