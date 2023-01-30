package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

@MethodsReturnNonnullByDefault

public class IcariaSignBlockEntity extends SignBlockEntity {
	public IcariaSignBlockEntity(BlockPos pPos, BlockState pState) {
		super(pPos, pState);
	}

	@Override
	public BlockEntityType<?> getType() {
		return IcariaBlockEntityTypes.SIGN.get();
	}
}
