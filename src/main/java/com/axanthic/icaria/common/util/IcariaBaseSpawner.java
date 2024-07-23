package com.axanthic.icaria.common.util;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BaseSpawner;
import net.minecraft.world.level.Level;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBaseSpawner extends BaseSpawner {
	public IcariaBaseSpawner() {

	}

	@Override
	public void broadcastEvent(Level pLevel, BlockPos pPos, int pEventId) {
		pLevel.blockEvent(pPos, pLevel.getBlockState(pPos).getBlock(), pEventId, 0);
	}
}
