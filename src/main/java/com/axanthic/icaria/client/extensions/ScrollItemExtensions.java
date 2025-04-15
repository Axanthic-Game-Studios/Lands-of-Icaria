package com.axanthic.icaria.client.extensions;

import com.axanthic.icaria.client.renderer.ScrollItemRenderer;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;

import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ScrollItemExtensions implements IClientItemExtensions {

	@Override
	public BlockEntityWithoutLevelRenderer getCustomRenderer() {
		var minecraft = Minecraft.getInstance();
		return new ScrollItemRenderer(minecraft.getBlockEntityRenderDispatcher(), minecraft.getEntityModels());
	}
}
