package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaTrappedChestBlockEntity extends IcariaChestBlockEntity {
	public IcariaTrappedChestBlockEntity(BlockPos pBlockPos, BlockState pBlockState) {
		super(IcariaBlockEntityTypes.TRAPPED_CHEST.get(), pBlockPos, pBlockState);
	}

	@Override
	public void signalOpenCount(Level pLevel, BlockPos pBlockPos, BlockState pBlockState, int pEventId, int pEventParam) {
		super.signalOpenCount(pLevel, pBlockPos, pBlockState, pEventId, pEventParam);
		if (pEventId != pEventParam) {
			var block = pBlockState.getBlock();
			pLevel.updateNeighborsAt(pBlockPos, block);
			pLevel.updateNeighborsAt(pBlockPos.below(), block);
		}
	}
}
