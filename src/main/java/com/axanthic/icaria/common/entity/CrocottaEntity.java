package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.goal.CrocottaTargetGoal;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CrocottaEntity extends Monster {
	public AnimationState attackAnimationState = new AnimationState();

	public CrocottaEntity(EntityType<? extends CrocottaEntity> pType, Level pLevel) {
		super(pType, pLevel);
		this.xpReward = 5;
	}

	@Override
	public boolean doHurtTarget(Entity pEntity) {
		this.level().broadcastEntityEvent(this, (byte) 4);
		return super.doHurtTarget(pEntity);
	}

	@Override
	public float getVoicePitch() {
		return 0.25F;
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
		this.playSound(SoundEvents.WOLF_STEP, 0.1F, 1.0F);
	}

	@Override
	public void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(2, new LeapAtTargetGoal(this, 0.25F));
		this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.001F));
		this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 10.0F, 0.025F, false));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new CrocottaTargetGoal<>(this, Player.class, true, true));
		this.targetSelector.addGoal(2, new CrocottaTargetGoal<>(this, AeternaeEntity.class, true, true));
		this.targetSelector.addGoal(2, new CrocottaTargetGoal<>(this, ArganHoundEntity.class, true, true));
		this.targetSelector.addGoal(2, new CrocottaTargetGoal<>(this, CapellaEntity.class, true, true));
		this.targetSelector.addGoal(2, new CrocottaTargetGoal<>(this, CatoblepasEntity.class, true, true));
		this.targetSelector.addGoal(2, new CrocottaTargetGoal<>(this, CerverEntity.class, true, true));
		this.targetSelector.addGoal(2, new CrocottaTargetGoal<>(this, SowEntity.class, true, true));
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 2.0D).add(Attributes.MAX_HEALTH, 16.0D).add(Attributes.MOVEMENT_SPEED, 0.25D);
	}

	@Override
	public SoundEvent getAmbientSound() {
		return SoundEvents.WOLF_AMBIENT;
	}

	@Override
	public SoundEvent getDeathSound() {
		return SoundEvents.WOLF_DEATH;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource pDamageSource) {
		return SoundEvents.WOLF_HURT;
	}
}
