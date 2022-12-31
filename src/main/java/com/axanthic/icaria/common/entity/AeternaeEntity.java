package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.goal.IcariaBreedGoal;
import com.axanthic.icaria.common.goal.IcariaEatBlockGoal;
import com.axanthic.icaria.common.goal.IcariaFollowParentGoal;
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

public class AeternaeEntity extends IcariaAnimalEntity {
    public int eatAnimationTick;

    public AnimationState attackAnimationState = new AnimationState();

    public IcariaEatBlockGoal eatBlockGoal;

    public AeternaeEntity(EntityType<? extends IcariaAnimalEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel, 0.25F, 0.35F, 0.25F);
        this.xpReward = 5;
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(IcariaItems.SPELT.get());
    }

    @OnlyIn(Dist.CLIENT)
    public float xRotMouth(float pPartialTicks) {
        if (this.eatAnimationTick > 10) {
            if (this.eatAnimationTick <= 30) {
                float tick = this.eatAnimationTick - pPartialTicks;
                return -Mth.cos((float)(tick * Math.PI / 5 + Math.PI)) - 1;
            }
        }

        return 0;
    }

    @OnlyIn(Dist.CLIENT)
    public float xRotNeck(float pPartialTicks) {
        float swing = this.swingTime;
        float tick = this.eatAnimationTick - pPartialTicks;
        if (this.eatAnimationTick > 0) {
            if (this.eatAnimationTick < 10 || this.eatAnimationTick > 30) {
                return Mth.cos((float)(tick * Math.PI / 10)) - 1;
            } else {
                return -2;
            }
        }

        if (swing > 0) {
            if (swing != 1) {
                if (swing < 0.5F) {
                    return -swing * 4;
                }
            }

            return (swing - 0.5F) * 4 - 2;
        }

        return 0;
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.level.isClientSide) {
            this.eatAnimationTick = Math.max(0, this.eatAnimationTick - 1);
        }
    }

    @Override
    public void customServerAiStep() {
        super.customServerAiStep();
        this.eatAnimationTick = this.eatBlockGoal.getEatAnimationTick();
    }

    @Override
    public void dropCustomDeathLoot(DamageSource pDamageSource, int pLooting, boolean pRecentlyHit) {
        super.dropCustomDeathLoot(pDamageSource, pLooting, pRecentlyHit);
        if (!this.isBaby()) {
            if (pDamageSource.getEntity() instanceof Creeper creeper) {
                if (creeper.canDropMobsSkull()) {
                    if (creeper.isPowered()) {
                        creeper.increaseDroppedSkulls();
                        this.spawnAtLocation(IcariaItems.AETERNAE_SKULL.get());
                    }
                }
            }
        }
    }

    @Override
    public void handleEntityEvent(byte pId) {
        if (pId == 4) {
            this.attackAnimationState.start(this.tickCount);
        } else if (pId == 10) {
            this.eatAnimationTick = 40;
        } else {
            super.handleEntityEvent(pId);
        }
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
        this.level.broadcastEntityEvent(this, (byte)4);
        return super.doHurtTarget(pEntity);
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
        this.goalSelector.addGoal(3, new IcariaBreedGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(5, new TemptGoal(this, 1.0D, Ingredient.of(IcariaItems.SPELT.get()), false));
        this.goalSelector.addGoal(6, new IcariaFollowParentGoal(this, 1.0D));
        this.goalSelector.addGoal(7, this.eatBlockGoal);
        this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.001F));
        this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 5.0F, 0.025F, false));
        this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, (new AeternaeHurtByOtherGoal(this, 1.5D)).setAlertOthers());
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 4.0D).add(Attributes.ATTACK_KNOCKBACK, 1.0D).add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    public void setSize(int pSize) {
        int size = Mth.clamp(pSize, 1, 4);
        this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(size);
        this.getAttribute(Attributes.ATTACK_KNOCKBACK).setBaseValue(size * 0.5D);
        this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(size * size);
        super.setSize(pSize);
    }

    @Override
    public AeternaeEntity getBreedOffspring(ServerLevel pLevel, IcariaAnimalEntity pMob) {
        return IcariaEntities.AETERNAE.get().create(pLevel);
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

    public static class AeternaeHurtByOtherGoal extends HurtByTargetGoal {
        public double speedModifier;

        AeternaeHurtByOtherGoal(AeternaeEntity pMob, double pSpeedModifier) {
            super(pMob);
            this.speedModifier = pSpeedModifier;
        }

        @Override
        public void alertOther(Mob pMob, LivingEntity pEntity) {
            if (pMob instanceof AeternaeEntity) {
                double d = RandomSource.create().nextInt(8, 16);
                pMob.getNavigation().moveTo(pEntity.getX() + d, 0.0D, pEntity.getX() + d, speedModifier);
            }
        }
    }
}
