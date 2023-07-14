package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.goal.MyrmekeSoldierHurtByTargetGoal;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.level.Level;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class MyrmekeSoldierEntity extends MyrmekeDroneEntity {
    public int maxTick = 40;
    public int minTick = 0;

    public static final EntityDataAccessor<Integer> TICK = SynchedEntityData.defineId(MyrmekeSoldierEntity.class, EntityDataSerializers.INT);

    public MyrmekeSoldierEntity(EntityType<? extends MyrmekeSoldierEntity> pType, Level pLevel) {
        super(pType, pLevel);
        this.xpReward = 5;
    }

    public boolean onTick() {
        return this.getTick() < this.maxTick;
    }

    public float getShadowStrength() {
        return this.getTick() / (float) this.maxTick;
    }

    public int getTick() {
        return this.entityData.get(MyrmekeSoldierEntity.TICK);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putInt("Tick", this.getTick());
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.isAlive()) {
            int tick = this.getTick();
            if (tick < this.maxTick) {
                ++tick;
                this.setTick(tick);
            }
        }
    }

    @Override
    public void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(MyrmekeSoldierEntity.TICK, this.minTick);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setTick(pCompound.getInt("Tick"));
    }

    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new LeapAtTargetGoal(this, 0.25F));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.001F));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new MyrmekeSoldierHurtByTargetGoal(this).setAlertOthers());
    }

    public void setTick(int pSize) {
        int tick = Mth.clamp(pSize, this.minTick, this.maxTick);
        this.entityData.set(MyrmekeSoldierEntity.TICK, tick);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide) {
            this.tickParticlePlusSounds();
        }
    }

    public void tickParticlePlusSounds() {
        if (this.onTick()) {
            this.level().playLocalSound(this.getX(), this.getY(), this.getZ(), this.getBlockStateOn().getSoundType().getBreakSound(), SoundSource.BLOCKS, 1.0F, 1.0F, false);
            for (int i = 0; i < 25; ++i) {
                double x = this.getX() + Mth.randomBetween(this.getRandom(), -0.75F, 0.75F);
                double y = this.getY();
                double z = this.getZ() + Mth.randomBetween(this.getRandom(), -0.75F, 0.75F);
                this.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, this.getBlockStateOn()), x, y, z, 0.0D, 0.0D, 0.0D);
            }
        }
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 2.0D).add(Attributes.MAX_HEALTH, 16.0D).add(Attributes.MOVEMENT_SPEED, 0.25D);
    }
}
