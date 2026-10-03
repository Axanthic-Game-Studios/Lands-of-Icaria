package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.client.helper.IcariaClientHelper;
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

	public float red;
	public float green;
	public float blue;

	public ClusterBlockEntity(BlockPos pBlockPos, BlockState pBlockState) {
		super(IcariaBlockEntityTypes.CLUSTER.get(), pBlockPos, pBlockState);
	}

	public ClusterBlockEntity(BlockPos pBlockPos, BlockState pBlockState, double pX, double pY, double pZ) {
		this(pBlockPos, pBlockState);
		this.x = pX;
		this.y = pY;
		this.z = pZ;
	}

	@Override
	public void onLoad() {
		super.onLoad();
		if (this.getLevel() != null) {
			if (this.getLevel().isClientSide()) {
				this.red = IcariaClientHelper.getRed(this);
				this.green = IcariaClientHelper.getGreen(this);
				this.blue = IcariaClientHelper.getBlue(this);
			}
		}
	}
}
