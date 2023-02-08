package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaEntityTypes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
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
    public int spellCastTickCount;

    public static final EntityDataAccessor<Byte> CLIMBING = SynchedEntityData.defineId(MyrmekeQueenEntity.class, EntityDataSerializers.BYTE);
    public static final EntityDataAccessor<Byte> SPELL = SynchedEntityData.defineId(MyrmekeQueenEntity.class, EntityDataSerializers.BYTE);

    public MyrmekeQueenSpellEnum spell = MyrmekeQueenSpellEnum.NONE;

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

    public boolean isCasting() {
        if (this.level.isClientSide) {
            return this.entityData.get(SPELL) > 0;
        } else {
            return this.spellCastTickCount > 0;
        }
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
    public void addAdditionalSaveData(CompoundTag pTag) {
        super.addAdditionalSaveData(pTag);
        pTag.putInt("SpellTicks", this.spellCastTickCount);
    }

    @Override
    public void customServerAiStep() {
        super.customServerAiStep();
        if (this.spellCastTickCount > 0) {
            --this.spellCastTickCount;
        }
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
    public void readAdditionalSaveData(CompoundTag pTag) {
        super.readAdditionalSaveData(pTag);
        this.spellCastTickCount = pTag.getInt("SpellTicks");
    }

    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new MyrmekeQueenSummonGoal());
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.001F));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, (new MyrmekeQueenHurtByTargetGoal(this)).setAlertOthers());
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public void setCasting(MyrmekeQueenSpellEnum pSpell) {
        this.spell = pSpell;
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

    public SoundEvent getCastingSound() {
        return SoundEvents.EVOKER_CAST_SPELL;
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

    public class MyrmekeQueenSummonGoal extends MyrmekeQueenSpellcastGoal {
        public TargetingConditions targetingConditions = TargetingConditions.forNonCombat().range(16.0D).ignoreLineOfSight().ignoreInvisibilityTesting();

        @Override
        public boolean canUse() {
            if (!super.canUse()) {
                return false;
            } else {
                int i = MyrmekeQueenEntity.this.level.getNearbyEntities(MyrmekeSoldierEntity.class, this.targetingConditions, MyrmekeQueenEntity.this, MyrmekeQueenEntity.this.getBoundingBox().inflate(16.0D)).size();
                return i < 2;
            }
        }

        @Override
        public int getSpellCastInterval() {
            return 340;
        }

        @Override
        public int getSpellCastTime() {
            return 100;
        }

        @Override
        public int getSpellWarmupTime() {
            return 20;
        }

        @Override
        public void performSpell() {
            ServerLevel serverLevel = (ServerLevel) MyrmekeQueenEntity.this.level;
            for (int i = 0; i < MyrmekeQueenEntity.this.random.nextIntBetweenInclusive(2,4); ++i) {
                BlockPos blockPos = MyrmekeQueenEntity.this.blockPosition().offset(-2 + MyrmekeQueenEntity.this.random.nextInt(5), 0, -2 + MyrmekeQueenEntity.this.random.nextInt(5));
                MyrmekeSoldierEntity entity = IcariaEntityTypes.MYRMEKE_SOLDIER.get().create(MyrmekeQueenEntity.this.level);
                if (entity != null) {
                    entity.moveTo(blockPos, 0.0F, 0.0F);
                    entity.finalizeSpawn(serverLevel, MyrmekeQueenEntity.this.level.getCurrentDifficultyAt(blockPos), MobSpawnType.MOB_SUMMONED, null, null);
                    serverLevel.addFreshEntityWithPassengers(entity);
                }
            }
        }

        @Override
        public MyrmekeQueenSpellEnum getSpell() {
            return MyrmekeQueenSpellEnum.SUMMON;
        }

        @Override
        public SoundEvent getSpellPrepareSound() {
            return SoundEvents.EVOKER_PREPARE_SUMMON;
        }
    }

    public abstract class MyrmekeQueenSpellcastGoal extends Goal {
        public int nextAttackTickCount;
        public int warmupDelay;

        @Override
        public boolean canUse() {
            LivingEntity livingEntity = MyrmekeQueenEntity.this.getTarget();
            if (livingEntity != null) {
                if (livingEntity.isAlive()) {
                    if (MyrmekeQueenEntity.this.isCasting()) {
                        return false;
                    } else {
                        return MyrmekeQueenEntity.this.tickCount >= this.nextAttackTickCount;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        @Override
        public boolean canContinueToUse() {
            LivingEntity livingEntity = MyrmekeQueenEntity.this.getTarget();
            return livingEntity != null && livingEntity.isAlive() && this.warmupDelay > 0;
        }

        @Override
        public void start() {
            this.warmupDelay = this.adjustedTickDelay(this.getSpellWarmupTime());
            MyrmekeQueenEntity.this.spellCastTickCount = this.getSpellCastTime();
            this.nextAttackTickCount = MyrmekeQueenEntity.this.tickCount + this.getSpellCastInterval();
            MyrmekeQueenEntity.this.playSound(this.getSpellPrepareSound(), 1.0F, 1.0F);
            MyrmekeQueenEntity.this.setCasting(this.getSpell());
        }

        @Override
        public void tick() {
            --this.warmupDelay;
            if (this.warmupDelay == 0) {
                this.performSpell();
                MyrmekeQueenEntity.this.playSound(MyrmekeQueenEntity.this.getCastingSound(), 1.0F, 1.0F);
            }
        }

        public abstract int getSpellCastInterval();

        public abstract int getSpellCastTime();

        public abstract int getSpellWarmupTime();

        public abstract void performSpell();

        public abstract MyrmekeQueenSpellEnum getSpell();

        public abstract SoundEvent getSpellPrepareSound();
    }
}
