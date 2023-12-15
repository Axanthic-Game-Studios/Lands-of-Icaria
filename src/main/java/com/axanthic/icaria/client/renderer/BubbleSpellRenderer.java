package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.registry.IcariaRenderTypes;
import com.axanthic.icaria.common.entity.BubbleSpellEntity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;

import java.util.Random;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class BubbleSpellRenderer extends EntityRenderer<BubbleSpellEntity> {
    public BubbleSpellRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public void render(BubbleSpellEntity pEntity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight) {
        pPoseStack.pushPose();

        var consumer = pBufferSource.getBuffer(IcariaRenderTypes.ADDITIVE_TRANSPARENT);
        var matrix4f = pPoseStack.last().pose();

        var random = new Random(pEntity.getId());

        float scale = 0.25F;
        float ticks = pPartialTick + pEntity.tickCount;

        int alpha = 255;
        int brightness = 50;

        int r0 = random.nextInt(brightness);
        int g0 = random.nextInt(brightness);
        int b0 = random.nextInt(brightness);
        int r1 = random.nextInt(brightness);
        int g1 = random.nextInt(brightness);
        int b1 = random.nextInt(brightness);
        int r2 = random.nextInt(brightness);
        int g2 = random.nextInt(brightness);
        int b2 = random.nextInt(brightness);
        int r3 = random.nextInt(brightness);
        int g3 = random.nextInt(brightness);
        int b3 = random.nextInt(brightness);
        int r4 = random.nextInt(brightness);
        int g4 = random.nextInt(brightness);
        int b4 = random.nextInt(brightness);
        int r5 = random.nextInt(brightness);
        int g5 = random.nextInt(brightness);
        int b5 = random.nextInt(brightness);
        int r6 = random.nextInt(brightness);
        int g6 = random.nextInt(brightness);
        int b6 = random.nextInt(brightness);
        int r7 = random.nextInt(brightness);
        int g7 = random.nextInt(brightness);
        int b7 = random.nextInt(brightness);

        pPoseStack.translate(0.0D, 0.25D, 0.0D);

        pPoseStack.mulPose(Axis.XP.rotationDegrees(random.nextFloat() * 360.0F + ticks * 0.5F));
        pPoseStack.mulPose(Axis.YP.rotationDegrees(random.nextFloat() * 360.0F + ticks * 0.5F));
        pPoseStack.mulPose(Axis.ZP.rotationDegrees(random.nextFloat() * 360.0F + ticks * 0.5F));

        consumer.vertex(matrix4f, -scale, -scale, scale).color(r0, g0, b0, alpha).endVertex();
        consumer.vertex(matrix4f, -scale, scale, scale).color(r1, g1, b1, alpha).endVertex();
        consumer.vertex(matrix4f, -scale, scale, -scale).color(r2, g2, b2, alpha).endVertex();
        consumer.vertex(matrix4f, -scale, -scale, -scale).color(r3, g3, b3, alpha).endVertex();

        consumer.vertex(matrix4f, -scale, -scale, -scale).color(r3, g3, b3, alpha).endVertex();
        consumer.vertex(matrix4f, -scale, scale, -scale).color(r2, g2, b2, alpha).endVertex();
        consumer.vertex(matrix4f, scale, scale, -scale).color(r4, g4, b4, alpha).endVertex();
        consumer.vertex(matrix4f, scale, -scale, -scale).color(r5, g5, b5, alpha).endVertex();

        consumer.vertex(matrix4f, scale, -scale, -scale).color(r5, g5, b5, alpha).endVertex();
        consumer.vertex(matrix4f, scale, scale, -scale).color(r4, g4, b4, alpha).endVertex();
        consumer.vertex(matrix4f, scale, scale, scale).color(r6, g6, b6, alpha).endVertex();
        consumer.vertex(matrix4f, scale, -scale, scale).color(r7, g7, b7, alpha).endVertex();

        consumer.vertex(matrix4f, scale, -scale, scale).color(r7, g7, b7, alpha).endVertex();
        consumer.vertex(matrix4f, scale, scale, scale).color(r6, g6, b6, alpha).endVertex();
        consumer.vertex(matrix4f, -scale, scale, scale).color(r1, g1, b1, alpha).endVertex();
        consumer.vertex(matrix4f, -scale, -scale, scale).color(r0, g0, b0, alpha).endVertex();

        consumer.vertex(matrix4f, scale, scale, scale).color(r6, g6, b6, alpha).endVertex();
        consumer.vertex(matrix4f, scale, scale, -scale).color(r4, g4, b4, alpha).endVertex();
        consumer.vertex(matrix4f, -scale, scale, -scale).color(r2, g2, b2, alpha).endVertex();
        consumer.vertex(matrix4f, -scale, scale, scale).color(r1, g1, b1, alpha).endVertex();

        consumer.vertex(matrix4f, -scale, -scale, -scale).color(r3, g3, b3, alpha).endVertex();
        consumer.vertex(matrix4f, scale, -scale, -scale).color(r5, g5, b5, alpha).endVertex();
        consumer.vertex(matrix4f, scale, -scale, scale).color(r7, g7, b7, alpha).endVertex();
        consumer.vertex(matrix4f, -scale, -scale, scale).color(r0, g0, b0, alpha).endVertex();

        pPoseStack.popPose();
    }

    @Override
    public ResourceLocation getTextureLocation(BubbleSpellEntity pEntity) {
        return InventoryMenu.BLOCK_ATLAS;
    }
}
