package com.axanthic.icaria.client.extensions;

import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.material.FluidState;

import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;

public class IcariaClientFluidTypeExtensions implements IClientFluidTypeExtensions {
    public ResourceLocation flowingTexture;
    public ResourceLocation stillTexture;

    public IcariaClientFluidTypeExtensions(ResourceLocation pFlowingTexture, ResourceLocation pStillTexture) {
        this.flowingTexture = pFlowingTexture;
        this.stillTexture = pStillTexture;
    }

    @Override
    public int getTintColor(FluidState pState, BlockAndTintGetter pLevel, BlockPos pPos) {
        return BiomeColors.getAverageWaterColor(pLevel, pPos) | 0xFF000000;
    }

    @Override
    public ResourceLocation getFlowingTexture() {
        return this.flowingTexture;
    }

    @Override
    public ResourceLocation getStillTexture() {
        return this.stillTexture;
    }
}
