package com.axanthic.icaria.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@ParametersAreNonnullByDefault

public class DamagingBushTypeBlock extends BushTypeBlock {
	public DamagingBushTypeBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
		if (pEntity instanceof Bee) {
			pEntity.setInvulnerable(true);
		}

		pEntity.hurt(DamageSource.CACTUS, 1.0F);
	}
}
