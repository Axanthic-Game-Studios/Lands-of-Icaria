package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.common.item.IcariaSkullItem;
import com.axanthic.icaria.common.util.IcariaSkullBlockType;

import com.mojang.blaze3d.vertex.PoseStack;

import java.util.Map;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.model.SkullModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaSkullItemRenderer extends BlockEntityWithoutLevelRenderer {
	public Map<IcariaSkullBlockType, SkullModel> map;

	public IcariaSkullItemRenderer(BlockEntityRenderDispatcher pBlockEntityRenderDispatcher, EntityModelSet pEntityModelSet) {
		super(pBlockEntityRenderDispatcher, pEntityModelSet);
		this.map = IcariaSkullBlockRenderer.createRenderers(pEntityModelSet);
	}

	@Override
	public void renderByItem(ItemStack pItemStack, ItemDisplayContext pItemDisplayContext, PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight, int pPackedOverlay) {
		if (pItemStack.getItem() instanceof IcariaSkullItem skullItem) {
			IcariaSkullBlockRenderer.renderSkull(skullItem.getBlock(), null, this.map, pMultiBufferSource, pPoseStack, 180.0F, pPackedLight);
		}
	}
}
