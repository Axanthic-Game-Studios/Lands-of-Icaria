package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.common.entity.IcariaChestBlockEntity;
import com.axanthic.icaria.common.entity.IcariaTrappedChestBlockEntity;
import com.axanthic.icaria.common.item.IcariaChestItem;
import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaChestItemRenderer extends BlockEntityWithoutLevelRenderer {
	public IcariaChestItemRenderer(BlockEntityRenderDispatcher pBlockEntityRenderDispatcher, EntityModelSet pEntityModelSet) {
		super(pBlockEntityRenderDispatcher, pEntityModelSet);
	}

	@Override
	public void renderByItem(ItemStack pStack, ItemDisplayContext pDisplayContext, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
		if (pStack.getItem() instanceof IcariaChestItem chestItem) {
			var state = chestItem.getBlock().defaultBlockState();
			if (state.is(IcariaBlocks.CHEST.get())) {
				var entity = new IcariaChestBlockEntity(BlockPos.ZERO, state);
				Minecraft.getInstance().getBlockEntityRenderDispatcher().renderItem(entity, pPoseStack, pBuffer, pPackedLight, pPackedOverlay);
			} else if (state.is(IcariaBlocks.TRAPPED_CHEST.get())) {
				var entity = new IcariaTrappedChestBlockEntity(BlockPos.ZERO, state);
				Minecraft.getInstance().getBlockEntityRenderDispatcher().renderItem(entity, pPoseStack, pBuffer, pPackedLight, pPackedOverlay);
			}
		}
	}
}
