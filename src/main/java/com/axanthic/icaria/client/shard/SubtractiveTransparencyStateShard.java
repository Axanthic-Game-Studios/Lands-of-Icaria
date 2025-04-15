package com.axanthic.icaria.client.shard;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.RenderStateShard;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SubtractiveTransparencyStateShard extends RenderStateShard.TransparencyStateShard {
	public SubtractiveTransparencyStateShard(String pName) {
		super(
			pName, () -> {
				RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.SRC_COLOR, GlStateManager.SourceFactor.ZERO, GlStateManager.DestFactor.ONE);
				RenderSystem.enableBlend();
			}, () -> {
				RenderSystem.defaultBlendFunc();
				RenderSystem.disableBlend();
			}
		);
	}
}
