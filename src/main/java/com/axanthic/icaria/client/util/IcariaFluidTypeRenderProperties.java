package com.axanthic.icaria.client.util;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Matrix4f;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;

import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;

import java.util.Objects;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaFluidTypeRenderProperties implements IClientFluidTypeExtensions {
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
    public void renderOverlay(Minecraft mc, PoseStack poseStack) {
        BlockPos blockPos = new BlockPos(Objects.requireNonNull(mc.player).getX(), mc.player.getEyeY(), mc.player.getZ());
        BufferBuilder bufferBuilder = Tesselator.getInstance().getBuilder();
        Matrix4f matrix4f = poseStack.last().pose();
        ResourceLocation resourceLocation = this.getRenderOverlayTexture(mc);

        float brightness = LightTexture.getBrightness(mc.player.level.dimensionType(), mc.player.level.getMaxLocalRawBrightness(blockPos));
        float uOffset = -mc.player.getYRot() / 64.0F;
        float vOffset = mc.player.getXRot() / 64.0F;

        if (resourceLocation == null) {
            return;
        }

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.enableTexture();
        RenderSystem.setShaderTexture(0, resourceLocation);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShaderColor(brightness, brightness, brightness, 0.5F);

        bufferBuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferBuilder.vertex(matrix4f, -1.0F, -1.0F, -0.5F).uv(4.0F + uOffset, 4.0F + vOffset).endVertex();
        bufferBuilder.vertex(matrix4f, 1.0F, -1.0F, -0.5F).uv(uOffset, 4.0F + vOffset).endVertex();
        bufferBuilder.vertex(matrix4f, 1.0F, 1.0F, -0.5F).uv(uOffset, vOffset).endVertex();
        bufferBuilder.vertex(matrix4f, -1.0F, 1.0F, -0.5F).uv(4.0F + uOffset, vOffset).endVertex();

        BufferUploader.drawWithShader(bufferBuilder.end());

        RenderSystem.disableBlend();
    }
}
