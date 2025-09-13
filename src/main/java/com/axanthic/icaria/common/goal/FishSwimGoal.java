package com.axanthic.icaria.common.goal;

import com.axanthic.icaria.common.entity.FishEntity;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.util.AirAndWaterRandomPos;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FishSwimGoal extends Goal {
	public FishEntity entity;

	public FishSwimGoal(FishEntity pEntity) {
		this.entity = pEntity;
	}

	@Override
	public boolean canContinueToUse() {
		return this.entity.getNavigation().isInProgress();
	}

	@Override
	public boolean canUse() {
		return this.entity.getNavigation().isDone();
	}

	@Override
	public void start() {
		var viewVector = this.entity.getViewVector(0.0F);
		var moveVector = AirAndWaterRandomPos.getPos(this.entity, 10, 2, 0, viewVector.x(), viewVector.z(), 1.0D);
		if (moveVector != null) {
			this.entity.getNavigation().moveTo(this.entity.getNavigation().createPath(BlockPos.containing(moveVector), 1), 1.0D);
		}
	}
}
