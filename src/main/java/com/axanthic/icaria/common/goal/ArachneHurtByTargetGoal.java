package com.axanthic.icaria.common.goal;

import com.axanthic.icaria.common.entity.ArachneDroneEntity;
import com.axanthic.icaria.common.entity.ArachneEntity;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.level.block.Blocks;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ArachneHurtByTargetGoal extends HurtByTargetGoal {
	public ArachneHurtByTargetGoal(ArachneEntity pEntity) {
		super(pEntity);
	}

	@Override
	public void alertOther(Mob pMob, LivingEntity pLivingEntity) {
		if (pMob instanceof ArachneDroneEntity) {
			pMob.setTarget(pLivingEntity);
		}
	}

	@Override
	public void tick() {
		var livingEntity = this.mob.getTarget();
		if (livingEntity != null) {
			if (this.mob.distanceTo(livingEntity) <= 10.0D) {
				if (this.mob.getRandom().nextInt(100) == 0) {
					this.mob.level().setBlockAndUpdate(livingEntity.blockPosition(), Blocks.COBWEB.defaultBlockState()); // TODO replace with Arachne web
				}
			}
		}
	}
}
