package com.axanthic.icaria.client.extensions;

import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.material.FluidState;

import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidStack;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class MediterraneanWaterFluidTypeExtensions implements IClientFluidTypeExtensions {

	@Override
	public int getTintColor(FluidStack pStack) {
		return 0xFF4D9352;
	}

	@Override
	public int getTintColor(FluidState pState, BlockAndTintGetter pLevel, BlockPos pPos) {
		return BiomeColors.getAverageWaterColor(pLevel, pPos) | 0xFF000000;
	}

	@Override
	public ResourceLocation getFlowingTexture() {
		return IcariaResourceLocations.FLOWING_MEDITERRANEAN_WATER;
	}

	@Override
	public ResourceLocation getStillTexture() {
		return IcariaResourceLocations.MEDITERRANEAN_WATER;
	}
}
