package com.axanthic.icaria.client.extensions;

import com.axanthic.icaria.client.renderer.IcariaSkullItemRenderer;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;

import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaSkullItemExtensions implements IClientItemExtensions {

	@Override
	public BlockEntityWithoutLevelRenderer getCustomRenderer() {
		var minecraft = Minecraft.getInstance();
		return new IcariaSkullItemRenderer(minecraft.getBlockEntityRenderDispatcher(), minecraft.getEntityModels());
	}
}
