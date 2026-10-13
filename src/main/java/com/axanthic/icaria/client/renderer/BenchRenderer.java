package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.entity.BenchEntity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class BenchRenderer extends EntityRenderer<BenchEntity, EntityRenderState> {
	public BenchRenderer(EntityRendererProvider.Context pContext) {
		super(pContext);
	}

	@Override
	public EntityRenderState createRenderState() {
		return new EntityRenderState();
	}
}
