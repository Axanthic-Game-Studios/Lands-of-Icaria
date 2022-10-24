package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.blockentity.IcariaSignBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaStandingSignBlock extends StandingSignBlock {
	public IcariaStandingSignBlock(Properties pProperties, WoodType pWoodType) {
		super(pProperties, pWoodType);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		return new IcariaSignBlockEntity(pPos, pState);
	}
}
