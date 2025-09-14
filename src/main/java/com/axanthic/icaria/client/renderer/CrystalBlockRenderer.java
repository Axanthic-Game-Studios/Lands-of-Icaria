package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.entity.CrystalBlockEntity;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record CrystalBlockRenderer(BlockEntityRendererProvider.Context context) implements BlockEntityRenderer<CrystalBlockEntity> {

	@Override
	public int getViewDistance() {
		return IcariaConfig.RENDER_DISTANCE_CRYSTAL_RAYS.get();
	}

	@Override
	public void render(CrystalBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight, int pPackedOverlay, Vec3 pVec3) {
		pPoseStack.pushPose();
		IcariaClientHelper.setPositionAndSize(pPoseStack, pBlockEntity.x, pBlockEntity.y, pBlockEntity.z, 1.0F);
		IcariaClientHelper.renderRays(pPoseStack, pMultiBufferSource, pBlockEntity.red, pBlockEntity.green, pBlockEntity.blue);
		pPoseStack.popPose();
	}

	@Override
	public AABB getRenderBoundingBox(CrystalBlockEntity pBlockEntity) {
		return AABB.INFINITE;
	}
}
