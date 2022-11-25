package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.goal.IcariaEatBlockGoal;
import com.axanthic.icaria.common.goal.IcariaPanicGoal;
import com.axanthic.icaria.common.registry.IcariaEntities;
import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class AeternaeEntity extends Animal {
    public int eatAnimationTick;

    public IcariaEatBlockGoal eatBlockGoal;

    public AeternaeEntity(EntityType<? extends Animal> pType, Level pLevel) {
        super(pType, pLevel);
        this.xpReward = 5;
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(IcariaItems.SPELT.get());
    }

    @Override
    public float getEyeHeight(Pose pPose) {
        return this.isBaby() ? 0.75F : 1.25F;
    }

    @OnlyIn(Dist.CLIENT)
    public float xRotMouth(float partialTick) {
        if (this.eatAnimationTick > 10 && this.eatAnimationTick <= 30) {
            float tick = this.eatAnimationTick - partialTick;
            return -Mth.cos((float)(tick * Math.PI / 5 + Math.PI)) - 1;
        }

        return 0;
    }

    @OnlyIn(Dist.CLIENT)
    public float xRotNeck(float partialTick) {
        float tick = this.eatAnimationTick - partialTick;
        float swing = this.swingTime;

        if (this.eatAnimationTick > 0 && (this.eatAnimationTick < 10 || this.eatAnimationTick > 30)) {
            return Mth.cos((float)(tick * Math.PI / 10)) - 1;
        } else if (this.eatAnimationTick > 0) {
            return -2;
        }

        if (swing > 0 && swing != 1) {
            if (swing < 0.5F) {
                return -swing * 4;
            }

            return (swing - 0.5F) * 4 - 2;
        }

        return 0;
    }

    @Override
    public float getVoicePitch() {
        return this.isBaby() ? 1.25F : 0.75F;
    }

    @Override
    public void aiStep() {
        if (this.level.isClientSide) {
            this.eatAnimationTick = Math.max(0, this.eatAnimationTick - 1);
        }

        super.aiStep();
    }

    @Override
    public void ate() {
        super.ate();
        if (this.isBaby()) {
            this.ageUp(60);
        }
    }

    @Override
    public void customServerAiStep() {
        this.eatAnimationTick = this.eatBlockGoal.getEatAnimationTick();
        super.customServerAiStep();
    }

    @Override
    public void dropCustomDeathLoot(DamageSource pDamageSource, int i, boolean b) {
        super.dropCustomDeathLoot(pDamageSource, i, b);
        if (pDamageSource.getEntity() instanceof Creeper creeper) {
            if (creeper.isPowered() && creeper.canDropMobsSkull()) {
                creeper.increaseDroppedSkulls();
                this.spawnAtLocation(IcariaItems.AETERNAE_SKULL.get());
            }
        }
    }

    @Override
    public void handleEntityEvent(byte b) {
        if (b == 10) {
            this.eatAnimationTick = 40;
        } else {
            super.handleEntityEvent(b);
        }
    }

    @Override
    public void playStepSound(BlockPos pPos, BlockState pState) {
        this.playSound(SoundEvents.COW_STEP, 0.1F, 1.0F);
    }

    @Override
    public void registerGoals() {
        this.eatBlockGoal = new IcariaEatBlockGoal(this);
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new IcariaPanicGoal(this, 1.5D));
        this.goalSelector.addGoal(3, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(5, new TemptGoal(this, 1.0D, Ingredient.of(IcariaItems.SPELT.get()), true));
        this.goalSelector.addGoal(6, new FollowParentGoal(this, 1.0D));
        this.goalSelector.addGoal(7, this.eatBlockGoal);
        this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.001F));
        this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 5.0F, 0.025F, false));
        this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, (new AeternaeHurtByOtherGoal(this, 1.5D)).setAlertOthers());
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 4.0D).add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    @Override
    public SoundEvent getAmbientSound() {
        return SoundEvents.COW_AMBIENT;
    }

    @Override
    public SoundEvent getDeathSound() {
        return SoundEvents.COW_DEATH;
    }

    @Override
    public SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.COW_HURT;
    }

    @Override
    public AeternaeEntity getBreedOffspring(ServerLevel pLevel, AgeableMob pMob) {
        return IcariaEntities.AETERNAE.get().create(pLevel);
    }

    public static class AeternaeHurtByOtherGoal extends HurtByTargetGoal {
        public double speedModifier;

        AeternaeHurtByOtherGoal(AeternaeEntity pMob, double pSpeedModifier) {
            super(pMob);
            this.speedModifier = pSpeedModifier;
        }

        @Override
        public void alertOther(Mob pMob, LivingEntity pEntity) {
            if (pMob instanceof AeternaeEntity) {
                double randomSource = RandomSource.create().nextInt(8, 16);

                pMob.getNavigation().moveTo(pEntity.getX() + randomSource, 0.0D, pEntity.getX() + randomSource, speedModifier);
            }
        }
    }
}
