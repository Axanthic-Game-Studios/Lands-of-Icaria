package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;

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
	public void signalOpenCount(Level pLevel, BlockPos pBlockPos, BlockState pBlockState, int pPrevious, int pCurrent) {
		super.signalOpenCount(pLevel, pBlockPos, pBlockState, pPrevious, pCurrent);
		if (pPrevious != pCurrent) {
			var block = pBlockState.getBlock();
			pLevel.updateNeighborsAt(pBlockPos, block);
			pLevel.updateNeighborsAt(pBlockPos.below(), block);
		}
	}
}
