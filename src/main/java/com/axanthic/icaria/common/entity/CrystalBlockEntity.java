package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CrystalBlockEntity extends BlockEntity {
	public double x;
	public double y;
	public double z;

	public float red;
	public float green;
	public float blue;

	public CrystalBlockEntity(BlockPos pBlockPos, BlockState pBlockState) {
		super(IcariaBlockEntityTypes.CRYSTAL.get(), pBlockPos, pBlockState);
	}

	public CrystalBlockEntity(BlockPos pBlockPos, BlockState pBlockState, double pX, double pY, double pZ) {
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
