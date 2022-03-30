package com.axanthic.icaria.common.entities;

import com.axanthic.icaria.common.registry.IcariaEntities;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

@MethodsReturnNonnullByDefault

public class IcariaSignBlockEntity extends SignBlockEntity {
	public IcariaSignBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
		super(pWorldPosition, pBlockState);
	}

	@Override
	public BlockEntityType<?> getType() {
		return IcariaEntities.SIGN.get();
	}
}
