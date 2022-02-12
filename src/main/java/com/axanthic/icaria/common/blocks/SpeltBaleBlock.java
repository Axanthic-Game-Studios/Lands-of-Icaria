package com.axanthic.icaria.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class SpeltBaleBlock extends AxisBlock {
	public SpeltBaleBlock(Properties properties) {
		super(properties);
	}

	public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float f) {
		entity.causeFallDamage(f, 0.2F, DamageSource.FALL);
	}
}
