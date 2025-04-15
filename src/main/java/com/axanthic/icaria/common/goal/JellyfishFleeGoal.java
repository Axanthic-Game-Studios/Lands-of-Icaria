package com.axanthic.icaria.common.goal;

import com.axanthic.icaria.common.entity.JellyfishEntity;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.Vec3;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class JellyfishFleeGoal extends Goal {
	public int fleeTick;

	public JellyfishEntity entity;

	public JellyfishFleeGoal(JellyfishEntity pEntity) {
		this.entity = pEntity;
	}

	@Override
	public boolean canUse() {
		var livingEntity = this.entity.getLastHurtByMob();
		return livingEntity != null && this.entity.distanceToSqr(livingEntity) < 100.0D;
	}

	@Override
	public void stop() {
		var randomSource = this.entity.getRandom();
		this.entity.movementVector = new Vec3(randomSource.nextFloat() * 0.2F - 0.1F, randomSource.nextFloat() * 0.2F - 0.1F, randomSource.nextFloat() * 0.2F - 0.1F);
		this.fleeTick = 0;
	}

	@Override
	public void tick() {
		var livingEntity = this.entity.getLastHurtByMob();
		if (livingEntity != null) {
			var x = this.entity.getX() - livingEntity.getX();
			var y = this.entity.getY() - livingEntity.getY();
			var z = this.entity.getZ() - livingEntity.getZ();
			this.entity.movementVector = new Vec3(x * 0.1F, y * 0.1F, z * 0.1F);
			this.fleeTick++;
		}
	}
}
