package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.block.BlockModelRenderState;
import net.minecraft.util.context.ContextKey;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaContextKeys {
	public static ContextKey<Boolean> BARREL = new ContextKey<>(IcariaIdentifiers.BARREL);
	public static ContextKey<BlockModelRenderState> BARREL_BLOCK_MODEL_RENDER_STATE = new ContextKey<>(IcariaIdentifiers.BARREL_BLOCK_MODEL_RENDER_STATE);
	public static ContextKey<Boolean> LOOT_VASE = new ContextKey<>(IcariaIdentifiers.LOOT_VASE);
	public static ContextKey<BlockModelRenderState> LOOT_VASE_BLOCK_MODEL_RENDER_STATE = new ContextKey<>(IcariaIdentifiers.LOOT_VASE_BLOCK_MODEL_RENDER_STATE);
}
