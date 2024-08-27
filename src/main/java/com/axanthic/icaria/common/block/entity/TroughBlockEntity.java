package com.axanthic.icaria.common.block.entity;

import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class TroughBlockEntity extends BlockEntity {
	public TroughBlockEntity(BlockPos pPos, BlockState pState) {
		super(IcariaBlockEntityTypes.TROUGH.get(), pPos, pState);
	}
}
