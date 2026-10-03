package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.client.state.FlowerPotCountertopBlockRenderState;
import com.axanthic.icaria.common.entity.FlowerPotCountertopBlockEntity;
import com.axanthic.icaria.common.registry.IcariaDataMapTypes;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.Nullable;

import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.block.BlockModelRenderState;
import net.minecraft.client.renderer.block.model.BlockDisplayContext;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.phys.Vec3;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record FlowerPotCountertopBlockRenderer(BlockEntityRendererProvider.Context context) implements BlockEntityRenderer<FlowerPotCountertopBlockEntity, FlowerPotCountertopBlockRenderState> {

	@Override
	public void extractRenderState(FlowerPotCountertopBlockEntity pBlockEntity, FlowerPotCountertopBlockRenderState pRenderState, float pPartialTicks, Vec3 pVec3, @Nullable ModelFeatureRenderer.CrumblingOverlay pCrumblingOverlay) {
		BlockEntityRenderer.super.extractRenderState(pBlockEntity, pRenderState, pPartialTicks, pVec3, pCrumblingOverlay);
		pRenderState.blockModelRenderState = new BlockModelRenderState();
		pRenderState.itemStack = pBlockEntity.getItemStack();
		var itemStack = pRenderState.itemStack;
		if (itemStack != null) {
			var data = itemStack.typeHolder().getData(IcariaDataMapTypes.POTTABLES);
			if (data != null) {
				this.context().blockModelResolver().update(pRenderState.blockModelRenderState, data.block().defaultBlockState(), BlockDisplayContext.create());
			}
		}
	}

	@Override
	public void submit(FlowerPotCountertopBlockRenderState pRenderState, PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, CameraRenderState pCameraRenderState) {
		pRenderState.blockModelRenderState.submit(pPoseStack, pSubmitNodeCollector, pRenderState.lightCoords, OverlayTexture.NO_OVERLAY, 0);
	}

	@Override
	public FlowerPotCountertopBlockRenderState createRenderState() {
		return new FlowerPotCountertopBlockRenderState();
	}
}
