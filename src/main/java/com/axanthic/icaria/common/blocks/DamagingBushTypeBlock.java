package com.axanthic.icaria.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;

import javax.annotation.Nonnull;

@SuppressWarnings("deprecation")

public class DamagingBushTypeBlock extends BushTypeBlock {
	public DamagingBushTypeBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public void entityInside(@Nonnull BlockState pState, @Nonnull Level pLevel, @Nonnull BlockPos pPos, @Nonnull Entity pEntity) {
		if (pEntity instanceof Bee) {
			pEntity.setInvulnerable(true);
		}

		pEntity.hurt(DamageSource.CACTUS, 1.0F);
	}

	@Override
	public BlockPathTypes getAiPathNodeType(BlockState state, BlockGetter level, BlockPos pos, Mob entity) {
		return BlockPathTypes.DAMAGE_CACTUS;
	}
}
