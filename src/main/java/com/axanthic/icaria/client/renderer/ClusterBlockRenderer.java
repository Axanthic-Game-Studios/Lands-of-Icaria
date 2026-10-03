package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.state.ClusterBlockRenderState;
import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.entity.ClusterBlockEntity;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.Nullable;

import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record ClusterBlockRenderer(BlockEntityRendererProvider.Context context) implements BlockEntityRenderer<ClusterBlockEntity, ClusterBlockRenderState> {

	@Override
	public int getViewDistance() {
		return IcariaConfig.RENDER_DISTANCE_CLUSTER_RAYS.get();
	}

	@Override
	public void extractRenderState(ClusterBlockEntity pBlockEntity, ClusterBlockRenderState pRenderState, float pPartialTicks, Vec3 pVec3, @Nullable ModelFeatureRenderer.CrumblingOverlay pCrumblingOverlay) {
		BlockEntityRenderer.super.extractRenderState(pBlockEntity, pRenderState, pPartialTicks, pVec3, pCrumblingOverlay);
		pRenderState.x = pBlockEntity.x;
		pRenderState.y = pBlockEntity.y;
		pRenderState.z = pBlockEntity.z;
		pRenderState.red = pBlockEntity.red;
		pRenderState.green = pBlockEntity.green;
		pRenderState.blue = pBlockEntity.blue;
	}

	@Override
	public void submit(ClusterBlockRenderState pRenderState, PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, CameraRenderState pCameraRenderState) {
		pPoseStack.pushPose();
		IcariaClientHelper.setPositionAndSize(pPoseStack, pRenderState.x, pRenderState.y, pRenderState.z, 1.0F);
		IcariaClientHelper.submitRays(pSubmitNodeCollector, pPoseStack, pRenderState.red, pRenderState.green, pRenderState.blue);
		pPoseStack.popPose();
	}

	@Override
	public AABB getRenderBoundingBox(ClusterBlockEntity pBlockEntity) {
		return AABB.INFINITE;
	}

	@Override
	public ClusterBlockRenderState createRenderState() {
		return new ClusterBlockRenderState();
	}
}
