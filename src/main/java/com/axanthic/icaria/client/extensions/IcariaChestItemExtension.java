package com.axanthic.icaria.client.extensions;

import com.axanthic.icaria.client.renderer.IcariaChestItemRenderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;

import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class IcariaChestItemExtension implements IClientItemExtensions {
    @Override
    public BlockEntityWithoutLevelRenderer getCustomRenderer() {
        var minecraft = Minecraft.getInstance();
        return new IcariaChestItemRenderer(minecraft.getBlockEntityRenderDispatcher(), minecraft.getEntityModels());
    }
}
