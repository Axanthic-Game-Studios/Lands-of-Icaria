package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.common.item.IcariaSkullItem;
import com.axanthic.icaria.common.util.IcariaSkullBlockType;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.SkullModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

import java.util.Map;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaSkullItemRenderer extends BlockEntityWithoutLevelRenderer {
    public Map<IcariaSkullBlockType, SkullModel> map;

    public IcariaSkullItemRenderer(BlockEntityRenderDispatcher pDispatcher, EntityModelSet pSet) {
        super(pDispatcher, pSet);
        this.map = IcariaSkullBlockRenderer.createRenderers(pSet);
    }

    @Override
    public void renderByItem(ItemStack pStack, ItemDisplayContext pDisplayContext, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        if (pStack.getItem() instanceof IcariaSkullItem skullItem) {
            IcariaSkullBlockRenderer.renderSkull(null, 180.0F, pPoseStack, pBuffer, pPackedLight, this.map, skullItem.getBlock());
        }
    }
}
