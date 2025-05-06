package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SkullBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaSkullBlockEntity extends SkullBlockEntity {
	public IcariaSkullBlockEntity(BlockPos pBlockPos, BlockState pBlockState) {
		super(pBlockPos, pBlockState);
	}

	@Override
	public BlockEntityType<?> getType() {
		return IcariaBlockEntityTypes.SKULL.get();
	}
}
