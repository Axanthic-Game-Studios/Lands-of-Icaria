package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.state.ForgeBlockRenderState;
import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.entity.ForgeBlockEntity;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record ForgeBlockRenderer(BlockEntityRendererProvider.Context context) implements BlockEntityRenderer<ForgeBlockEntity, ForgeBlockRenderState> {

	@Override
	public int getViewDistance() {
		return IcariaConfig.RENDER_DISTANCE_FORGE_ITEMS.get();
	}

	@Override
	public void extractRenderState(ForgeBlockEntity pBlockEntity, ForgeBlockRenderState pRenderState, float pPartialTick, Vec3 pVec3, @Nullable ModelFeatureRenderer.CrumblingOverlay pCrumblingOverlay) {
		BlockEntityRenderer.super.extractRenderState(pBlockEntity, pRenderState, pPartialTick, pVec3, pCrumblingOverlay);
		pRenderState.blockState = pBlockEntity.getBlockState();
		pRenderState.fuel = new ItemStackRenderState();
		pRenderState.outputA = new ItemStackRenderState();
		pRenderState.outputB = new ItemStackRenderState();
		this.context().itemModelResolver().updateForTopItem(pRenderState.fuel, pBlockEntity.getFuel(), ItemDisplayContext.FIXED, pBlockEntity.getLevel(), null, 0);
		this.context().itemModelResolver().updateForTopItem(pRenderState.outputA, pBlockEntity.getOutputA(), ItemDisplayContext.FIXED, pBlockEntity.getLevel(), null, 0);
		this.context().itemModelResolver().updateForTopItem(pRenderState.outputB, pBlockEntity.getOutputB(), ItemDisplayContext.FIXED, pBlockEntity.getLevel(), null, 0);
	}

	@Override
	public void submit(ForgeBlockRenderState pRenderState, PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, CameraRenderState pCameraRenderState) {
		var direction = pRenderState.blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
		IcariaClientHelper.submitItem(pSubmitNodeCollector, pPoseStack, pRenderState.fuel, direction, pRenderState.lightCoords, 1.0F, 0.0F, 0.125F, 0.5F, 0.5F, 90.0F, 0.0F, 180.0F + direction.toYRot(), 0.375F, 0.375F, 0.375F);
		IcariaClientHelper.submitItem(pSubmitNodeCollector, pPoseStack, pRenderState.outputA, direction, pRenderState.lightCoords, 0.4875F, 0.5125F, 1.1875F, 0.3875F, 0.6125F, 90.0F, 0.0F, 180.0F + direction.toYRot(), 0.375F, 0.375F, 0.375F);
		IcariaClientHelper.submitItem(pSubmitNodeCollector, pPoseStack, pRenderState.outputB, direction, pRenderState.lightCoords, 1.0F, 0.0F, 0.875F, 0.3875F, 0.6125F, 90.0F, 0.0F, 180.0F + direction.toYRot(), 0.375F, 0.375F, 0.375F);
	}

	@Override
	public AABB getRenderBoundingBox(ForgeBlockEntity pBlockEntity) {
		return AABB.INFINITE;
	}

	@Override
	public ForgeBlockRenderState createRenderState() {
		return new ForgeBlockRenderState();
	}
}
