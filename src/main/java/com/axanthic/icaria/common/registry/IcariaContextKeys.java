package com.axanthic.icaria.common.registry;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.util.context.ContextKey;
import net.minecraft.world.level.block.state.BlockState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaContextKeys {
	public static ContextKey<Boolean> BARREL = new ContextKey<>(IcariaIdentifiers.BARREL_CONTEXT_KEY);
	public static ContextKey<BlockState> BARREL_BLOCK_STATE = new ContextKey<>(IcariaIdentifiers.BARREL_BLOCK_STATE_CONTEXT_KEY);
	public static ContextKey<Boolean> LOOT_VASE = new ContextKey<>(IcariaIdentifiers.LOOT_VASE_CONTEXT_KEY);
	public static ContextKey<BlockState> LOOT_VASE_BLOCK_STATE = new ContextKey<>(IcariaIdentifiers.LOOT_VASE_BLOCK_STATE_CONTEXT_KEY);
}
