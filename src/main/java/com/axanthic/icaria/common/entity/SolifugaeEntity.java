package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.goal.IcariaArachnidTargetGoal;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;
import com.axanthic.icaria.data.tags.IcariaBlockTags;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SolifugaeEntity extends IcariaArachnidEntity {
	public static final EntityDataAccessor<Byte> CLIMBING = SynchedEntityData.defineId(SolifugaeEntity.class, EntityDataSerializers.BYTE);

	public SolifugaeEntity(EntityType<? extends SolifugaeEntity> pType, Level pLevel) {
		super(pType, pLevel);
		this.xpReward = 5;
	}

	@Override
	public boolean canBeAffected(MobEffectInstance pEffectInstance) {
		return super.canBeAffected(pEffectInstance) && !pEffectInstance.is(MobEffects.POISON);
	}

	public boolean isClimbing() {
		return (this.entityData.get(SolifugaeEntity.CLIMBING) & 1) != 0;
	}

	@Override
	public boolean onClimbable() {
		return this.isClimbing();
	}

	@Override
	public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
		super.defineSynchedData(pBuilder);
		pBuilder.define(SolifugaeEntity.CLIMBING, (byte) 0);
	}

	@Override
	public void makeStuckInBlock(BlockState pState, Vec3 pMotionMultiplier) {
		if (!pState.is(IcariaBlockTags.COBWEB_BLOCKS)) {
			super.makeStuckInBlock(pState, pMotionMultiplier);
		}
	}

	@Override
	public void playStepSound(BlockPos pPos, BlockState pState) {
		this.playSound(IcariaSoundEvents.SOLIFUGAE_STEP, 0.1F, 1.0F);
	}

	@Override
	public void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.001F));
		this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 5.0F, 0.025F, false));
		this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new IcariaArachnidTargetGoal<>(this, Player.class, true, true));
	}

	public void setClimbing(boolean pClimbing) {
		byte b = this.entityData.get(SolifugaeEntity.CLIMBING);
		if (pClimbing) {
			b = (byte) (b | 1);
		} else {
			b = (byte) (b & -2);
		}

		this.entityData.set(SolifugaeEntity.CLIMBING, b);
	}

	@Override
	public void tick() {
		super.tick();
		if (!this.level().isClientSide()) {
			this.setClimbing(this.horizontalCollision);
		}
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 4.0D).add(Attributes.MAX_HEALTH, 24.0D).add(Attributes.MOVEMENT_SPEED, 0.375D);
	}

	@Override
	public PathNavigation createNavigation(Level pLevel) {
		return new WallClimberNavigation(this, pLevel);
	}

	@Override
	public SoundEvent getAmbientSound() {
		return IcariaSoundEvents.SOLIFUGAE_AMBIENT;
	}

	@Override
	public SoundEvent getDeathSound() {
		return IcariaSoundEvents.SOLIFUGAE_DEATH;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource pDamageSource) {
		return IcariaSoundEvents.SOLIFUGAE_HURT;
	}
}
