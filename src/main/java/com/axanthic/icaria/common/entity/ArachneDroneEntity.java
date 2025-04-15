package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.goal.IcariaArachnidTargetGoal;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
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

@SuppressWarnings("deprecation")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ArachneDroneEntity extends ArachneEntity {
	public float hitboxMult = 0.25F;
	public float renderMult = 0.15F;
	public float shadowMult = 0.15F;

	public int maxSize = 4;
	public int minSize = 1;

	public static final EntityDataAccessor<Boolean> CLIMBING = SynchedEntityData.defineId(ArachneDroneEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Integer> SIZE = SynchedEntityData.defineId(ArachneDroneEntity.class, EntityDataSerializers.INT);

	public ArachneDroneEntity(EntityType<? extends ArachneDroneEntity> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	@Override
	public boolean isBaby() {
		return this.getSize() < this.maxSize;
	}

	@Override
	public boolean onClimbable() {
		return this.getClimbing();
	}

	@Override
	public boolean removeWhenFarAway(double pDistanceToClosestPlayer) {
		return true;
	}

	public boolean getClimbing() {
		return this.getEntityData().get(ArachneDroneEntity.CLIMBING);
	}

	public float getSizeForHitbox() {
		return this.getSize() * this.hitboxMult;
	}

	public float getSizeForRender() {
		return this.getSize() * this.renderMult;
	}

	public float getSizeForShadow() {
		return this.getSize() * this.shadowMult;
	}

	public int getSize() {
		return this.getEntityData().get(ArachneDroneEntity.SIZE);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag pCompoundTag) {
		super.addAdditionalSaveData(pCompoundTag);
		pCompoundTag.putBoolean("Climbing", this.getClimbing());
		pCompoundTag.putInt("Size", this.getSize());
	}

	@Override
	public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
		super.defineSynchedData(pBuilder);
		pBuilder.define(ArachneDroneEntity.CLIMBING, false);
		pBuilder.define(ArachneDroneEntity.SIZE, this.minSize);
	}

	@Override
	public void onSyncedDataUpdated(EntityDataAccessor<?> pEntityDataAccessor) {
		super.onSyncedDataUpdated(pEntityDataAccessor);
		this.refreshDimensions();
	}

	@Override
	public void playStepSound(BlockPos pBlockPos, BlockState pBlockState) {
		this.playSound(IcariaSoundEvents.ARACHNE_DRONE_STEP, 0.1F, 1.0F);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag pCompoundTag) {
		super.readAdditionalSaveData(pCompoundTag);
		this.setClimbing(pCompoundTag.getBoolean("Climbing"));
		this.setSize(pCompoundTag.getInt("Size"));
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
		this.getEntityData().set(ArachneDroneEntity.CLIMBING, pClimbing);
	}

	public void setSize(int pSize) {
		this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(pSize);
		this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(pSize * pSize);
		this.getEntityData().set(ArachneDroneEntity.SIZE, pSize);
		this.xpReward = pSize;
	}

	@Override
	public void tick() {
		super.tick();
		if (!this.level().isClientSide()) {
			this.setClimbing(this.horizontalCollision);
		}
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 4.0D).add(Attributes.MAX_HEALTH, 16.0D).add(Attributes.MOVEMENT_SPEED, 0.2D);
	}

	@Override
	public EntityDimensions getDefaultDimensions(Pose pPose) {
		return this.getType().getDimensions().scale(this.getSizeForHitbox());
	}

	@Override
	public InteractionResult mobInteract(Player pPlayer, InteractionHand pInteractionHand) {
		return InteractionResult.PASS;
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

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor pServerLevelAccessor, DifficultyInstance pDifficultyInstance, EntitySpawnReason pEntitySpawnReason, @Nullable SpawnGroupData pSpawnGroupData) {
		this.setSize(this.getRandom().nextIntBetweenInclusive(this.minSize, this.maxSize));
		return super.finalizeSpawn(pServerLevelAccessor, pDifficultyInstance, pEntitySpawnReason, pSpawnGroupData);
	}
}
