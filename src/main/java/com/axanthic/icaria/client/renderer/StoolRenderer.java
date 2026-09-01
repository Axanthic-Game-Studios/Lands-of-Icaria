package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.common.entity.StoolEntity;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class StoolRenderer extends EntityRenderer<StoolEntity, EntityRenderState> {
	public StoolRenderer(EntityRendererProvider.Context pContext) {
		super(pContext);
	}

	@Override
	public EntityRenderState createRenderState() {
		return new EntityRenderState();
	}
}
