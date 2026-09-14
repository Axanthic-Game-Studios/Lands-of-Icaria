package com.axanthic.icaria.client.renderer;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.StandingSignRenderer;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SignBlockRenderer extends StandingSignRenderer {
	public SignBlockRenderer(BlockEntityRendererProvider.Context pContext) {
		super(pContext);
	}
}
