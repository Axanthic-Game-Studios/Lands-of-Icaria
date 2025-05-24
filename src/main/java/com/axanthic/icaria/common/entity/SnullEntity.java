package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.helper.IcariaCommonHelper;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.stats.Stats;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

@SuppressWarnings("deprecation")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SnullEntity extends SizedPathfinderMobEntity {
	public int maxCooldown = 400;
	public int minCooldown = 0;
	public int maxHide = 80;
	public int minHide = 0;
	public int maxShow = 80;
	public int minShow = 0;

	public AnimationState hideAnimationState = new AnimationState();
	public AnimationState hurtAnimationState = new AnimationState();
	public AnimationState idleAnimationState = new AnimationState();
	public AnimationState moveAnimationState = new AnimationState();
	public AnimationState showAnimationState = new AnimationState();

	public static final EntityDataAccessor<Boolean> CLIMBING = SynchedEntityData.defineId(SnullEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Integer> COOLDOWN = SynchedEntityData.defineId(SnullEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> HIDE = SynchedEntityData.defineId(SnullEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> SHOW = SynchedEntityData.defineId(SnullEntity.class, EntityDataSerializers.INT);

	public SnullEntity(EntityType<? extends SnullEntity> pEntityType, Level pLevel) {
		super(pEntityType, pLevel, 0.25F, 0.25F, 0.15F);
	}

	@Override
	public boolean hurtServer(ServerLevel pServerLevel, DamageSource pDamageSource, float pAmount) {
		this.hide();
		return super.hurtServer(pServerLevel, pDamageSource, pAmount);
	}

	public boolean isMovement() {
		return this.onGround() && this.getDeltaMovement().horizontalDistanceSqr() > 0;
	}

	@Override
	public boolean isPushable() {
		return false;
	}

	@Override
	public boolean onClimbable() {
		return this.getClimbing();
	}

	public boolean onCooldown() {
		return this.getCooldown() > this.minCooldown;
	}

	public boolean onHide() {
		return this.getHide() > this.minHide;
	}

	public boolean onShow() {
		return this.getShow() > this.minShow;
	}

	public boolean getClimbing() {
		return this.getEntityData().get(SnullEntity.CLIMBING);
	}

	public int getCooldown() {
		return this.getEntityData().get(SnullEntity.COOLDOWN);
	}

	public int getHide() {
		return this.getEntityData().get(SnullEntity.HIDE);
	}

	public int getShow() {
		return this.getEntityData().get(SnullEntity.SHOW);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag pCompoundTag) {
		super.addAdditionalSaveData(pCompoundTag);
		pCompoundTag.putBoolean("Climbing", this.getClimbing());
		pCompoundTag.putInt("Cooldown", this.getCooldown());
		pCompoundTag.putInt("Hide", this.getHide());
		pCompoundTag.putInt("Show", this.getShow());
	}

	@Override
	public void aiStep() {
		super.aiStep();
		if (this.onHide()) {
			var hide = this.getHide();
			if (hide > this.minHide) {
				--hide;
				this.setHide(hide);
				this.setCooldown(this.maxCooldown);
			}
		} else if (this.onCooldown()) {
			var cooldown = this.getCooldown();
			if (cooldown > this.minCooldown) {
				--cooldown;
				this.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, cooldown, 3, false, false));
				this.setCooldown(cooldown);
				this.setShow(this.maxShow);
			}
		} else if (this.onShow()) {
			var show = this.getShow();
			if (show > this.minShow) {
				--show;
				this.setShow(show);
			}
		}
	}

	@Override
	public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
		super.defineSynchedData(pBuilder);
		pBuilder.define(SnullEntity.CLIMBING, false);
		pBuilder.define(SnullEntity.COOLDOWN, this.minCooldown);
		pBuilder.define(SnullEntity.HIDE, this.minHide);
		pBuilder.define(SnullEntity.SHOW, this.minShow);
	}

	public void hide() {
		if (!this.onClimbable() && !this.onCooldown() && !this.onHide() && !this.onShow()) {
			this.setHide(this.maxHide);
		}
	}

	@Override
	public void readAdditionalSaveData(CompoundTag pCompoundTag) {
		super.readAdditionalSaveData(pCompoundTag);
		this.setClimbing(pCompoundTag.getBooleanOr("Climbing", false));
		this.setCooldown(pCompoundTag.getIntOr("Cooldown", 0));
		this.setHide(pCompoundTag.getIntOr("Hide", 0));
		this.setShow(pCompoundTag.getIntOr("Show", 0));
	}

	@Override
	public void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.001F));
	}

	public void setClimbing(boolean pClimbing) {
		this.getEntityData().set(SnullEntity.CLIMBING, pClimbing);
	}

	public void setCooldown(int pCooldown) {
		this.getEntityData().set(SnullEntity.COOLDOWN, pCooldown);
	}

	public void setHide(int pHide) {
		this.getEntityData().set(SnullEntity.HIDE, pHide);
	}

	public void setShow(int pShow) {
		this.getEntityData().set(SnullEntity.SHOW, pShow);
	}

	public void setMovement() {
		if (this.onHide() || this.onCooldown() || this.onShow()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.0D);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.1D);
		}
	}

	@Override
	public void setSize(int pSize) {
		super.setSize(pSize);
		this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(pSize * pSize);
	}

	@Override
	public void tick() {
		super.tick();
		if (this.level().isClientSide()) {
			this.tickHide();
			this.tickHurt();
			this.tickIdle();
			this.tickMove();
			this.tickShow();
		} else {
			this.setClimbing(this.horizontalCollision);
			this.setMovement();
		}
	}

	public void tickHide() {
		if (this.onHide() || this.onCooldown()) {
			this.hideAnimationState.startIfStopped(this.tickCount);
		} else {
			this.hideAnimationState.stop();
		}
	}

	public void tickHurt() {
		if (this.hurtTime > 0) {
			this.hurtAnimationState.startIfStopped(this.tickCount);
		} else {
			this.hurtAnimationState.stop();
		}
	}

	public void tickIdle() {
		if (this.isAlive()) {
			this.idleAnimationState.startIfStopped(this.tickCount);
		} else {
			this.idleAnimationState.stop();
		}
	}

	public void tickMove() {
		if (this.getClimbing() || this.isMovement()) {
			this.moveAnimationState.startIfStopped(this.tickCount);
		} else {
			this.moveAnimationState.stop();
		}
	}

	public void tickShow() {
		if (!this.onCooldown() && !this.onHide()) {
			this.showAnimationState.startIfStopped(this.tickCount);
		} else {
			this.showAnimationState.stop();
		}
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return Mob.createMobAttributes().add(Attributes.KNOCKBACK_RESISTANCE, 1.0D).add(Attributes.MAX_HEALTH, 16.0D).add(Attributes.MOVEMENT_SPEED, 0.1D);
	}

	@Override
	public InteractionResult mobInteract(Player pPlayer, InteractionHand pInteractionHand) {
		var itemStack = pPlayer.getItemInHand(pInteractionHand);
		if (itemStack.getItem() == IcariaItems.HALITE_DUST.get()) {
			itemStack.consume(1, pPlayer);
			pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.HALITE_DUST.get()));
			IcariaCommonHelper.hurt(this.damageSources().generic(), this, 1.0F);
			this.hide();
			return InteractionResult.SUCCESS;
		} else {
			return super.mobInteract(pPlayer, pInteractionHand);
		}
	}

	@Override
	public PathNavigation createNavigation(Level pLevel) {
		return new WallClimberNavigation(this, pLevel);
	}

	@Override
	public SoundEvent getAmbientSound() {
		return IcariaSoundEvents.SNULL_AMBIENT;
	}

	@Override
	public SoundEvent getDeathSound() {
		return IcariaSoundEvents.SNULL_DEATH;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource pDamageSource) {
		return IcariaSoundEvents.SNULL_HURT;
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor pServerLevelAccessor, DifficultyInstance pDifficultyInstance, EntitySpawnReason pEntitySpawnReason, @Nullable SpawnGroupData pSpawnGroupData) {
		this.setSize(this.getRandom().nextIntBetweenInclusive(this.minSize, this.maxSize));
		return super.finalizeSpawn(pServerLevelAccessor, pDifficultyInstance, pEntitySpawnReason, pSpawnGroupData);
	}
}
