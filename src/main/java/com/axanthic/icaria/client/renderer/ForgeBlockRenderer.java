package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.entity.ForgeBlockEntity;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record ForgeBlockRenderer(BlockEntityRendererProvider.Context pContext) implements BlockEntityRenderer<ForgeBlockEntity> {

	@Override
	public int getViewDistance() {
		return IcariaConfig.RENDER_DISTANCE_FORGE_ITEMS.get();
	}

	@Override
	public void render(ForgeBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight, int pPackedOverlay) {
		var direction = pBlockEntity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);
		if (IcariaConfig.RENDER_FORGE_ITEMS.get()) {
			IcariaClientHelper.renderItem(pPoseStack, pMultiBufferSource, pBlockEntity.getFuel(), direction, pBlockEntity, pPackedLight, 1.0F, 0.0F, 0.125F, 0.5F, 0.5F, 90.0F, 0.0F, 180.0F + direction.toYRot(), 0.375F, 0.375F, 0.375F);
			IcariaClientHelper.renderItem(pPoseStack, pMultiBufferSource, pBlockEntity.getOutputA(), direction, pBlockEntity, pPackedLight, 0.4875F, 0.5125F, 1.1875F, 0.3875F, 0.6125F, 90.0F, 0.0F, 180.0F + direction.toYRot(), 0.375F, 0.375F, 0.375F);
			IcariaClientHelper.renderItem(pPoseStack, pMultiBufferSource, pBlockEntity.getOutputB(), direction, pBlockEntity, pPackedLight, 1.0F, 0.0F, 0.875F, 0.3875F, 0.6125F, 90.0F, 0.0F, 180.0F + direction.toYRot(), 0.375F, 0.375F, 0.375F);
		}
	}
}
