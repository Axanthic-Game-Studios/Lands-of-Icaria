package com.axanthic.icaria.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraftforge.common.IPlantable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class DirtTypeBlock extends Block {
	public DirtTypeBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public boolean canSustainPlant(BlockState pState, BlockGetter pLevel, BlockPos pPos, Direction pFacing, IPlantable pPlantable) {
		return false; // TODO canSustainPlant
	}
}
