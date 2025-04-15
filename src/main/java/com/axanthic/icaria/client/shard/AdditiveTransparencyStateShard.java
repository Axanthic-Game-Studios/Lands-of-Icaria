package com.axanthic.icaria.client.shard;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.RenderStateShard;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class AdditiveTransparencyStateShard extends RenderStateShard.TransparencyStateShard {
	public AdditiveTransparencyStateShard(String pName) {
		super(
			pName, () -> {
				RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE);
				RenderSystem.enableBlend();
			}, () -> {
				RenderSystem.defaultBlendFunc();
				RenderSystem.disableBlend();
			}
		);
	}
}
