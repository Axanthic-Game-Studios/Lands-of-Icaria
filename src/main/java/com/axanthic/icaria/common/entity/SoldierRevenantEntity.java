package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SoldierRevenantEntity extends RevenantEntity {
	public SoldierRevenantEntity(EntityType<? extends SoldierRevenantEntity> pType, Level pLevel) {
		super(pType, pLevel);
	}

	@Override
	public boolean removeWhenFarAway(double pDistanceToClosestPlayer) {
		return false;
	}

	@Override
	public void playStepSound(BlockPos pPos, BlockState pState) {
		this.playSound(IcariaSoundEvents.SOLDIER_REVENANT_STEP, 0.1F, 1.0F);
	}

	@Override
	public void populateDefaultEquipmentSlots(RandomSource pRandom, DifficultyInstance pDifficulty) {
		if (pRandom.nextInt(10) == 0) {
			this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(IcariaItems.KASSITEROS_TOOLS.bident.get()));
		} else if (pRandom.nextInt(10) == 1) {
			this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(IcariaItems.KASSITEROS_TOOLS.axe.get()));
		} else if (pRandom.nextInt(10) == 2) {
			this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(IcariaItems.KASSITEROS_TOOLS.dagger.get()));
		} else {
			this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(IcariaItems.KASSITEROS_TOOLS.sword.get()));
		}
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return Mob.createMobAttributes().add(Attributes.ARMOR, 6.0D).add(Attributes.ATTACK_DAMAGE, 4.0D).add(Attributes.FOLLOW_RANGE, 32.0D).add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.25D);
	}

	@Override
	public SoundEvent getDeathSound() {
		return IcariaSoundEvents.SOLDIER_REVENANT_DEATH;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource pDamageSource) {
		return IcariaSoundEvents.SOLDIER_REVENANT_HURT;
	}
}
