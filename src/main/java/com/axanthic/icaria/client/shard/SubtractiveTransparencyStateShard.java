package com.axanthic.icaria.client.shard;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.RenderStateShard;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SubtractiveTransparencyStateShard extends RenderStateShard.TransparencyStateShard {
    public SubtractiveTransparencyStateShard(String pName) {
        super(
            pName, () -> {
                RenderSystem.depthMask(false);
                RenderSystem.enableBlend();
                RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.SRC_COLOR, GlStateManager.SourceFactor.ZERO, GlStateManager.DestFactor.ONE);
            }, () -> {
                RenderSystem.depthMask(true);
                RenderSystem.disableBlend();
                RenderSystem.defaultBlendFunc();
            }
        );
    }
}
