package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.registry.IcariaRenderTypes;
import com.axanthic.icaria.common.entity.SpellEntity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.inventory.InventoryMenu;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SpellRenderer extends EntityRenderer<SpellEntity> {
    public SpellRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    float getX(float pLength, float pTicks, float pSpeed, float pWiggle) {
        return Mth.cos(pLength / 3.5F - pSpeed * pTicks / 2.0F) * pLength * pWiggle + Mth.cos(pLength / 2.0F - pSpeed * pTicks / 3.5F + 3) * pLength * pWiggle + Mth.sin(pLength / 7.5F - pSpeed * pTicks / 6.0F + 2) * pLength * pWiggle + Mth.sin(-pSpeed * pTicks / 5.0F + 2) * pLength * pWiggle;
    }

    float getY(float pLength, float pTicks, float pSpeed, float pWiggle) {
        return Mth.sin(pLength / 2.5F - pSpeed * pTicks / 3.0F) * pLength * pWiggle + Mth.sin(pLength / 3.0F - pSpeed * pTicks / 2.5F + 2) * pLength * pWiggle + Mth.cos(pLength / 7.0F - pSpeed * pTicks / 6.5F + 3) * pLength * pWiggle + Mth.cos(-pSpeed * pTicks / 4.0F + 3) * pLength * pWiggle;
    }

    @Override
    public void render(SpellEntity pEntity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight) {
        pPoseStack.pushPose();

        var consumer = pBufferSource.getBuffer(IcariaRenderTypes.ADDITIVE_TRANSPARENT);
        var matrix4f = pPoseStack.last().pose();

        int color = pEntity.getColor();

        float ticks = pPartialTick + pEntity.tickCount;

        float length = 50.0F;
        float speed = 1.5F;
        float width = 0.1F;
        float wiggle = 0.0025F;

        float res0 = 25.0F;

        float r0 = 0.0F;
        float g0 = 0.0F;
        float b0 = 0.0F;
        float a0 = 0.0F;

        float r = (color >> 16 & 255) / 255.0F / 2.0F;
        float g = (color >> 8 & 255) / 255.0F / 2.0F;
        float b = (color & 255) / 255.0F / 2.0F;

        pPoseStack.translate(0.0D, 0.25D, 0.0D);

        pPoseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(pPartialTick, pEntity.yRotO, pEntity.getYRot()) + 180.0F));
        pPoseStack.mulPose(Axis.XP.rotationDegrees(Mth.lerp(pPartialTick, pEntity.xRotO, pEntity.getXRot())));

        for (float i = 0.0F; i < length; i++) {
            float res = i / res0;
            float a = (length - i) / length;
            float x = this.getX(i, ticks, speed, wiggle);
            float y = this.getY(i, ticks, speed, wiggle);

            consumer.vertex(matrix4f, x + width, y, res).color(r0, g0, b0, a0).endVertex();
            consumer.vertex(matrix4f, x + width, y + width, res).color(r0, g0, b0, a0).endVertex();
            consumer.vertex(matrix4f, x, y + width, res).color(r0, g0, b0, a0).endVertex();
            consumer.vertex(matrix4f, x, y, res).color(r, g, b, a).endVertex();

            consumer.vertex(matrix4f, x, y - width, res).color(r0, g0, b0, a0).endVertex();
            consumer.vertex(matrix4f, x + width, y - width, res).color(r0, g0, b0, a0).endVertex();
            consumer.vertex(matrix4f, x + width, y, res).color(r0, g0, b0, a0).endVertex();
            consumer.vertex(matrix4f, x, y, res).color(r, g, b, a).endVertex();

            consumer.vertex(matrix4f, x - width, y, res).color(r0, g0, b0, a0).endVertex();
            consumer.vertex(matrix4f, x - width, y - width, res).color(r0, g0, b0, a0).endVertex();
            consumer.vertex(matrix4f, x, y - width, res).color(r0, g0, b0, a0).endVertex();
            consumer.vertex(matrix4f, x, y, res).color(r, g, b, a).endVertex();

            consumer.vertex(matrix4f, x, y + width, res).color(r0, g0, b0, a0).endVertex();
            consumer.vertex(matrix4f, x - width, y + width, res).color(r0, g0, b0, a0).endVertex();
            consumer.vertex(matrix4f, x - width, y, res).color(r0, g0, b0, a0).endVertex();
            consumer.vertex(matrix4f, x, y, res).color(r, g, b, a).endVertex();

            consumer.vertex(matrix4f, x, y, res).color(r, g, b, a).endVertex();
            consumer.vertex(matrix4f, x + width, y, res).color(r0, g0, b0, a0).endVertex();
            consumer.vertex(matrix4f, x + width, y + width, res).color(r0, g0, b0, a0).endVertex();
            consumer.vertex(matrix4f, x, y + width, res).color(r0, g0, b0, a0).endVertex();

            consumer.vertex(matrix4f, x, y, res).color(r, g, b, a).endVertex();
            consumer.vertex(matrix4f, x, y - width, res).color(r0, g0, b0, a0).endVertex();
            consumer.vertex(matrix4f, x + width, y - width, res).color(r0, g0, b0, a0).endVertex();
            consumer.vertex(matrix4f, x + width, y, res).color(r0, g0, b0, a0).endVertex();

            consumer.vertex(matrix4f, x, y, res).color(r, g, b, a).endVertex();
            consumer.vertex(matrix4f, x - width, y, res).color(r0, g0, b0, a0).endVertex();
            consumer.vertex(matrix4f, x - width, y - width, res).color(r0, g0, b0, a0).endVertex();
            consumer.vertex(matrix4f, x, y - width, res).color(r0, g0, b0, a0).endVertex();

            consumer.vertex(matrix4f, x, y, res).color(r, g, b, a).endVertex();
            consumer.vertex(matrix4f, x, y + width, res).color(r0, g0, b0, a0).endVertex();
            consumer.vertex(matrix4f, x - width, y + width, res).color(r0, g0, b0, a0).endVertex();
            consumer.vertex(matrix4f, x - width, y, res).color(r0, g0, b0, a0).endVertex();

            consumer.vertex(matrix4f, x + width, y, res).color(r0, g0, b0, a0).endVertex();
            consumer.vertex(matrix4f, x, y, res).color(r, g, b, a).endVertex();
            consumer.vertex(matrix4f, x, y + width, res).color(r0, g0, b0, a0).endVertex();
            consumer.vertex(matrix4f, x + width, y + width, res).color(r0, g0, b0, a0).endVertex();

            consumer.vertex(matrix4f, x, y - width, res).color(r0, g0, b0, a0).endVertex();
            consumer.vertex(matrix4f, x, y, res).color(r, g, b, a).endVertex();
            consumer.vertex(matrix4f, x + width, y, res).color(r0, g0, b0, a0).endVertex();
            consumer.vertex(matrix4f, x + width, y - width, res).color(r0, g0, b0, a0).endVertex();

            consumer.vertex(matrix4f, x - width, y, res).color(r0, g0, b0, a0).endVertex();
            consumer.vertex(matrix4f, x, y, res).color(r, g, b, a).endVertex();
            consumer.vertex(matrix4f, x, y - width, res).color(r0, g0, b0, a0).endVertex();
            consumer.vertex(matrix4f, x - width, y - width, res).color(r0, g0, b0, a0).endVertex();

            consumer.vertex(matrix4f, x, y + width, res).color(r0, g0, b0, a0).endVertex();
            consumer.vertex(matrix4f, x, y, res).color(r, g, b, a).endVertex();
            consumer.vertex(matrix4f, x - width, y, res).color(r0, g0, b0, a0).endVertex();
            consumer.vertex(matrix4f, x - width, y + width, res).color(r0, g0, b0, a0).endVertex();

            consumer.vertex(matrix4f, x, y, res).color(r, g, b, a).endVertex();
            consumer.vertex(matrix4f, x, y + width, res).color(r0, g0, b0, a0).endVertex();
            consumer.vertex(matrix4f, x + width, y + width, res).color(r0, g0, b0, a0).endVertex();
            consumer.vertex(matrix4f, x + width, y, res).color(r0, g0, b0, a0).endVertex();

            consumer.vertex(matrix4f, x, y, res).color(r, g, b, a).endVertex();
            consumer.vertex(matrix4f, x + width, y, res).color(r0, g0, b0, a0).endVertex();
            consumer.vertex(matrix4f, x + width, y - width, res).color(r0, g0, b0, a0).endVertex();
            consumer.vertex(matrix4f, x, y - width, res).color(r0, g0, b0, a0).endVertex();

            consumer.vertex(matrix4f, x, y, res).color(r, g, b, a).endVertex();
            consumer.vertex(matrix4f, x, y - width, res).color(r0, g0, b0, a0).endVertex();
            consumer.vertex(matrix4f, x - width, y - width, res).color(r0, g0, b0, a0).endVertex();
            consumer.vertex(matrix4f, x - width, y, res).color(r0, g0, b0, a0).endVertex();

            consumer.vertex(matrix4f, x, y, res).color(r, g, b, a).endVertex();
            consumer.vertex(matrix4f, x - width, y, res).color(r0, g0, b0, a0).endVertex();
            consumer.vertex(matrix4f, x - width, y + width, res).color(r0, g0, b0, a0).endVertex();
            consumer.vertex(matrix4f, x, y + width, res).color(r0, g0, b0, a0).endVertex();
        }

        pPoseStack.popPose();
    }

    @Override
    public ResourceLocation getTextureLocation(SpellEntity pEntity) {
        return InventoryMenu.BLOCK_ATLAS;
    }
}
