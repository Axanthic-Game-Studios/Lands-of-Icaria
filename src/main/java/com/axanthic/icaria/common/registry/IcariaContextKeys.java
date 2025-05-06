package com.axanthic.icaria.common.registry;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.util.context.ContextKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaContextKeys {
	public static ContextKey<Level> LEVEL = new ContextKey<>(IcariaResourceLocations.LEVEL_CONTEXT_KEY);
	public static ContextKey<Boolean> LOOT_VASE = new ContextKey<>(IcariaResourceLocations.LOOT_VASE_CONTEXT_KEY);
	public static ContextKey<BlockPos> LOOT_VASE_BLOCK_POS = new ContextKey<>(IcariaResourceLocations.LOOT_VASE_BLOCK_POS_CONTEXT_KEY);
	public static ContextKey<BlockState> LOOT_VASE_BLOCK_STATE = new ContextKey<>(IcariaResourceLocations.LOOT_VASE_BLOCK_STATE_CONTEXT_KEY);
}
