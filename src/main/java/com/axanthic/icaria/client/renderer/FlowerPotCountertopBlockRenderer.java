package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.state.FlowerPotCountertopBlockRenderState;
import com.axanthic.icaria.common.entity.FlowerPotCountertopBlockEntity;
import com.axanthic.icaria.common.registry.IcariaDataMapTypes;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record FlowerPotCountertopBlockRenderer(BlockEntityRendererProvider.Context context) implements BlockEntityRenderer<FlowerPotCountertopBlockEntity, FlowerPotCountertopBlockRenderState> {

	@Override
	public void extractRenderState(FlowerPotCountertopBlockEntity pBlockEntity, FlowerPotCountertopBlockRenderState pRenderState, float pPartialTick, Vec3 pVec3, @Nullable ModelFeatureRenderer.CrumblingOverlay pCrumblingOverlay) {
		BlockEntityRenderer.super.extractRenderState(pBlockEntity, pRenderState, pPartialTick, pVec3, pCrumblingOverlay);
		pRenderState.item = pBlockEntity.getItem();
		pRenderState.level = pBlockEntity.getLevel();
	}

	@Override
	public void submit(FlowerPotCountertopBlockRenderState pRenderState, PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, CameraRenderState pCameraRenderState) {
		var item = pRenderState.item;
		var level = pRenderState.level;
		if (item != null) {
			var itemStack = new ItemStack(item);
			var data = itemStack.getItemHolder().getData(IcariaDataMapTypes.POTTABLES);
			if (data != null) {
				var blockState = data.block().defaultBlockState();
				if (level != null) {
					pSubmitNodeCollector.submitBlock(pPoseStack, blockState, pRenderState.lightCoords, OverlayTexture.NO_OVERLAY, 0);
				}
			}
		}
	}

	@Override
	public FlowerPotCountertopBlockRenderState createRenderState() {
		return new FlowerPotCountertopBlockRenderState();
	}
}
