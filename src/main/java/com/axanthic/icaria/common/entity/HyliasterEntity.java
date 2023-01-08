package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaEntities;
import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Objects;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class HyliasterEntity extends Monster {
    public int maxSize = 4;
    public int maxTick = 48000;
    public int minSize = 1;
    public int minTick = 0;

    public float bboxMult;
    public float eyesMult;
    public float sizeMult;

    public AnimationState walkAnimationState = new AnimationState();

    public static final EntityDataAccessor<Integer> SIZE = SynchedEntityData.defineId(IcariaAgeableEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> TICK = SynchedEntityData.defineId(IcariaAgeableEntity.class, EntityDataSerializers.INT);

    public HyliasterEntity(EntityType<? extends Monster> pType, Level pLevel) {
        super(pType, pLevel);
        this.bboxMult = 1.125F;
        this.eyesMult = 0.125F;
        this.sizeMult = 0.175F;
    }

    @Override
    public boolean isBaby() {
        return this.getSize() < this.maxSize;
    }

    public boolean isMovingOnLand() {
        return this.onGround && this.getDeltaMovement().horizontalDistanceSqr() > 0;
    }

    public float getInverseSize() {
        return (this.getSize() * -1.0F) + 5.0F;
    }

    @Override
    public float getScale() {
        return this.getScaleFromSize() * this.bboxMult;
    }

    public float getScaleFromSize() {
        return (this.getSize() + (this.getInverseSize() * this.sizeMult)) - 0.5F;
    }

    @Override
    public float getStandingEyeHeight(Pose pPose, EntityDimensions pDimensions) {
        return this.getScaleFromSize() * this.eyesMult;
    }

    @Override
    public float getVoicePitch() {
        return (this.getInverseSize() * 0.25F) + 0.75F;
    }

    public int getSize() {
        return this.entityData.get(SIZE);
    }

    public int getTick() {
        return this.entityData.get(TICK);
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
    public void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SIZE, this.minSize);
        this.entityData.define(TICK, this.minTick);
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> pKey) {
        super.onSyncedDataUpdated(pKey);
        if (SIZE.equals(pKey)) {
            this.refreshDimensions();
        }
    }

    @Override
    public void playStepSound(BlockPos pPos, BlockState pState) {
        this.playSound(SoundEvents.SLIME_SQUISH, 0.1F, 1.0F);
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
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.001F));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 10.0F, 0.025F, false));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true, true));
    }

    @Override
    public void remove(Entity.RemovalReason pReason) {
        super.remove(pReason);
        if (!this.level.isClientSide) {
            int size = this.getSize();
            if (size > this.minSize) {
                if (this.isDeadOrDying()) {
                    for (int l = 0; l < size; ++l) {
                        float xOffset = ((float) (l % 2) - 0.5F) * size * 0.25F;
                        float zOffset = ((float) (l / 2) - 0.5F) * size * 0.25F;
                        HyliasterEntity entity = IcariaEntities.HYLIASTER.get().create(this.level);
                        if (entity != null) {
                            if (this.isPersistenceRequired()) {
                                entity.setPersistenceRequired();
                            }

                            entity.moveTo(this.getX() + xOffset, this.getY() + 0.5D, this.getZ() + zOffset, this.random.nextFloat() * 360.0F, 0.0F);
                            entity.setCustomName(this.getCustomName());
                            entity.setInvulnerable(this.isInvulnerable());
                            entity.setNoAi(this.isNoAi());
                            entity.setSize(this.minSize);
                            this.level.addFreshEntity(entity);
                        }
                    }
                }
            }
        }
    }

    public void setSize(int pSize) {
        int size = Mth.clamp(pSize, this.minSize, this.maxSize);
        this.refreshDimensions();
        Objects.requireNonNull(this.getAttribute(Attributes.ATTACK_DAMAGE)).setBaseValue(size);
        Objects.requireNonNull(this.getAttribute(Attributes.MAX_HEALTH)).setBaseValue(size * size);
        Objects.requireNonNull(this.getAttribute(Attributes.MOVEMENT_SPEED)).setBaseValue((size * 0.04D) + 0.1D);
        this.entityData.set(SIZE, size);
        this.xpReward = size + 1;
    }

    public void setTick(int pSize) {
        int tick = Mth.clamp(pSize, this.minTick, this.maxTick);
        this.entityData.set(TICK, tick);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level.isClientSide()) {
            if (this.isMovingOnLand()) {
                this.walkAnimationState.startIfStopped(this.tickCount);
            } else {
                this.walkAnimationState.stop();
            }
        }
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 4.0D).add(Attributes.MAX_HEALTH, 16.0D).add(Attributes.MOVEMENT_SPEED, 0.1D);
    }

    @Override
    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        ItemStack itemStack = pPlayer.getItemInHand(pHand);
        if (itemStack.getItem() == IcariaItems.VIAL_EMPTY.get()) {
            pPlayer.getLevel().playSound(pPlayer, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.BOTTLE_FILL, SoundSource.NEUTRAL, 1.0F, 1.0F);
            if (!this.level.isClientSide) {
                this.setTick(this.getTick() - 16000);
                if (this.getSize() == this.minSize) {
                    this.remove(RemovalReason.KILLED);
                }

                if (!pPlayer.isCreative()) {
                    itemStack.shrink(1);
                }

                if (itemStack.isEmpty()) {
                    pPlayer.setItemInHand(pHand, new ItemStack(IcariaItems.VIAL_HYLIASTRUM.get()));
                } else if (!pPlayer.getInventory().add(new ItemStack(IcariaItems.VIAL_HYLIASTRUM.get()))) {
                    pPlayer.drop(new ItemStack(IcariaItems.VIAL_HYLIASTRUM.get()), false);
                }

                return InteractionResult.SUCCESS;
            } else {
                return InteractionResult.CONSUME;
            }
        } else {
            return super.mobInteract(pPlayer, pHand);
        }
    }

    @Override
    public SoundEvent getDeathSound() {
        return SoundEvents.SLIME_DEATH;
    }

    @Override
    public SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.SLIME_HURT;
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
        this.setSize(this.maxSize);
        this.setTick(this.maxTick);
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
    }
}