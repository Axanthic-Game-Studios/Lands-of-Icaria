package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.block.KettleBlock;
import com.axanthic.icaria.common.block.TripleBarrelRackBlock;
import com.axanthic.icaria.common.helper.IcariaCommonHelper;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class MagicMissileSpellEntity extends SpellEntity {
	public MagicMissileSpellEntity(EntityType<? extends SpellEntity> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	@Override
	public void onHitBlock(BlockHitResult pBlockHitResult) {
		super.onHitBlock(pBlockHitResult);
		var level = this.level();
		var blockPos = pBlockHitResult.getBlockPos();
		var blockState = level.getBlockState(blockPos);
		var block = blockState.getBlock();
		if (blockState.getDestroySpeed(level, blockPos) > 0 && level.getBlockEntity(blockPos) == null && !(block instanceof DoorBlock) && !(block instanceof KettleBlock) && !(block instanceof TripleBarrelRackBlock)) {
			level.destroyBlock(blockPos, false);
		}
	}

	@Override
	public void onHitEntity(EntityHitResult pEntityHitResult) {
		super.onHitEntity(pEntityHitResult);
		IcariaCommonHelper.hurt(this.level().damageSources().magic(), pEntityHitResult.getEntity(), 8.0F);
	}
}
