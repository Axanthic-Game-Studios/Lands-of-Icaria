package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.common.goal.MyrmekeQueenHurtByTargetGoal;
import com.axanthic.icaria.common.goal.MyrmekeQueenSummonGoal;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.spell.IcariaSummonSpell;
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
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class MyrmekeQueenEntity extends Monster {
    public float red;
    public float green;
    public float blue;

    public static final EntityDataAccessor<Byte> CLIMBING = SynchedEntityData.defineId(MyrmekeQueenEntity.class, EntityDataSerializers.BYTE);
    public static final EntityDataAccessor<Byte> SPELL = SynchedEntityData.defineId(MyrmekeQueenEntity.class, EntityDataSerializers.BYTE);

    public MyrmekeQueenEntity(EntityType<? extends MyrmekeQueenEntity> pType, Level pLevel) {
        super(pType, pLevel);
        this.xpReward = 10;
    }

    @Override
    public boolean canBeAffected(MobEffectInstance pEffectInstance) {
        return super.canBeAffected(pEffectInstance) && !pEffectInstance.is(MobEffects.POISON);
    }

    public boolean isClimbing() {
        return (this.entityData.get(MyrmekeQueenEntity.CLIMBING) & 1) != 0;
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
    public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
        super.defineSynchedData(pBuilder);
        pBuilder.define(MyrmekeQueenEntity.CLIMBING, (byte) 0);
        pBuilder.define(MyrmekeQueenEntity.SPELL, (byte) 0);
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
        this.goalSelector.addGoal(2, new MyrmekeQueenSummonGoal(this));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.001F));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new MyrmekeQueenHurtByTargetGoal(this).setAlertOthers());
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public void setCasting(IcariaSummonSpell pSpell) {
        this.entityData.set(MyrmekeQueenEntity.SPELL, (byte) pSpell.id);
    }

    public void setClimbing(boolean pClimbing) {
        byte b = this.entityData.get(MyrmekeQueenEntity.CLIMBING);
        if (pClimbing) {
            b = (byte) (b | 1);
        } else {
            b = (byte) (b & -2);
        }

        this.entityData.set(MyrmekeQueenEntity.CLIMBING, b);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            this.tickRegisterRaysValues();
        } else {
            this.setClimbing(this.horizontalCollision);
        }
    }

    public void tickRegisterRaysValues() {
        if (this.getType() == IcariaEntityTypes.MYRMEKE_QUEEN.get()) {
            if (this.tickCount < 20) {
                this.red = IcariaClientHelper.getRed(this);
                this.green = IcariaClientHelper.getGreen(this);
                this.blue = IcariaClientHelper.getBlue(this);
            }
        }
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.25D);
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
}
