package com.axanthic.icaria.client.shard;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.renderer.RenderStateShard;

public class AdditiveTransparencyStateShard extends RenderStateShard.TransparencyStateShard {
    public AdditiveTransparencyStateShard(String pName) {
        super(
            pName, () -> {
                RenderSystem.depthMask(false);
                RenderSystem.enableBlend();
                RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE);
                }, () -> {
                RenderSystem.depthMask(true);
                RenderSystem.disableBlend();
                RenderSystem.defaultBlendFunc();
            }
        );
    }
}
