package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.state.LootVaseRenderState;
import com.axanthic.icaria.common.entity.LootVaseEntity;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class LootVaseRenderer extends EntityRenderer<LootVaseEntity, LootVaseRenderState> {
	public BlockRenderDispatcher blockRenderDispatcher;

	public LootVaseRenderer(EntityRendererProvider.Context pContext) {
		super(pContext);
		this.blockRenderDispatcher = pContext.getBlockRenderDispatcher();
	}

	@Override
	public void extractRenderState(LootVaseEntity pEntity, LootVaseRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.x = pEntity.getX();
		pRenderState.y = pEntity.getY();
		pRenderState.z = pEntity.getZ();
		pRenderState.blockPos = pEntity.getBlockPos();
		pRenderState.blockState = pEntity.getBlockState();
		pRenderState.level = pEntity.level();
	}

	@Override
	public void render(LootVaseRenderState pRenderState, PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight) {
		var seed = pRenderState.blockState.getSeed(pRenderState.blockPos);
		var list = this.blockRenderDispatcher.getBlockModel(pRenderState.blockState).collectParts(pRenderState.level, pRenderState.blockPos, pRenderState.blockState, RandomSource.create(seed));

		pPoseStack.pushPose();

		pPoseStack.translate(-0.5D, 0.0D, -0.5D);

		this.blockRenderDispatcher.getModelRenderer().tesselateBlock(pRenderState.level, list, pRenderState.blockState, BlockPos.containing(pRenderState.x, pRenderState.y, pRenderState.z), pPoseStack, renderType -> pMultiBufferSource.getBuffer(RenderType.CUTOUT), false, OverlayTexture.NO_OVERLAY);

		pPoseStack.popPose();

		super.render(pRenderState, pPoseStack, pMultiBufferSource, pPackedLight);
	}

	@Override
	public LootVaseRenderState createRenderState() {
		return new LootVaseRenderState();
	}
}
