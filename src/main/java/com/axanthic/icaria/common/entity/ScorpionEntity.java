package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.goal.IcariaArachnidTargetGoal;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;
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
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import net.neoforged.bus.api.Event;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ScorpionEntity extends IcariaArachnidEntity {
    public AnimationState attackAnimationState = new AnimationState();

    public static final EntityDataAccessor<Byte> CLIMBING = SynchedEntityData.defineId(ScorpionEntity.class, EntityDataSerializers.BYTE);

    public ScorpionEntity(EntityType<? extends ScorpionEntity> pType, Level pLevel) {
        super(pType, pLevel);
        this.xpReward = 5;
    }

    @Override
    public boolean canBeAffected(MobEffectInstance pEffectInstance) {
        if (pEffectInstance.getEffect() == MobEffects.POISON) {
            var event = new MobEffectEvent.Applicable(this, pEffectInstance);
            NeoForge.EVENT_BUS.post(event);
            return event.getResult() == Event.Result.ALLOW;
        }

        return super.canBeAffected(pEffectInstance);
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
        this.level().broadcastEntityEvent(this, (byte) 4);
        if (pEntity instanceof LivingEntity livingEntity) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 120, 0), this);
        }

        return super.doHurtTarget(pEntity);
    }

    public boolean isClimbing() {
        return (this.entityData.get(ScorpionEntity.CLIMBING) & 1) != 0;
    }

    @Override
    public boolean onClimbable() {
        return this.isClimbing();
    }

    @Override
    public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
        super.defineSynchedData(pBuilder);
        pBuilder.define(ScorpionEntity.CLIMBING, (byte) 0);
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
    public void makeStuckInBlock(BlockState pState, Vec3 pMotionMultiplier) {
        if (!pState.is(IcariaBlockTags.ICARIA_COBWEB_BLOCKS)) {
            super.makeStuckInBlock(pState, pMotionMultiplier);
        }
    }

    @Override
    public void playStepSound(BlockPos pPos, BlockState pState) {
        this.playSound(SoundEvents.SPIDER_STEP, 0.1F, 1.0F);
    }

    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.001F));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 5.0F, 0.025F, false));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new IcariaArachnidTargetGoal<>(this, Player.class, true, true));
        this.targetSelector.addGoal(3, new IcariaArachnidTargetGoal<>(this, IronGolem.class, true, true));
    }

    public void setClimbing(boolean pClimbing) {
        byte b = this.entityData.get(ScorpionEntity.CLIMBING);
        if (pClimbing) {
            b = (byte) (b | 1);
        } else {
            b = (byte) (b & -2);
        }

        this.entityData.set(ScorpionEntity.CLIMBING, b);
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level().isClientSide()) {
            this.setClimbing(this.horizontalCollision);
        }
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.createMobAttributes().add(Attributes.ARMOR, 6.0D).add(Attributes.ATTACK_DAMAGE, 6.0D).add(Attributes.MAX_HEALTH, 32.0D).add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    @Override
    public PathNavigation createNavigation(Level pLevel) {
        return new WallClimberNavigation(this, pLevel);
    }

    @Override
    public SoundEvent getAmbientSound() {
        return IcariaSoundEvents.SCORPION_AMBIENT;
    }

    @Override
    public SoundEvent getDeathSound() {
        return IcariaSoundEvents.SCORPION_DEATH;
    }

    @Override
    public SoundEvent getHurtSound(DamageSource pDamageSource) {
        return IcariaSoundEvents.SCORPION_HURT;
    }
}
