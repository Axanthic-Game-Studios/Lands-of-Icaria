package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.state.HutchBlockRenderState;
import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.entity.HutchBlockEntity;

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
import net.minecraft.util.Mth;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record HutchBlockRenderer(BlockEntityRendererProvider.Context context) implements BlockEntityRenderer<HutchBlockEntity, HutchBlockRenderState> {

	@Override
	public int getViewDistance() {
		return IcariaConfig.RENDER_DISTANCE_HUTCH_ITEMS.get();
	}

	@Override
	public void extractRenderState(HutchBlockEntity pBlockEntity, HutchBlockRenderState pRenderState, float pPartialTick, Vec3 pVec3, @Nullable ModelFeatureRenderer.CrumblingOverlay pCrumblingOverlay) {
		BlockEntityRenderer.super.extractRenderState(pBlockEntity, pRenderState, pPartialTick, pVec3, pCrumblingOverlay);
		pRenderState.bottomLeftAngle = pBlockEntity.getBottomLeftAngle();
		pRenderState.bottomRightAngle = pBlockEntity.getBottomRightAngle();
		pRenderState.topLeftAngle = pBlockEntity.getTopLeftAngle();
		pRenderState.topRightAngle = pBlockEntity.getTopRightAngle();
		pRenderState.blockState = pBlockEntity.getBlockState();
		pRenderState.bottomLeftItem = new ItemStackRenderState();
		pRenderState.bottomRightItem = new ItemStackRenderState();
		pRenderState.topLeftItem = new ItemStackRenderState();
		pRenderState.topRightItem = new ItemStackRenderState();
		pRenderState.level = pBlockEntity.getLevel();
		this.extract(pBlockEntity.getBottomLeftItem(), pRenderState.bottomLeftItem, pRenderState);
		this.extract(pBlockEntity.getBottomRightItem(), pRenderState.bottomRightItem, pRenderState);
		this.extract(pBlockEntity.getTopLeftItem(), pRenderState.topLeftItem, pRenderState);
		this.extract(pBlockEntity.getTopRightItem(), pRenderState.topRightItem, pRenderState);
	}

	public void extract(@Nullable Item pItem, ItemStackRenderState pItemStackRenderState, HutchBlockRenderState pRenderState) {
		if (pItem != null) {
			this.context().itemModelResolver().updateForTopItem(pItemStackRenderState, new ItemStack(pItem), ItemDisplayContext.FIXED, pRenderState.level, null, 0);
		}
	}

	@Override
	public void submit(HutchBlockRenderState pRenderState, PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, CameraRenderState pCameraRenderState) {
		var direction = pRenderState.blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
		IcariaClientHelper.submitItem(pSubmitNodeCollector, pPoseStack, pRenderState.bottomLeftItem, direction, pRenderState.lightCoords, 0.25F, 0.75F, 0.34375F, 0.75F, 0.25F, 0.0F, (180.0F - direction.toYRot() - Mth.sin((float) (pRenderState.level.getGameTime() * 0.025F - pRenderState.bottomLeftAngle * 90.0F)) * 45.0F), 0.0F, 0.25F, 0.25F, 0.25F);
		IcariaClientHelper.submitItem(pSubmitNodeCollector, pPoseStack, pRenderState.bottomRightItem, direction, pRenderState.lightCoords, 0.75F, 0.25F, 0.34375F, 0.75F, 0.25F, 0.0F, (180.0F - direction.toYRot() - Mth.sin((float) (pRenderState.level.getGameTime() * 0.025F - pRenderState.bottomRightAngle * 90.0F)) * 45.0F), 0.0F, 0.25F, 0.25F, 0.25F);
		IcariaClientHelper.submitItem(pSubmitNodeCollector, pPoseStack, pRenderState.topLeftItem, direction, pRenderState.lightCoords, 0.25F, 0.75F, 0.84375F, 0.75F, 0.25F, 0.0F, (180.0F - direction.toYRot() - Mth.sin((float) (pRenderState.level.getGameTime() * 0.025F - pRenderState.topLeftAngle * 90.0F)) * 45.0F), 0.0F, 0.25F, 0.25F, 0.25F);
		IcariaClientHelper.submitItem(pSubmitNodeCollector, pPoseStack, pRenderState.topRightItem, direction, pRenderState.lightCoords, 0.75F, 0.25F, 0.84375F, 0.75F, 0.25F, 0.0F, (180.0F - direction.toYRot() - Mth.sin((float) (pRenderState.level.getGameTime() * 0.025F - pRenderState.topRightAngle * 90.0F)) * 45.0F), 0.0F, 0.25F, 0.25F, 0.25F);
	}

	@Override
	public HutchBlockRenderState createRenderState() {
		return new HutchBlockRenderState();
	}
}
