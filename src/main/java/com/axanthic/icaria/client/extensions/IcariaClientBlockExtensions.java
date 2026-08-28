package com.axanthic.icaria.client.extensions;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

import net.neoforged.neoforge.client.extensions.common.IClientBlockExtensions;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaClientBlockExtensions implements IClientBlockExtensions {

	@Override
	public boolean areBreakingParticlesTinted(BlockState pBlockState, ClientLevel pClientLevel, BlockPos pBlockPos) {
		return false;
	}
}
