package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.common.util.IcariaSkullBlockType;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.SkullModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;

import java.util.Map;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaSkullItemRenderer extends BlockEntityWithoutLevelRenderer {
    public Map<IcariaSkullBlockType, SkullModel> modelByType;

    public IcariaSkullItemRenderer(BlockEntityRenderDispatcher pDispatcher, EntityModelSet pSet) {
        super(pDispatcher, pSet);
        modelByType = IcariaSkullBlockRenderer.createSkullRenderers(pSet);
    }

    @Override
    public void renderByItem(ItemStack pItemStack, ItemTransforms.TransformType pTransformType, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pCombinedLight, int pCombinedOverlay) {
        if (pItemStack.getItem() instanceof BlockItem blockItem) {
            IcariaSkullBlockRenderer.renderSkull(null, 180.0F, pPoseStack, pBufferSource, pCombinedLight, modelByType, blockItem.getBlock());
        }
    }
}
