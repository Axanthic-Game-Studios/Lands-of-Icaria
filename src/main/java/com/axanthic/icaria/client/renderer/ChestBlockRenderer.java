package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.entity.IcariaChestBlockEntity;

import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.ChestRenderer;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ChestBlockRenderer extends ChestRenderer<IcariaChestBlockEntity> {
	public ChestBlockRenderer(BlockEntityRendererProvider.Context pContext) {
		super(pContext);
	}
}
