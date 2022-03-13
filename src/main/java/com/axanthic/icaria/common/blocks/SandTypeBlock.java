package com.axanthic.icaria.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraftforge.common.IPlantable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class SandTypeBlock extends Block {
	public SandTypeBlock(Properties properties) {
		super(properties);
	}

	@Override
	public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
		return false; // TODO
	}
}
