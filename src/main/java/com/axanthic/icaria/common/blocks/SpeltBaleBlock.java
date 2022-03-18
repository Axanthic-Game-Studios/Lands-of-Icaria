package com.axanthic.icaria.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class SpeltBaleBlock extends RotatedPillarBlock {
	public SpeltBaleBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public void fallOn(Level pLevel, BlockState pState, BlockPos pPos, Entity pEntity, float pFallDistance) {
		pEntity.causeFallDamage(pFallDistance, 0.2F, DamageSource.FALL);
	}
}
