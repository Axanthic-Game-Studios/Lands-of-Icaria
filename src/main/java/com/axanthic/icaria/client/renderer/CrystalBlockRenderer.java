package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.entity.CrystalBlockEntity;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.phys.AABB;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CrystalBlockRenderer implements BlockEntityRenderer<CrystalBlockEntity> {
	public CrystalBlockRenderer(BlockEntityRendererProvider.Context pContext) {

	}

	@Override
	public int getViewDistance() {
		return IcariaConfig.RENDER_DISTANCE_CRYSTAL_RAYS.get();
	}

	@Override
	public void render(CrystalBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
		pPoseStack.pushPose();
		IcariaClientHelper.setPositionAndSize(pPoseStack, pBlockEntity.x, pBlockEntity.y, pBlockEntity.z, 1.0F);
		IcariaClientHelper.renderRays(pPoseStack, pBufferSource, pBlockEntity.red, pBlockEntity.green, pBlockEntity.blue);
		pPoseStack.popPose();
	}

	@Override
	public AABB getRenderBoundingBox(CrystalBlockEntity pBlockEntity) {
		return AABB.INFINITE;
	}
}
