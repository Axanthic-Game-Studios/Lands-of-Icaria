package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.goal.MyrmekeDroneHurtByTargetGoal;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class MyrmekeDroneEntity extends MyrmekeQueenEntity {
	public AnimationState attackAnimationState = new AnimationState();

	public MyrmekeDroneEntity(EntityType<? extends MyrmekeDroneEntity> pType, Level pLevel) {
		super(pType, pLevel);
		this.xpReward = 5;
	}

	@Override
	public boolean doHurtTarget(Entity pEntity) {
		this.level().broadcastEntityEvent(this, (byte) 4);
		return super.doHurtTarget(pEntity);
	}

	@Override
	public void handleEntityEvent(byte pId) {
		if (pId == 4) {
			this.attackAnimationState.start(this.tickCount);
		} else {
			super.handleEntityEvent(pId);
		}
	}

	@Override
	public void playStepSound(BlockPos pPos, BlockState pState) {
		this.playSound(IcariaSoundEvents.MYRMEKE_DRONE_STEP, 0.1F, 1.0F);
	}

	@Override
	public void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(2, new LeapAtTargetGoal(this, 0.25F));
		this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.001F));
		this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new MyrmekeDroneHurtByTargetGoal(this).setAlertOthers());
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 1.0D).add(Attributes.MAX_HEALTH, 12.0D).add(Attributes.MOVEMENT_SPEED, 0.25D);
	}

	@Override
	public SoundEvent getAmbientSound() {
		return IcariaSoundEvents.MYRMEKE_DRONE_AMBIENT;
	}

	@Override
	public SoundEvent getDeathSound() {
		return IcariaSoundEvents.MYRMEKE_DRONE_DEATH;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource pDamageSource) {
		return IcariaSoundEvents.MYRMEKE_DRONE_HURT;
	}
}
