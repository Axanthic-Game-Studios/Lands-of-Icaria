package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.entity.KilnBlockEntity;

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

public record KilnBlockRenderer(BlockEntityRendererProvider.Context context) implements BlockEntityRenderer<KilnBlockEntity> {

	@Override
	public int getViewDistance() {
		return IcariaConfig.RENDER_DISTANCE_KILN_ITEMS.get();
	}

	@Override
	public void render(KilnBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight, int pPackedOverlay, Vec3 pVec3) {
		var direction = pBlockEntity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);
		IcariaClientHelper.renderItem(pPoseStack, pMultiBufferSource, pBlockEntity.getFuel(), direction, pBlockEntity, pPackedLight, 0.5F, 0.5F, 0.1875F, 0.5F, 0.5F, 90.0F, 0.0F, 180.0F + direction.toYRot(), 0.25F, 0.25F, 0.25F);
		IcariaClientHelper.renderItem(pPoseStack, pMultiBufferSource, pBlockEntity.getInput(), direction, pBlockEntity, pPackedLight, 0.5F, 0.5F, 0.625F, 0.5F, 0.5F, 90.0F, 0.0F, 180.0F + direction.toYRot(), 0.25F, 0.25F, 0.25F);
	}
}
