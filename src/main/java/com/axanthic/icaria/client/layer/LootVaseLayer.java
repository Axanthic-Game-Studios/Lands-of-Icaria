package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.common.registry.IcariaContextKeys;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.PlayerRenderState;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class LootVaseLayer extends RenderLayer<PlayerRenderState, PlayerModel> {
	public LootVaseLayer(RenderLayerParent<PlayerRenderState, PlayerModel> pRenderLayerParent) {
		super(pRenderLayerParent);
	}

	@Override
	public void render(PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight, PlayerRenderState pPlayerRenderState, float pYRot, float pXRot) {
		var blockPos = pPlayerRenderState.getRenderDataOrThrow(IcariaContextKeys.LOOT_VASE_BLOCK_POS);
		var blockState = pPlayerRenderState.getRenderDataOrThrow(IcariaContextKeys.LOOT_VASE_BLOCK_STATE);
		var level = pPlayerRenderState.getRenderDataOrThrow(IcariaContextKeys.LEVEL);
		var lootVase = pPlayerRenderState.getRenderDataOrThrow(IcariaContextKeys.LOOT_VASE);

		var vertexConsumer = pMultiBufferSource.getBuffer(RenderType.CUTOUT);

		pPoseStack.pushPose();

		pPoseStack.mulPose(Axis.ZP.rotationDegrees(180.0F));

		pPoseStack.translate(-0.5D, 0.5D, -0.5D);

		this.render(lootVase, blockPos, blockState, level, pPoseStack, vertexConsumer);

		pPoseStack.popPose();
	}

	public void render(boolean pLootVase, BlockPos pBlockPos, BlockState pBlockState, Level pLevel, PoseStack pPoseStack, VertexConsumer pVertexConsumer) {
		if (pLootVase) {
			Minecraft.getInstance().getBlockRenderer().renderBatched(pBlockState, pBlockPos, pLevel, pPoseStack, pVertexConsumer, false, RandomSource.create());
		}
	}
}
