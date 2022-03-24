package com.axanthic.icaria.common.entities;

import com.axanthic.icaria.common.registry.IcariaEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CrystalBlockEntity extends BlockEntity {
	public CrystalBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
		super(IcariaEntities.CRYSTAL.get(), pWorldPosition, pBlockState);
	}
}
