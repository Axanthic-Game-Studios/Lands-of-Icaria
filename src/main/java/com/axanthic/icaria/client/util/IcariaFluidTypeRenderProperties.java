package com.axanthic.icaria.client.util;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;

import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;

import org.joml.Matrix4f;

import java.util.Objects;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaFluidTypeRenderProperties implements IClientFluidTypeExtensions {
    public ResourceLocation stillTexture;
    public ResourceLocation flowingTexture;
    public ResourceLocation renderOverlayTexture;

    public IcariaFluidTypeRenderProperties(ResourceLocation pStillTexture, ResourceLocation pFlowingTexture, ResourceLocation pRenderOverlayTexture) {
        this.stillTexture = pStillTexture;
        this.flowingTexture = pFlowingTexture;
        this.renderOverlayTexture = pRenderOverlayTexture;
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
    public ResourceLocation getRenderOverlayTexture(Minecraft pMinecraft) {
        return this.renderOverlayTexture;
    }

    @Override
    public void renderOverlay(Minecraft pMinecraft, PoseStack pPoseStack) {
        BlockPos blockPos = new BlockPos(Objects.requireNonNull(pMinecraft.player).getX(), pMinecraft.player.getEyeY(), pMinecraft.player.getZ());
        BufferBuilder bufferBuilder = Tesselator.getInstance().getBuilder();
        Matrix4f matrix4f = pPoseStack.last().pose();
        ResourceLocation resourceLocation = this.getRenderOverlayTexture(pMinecraft);

        float brightness = LightTexture.getBrightness(pMinecraft.player.level.dimensionType(), pMinecraft.player.level.getMaxLocalRawBrightness(blockPos));
        float uOffset = -pMinecraft.player.getYRot() / 64.0F;
        float vOffset = pMinecraft.player.getXRot() / 64.0F;

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
