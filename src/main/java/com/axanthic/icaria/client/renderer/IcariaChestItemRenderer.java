package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.common.entity.IcariaChestBlockEntity;
import com.axanthic.icaria.common.entity.IcariaTrappedChestBlockEntity;
import com.axanthic.icaria.common.item.IcariaChestItem;
import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaChestItemRenderer extends BlockEntityWithoutLevelRenderer {
	public IcariaChestItemRenderer(BlockEntityRenderDispatcher pBlockEntityRenderDispatcher, EntityModelSet pEntityModelSet) {
		super(pBlockEntityRenderDispatcher, pEntityModelSet);
	}

	@Override
	public void renderByItem(ItemStack pItemStack, ItemDisplayContext pItemDisplayContext, PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight, int pPackedOverlay) {
		var blockEntityRenderDispatcher = Minecraft.getInstance().getBlockEntityRenderDispatcher();
		if (pItemStack.getItem() instanceof IcariaChestItem chestItem) {
			var blockState = chestItem.getBlock().defaultBlockState();
			if (blockState.is(IcariaBlocks.CHEST.get())) {
				var blockEntity = new IcariaChestBlockEntity(BlockPos.ZERO, blockState);
				blockEntityRenderDispatcher.renderItem(blockEntity, pPoseStack, pMultiBufferSource, pPackedLight, pPackedOverlay);
			} else if (blockState.is(IcariaBlocks.TRAPPED_CHEST.get())) {
				var blockEntity = new IcariaTrappedChestBlockEntity(BlockPos.ZERO, blockState);
				blockEntityRenderDispatcher.renderItem(blockEntity, pPoseStack, pMultiBufferSource, pPackedLight, pPackedOverlay);
			}
		}
	}
}
