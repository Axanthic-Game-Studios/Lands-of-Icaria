package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Objects;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SnullEntity extends SizedPathfinderMobEntity {
    public int maxCooldown = 400;
    public int minCooldown = 0;

    public AnimationState hideAnimationState = new AnimationState();
    public AnimationState hurtAnimationState = new AnimationState();
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState moveAnimationState = new AnimationState();
    public AnimationState showAnimationState = new AnimationState();

    public static final EntityDataAccessor<Byte> CLIMBING = SynchedEntityData.defineId(SnullEntity.class, EntityDataSerializers.BYTE);
    public static final EntityDataAccessor<Integer> COOLDOWN = SynchedEntityData.defineId(SnullEntity.class, EntityDataSerializers.INT);

    public SnullEntity(EntityType<? extends SnullEntity> pType, Level pLevel) {
        super(pType, pLevel, 0.25F, 0.125F, 0.25F);
    }

    public boolean isClimbing() {
        return (this.entityData.get(CLIMBING) & 1) != 0;
    }

    @Override
    public boolean onClimbable() {
        return this.isClimbing();
    }

    public boolean isMovingOnLand() {
        return this.onGround && this.getDeltaMovement().horizontalDistanceSqr() > 0;
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        if (this.getHealth() < 4.0F) {
            this.setCooldown(this.maxCooldown);
        }

        return super.hurt(pSource, pAmount);
    }

    public boolean onHurt() {
        return this.getLastDamageSource() == DamageSource.GENERIC;
    }

    public boolean onCooldown() {
        return this.getCooldown() > this.minCooldown;
    }

    @Override
    public float getVoicePitch() {
        return super.getVoicePitch() - 0.75F;
    }

    public int getCooldown() {
        return this.entityData.get(COOLDOWN);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putInt("Cooldown", this.getCooldown());
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.isAlive()) {
            int cooldown = this.getCooldown();
            if (cooldown > this.minCooldown) {
                --cooldown;
                this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, cooldown, 3, false, false));
                this.setCooldown(cooldown);
            }
        }
    }

    @Override
    public void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(CLIMBING, (byte) 0);
        this.entityData.define(COOLDOWN, this.minCooldown);
    }

    @Override
    public void dropCustomDeathLoot(DamageSource pDamageSource, int pLooting, boolean pRecentlyHit) {
        super.dropCustomDeathLoot(pDamageSource, pLooting, pRecentlyHit);
        if (pDamageSource.getEntity() instanceof Creeper creeper) {
            if (!this.isBaby()) {
                if (creeper.isPowered()) {
                    if (creeper.canDropMobsSkull()) {
                        creeper.increaseDroppedSkulls();
                        if (this.getType() == IcariaEntityTypes.SNULL.get()) {
                            this.spawnAtLocation(IcariaItems.SOW_SKULL.get()); // TODO: replace with revenant skull
                        } else if (this.getType() == IcariaEntityTypes.FOREST_SNULL.get()) {
                            this.spawnAtLocation(IcariaItems.LAUREL_FOREST_HAG_SKULL.get());
                        }
                    }
                }
            }
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setCooldown(pCompound.getInt("Cooldown"));
    }

    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.001F));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
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

    public void setCooldown(int pCooldown) {
        int ticks = Mth.clamp(pCooldown, this.minCooldown, this.maxCooldown);
        this.entityData.set(COOLDOWN, ticks);
    }

    @Override
    public void setSize(int pSize) {
        super.setSize(pSize);
        int size = Mth.clamp(pSize, this.minSize, this.maxSize);
        Objects.requireNonNull(this.getAttribute(Attributes.MAX_HEALTH)).setBaseValue(size * size);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level.isClientSide) {
            if (this.isAlive()) {
                this.idleAnimationState.startIfStopped(this.tickCount);
            } else {
                this.idleAnimationState.stop();
            }

            if (this.isClimbing() || this.isMovingOnLand()) {
                this.moveAnimationState.startIfStopped(this.tickCount);
            } else {
                this.moveAnimationState.stop();
            }

            if (this.onCooldown()) {
                this.hideAnimationState.startIfStopped(this.tickCount);
                this.showAnimationState.stop();
            } else {
                this.showAnimationState.startIfStopped(this.tickCount);
                this.hideAnimationState.stop();
            }

            if (this.onHurt()) {
                this.hurtAnimationState.startIfStopped(this.tickCount);
            } else {
                this.hurtAnimationState.stop();
            }
        } else {
            this.setClimbing(this.horizontalCollision);
        }
    }

    @Override
    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        ItemStack itemStack = pPlayer.getItemInHand(pHand);
        if (itemStack.getItem() == IcariaItems.HALITE_DUST.get()) {
            if (!this.level.isClientSide) {
                this.hurt(DamageSource.GENERIC, 1.0F);
                this.setCooldown(this.maxCooldown);
                if (!pPlayer.isCreative()) {
                    itemStack.shrink(1);
                }

                return InteractionResult.SUCCESS;
            } else {
                return InteractionResult.CONSUME;
            }
        } else {
            return super.mobInteract(pPlayer, pHand);
        }
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 16.0D).add(Attributes.MOVEMENT_SPEED, 0.125D);
    }

    @Override
    public PathNavigation createNavigation(Level pLevel) {
        return new WallClimberNavigation(this, pLevel);
    }

    @Override
    public SoundEvent getAmbientSound() {
        return SoundEvents.SLIME_SQUISH;
    }

    @Override
    public SoundEvent getDeathSound() {
        return SoundEvents.SLIME_DEATH;
    }

    @Override
    public SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.SLIME_HURT;
    }
}
