package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.data.tags.IcariaBlockTags;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.Event;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class MyrmekeQueenEntity extends Monster {
    public static final EntityDataAccessor<Byte> CLIMBING = SynchedEntityData.defineId(MyrmekeQueenEntity.class, EntityDataSerializers.BYTE);
    public static final EntityDataAccessor<Byte> SPELL = SynchedEntityData.defineId(MyrmekeQueenEntity.class, EntityDataSerializers.BYTE);

    public MyrmekeQueenEntity(EntityType<? extends MyrmekeQueenEntity> pType, Level pLevel) {
        super(pType, pLevel);
        this.xpReward = 10;
    }

    @Override
    public boolean canBeAffected(MobEffectInstance pEffectInstance) {
        if (pEffectInstance.getEffect() == MobEffects.POISON) {
            MobEffectEvent.Applicable event = new MobEffectEvent.Applicable(this, pEffectInstance);
            MinecraftForge.EVENT_BUS.post(event);
            return event.getResult() == Event.Result.ALLOW;
        }

        return super.canBeAffected(pEffectInstance);
    }

    public boolean isClimbing() {
        return (this.entityData.get(CLIMBING) & 1) != 0;
    }

    @Override
    public boolean onClimbable() {
        return this.isClimbing();
    }

    @Override
    public boolean removeWhenFarAway(double pDistanceToClosestPlayer) {
        return false;
    }

    @Override
    public float getStandingEyeHeight(Pose pPose, EntityDimensions pDimensions) {
        return 0.25F;
    }

    @Override
    public void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(CLIMBING, (byte) 0);
        this.entityData.define(SPELL, (byte) 0);
    }

    @Override
    public void playStepSound(BlockPos pPos, BlockState pState) {
        this.playSound(SoundEvents.SPIDER_STEP, 0.1F, 1.0F);
    }

    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new MyrmekeQueenSummonGoal(this));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.001F));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, (new MyrmekeQueenHurtByTargetGoal(this)).setAlertOthers());
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public void setCasting(MyrmekeQueenSpellEnum pSpell) {
        this.entityData.set(SPELL, (byte) pSpell.id);
    }

    public void setClimbing(boolean pClimbing) {
        byte b = this.entityData.get(CLIMBING);
        if (pClimbing) {
            b = (byte) (b | 1);
        } else {
            b = (byte) (b & -2);
        }

        this.entityData.set(CLIMBING, b);
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level.isClientSide) {
            this.setClimbing(this.horizontalCollision);
        }
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    @Override
    public MobType getMobType() {
        return MobType.ARTHROPOD;
    }

    @Override
    public PathNavigation createNavigation(Level pLevel) {
        return new WallClimberNavigation(this, pLevel);
    }

    @Override
    public SoundEvent getAmbientSound() {
        return SoundEvents.SPIDER_AMBIENT;
    }

    @Override
    public SoundEvent getDeathSound() {
        return SoundEvents.SPIDER_DEATH;
    }

    @Override
    public SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.SPIDER_HURT;
    }

    public enum MyrmekeQueenSpellEnum {
        NONE(0),
        SUMMON(1);

        public final int id;

        MyrmekeQueenSpellEnum(int pId) {
            this.id = pId;
        }
    }

    public static class MyrmekeQueenHurtByTargetGoal extends HurtByTargetGoal {
        MyrmekeQueenHurtByTargetGoal(MyrmekeQueenEntity pEntity) {
            super(pEntity);
        }

        @Override
        public void alertOther(Mob pMob, LivingEntity pEntity) {
            if (pMob instanceof MyrmekeDroneEntity) {
                pMob.setTarget(pEntity);
            }
        }
    }

    public static class MyrmekeQueenSummonGoal extends Goal {
        public MyrmekeQueenEntity entity;

        public TargetingConditions targetingConditions = TargetingConditions.forNonCombat().range(16.0D).ignoreLineOfSight().ignoreInvisibilityTesting();

        MyrmekeQueenSummonGoal(MyrmekeQueenEntity pEntity) {
            super();
            this.entity = pEntity;
        }

        @Override
        public boolean canUse() {
            LivingEntity livingEntity = this.entity.getTarget();
            if (livingEntity != this.entity.getLastHurtByMob()) {
                return false;
            } else if (!this.entity.getBlockStateOn().is(IcariaBlockTags.MYRMEKE_SUMMONS_ON)) {
                return false;
            } else {
                return this.entity.level.getNearbyEntities(MyrmekeSoldierEntity.class, this.targetingConditions, this.entity, this.entity.getBoundingBox().inflate(32.0D)).size() <= 2;
            }
        }

        @Override
        public void start() {
            this.entity.setCasting(MyrmekeQueenSpellEnum.SUMMON);
        }

        @Override
        public void tick() {
            MyrmekeSoldierEntity entity = IcariaEntityTypes.MYRMEKE_SOLDIER.get().create(this.entity.level);
            for (int i = 0; i < this.entity.random.nextIntBetweenInclusive(3,4); ++i) {
                if (entity != null) {
                    int random = this.entity.random.nextIntBetweenInclusive(-4, 4);
                    this.entity.level.addFreshEntity(entity);
                    this.entity.playSound(SoundEvents.EVOKER_PREPARE_SUMMON, 1.0F, 1.0F);
                    entity.moveTo(this.entity.blockPosition().offset(random, 0, random), 0.0F, 0.0F);
                }
            }
        }
    }
}
