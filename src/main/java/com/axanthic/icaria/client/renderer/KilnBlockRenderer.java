package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.state.KilnBlockRenderState;
import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.entity.KilnBlockEntity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record KilnBlockRenderer(BlockEntityRendererProvider.Context context) implements BlockEntityRenderer<KilnBlockEntity, KilnBlockRenderState> {

	@Override
	public int getViewDistance() {
		return IcariaConfig.RENDER_DISTANCE_KILN_ITEMS.get();
	}

	@Override
	public void extractRenderState(KilnBlockEntity pBlockEntity, KilnBlockRenderState pRenderState, float pPartialTick, Vec3 pVec3, @Nullable ModelFeatureRenderer.CrumblingOverlay pCrumblingOverlay) {
		BlockEntityRenderer.super.extractRenderState(pBlockEntity, pRenderState, pPartialTick, pVec3, pCrumblingOverlay);
		pRenderState.blockState = pBlockEntity.getBlockState();
		pRenderState.fuel = new ItemStackRenderState();
		pRenderState.intake = new ItemStackRenderState();
		this.context().itemModelResolver().updateForTopItem(pRenderState.fuel, pBlockEntity.getFuel(), ItemDisplayContext.FIXED, pBlockEntity.getLevel(), null, 0);
		this.context().itemModelResolver().updateForTopItem(pRenderState.intake, pBlockEntity.getIntake(), ItemDisplayContext.FIXED, pBlockEntity.getLevel(), null, 0);
	}

	@Override
	public void submit(KilnBlockRenderState pRenderState, PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, CameraRenderState pCameraRenderState) {
		var direction = pRenderState.blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
		IcariaClientHelper.submitItem(pSubmitNodeCollector, pPoseStack, pRenderState.fuel, direction, pRenderState.lightCoords, 0.5F, 0.5F, 0.1875F, 0.5F, 0.5F, 90.0F, 0.0F, 180.0F + direction.toYRot(), 0.25F, 0.25F, 0.25F);
		IcariaClientHelper.submitItem(pSubmitNodeCollector, pPoseStack, pRenderState.intake, direction, pRenderState.lightCoords, 0.5F, 0.5F, 0.625F, 0.5F, 0.5F, 90.0F, 0.0F, 180.0F + direction.toYRot(), 0.25F, 0.25F, 0.25F);
	}

	@Override
	public KilnBlockRenderState createRenderState() {
		return new KilnBlockRenderState();
	}
}
