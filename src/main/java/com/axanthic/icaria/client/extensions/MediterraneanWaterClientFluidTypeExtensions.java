package com.axanthic.icaria.client.extensions;

import com.axanthic.icaria.common.registry.IcariaColors;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.material.FluidState;

import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidStack;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class MediterraneanWaterClientFluidTypeExtensions implements IClientFluidTypeExtensions {

	@Override
	public int getTintColor(FluidStack pFluidStack) {
		return IcariaColors.TINT_WATER;
	}

	@Override
	public int getTintColor(FluidState pFluidState, BlockAndTintGetter pBlockAndTintGetter, BlockPos pBlockPos) {
		return BiomeColors.getAverageWaterColor(pBlockAndTintGetter, pBlockPos) | 0xFF000000;
	}

	@Override
	public ResourceLocation getFlowingTexture() {
		return IcariaResourceLocations.FLOWING_MEDITERRANEAN_WATER;
	}

	@Override
	public ResourceLocation getOverlayTexture() {
		return IcariaResourceLocations.MEDITERRANEAN_WATER_OVERLAY;
	}

	@Override
	public ResourceLocation getRenderOverlayTexture(Minecraft pMinecraft) {
		return IcariaResourceLocations.MEDITERRANEAN_WATER_UNDERWATER;
	}

	@Override
	public ResourceLocation getStillTexture() {
		return IcariaResourceLocations.MEDITERRANEAN_WATER;
	}
}
