package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaEntities;
import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SowEntity extends Animal {
    public SowEntity(EntityType<? extends Animal> pType, Level pLevel) {
        super(pType, pLevel);
        this.xpReward = 5;
    }

    @Override
    public double getPassengersRidingOffset() {
        return this.getBbHeight() * 0.5F;
    }

    @Override
    public float getEyeHeight(Pose pPose) {
        return this.isBaby() ? 0.4F : 0.6F;
    }

    @Override
    public float getVoicePitch() {
        return this.isBaby() ? 1.25F : 0.75F;
    }

    @Override
    public void dropCustomDeathLoot(DamageSource pDamageSource, int i, boolean b) {
        super.dropCustomDeathLoot(pDamageSource, i, b);
        if (pDamageSource.getEntity() instanceof Creeper creeper) {
            if (creeper.isPowered() && creeper.canDropMobsSkull()) {
                creeper.increaseDroppedSkulls();
                this.spawnAtLocation(IcariaItems.SOW_SKULL.get());
            }
        }
    }

    @Override
    public void playStepSound(BlockPos pPos, BlockState pState) {
        this.playSound(SoundEvents.PIG_STEP, 0.15F, 1.0F);
    }

    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new SowPanicGoal(this, 2.0D));
        this.goalSelector.addGoal(3, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, Ingredient.of(Items.WHEAT), false));
        this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, (new SowHurtByOtherGoal(this)).setAlertOthers());
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 2.0D).add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.MOVEMENT_SPEED, 0.2D);
    }

    @Override
    public SoundEvent getAmbientSound() {
        return SoundEvents.PIG_AMBIENT;
    }

    @Override
    public SoundEvent getDeathSound() {
        return SoundEvents.PIG_DEATH;
    }

    @Override
    public SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.PIG_HURT;
    }

    @Override
    public SowEntity getBreedOffspring(ServerLevel pLevel, AgeableMob pMob) {
        return IcariaEntities.SOW.get().create(pLevel);
    }

    public static class SowPanicGoal extends PanicGoal {
        public SowPanicGoal(PathfinderMob pMob, double pSpeedModifier) {
            super(pMob, pSpeedModifier);
        }

        @Override
        public boolean shouldPanic() {
            return this.mob.isOnFire();
        }
    }

    public static class SowHurtByOtherGoal extends HurtByTargetGoal {
        SowHurtByOtherGoal(SowEntity pMob) {
            super(pMob);
        }

        @Override
        public void alertOther(Mob pMob, LivingEntity pEntity) {
            if (pMob instanceof SowEntity) {
                double randomSource = RandomSource.create().nextInt(8, 16);

                pMob.getNavigation().moveTo(pEntity.getX() + randomSource, 0.0D, pEntity.getX() + randomSource, 2.0D);
            }
        }
    }
}
