package com.axanthic.icaria.client.extensions;

import com.axanthic.icaria.client.renderer.IcariaChestItemRenderer;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;

import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaChestItemExtensions implements IClientItemExtensions {

	@Override
	public BlockEntityWithoutLevelRenderer getCustomRenderer() {
		var minecraft = Minecraft.getInstance();
		return new IcariaChestItemRenderer(minecraft.getBlockEntityRenderDispatcher(), minecraft.getEntityModels());
	}
}
