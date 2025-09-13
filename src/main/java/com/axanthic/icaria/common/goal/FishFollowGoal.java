package com.axanthic.icaria.common.goal;

import com.axanthic.icaria.common.entity.FishEntity;

import java.util.stream.Collectors;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.ai.goal.Goal;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FishFollowGoal extends Goal {
	public FishEntity entity;

	public double speedModifier;
	public double searchRadius;

	public int maxSwarmSize;

	public FishFollowGoal(FishEntity pEntity, double pMovementModifier, double pSearchRadius, int pSchoolVolume) {
		this.entity = pEntity;
		this.speedModifier = pMovementModifier;
		this.searchRadius = pSearchRadius;
		this.maxSwarmSize = pSchoolVolume;
	}

	@Override
	public boolean canContinueToUse() {
		var leader = this.entity.getLeader();
		return leader != null && leader.isAlive();
	}

	@Override
	public boolean canUse() {
		if (this.entity.isLeader()) {
			return false;
		}

		var entities = this.entity.level().getEntitiesOfClass(this.entity.getClass(), this.entity.getBoundingBox().inflate(this.searchRadius));

		var volume = entities.stream()
			.filter(entity -> entity.getLeader() != null)
			.collect(Collectors.groupingBy(FishEntity::getLeader, Collectors.counting()));

		var leader = entities.stream()
			.filter(FishEntity::isAlive)
			.filter(FishEntity::isLeader)
			.filter(entity -> volume.getOrDefault(entity, 0L) + 1 < this.maxSwarmSize)
			.findFirst()
			.orElse(null);

		this.entity.setLeader(leader);

		return leader != null;
	}

	@Override
	public void tick() {
		var leader = this.entity.getLeader();
		if (leader != null && leader.isAlive()) {
			this.entity.getNavigation().moveTo(leader, this.speedModifier);
		}
	}
}
