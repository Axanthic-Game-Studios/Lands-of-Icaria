package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.common.entity.IcariaSpawnerBlockEntity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.util.Mth;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaSpawnerBlockRenderer implements BlockEntityRenderer<IcariaSpawnerBlockEntity> {
    public EntityRenderDispatcher entityRenderer;

    public IcariaSpawnerBlockRenderer(BlockEntityRendererProvider.Context pContext) {
        this.entityRenderer = pContext.getEntityRenderer();
    }

    @Override
    public void render(IcariaSpawnerBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        pPoseStack.pushPose();
        pPoseStack.translate(0.5F, 0.0F, 0.5F);
        var blockEntity = pBlockEntity.getSpawner();
        if (pBlockEntity.getLevel() != null) {
            var entity = blockEntity.getOrCreateDisplayEntity(pBlockEntity.getLevel(), pBlockEntity.getLevel().getRandom(), pBlockEntity.getBlockPos());
            if (entity != null) {
                float size = 0.53125F;
                float bb = Math.max(entity.getBbWidth(), entity.getBbHeight());
                if (bb > 1.0F) {
                    size /= bb;
                }

                pPoseStack.translate(0.0F, 0.4F, 0.0F);
                pPoseStack.mulPose(Axis.YP.rotationDegrees((float) Mth.lerp(pPartialTick, blockEntity.getoSpin(), blockEntity.getSpin()) * 10.0F));
                pPoseStack.translate(0.0F, -0.2F, 0.0F);
                pPoseStack.mulPose(Axis.XP.rotationDegrees(-30.0F));
                pPoseStack.scale(size, size, size);
                this.entityRenderer.render(entity, 0.0D, 0.0D, 0.0D, 0.0F, pPartialTick, pPoseStack, pBufferSource, pPackedLight);
            }
        }

        pPoseStack.popPose();
    }
}
