package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.goal.FishFollowGoal;
import com.axanthic.icaria.common.goal.FishSwimGoal;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnGroupData;
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

public class FishEntity extends SizedPathfinderMobEntity {
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
		this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(pSize * pSize);
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return Mob.createMobAttributes().add(Attributes.FLYING_SPEED, 0.4F).add(Attributes.GRAVITY, 0.0F).add(Attributes.MAX_HEALTH, 16.0D).add(Attributes.MOVEMENT_SPEED, 0.2F);
	}

	@Nullable
	public FishEntity getLeader() {
		return this.leader;
	}

	@Override
	public PathNavigation createNavigation(Level pLevel) {
		return new FlyingPathNavigation(this, pLevel);
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor pServerLevelAccessor, DifficultyInstance pDifficultyInstance, EntitySpawnReason pEntitySpawnReason, @Nullable SpawnGroupData pSpawnGroupData) {
		this.setHomeTo(this.blockPosition(), 10);
		this.setSize(this.getRandom().nextIntBetweenInclusive(this.minSize, this.maxSize));
		return super.finalizeSpawn(pServerLevelAccessor, pDifficultyInstance, pEntitySpawnReason, pSpawnGroupData);
	}
}
