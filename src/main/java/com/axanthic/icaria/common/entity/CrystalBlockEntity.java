package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import net.minecraftforge.common.extensions.IForgeBlockEntity;

public class CrystalBlockEntity extends BlockEntity {
	public double x;
	public double y;
	public double z;

	public int r;
	public int g;
	public int b;

	public CrystalBlockEntity(BlockPos pPos, BlockState pBlockState) {
		super(IcariaBlockEntities.CRYSTAL.get(), pPos, pBlockState);
	}

	public CrystalBlockEntity(BlockPos pPos, BlockState pBlockState, double x, double y, double z, int r, int g, int b) {
		this(pPos, pBlockState);
		this.x = x;
		this.y = y;
		this.z = z;
		this.r = r;
		this.g = g;
		this.b = b;
	}

	@Override
	public AABB getRenderBoundingBox() {
		return IForgeBlockEntity.INFINITE_EXTENT_AABB;
	}
}
