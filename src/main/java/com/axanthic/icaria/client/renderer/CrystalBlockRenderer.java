package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.state.CrystalBlockRenderState;
import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.entity.CrystalBlockEntity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record CrystalBlockRenderer(BlockEntityRendererProvider.Context context) implements BlockEntityRenderer<CrystalBlockEntity, CrystalBlockRenderState> {

	@Override
	public int getViewDistance() {
		return IcariaConfig.RENDER_DISTANCE_CRYSTAL_RAYS.get();
	}

	@Override
	public void extractRenderState(CrystalBlockEntity pBlockEntity, CrystalBlockRenderState pRenderState, float pPartialTick, Vec3 pVec3, @Nullable ModelFeatureRenderer.CrumblingOverlay pCrumblingOverlay) {
		BlockEntityRenderer.super.extractRenderState(pBlockEntity, pRenderState, pPartialTick, pVec3, pCrumblingOverlay);
		pRenderState.x = pBlockEntity.x;
		pRenderState.y = pBlockEntity.y;
		pRenderState.z = pBlockEntity.z;
		pRenderState.red = pBlockEntity.red;
		pRenderState.green = pBlockEntity.green;
		pRenderState.blue = pBlockEntity.blue;
	}

	@Override
	public void submit(CrystalBlockRenderState pRenderState, PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, CameraRenderState pCameraRenderState) {
		pPoseStack.pushPose();
		IcariaClientHelper.setPositionAndSize(pPoseStack, pRenderState.x, pRenderState.y, pRenderState.z, 1.0F);
		IcariaClientHelper.submitRays(pSubmitNodeCollector, pPoseStack, pRenderState.red, pRenderState.green, pRenderState.blue);
		pPoseStack.popPose();
	}

	@Override
	public AABB getRenderBoundingBox(CrystalBlockEntity pBlockEntity) {
		return AABB.INFINITE;
	}

	@Override
	public CrystalBlockRenderState createRenderState() {
		return new CrystalBlockRenderState();
	}
}
