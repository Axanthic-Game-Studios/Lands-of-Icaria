package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CrystalBlockEntity extends BlockEntity {
	public double x;
	public double y;
	public double z;

	public float red;
	public float green;
	public float blue;

	public CrystalBlockEntity(BlockPos pPos, BlockState pState) {
		super(IcariaBlockEntityTypes.CRYSTAL.get(), pPos, pState);
	}

	public CrystalBlockEntity(BlockPos pPos, BlockState pState, double pX, double pY, double pZ) {
		this(pPos, pState);
		this.x = pX;
		this.y = pY;
		this.z = pZ;
	}

	@Override
	public void onLoad() {
		super.onLoad();
		var level = this.getLevel();
		if (level != null) {
			if (level.isClientSide()) {
				this.red = IcariaClientHelper.getRed(this);
				this.green = IcariaClientHelper.getGreen(this);
				this.blue = IcariaClientHelper.getBlue(this);
			}
		}
	}
}
