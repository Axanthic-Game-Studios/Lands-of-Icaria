package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.state.FloatingBlockRenderState;
import com.axanthic.icaria.common.entity.FloatingBlockEntity;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;

import net.neoforged.neoforge.client.model.data.ModelData;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FloatingBlockRenderer extends EntityRenderer<FloatingBlockEntity, FloatingBlockRenderState> {
	public BlockRenderDispatcher blockRenderDispatcher;

	public FloatingBlockRenderer(EntityRendererProvider.Context pContext) {
		super(pContext);
		this.blockRenderDispatcher = pContext.getBlockRenderDispatcher();
	}

	public void block(BakedModel pBakedModel, BlockState pBlockState, MultiBufferSource pMultiBufferSource, PoseStack pPoseStack, FloatingBlockRenderState pRenderState) {
		for (var renderType : pBakedModel.getRenderTypes(pBlockState, RandomSource.create(), ModelData.EMPTY)) {
			this.blockRenderDispatcher.getModelRenderer().tesselateBlock(pRenderState.level, pBakedModel, pBlockState, BlockPos.containing(pRenderState.x, pRenderState.aabb.maxY, pRenderState.z), pPoseStack, pMultiBufferSource.getBuffer(renderType), false, RandomSource.create(), pBlockState.getSeed(pRenderState.blockPos), OverlayTexture.NO_OVERLAY, ModelData.EMPTY, renderType);
		}
	}

	@Override
	public void extractRenderState(FloatingBlockEntity pEntity, FloatingBlockRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.aabb = pEntity.getBoundingBox();
		pRenderState.blockPos = pEntity.getBlockPos();
		pRenderState.blockState = pEntity.getBlockState();
		pRenderState.level = pEntity.level();
	}

	@Override
	public void render(FloatingBlockRenderState pRenderState, PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight) {
		var blockState = pRenderState.blockState;

		pPoseStack.pushPose();

		pPoseStack.translate(-0.5D, 0.0D, -0.5D);

		this.block(this.blockRenderDispatcher.getBlockModel(blockState), blockState, pMultiBufferSource, pPoseStack, pRenderState);

		pPoseStack.popPose();

		super.render(pRenderState, pPoseStack, pMultiBufferSource, pPackedLight);
	}

	@Override
	public FloatingBlockRenderState createRenderState() {
		return new FloatingBlockRenderState();
	}
}
