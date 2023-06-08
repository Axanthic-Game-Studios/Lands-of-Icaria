package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.common.entity.LootVaseEntity;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.RenderShape;

import net.minecraftforge.client.model.data.ModelData;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class LootVaseRenderer extends EntityRenderer<LootVaseEntity> {
    public BlockRenderDispatcher dispatcher;

    public LootVaseRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.dispatcher = pContext.getBlockRenderDispatcher();
    }

    @Override
    public void render(LootVaseEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        var blockState = pEntity.getBlockState();
        if (blockState.getRenderShape() == RenderShape.MODEL) {
            var level = pEntity.getLevel();
            if (blockState != level.getBlockState(pEntity.blockPosition()) && blockState.getRenderShape() != RenderShape.INVISIBLE) {
                var blockPos = BlockPos.containing(pEntity.getX(), pEntity.getBoundingBox().maxY, pEntity.getZ());
                var model = this.dispatcher.getBlockModel(blockState);
                pMatrixStack.pushPose();
                pMatrixStack.translate(-0.5D, 0.0D, -0.5D);
                for (var renderType : model.getRenderTypes(blockState, RandomSource.create(blockState.getSeed(pEntity.getStartPos())), ModelData.EMPTY)) {
                    this.dispatcher.getModelRenderer().tesselateBlock(level, model, blockState, blockPos, pMatrixStack, pBuffer.getBuffer(renderType), false, RandomSource.create(), blockState.getSeed(pEntity.getStartPos()), OverlayTexture.NO_OVERLAY, ModelData.EMPTY, renderType);
                }

                pMatrixStack.popPose();
                super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
            }
        }
    }

    @Override
    public ResourceLocation getTextureLocation(LootVaseEntity pEntity) {
        return TextureAtlas.LOCATION_BLOCKS;
    }
}
