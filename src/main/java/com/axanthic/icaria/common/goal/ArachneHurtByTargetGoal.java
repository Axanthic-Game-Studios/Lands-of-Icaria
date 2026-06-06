package com.axanthic.icaria.common.goal;

import com.axanthic.icaria.common.entity.ArachneDroneEntity;
import com.axanthic.icaria.common.entity.ArachneEntity;
import com.axanthic.icaria.common.registry.IcariaBlocks;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;

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
		var level = this.mob.level();
		var livingEntity = this.mob.getTarget();
		if (livingEntity != null) {
			if (this.mob.distanceTo(livingEntity) <= 10.0D) {
				if (this.mob.getRandom().nextInt(50) == 0) {
					if (level.getBlockState(livingEntity.blockPosition()).isAir()) {
						level.playSound(null, livingEntity.blockPosition(), SoundEvents.COBWEB_PLACE, SoundSource.BLOCKS);
						level.setBlockAndUpdate(livingEntity.blockPosition(), IcariaBlocks.COBWEB.get().defaultBlockState());
					}
				}
			}
		}
	}
}
