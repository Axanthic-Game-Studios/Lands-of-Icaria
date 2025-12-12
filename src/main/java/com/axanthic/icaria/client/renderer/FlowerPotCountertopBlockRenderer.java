package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.common.entity.FlowerPotCountertopBlockEntity;
import com.axanthic.icaria.common.registry.IcariaDataMapTypes;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.phys.Vec3;

@SuppressWarnings("deprecation")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record FlowerPotCountertopBlockRenderer(BlockEntityRendererProvider.Context context) implements BlockEntityRenderer<FlowerPotCountertopBlockEntity> {

	@Override
	public void render(FlowerPotCountertopBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight, int pPackedOverlay, Vec3 pVec3) {
		var item = pBlockEntity.getItem();
		var level = pBlockEntity.getLevel();
		if (item != null) {
			var data = item.builtInRegistryHolder().getData(IcariaDataMapTypes.POTTABLES);
			if (data != null) {
				var block = data.block().defaultBlockState();
				if (level != null) {
					this.context().getBlockRenderDispatcher().renderSingleBlock(block, pPoseStack, pMultiBufferSource, pPackedLight, pPackedOverlay, level, pBlockEntity.getBlockPos());
				}
			}
		}
	}
}
