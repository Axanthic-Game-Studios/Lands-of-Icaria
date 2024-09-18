package com.axanthic.icaria.client.extensions;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

import net.neoforged.neoforge.client.extensions.common.IClientBlockExtensions;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class TintedBlockExtensions implements IClientBlockExtensions {

	@Override
	public boolean areBreakingParticlesTinted(BlockState pState, ClientLevel pLevel, BlockPos pPos) {
		return false;
	}
}
