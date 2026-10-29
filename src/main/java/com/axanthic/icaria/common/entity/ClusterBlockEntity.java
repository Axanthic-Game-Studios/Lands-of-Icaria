package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ClusterBlockEntity extends BlockEntity {
	public double x;
	public double y;
	public double z;

	public ClusterBlockEntity(BlockPos pBlockPos, BlockState pBlockState) {
		super(IcariaBlockEntityTypes.CLUSTER.get(), pBlockPos, pBlockState);
	}

	public ClusterBlockEntity(BlockPos pBlockPos, BlockState pBlockState, double pX, double pY, double pZ) {
		this(pBlockPos, pBlockState);
		this.x = pX;
		this.y = pY;
		this.z = pZ;
	}
}
