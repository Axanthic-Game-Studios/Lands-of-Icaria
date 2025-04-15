package com.axanthic.icaria.common.util;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BaseSpawner;
import net.minecraft.world.level.Level;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBaseSpawner extends BaseSpawner {

	@Override
	public void broadcastEvent(Level pLevel, BlockPos pBlockPos, int pEventId) {
		pLevel.blockEvent(pBlockPos, pLevel.getBlockState(pBlockPos).getBlock(), pEventId, 0);
	}
}
