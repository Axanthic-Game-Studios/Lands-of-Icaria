package com.axanthic.icaria.common.goal;

import com.axanthic.icaria.common.entity.ArachneDroneEntity;
import com.axanthic.icaria.common.entity.ArachneEntity;

import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.level.block.Blocks;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class ArachneHurtByTargetGoal extends HurtByTargetGoal {
    public ArachneHurtByTargetGoal(ArachneEntity pEntity) {
        super(pEntity);
    }

    @Override
    public void alertOther(Mob pMob, LivingEntity pEntity) {
        if (pMob instanceof ArachneDroneEntity) {
            pMob.setTarget(pEntity);
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (RandomSource.create().nextInt(100) == 0) {
            var livingEntity = this.mob.getTarget();
            if (livingEntity != null) {
                if (this.mob.distanceTo(this.mob.getTarget()) <= 10.0D) {
                    this.mob.level.setBlockAndUpdate(livingEntity.blockPosition(), Blocks.COBWEB.defaultBlockState()); // TODO: replace with Arachne web
                }
            }
        }
    }
}
