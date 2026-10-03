package com.axanthic.icaria.client.extensions;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaIdentifiers;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.Identifier;

import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaClientFluidTypeExtensions implements IClientFluidTypeExtensions {

	@Override
	public Identifier getRenderOverlayTexture(Minecraft pMinecraft) {
		return IcariaIdentifiers.MEDITERRANEAN_WATER_UNDERWATER;
	}
}
