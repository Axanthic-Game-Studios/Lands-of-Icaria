package com.axanthic.icaria.client.util;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Matrix4f;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;

import net.minecraftforge.client.IFluidTypeRenderProperties;

import java.util.Objects;

public class IcariaFluidTypeRenderProperties implements IFluidTypeRenderProperties {
    public ResourceLocation stillTexture;
    public ResourceLocation flowingTexture;
    public ResourceLocation renderOverlayTexture;

    public IcariaFluidTypeRenderProperties(ResourceLocation stillTexture, ResourceLocation flowingTexture, ResourceLocation renderOverlayTexture) {
        this.stillTexture = stillTexture;
        this.flowingTexture = flowingTexture;
        this.renderOverlayTexture = renderOverlayTexture;
    }

    @Override
    public ResourceLocation getStillTexture() {
        return this.stillTexture;
    }

    @Override
    public ResourceLocation getFlowingTexture() {
        return this.flowingTexture;
    }

    @Override
    public ResourceLocation getRenderOverlayTexture(Minecraft mc) {
        return this.renderOverlayTexture;
    }

    @Override
    public void renderOverlay(Minecraft mc, PoseStack stack) {
        ResourceLocation texture = this.getRenderOverlayTexture(mc);
        if (texture == null) return;
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.enableTexture();
        RenderSystem.setShaderTexture(0, texture);
        BufferBuilder buffer = Tesselator.getInstance().getBuilder();
        BlockPos playerEyePos = new BlockPos(Objects.requireNonNull(mc.player).getX(), mc.player.getEyeY(), mc.player.getZ());
        float brightness = LightTexture.getBrightness(mc.player.level.dimensionType(), mc.player.level.getMaxLocalRawBrightness(playerEyePos));
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShaderColor(brightness, brightness, brightness, 0.5F);
        float uOffset = -mc.player.getYRot() / 64.0F;
        float vOffset = mc.player.getXRot() / 64.0F;
        Matrix4f pose = stack.last().pose();
        buffer.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        buffer.vertex(pose, -1.0F, -1.0F, -0.5F).uv(4.0F + uOffset, 4.0F + vOffset).endVertex();
        buffer.vertex(pose, 1.0F, -1.0F, -0.5F).uv(uOffset, 4.0F + vOffset).endVertex();
        buffer.vertex(pose, 1.0F, 1.0F, -0.5F).uv(uOffset, vOffset).endVertex();
        buffer.vertex(pose, -1.0F, 1.0F, -0.5F).uv(4.0F + uOffset, vOffset).endVertex();
        BufferUploader.drawWithShader(buffer.end());
        RenderSystem.disableBlend();
    }
}
