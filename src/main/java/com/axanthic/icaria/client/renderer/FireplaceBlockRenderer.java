package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.common.block.FireplaceBlock;
import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.entity.FireplaceBlockEntity;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record FireplaceBlockRenderer(BlockEntityRendererProvider.Context context) implements BlockEntityRenderer<FireplaceBlockEntity> {

	@Override
	public int getViewDistance() {
		return IcariaConfig.RENDER_DISTANCE_FIREPLACE_ITEMS.get();
	}

	@Override
	public void render(FireplaceBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight, int pPackedOverlay, Vec3 pVec3) {
		var blockState = pBlockEntity.getBlockState();
		if (blockState.getBlock() instanceof FireplaceBlock fireplaceBlock) {
			var direction = blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
			IcariaClientHelper.renderItem(pPoseStack, pMultiBufferSource, pBlockEntity.getInput(), direction, pBlockEntity, pPackedLight, 0.5F, 0.5F, fireplaceBlock.itemHeight, 0.5625F, 0.4375F, 90.0F, 0.0F, 180.0F + direction.toYRot(), 0.3F, 0.3F, 0.3F);
		}
	}
}
