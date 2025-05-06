package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.entity.IcariaSkullBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.WallSkullBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaWallSkullBlock extends WallSkullBlock {
	public IcariaWallSkullBlock(SkullBlock.Type pType, Properties pProperties) {
		super(pType, pProperties);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pBlockPos, BlockState pBlockState) {
		return new IcariaSkullBlockEntity(pBlockPos, pBlockState);
	}
}
