package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.goal.IcariaArachnidTargetGoal;
import com.axanthic.icaria.data.tags.IcariaBlockTags;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
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
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import net.neoforged.bus.api.Event;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ArachneDroneEntity extends ArachneEntity {
    public int maxSize = 4;
    public int maxTick = 48000;
    public int minSize = 1;
    public int minTick = 0;

    public float aabbMult = 0.25F;
    public float renderMult = 0.15F;
    public float shadowMult = 0.15F;
    public float sizeMult = 0.75F;
    public float sizeMultInverted = 0.25F;

    public static final EntityDataAccessor<Byte> CLIMBING = SynchedEntityData.defineId(ArachneDroneEntity.class, EntityDataSerializers.BYTE);

    public static final EntityDataAccessor<Integer> SIZE = SynchedEntityData.defineId(ArachneDroneEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> TICK = SynchedEntityData.defineId(ArachneDroneEntity.class, EntityDataSerializers.INT);

    public ArachneDroneEntity(EntityType<? extends ArachneDroneEntity> pType, Level pLevel) {
        super(pType, pLevel);
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
    public boolean isBaby() {
        return this.getSize() < this.maxSize;
    }

    public boolean isClimbing() {
        return (this.entityData.get(ArachneDroneEntity.CLIMBING) & 1) != 0;
    }

    @Override
    public boolean onClimbable() {
        return this.isClimbing();
    }

    public float getSizeInverted() {
        return this.getSize() * -1.0F + 5.0F;
    }

    public float getScaleForRender() {
        return this.getScaleFromSize() * this.renderMult;
    }

    public float getScaleForShadow() {
        return this.getScaleFromSize() * this.shadowMult;
    }

    public float getScaleFromSize() {
        return this.getSizeWithMultInverted() + this.getSizeWithMult();
    }

    public float getSizeWithMult() {
        return this.getSize() * this.sizeMult;
    }

    public float getSizeWithMultInverted() {
        return this.getSizeInverted() * this.sizeMultInverted;
    }

    @Override
    public float getVoicePitch() {
        return this.getSizeWithMultInverted() + 0.75F;
    }

    public int getSize() {
        return this.entityData.get(ArachneDroneEntity.SIZE);
    }

    public int getTick() {
        return this.entityData.get(ArachneDroneEntity.TICK);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putInt("Size", this.getSize());
        pCompound.putInt("Tick", this.getTick());
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.isAlive()) {
            int tick = this.getTick();
            if (tick < 16000) {
                ++tick;
                this.setTick(tick);
                this.setSize(1);
            } else if (tick < 32000) {
                ++tick;
                this.setTick(tick);
                this.setSize(2);
            } else if (tick < 48000) {
                ++tick;
                this.setTick(tick);
                this.setSize(3);
            } else {
                ++tick;
                this.setTick(tick);
                this.setSize(4);
            }
        }
    }

    @Override
    public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
        super.defineSynchedData(pBuilder);
        pBuilder.define(ArachneDroneEntity.CLIMBING, (byte) 0);
        pBuilder.define(ArachneDroneEntity.SIZE, this.minSize);
        pBuilder.define(ArachneDroneEntity.TICK, this.minTick);
    }

    @Override
    public void makeStuckInBlock(BlockState pState, Vec3 pMotionMultiplier) {
        if (!pState.is(IcariaBlockTags.ICARIA_COBWEB_BLOCKS)) {
            super.makeStuckInBlock(pState, pMotionMultiplier);
        }
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> pKey) {
        super.onSyncedDataUpdated(pKey);
        if (ArachneDroneEntity.SIZE.equals(pKey)) {
            this.refreshDimensions();
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setSize(pCompound.getInt("Size"));
        this.setTick(pCompound.getInt("Tick"));
    }

    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new LeapAtTargetGoal(this, 0.25F));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.001F));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 5.0F, 0.025F, false));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new IcariaArachnidTargetGoal<>(this, Player.class, true, true));
        this.targetSelector.addGoal(3, new IcariaArachnidTargetGoal<>(this, IronGolem.class, true, true));
    }

    public void setClimbing(boolean pClimbing) {
        byte b = this.entityData.get(ArachneDroneEntity.CLIMBING);
        if (pClimbing) {
            b = (byte) (b | 1);
        } else {
            b = (byte) (b & -2);
        }

        this.entityData.set(ArachneDroneEntity.CLIMBING, b);
    }

    public void setSize(int pSize) {
        int size = Mth.clamp(pSize, this.minSize, this.maxSize);
        this.refreshDimensions();
        this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(size);
        this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(size * size);
        this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue((size * 0.04D) + 0.1D);
        this.entityData.set(ArachneDroneEntity.SIZE, size);
        this.xpReward = size + 1;
    }

    public void setTick(int pSize) {
        int tick = Mth.clamp(pSize, this.minTick, this.maxTick);
        this.entityData.set(ArachneDroneEntity.TICK, tick);
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level().isClientSide()) {
            this.setClimbing(this.horizontalCollision);
        }
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 4.0D).add(Attributes.MAX_HEALTH, 16.0D).add(Attributes.MOVEMENT_SPEED, 0.1D);
    }

    @Override
    public EntityDimensions getDefaultDimensions(Pose pPose) {
        float scale = this.getScaleFromSize() * this.aabbMult;
        return this.getType().getDimensions().scale(scale);
    }

    @Override
    public PathNavigation createNavigation(Level pLevel) {
        return new WallClimberNavigation(this, pLevel);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData) {
        this.setSize(this.random.nextIntBetweenInclusive(0, 4));
        this.setTick(this.random.nextIntBetweenInclusive(0, 64000));
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData);
    }
}
