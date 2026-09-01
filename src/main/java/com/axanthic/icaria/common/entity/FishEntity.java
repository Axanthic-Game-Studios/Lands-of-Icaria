package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.goal.FishFollowGoal;
import com.axanthic.icaria.common.goal.FishSwimGoal;
import com.axanthic.icaria.common.helper.IcariaCommonHelper;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;

@SuppressWarnings("deprecation, unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FishEntity extends IcariaPathfinderMobEntity {
	public boolean isLeader;

	public FishEntity leader;

	public FishEntity(EntityType<? extends FishEntity> pEntityType, Level pLevel) {
		super(pEntityType, pLevel, 0.3F, 0.3F, 0.1F);
		this.moveControl = new FlyingMoveControl(this, 10, true);
	}

	public static boolean checkMobSpawnRules(EntityType<? extends Mob> pEntityType, LevelAccessor pLevelAccessor, EntitySpawnReason pEntitySpawnReason, BlockPos pBlockPos, RandomSource pRandomSource) {
		return true;
	}

	public boolean isLeader() {
		return this.isLeader;
	}

	@Override
	public int getMaxSpawnClusterSize() {
		return 15;
	}

	@Override
	public void registerGoals() {
		this.goalSelector.addGoal(1, new FishSwimGoal(this));
		this.goalSelector.addGoal(2, new FishFollowGoal(this, 1.0D, 64, 15));
	}

	public void setLeader(@Nullable FishEntity leader) {
		this.leader = leader;
		this.isLeader = leader == null;
	}

	@Override
	public void setSize(int pSize) {
		super.setSize(pSize);
		IcariaCommonHelper.setAttribute(Attributes.MAX_HEALTH, this, pSize * pSize);
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return Mob.createMobAttributes().add(Attributes.FLYING_SPEED, 0.4F).add(Attributes.GRAVITY, 0.0F).add(Attributes.MAX_HEALTH, 16.0D).add(Attributes.MOVEMENT_SPEED, 0.2F);
	}

	@Nullable
	public FishEntity getLeader() {
		return this.leader;
	}

	@Override
	public Entity.MovementEmission getMovementEmission() {
		return Entity.MovementEmission.EVENTS;
	}

	@Override
	public PathNavigation createNavigation(Level pLevel) {
		return new FlyingPathNavigation(this, pLevel);
	}

	@Override
	public SoundEvent getAmbientSound() {
		return IcariaSoundEvents.FISH_AMBIENT;
	}

	@Override
	public SoundEvent getDeathSound() {
		return IcariaSoundEvents.FISH_DEATH;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource pDamageSource) {
		return IcariaSoundEvents.FISH_HURT;
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor pServerLevelAccessor, DifficultyInstance pDifficultyInstance, EntitySpawnReason pEntitySpawnReason, @Nullable SpawnGroupData pSpawnGroupData) {
		this.setHomeTo(this.blockPosition(), 10);
		this.setSize(this.getRandom().nextIntBetweenInclusive(this.minSize, this.maxSize));
		return super.finalizeSpawn(pServerLevelAccessor, pDifficultyInstance, pEntitySpawnReason, pSpawnGroupData);
	}
}
