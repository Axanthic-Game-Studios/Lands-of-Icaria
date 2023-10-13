package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.common.entity.IcariaBarrelEntity;

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

public class IcariaBarrelRenderer extends EntityRenderer<IcariaBarrelEntity> {
    public BlockRenderDispatcher blockRenderDispatcher;

    public IcariaBarrelRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.blockRenderDispatcher = pContext.getBlockRenderDispatcher();
    }

    @Override
    public void render(IcariaBarrelEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        var blockState = pEntity.getRenderState();
        if (blockState.getRenderShape() == RenderShape.MODEL) {
            var level = pEntity.level();
            if (blockState != level.getBlockState(pEntity.blockPosition()) && blockState.getRenderShape() != RenderShape.INVISIBLE) {
                var blockPos = BlockPos.containing(pEntity.getX(), pEntity.getBoundingBox().maxY, pEntity.getZ());
                var bakedModel = this.blockRenderDispatcher.getBlockModel(blockState);
                pMatrixStack.pushPose();
                pMatrixStack.translate(-0.5D, 0.0D, -0.5D);
                for (var renderType : bakedModel.getRenderTypes(blockState, RandomSource.create(blockState.getSeed(pEntity.getBlockPos())), ModelData.EMPTY)) {
                    this.blockRenderDispatcher.getModelRenderer().tesselateBlock(level, bakedModel, blockState, blockPos, pMatrixStack, pBuffer.getBuffer(renderType), false, RandomSource.create(), blockState.getSeed(pEntity.getBlockPos()), OverlayTexture.NO_OVERLAY, ModelData.EMPTY, renderType);
                }

                pMatrixStack.popPose();
                super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
            }
        }
    }

    @Override
    public ResourceLocation getTextureLocation(IcariaBarrelEntity pEntity) {
        return TextureAtlas.LOCATION_BLOCKS;
    }
}
