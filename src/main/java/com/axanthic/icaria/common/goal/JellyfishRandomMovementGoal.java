package com.axanthic.icaria.common.goal;

import com.axanthic.icaria.common.entity.JellyfishEntity;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.Vec3;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class JellyfishRandomMovementGoal extends Goal {
	public final JellyfishEntity entity;

	public JellyfishRandomMovementGoal(JellyfishEntity pEntity) {
		this.entity = pEntity;
	}

	@Override
	public boolean canUse() {
		return true;
	}

	@Override
	public void tick() {
		var randomSource = this.entity.getRandom();
		if (this.entity.getNoActionTime() > 100) {
			this.entity.movementVector = new Vec3(0.0F, 0.0F, 0.0F);
		} else if (this.entity.getRandom().nextInt(100) == 0) {
			this.entity.movementVector = new Vec3(randomSource.nextFloat() * 0.2F - 0.1F, randomSource.nextFloat() * 0.2F - 0.1F, randomSource.nextFloat() * 0.2F - 0.1F);
		}
	}
}
