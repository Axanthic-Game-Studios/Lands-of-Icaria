package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.block.KettleBlock;
import com.axanthic.icaria.common.block.TripleBarrelRackBlock;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class AntiGravitySpellEntity extends SpellEntity {
	public AntiGravitySpellEntity(EntityType<? extends SpellEntity> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	@Override
	public void onHitBlock(BlockHitResult pBlockHitResult) {
		super.onHitBlock(pBlockHitResult);
		var level = this.level();
		var blockPos = pBlockHitResult.getBlockPos();
		var blockState = level.getBlockState(blockPos);
		var block = blockState.getBlock();
		var entity = new FloatingBlockEntity(IcariaEntityTypes.FLOATING_BLOCK.get(), level, blockState, blockPos);
		if (blockState.getDestroySpeed(level, blockPos) > 0 && level.getBlockEntity(blockPos) == null && !(block instanceof DoorBlock) && !(block instanceof KettleBlock) && !(block instanceof TripleBarrelRackBlock)) {
			entity.snapTo(blockPos, 0.0F, 0.0F);
			entity.setDeltaMovement(0.0D, 0.05D, 0.0D);
			level.addFreshEntity(entity);
			level.removeBlock(blockPos, false);
		}
	}

	@Override
	public void onHitEntity(EntityHitResult pEntityHitResult) {
		super.onHitEntity(pEntityHitResult);
		if (pEntityHitResult.getEntity() instanceof LivingEntity livingEntity) {
			var mobEffectInstance = new MobEffectInstance(MobEffects.LEVITATION, 300);
			livingEntity.addEffect(mobEffectInstance);
		}
	}
}
