package com.axanthic.icaria.client.extensions;

import com.axanthic.icaria.common.registry.IcariaColors;
import com.axanthic.icaria.common.registry.IcariaIdentifiers;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;


import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;

import net.minecraft.resources.Identifier;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.material.FluidState;

import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidStack;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaClientFluidTypeExtensions implements IClientFluidTypeExtensions {

	@Override
	public int getTintColor(FluidStack pFluidStack) {
		return IcariaColors.TINT_WATER;
	}

	@Override
	public int getTintColor(FluidState pFluidState, BlockAndTintGetter pBlockAndTintGetter, BlockPos pBlockPos) {
		return BiomeColors.getAverageWaterColor(pBlockAndTintGetter, pBlockPos) | 0xFF000000;
	}

	@Override
	public Identifier getFlowingTexture() {
		return IcariaIdentifiers.FLOWING_MEDITERRANEAN_WATER;
	}

	@Override
	public Identifier getOverlayTexture() {
		return IcariaIdentifiers.MEDITERRANEAN_WATER_OVERLAY;
	}

	@Override
	public Identifier getRenderOverlayTexture(Minecraft pMinecraft) {
		return IcariaIdentifiers.MEDITERRANEAN_WATER_UNDERWATER;
	}

	@Override
	public Identifier getStillTexture() {
		return IcariaIdentifiers.MEDITERRANEAN_WATER;
	}
}
