package com.axanthic.icaria.common.goal;

import com.axanthic.icaria.common.entity.JellyfishEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.Vec3;

public class JellyfishFleeGoal extends Goal {
    public int fleeTicks;

    public JellyfishEntity entity;

    public JellyfishFleeGoal(JellyfishEntity pEntity) {
        this.entity = pEntity;
    }

    @Override
    public boolean canUse() {
        var livingEntity = this.entity.getLastHurtByMob();
        if (livingEntity != null) {
            return this.entity.distanceToSqr(livingEntity) < 100.0D;
        } else {
            return false;
        }
    }

    @Override
    public void start() {
        this.fleeTicks = 0;
    }

    @Override
    public boolean requiresUpdateEveryTick() {
        return true;
    }

    @Override
    public void tick() {
        ++this.fleeTicks;
        var livingEntity = this.entity.getLastHurtByMob();
        if (livingEntity != null) {
            var vec3 = new Vec3(this.entity.getX() - livingEntity.getX(), this.entity.getY() - livingEntity.getY(), this.entity.getZ() - livingEntity.getZ());
            if (this.entity.level().getBlockState(BlockPos.containing(this.entity.getX() + vec3.x, this.entity.getY() + vec3.y, this.entity.getZ() + vec3.z)).isAir()) {
                double length = vec3.length();
                if (length > 0.0D) {
                    vec3.normalize();
                    double d = 3.0D;
                    if (length > 5.0D) {
                        d -= (length - 5.0D) / 5.0D;
                    }

                    if (d > 0.0D) {
                        vec3 = vec3.scale(d);
                    }
                }

                this.entity.setMovementVector((float) vec3.x / 20.0F, (float) vec3.y / 20.0F, (float) vec3.z / 20.0F);
            }
        }
    }
}
