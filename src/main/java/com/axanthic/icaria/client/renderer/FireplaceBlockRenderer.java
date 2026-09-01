package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.state.FireplaceBlockRenderState;
import com.axanthic.icaria.common.block.FireplaceBlock;
import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.entity.FireplaceBlockEntity;

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
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record FireplaceBlockRenderer(BlockEntityRendererProvider.Context context) implements BlockEntityRenderer<FireplaceBlockEntity, FireplaceBlockRenderState> {

	@Override
	public int getViewDistance() {
		return IcariaConfig.RENDER_DISTANCE_FIREPLACE_ITEMS.get();
	}

	@Override
	public void extractRenderState(FireplaceBlockEntity pBlockEntity, FireplaceBlockRenderState pRenderState, float pPartialTick, Vec3 pVec3, @Nullable ModelFeatureRenderer.CrumblingOverlay pCrumblingOverlay) {
		BlockEntityRenderer.super.extractRenderState(pBlockEntity, pRenderState, pPartialTick, pVec3, pCrumblingOverlay);
		pRenderState.blockState = pBlockEntity.getBlockState();
		pRenderState.intake = new ItemStackRenderState();
		this.context().itemModelResolver().updateForTopItem(pRenderState.intake, pBlockEntity.getIntake(), ItemDisplayContext.FIXED, pBlockEntity.getLevel(), null, 0);
	}

	@Override
	public void submit(FireplaceBlockRenderState pRenderState, PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, CameraRenderState pCameraRenderState) {
		var blockState = pRenderState.blockState;
		if (blockState.getBlock() instanceof FireplaceBlock fireplaceBlock) {
			var direction = blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
			IcariaClientHelper.submitItem(pSubmitNodeCollector, pPoseStack, pRenderState.intake, direction, pRenderState.lightCoords, 0.5F, 0.5F, fireplaceBlock.itemHeight, 0.5625F, 0.4375F, 90.0F, 0.0F, 180.0F + direction.toYRot(), 0.3F, 0.3F, 0.3F);
		}
	}

	@Override
	public AABB getRenderBoundingBox(FireplaceBlockEntity pBlockEntity) {
		return AABB.INFINITE;
	}

	@Override
	public FireplaceBlockRenderState createRenderState() {
		return new FireplaceBlockRenderState();
	}
}
