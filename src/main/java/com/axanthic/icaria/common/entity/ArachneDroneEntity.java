package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.goal.IcariaArachnidTargetGoal;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;
import com.axanthic.icaria.data.tags.IcariaBlockTags;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
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
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ArachneDroneEntity extends ArachneEntity {
	public int maxSize = 4;
	public int minSize = 1;

	public float aabbMult = 0.25F;
	public float renderMult = 0.15F;
	public float shadowMult = 0.15F;
	public float sizeMult = 0.75F;
	public float sizeMultInverted = 0.25F;

	public static final EntityDataAccessor<Byte> CLIMBING = SynchedEntityData.defineId(ArachneDroneEntity.class, EntityDataSerializers.BYTE);

	public static final EntityDataAccessor<Integer> SIZE = SynchedEntityData.defineId(ArachneDroneEntity.class, EntityDataSerializers.INT);

	public ArachneDroneEntity(EntityType<? extends ArachneDroneEntity> pType, Level pLevel) {
		super(pType, pLevel);
	}

	@Override
	public boolean canBeAffected(MobEffectInstance pEffectInstance) {
		return super.canBeAffected(pEffectInstance) && !pEffectInstance.is(MobEffects.POISON);
	}

	@Override
	public boolean isBaby() {
		return this.getSize() < this.maxSize;
	}

	public boolean isClimbing() {
		return (this.entityData.get(ArachneDroneEntity.CLIMBING) & 1) != 0;
	}

	@Override
	public boolean onClimbable() {
		return this.isClimbing();
	}

	@Override
	public boolean removeWhenFarAway(double pDistanceToClosestPlayer) {
		return true;
	}

	public float getSizeInverted() {
		return this.getSize() * -1.0F + 5.0F;
	}

	public float getScaleForRender() {
		return this.getScaleFromSize() * this.renderMult;
	}

	public float getScaleForShadow() {
		return this.getScaleFromSize() * this.shadowMult;
	}

	public float getScaleFromSize() {
		return this.getSizeWithMultInverted() + this.getSizeWithMult();
	}

	public float getSizeWithMult() {
		return this.getSize() * this.sizeMult;
	}

	public float getSizeWithMultInverted() {
		return this.getSizeInverted() * this.sizeMultInverted;
	}

	@Override
	public float getVoicePitch() {
		return this.getSizeWithMultInverted() + 0.75F;
	}

	public int getSize() {
		return this.entityData.get(ArachneDroneEntity.SIZE);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag pCompound) {
		super.addAdditionalSaveData(pCompound);
		pCompound.putInt("Size", this.getSize());
	}

	@Override
	public void aiStep() {
		super.aiStep();
		if (this.isAlive()) {
			this.setSize(this.getSize());
		}
	}

	@Override
	public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
		super.defineSynchedData(pBuilder);
		pBuilder.define(ArachneDroneEntity.CLIMBING, (byte) 0);
		pBuilder.define(ArachneDroneEntity.SIZE, this.minSize);
	}

	@Override
	public void makeStuckInBlock(BlockState pState, Vec3 pMotionMultiplier) {
		if (!pState.is(IcariaBlockTags.COBWEB_BLOCKS)) {
			super.makeStuckInBlock(pState, pMotionMultiplier);
		}
	}

	@Override
	public void onSyncedDataUpdated(EntityDataAccessor<?> pKey) {
		super.onSyncedDataUpdated(pKey);
		if (ArachneDroneEntity.SIZE.equals(pKey)) {
			this.refreshDimensions();
		}
	}

	@Override
	public void playStepSound(BlockPos pPos, BlockState pState) {
		this.playSound(IcariaSoundEvents.ARACHNE_DRONE_STEP, 0.1F, 1.0F);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag pCompound) {
		super.readAdditionalSaveData(pCompound);
		this.setSize(pCompound.getInt("Size"));
	}

	@Override
	public void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(2, new LeapAtTargetGoal(this, 0.25F));
		this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.001F));
		this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 5.0F, 0.025F, false));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new IcariaArachnidTargetGoal<>(this, Player.class, true, true));
	}

	public void setClimbing(boolean pClimbing) {
		byte b = this.entityData.get(ArachneDroneEntity.CLIMBING);
		if (pClimbing) {
			b = (byte) (b | 1);
		} else {
			b = (byte) (b & -2);
		}

		this.entityData.set(ArachneDroneEntity.CLIMBING, b);
	}

	public void setSize(int pSize) {
		int size = Mth.clamp(pSize, this.minSize, this.maxSize);
		this.refreshDimensions();
		this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(size);
		this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(size * size);
		this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue((size * 0.04D) + 0.1D);
		this.entityData.set(ArachneDroneEntity.SIZE, size);
		this.xpReward = size + 1;
	}

	@Override
	public void tick() {
		super.tick();
		if (!this.level().isClientSide()) {
			this.setClimbing(this.horizontalCollision);
		}
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 4.0D).add(Attributes.MAX_HEALTH, 16.0D).add(Attributes.MOVEMENT_SPEED, 0.1D);
	}

	@Override
	public EntityDimensions getDefaultDimensions(Pose pPose) {
		float scale = this.getScaleFromSize() * this.aabbMult;
		return this.getType().getDimensions().scale(scale);
	}

	@Override
	public PathNavigation createNavigation(Level pLevel) {
		return new WallClimberNavigation(this, pLevel);
	}

	@Override
	public SoundEvent getAmbientSound() {
		return IcariaSoundEvents.ARACHNE_DRONE_AMBIENT;
	}

	@Override
	public SoundEvent getDeathSound() {
		return IcariaSoundEvents.ARACHNE_DRONE_DEATH;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource pDamageSource) {
		return IcariaSoundEvents.ARACHNE_DRONE_HURT;
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData) {
		this.setSize(this.random.nextIntBetweenInclusive(1, 4));
		return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData);
	}
}
