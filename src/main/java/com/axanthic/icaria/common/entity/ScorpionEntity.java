package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.goal.IcariaArachnidTargetGoal;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ScorpionEntity extends IcariaArachnidEntity {
	public AnimationState attackAnimationState = new AnimationState();

	public static final EntityDataAccessor<Boolean> CLIMBING = SynchedEntityData.defineId(ScorpionEntity.class, EntityDataSerializers.BOOLEAN);

	public ScorpionEntity(EntityType<? extends ScorpionEntity> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	@Override
	public boolean doHurtTarget(ServerLevel pServerLevel, Entity pEntity) {
		this.level().broadcastEntityEvent(this, (byte) 4);
		this.poison(pEntity);
		return super.doHurtTarget(pServerLevel, pEntity);
	}

	public boolean getClimbing() {
		return this.getEntityData().get(ScorpionEntity.CLIMBING);
	}

	@Override
	public boolean onClimbable() {
		return this.getClimbing();
	}

	@Override
	public void addAdditionalSaveData(CompoundTag pCompoundTag) {
		super.addAdditionalSaveData(pCompoundTag);
		pCompoundTag.putBoolean("Climbing", this.getClimbing());
	}

	@Override
	public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
		super.defineSynchedData(pBuilder);
		pBuilder.define(ScorpionEntity.CLIMBING, false);
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
	public void playStepSound(BlockPos pBlockPos, BlockState pBlockState) {
		this.playSound(IcariaSoundEvents.SCORPION_STEP, 0.1F, 1.0F);
	}

	public void poison(Entity pEntity) {
		if (pEntity instanceof LivingEntity livingEntity) {
			var mobEffectInstance = new MobEffectInstance(MobEffects.POISON, 120, 0);
			livingEntity.addEffect(mobEffectInstance, this);
		}
	}

	@Override
	public void readAdditionalSaveData(CompoundTag pCompoundTag) {
		super.readAdditionalSaveData(pCompoundTag);
		this.setClimbing(pCompoundTag.getBoolean("Climbing"));
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
		this.getEntityData().set(ScorpionEntity.CLIMBING, pClimbing);
	}

	@Override
	public void tick() {
		super.tick();
		if (!this.level().isClientSide()) {
			this.setClimbing(this.horizontalCollision);
		}
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return Mob.createMobAttributes().add(Attributes.ARMOR, 6.0D).add(Attributes.ATTACK_DAMAGE, 6.0D).add(Attributes.MAX_HEALTH, 32.0D).add(Attributes.MOVEMENT_SPEED, 0.2D);
	}

	@Override
	public PathNavigation createNavigation(Level pLevel) {
		return new WallClimberNavigation(this, pLevel);
	}

	@Override
	public SoundEvent getAmbientSound() {
		return IcariaSoundEvents.SCORPION_AMBIENT;
	}

	@Override
	public SoundEvent getDeathSound() {
		return IcariaSoundEvents.SCORPION_DEATH;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource pDamageSource) {
		return IcariaSoundEvents.SCORPION_HURT;
	}
}
