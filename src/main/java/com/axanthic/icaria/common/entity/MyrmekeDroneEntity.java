package com.axanthic.icaria.common.entity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class MyrmekeDroneEntity extends MyrmekeQueenEntity {
    public AnimationState attackAnimationState = new AnimationState();

    public MyrmekeDroneEntity(EntityType<? extends MyrmekeDroneEntity> pType, Level pLevel) {
        super(pType, pLevel);
        this.xpReward = 5;
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
        this.level.broadcastEntityEvent(this, (byte) 4);
        return super.doHurtTarget(pEntity);
    }

    @Override
    public void handleEntityEvent(byte pId) {
        if (pId == 4) {
            this.attackAnimationState.start(this.tickCount);
        } else {
            super.handleEntityEvent(pId);
        }
    }

    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new LeapAtTargetGoal(this, 0.25F));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.001F));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, (new MyrmekeDroneHurtByTargetGoal(this)).setAlertOthers());
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 1.0D).add(Attributes.MAX_HEALTH, 12.0D).add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    public static class MyrmekeDroneHurtByTargetGoal extends MyrmekeQueenHurtByTargetGoal {
        MyrmekeDroneHurtByTargetGoal(MyrmekeDroneEntity pEntity) {
            super(pEntity);
        }

        @Override
        public void alertOther(Mob pMob, LivingEntity pEntity) {
            if (pMob instanceof MyrmekeSoldierEntity) {
                pMob.setTarget(pEntity);
            }
        }
    }
}
