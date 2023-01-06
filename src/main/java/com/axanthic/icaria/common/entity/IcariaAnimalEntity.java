package com.axanthic.icaria.common.entity;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public abstract class IcariaAnimalEntity extends IcariaAgeableEntity {
    public int maxCooldown = 16000;
    public int minCooldown = 0;
    public int maxDuration = 1200;
    public int minDuration = 0;

    public static final EntityDataAccessor<Integer> COOLDOWN = SynchedEntityData.defineId(IcariaAnimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DURATION = SynchedEntityData.defineId(IcariaAnimalEntity.class, EntityDataSerializers.INT);

    public IcariaAnimalEntity(EntityType<? extends IcariaAgeableEntity> pEntityType, Level pLevel, float bboxMult, float eyesMult, float sizeMult) {
        super(pEntityType, pLevel, bboxMult, eyesMult, sizeMult);
        this.setPathfindingMalus(BlockPathTypes.DAMAGE_FIRE, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.DANGER_FIRE, 16.0F);
    }

    public boolean canMate(IcariaAnimalEntity pOtherAnimal) {
        if (pOtherAnimal == this) {
            return false;
        } else if (pOtherAnimal.getClass() != this.getClass()) {
            return false;
        } else {
            return this.inLove() && pOtherAnimal.inLove();
        }
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        if (this.isInvulnerableTo(pSource)) {
            return false;
        } else {
            this.setDuration(this.minDuration);
            return super.hurt(pSource, pAmount);
        }
    }

    public boolean inLove() {
        return this.getDuration() > this.minDuration;
    }

    public boolean isFood(ItemStack pStack) {
        return false;
    }

    public boolean onCooldown() {
        return this.getCooldown() > this.minCooldown;
    }

    @Override
    public boolean removeWhenFarAway(double pDistanceToClosestPlayer) {
        return false;
    }

    public int getCooldown() {
        return this.entityData.get(COOLDOWN);
    }

    public int getDuration() {
        return this.entityData.get(DURATION);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putInt("Cooldown", this.getCooldown());
        pCompound.putInt("Duration", this.getDuration());
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.isAlive()) {
            int cooldown = this.getCooldown();
            if (cooldown > this.minCooldown) {
                --cooldown;
                this.setCooldown(cooldown);
            }

            int duration = this.getDuration();
            if (duration > this.minDuration) {
                --duration;
                this.setDuration(duration);
                if (this.getDuration() % 10 == 0) {
                    double d = this.random.nextGaussian() * 0.025D;
                    this.level.addParticle(ParticleTypes.HEART, this.getRandomX(1.0D), this.getRandomY() + 0.5D, this.getRandomZ(1.0D), d, d, d);
                }
            }
        }
    }

    @Override
    public void ate() {
        super.ate();
        if (this.isBaby()) {
            this.setTick(this.getTick() + 2400);
        }
    }

    @Override
    public void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(COOLDOWN, this.minCooldown);
        this.entityData.define(DURATION, this.minDuration);
    }

    @Override
    public void handleEntityEvent(byte pId) {
        if (pId == 18) {
            for (int i = 0; i < 7; ++i) {
                double d = this.random.nextGaussian() * 0.025D;
                this.level.addParticle(ParticleTypes.HEART, this.getRandomX(1.0D), this.getRandomY() + 0.5D, this.getRandomZ(1.0D), d, d, d);
            }
        } else {
            super.handleEntityEvent(pId);
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setCooldown(pCompound.getInt("Cooldown"));
        this.setDuration(pCompound.getInt("Duration"));
    }

    public void setCooldown(int pSize) {
        int ticks = Mth.clamp(pSize, this.minCooldown, this.maxCooldown);
        this.entityData.set(COOLDOWN, ticks);
    }

    public void setDuration(int pSize) {
        int ticks = Mth.clamp(pSize, this.minDuration, this.maxDuration);
        this.entityData.set(DURATION, ticks);
    }

    public void spawnChildFromBreeding(ServerLevel pLevel, IcariaAnimalEntity pMate) {
        IcariaAgeableEntity ageableMob = this.getBreedOffspring(pLevel, pMate);
        if (ageableMob != null) {
            ageableMob.moveTo(this.getX(), this.getY(), this.getZ(), 0.0F, 0.0F);
            ageableMob.setSize(this.minSize);
            ageableMob.setTick(this.minTick);
            pMate.setCooldown(this.maxCooldown);
            this.setCooldown(this.maxCooldown);
            pMate.setDuration(this.minDuration);
            this.setDuration(this.minDuration);
            pLevel.addFreshEntityWithPassengers(ageableMob);
            pLevel.broadcastEntityEvent(this, (byte) 18);
            if (pLevel.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
                pLevel.addFreshEntity(new ExperienceOrb(pLevel, this.getX(), this.getY(), this.getZ(), this.getRandom().nextInt(7) + 1));
            }
        }
    }

    @Override
    public @Nonnull InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        ItemStack itemStack = pPlayer.getItemInHand(pHand);
        if (this.isFood(itemStack)) {
            if (!this.level.isClientSide) {
                if (!this.isBaby()) {
                    if (!this.inLove()) {
                        if (!this.onCooldown()) {
                            itemStack.shrink(1);
                            pPlayer.awardStat(Stats.ANIMALS_BRED);
                            this.level.broadcastEntityEvent(this, (byte) 18);
                            this.setDuration(this.maxDuration);
                            return InteractionResult.SUCCESS;
                        }
                    }
                }
            }

            if (this.isBaby()) {
                itemStack.shrink(1);
                this.level.addParticle(ParticleTypes.HAPPY_VILLAGER, this.getRandomX(1.0D), this.getRandomY() + 0.5D, this.getRandomZ(1.0D), 0.0D, 0.0D, 0.0D);
                this.setTick(this.getTick() + ((this.maxTick - this.getTick()) / 10));
                return InteractionResult.sidedSuccess(this.level.isClientSide);
            }

            if (this.level.isClientSide) {
                return InteractionResult.CONSUME;
            }
        }

        return super.mobInteract(pPlayer, pHand);
    }

    @Nullable
    public abstract IcariaAnimalEntity getBreedOffspring(ServerLevel pLevel, IcariaAnimalEntity pOtherParent);
}
