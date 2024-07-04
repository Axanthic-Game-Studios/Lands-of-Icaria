package com.axanthic.icaria.common.entity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.pathfinder.PathType;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public abstract class IcariaAnimalEntity extends SizedPathfinderMobEntity implements IcariaBreedableEntity {
    public int maxCooldown = 16000;
    public int minCooldown = 0;
    public int maxDuration = 1200;
    public int minDuration = 0;
    public int maxTick = 48000;
    public int minTick = 0;

    public static final EntityDataAccessor<Integer> COOLDOWN = SynchedEntityData.defineId(IcariaAnimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DURATION = SynchedEntityData.defineId(IcariaAnimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> TICK = SynchedEntityData.defineId(IcariaAnimalEntity.class, EntityDataSerializers.INT);

    public IcariaAnimalEntity(EntityType<? extends IcariaAnimalEntity> pType, Level pLevel, float pAabbMult, float pRenderMult, float pShadowMult, float pSizeMult, float pSizeMultInverted) {
        super(pType, pLevel, pAabbMult, pRenderMult, pShadowMult, pSizeMult, pSizeMultInverted);
        this.setPathfindingMalus(PathType.DAMAGE_FIRE, -1.0F);
        this.setPathfindingMalus(PathType.DANGER_FIRE, 16.0F);
    }

    public boolean canMate(IcariaAnimalEntity pEntity) {
        if (pEntity == this) {
            return false;
        } else if (pEntity.getClass() != this.getClass()) {
            return false;
        } else {
            return this.inLove() && pEntity.inLove();
        }
    }

    public static boolean checkAnimalSpawnRules(EntityType<? extends IcariaAnimalEntity> pAnimal, LevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom) {
        return IcariaAnimalEntity.isBrightEnoughToSpawn(pLevel, pPos);
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

    public static boolean isBrightEnoughToSpawn(BlockAndTintGetter pLevel, BlockPos pPos) {
        return pLevel.getRawBrightness(pPos, 0) > 8;
    }

    public boolean isFood(ItemStack pStack) {
        return false;
    }

    public boolean onCooldown() {
        return this.getCooldown() > this.minCooldown;
    }

    public int getCooldown() {
        return this.entityData.get(IcariaAnimalEntity.COOLDOWN);
    }

    public int getDuration() {
        return this.entityData.get(IcariaAnimalEntity.DURATION);
    }

    public int getTick() {
        return this.entityData.get(IcariaAnimalEntity.TICK);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putInt("Cooldown", this.getCooldown());
        pCompound.putInt("Duration", this.getDuration());
        pCompound.putInt("Tick", this.getTick());
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
                    double random = this.random.nextGaussian() * 0.025D;
                    this.level().addParticle(ParticleTypes.HEART, this.getRandomX(1.0D), this.getRandomY() + 0.5D, this.getRandomZ(1.0D), random, random, random);
                }
            }

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
    public void ate() {
        super.ate();
        if (this.isBaby()) {
            this.setTick(this.getTick() + 2400);
        }
    }

    @Override
    public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
        super.defineSynchedData(pBuilder);
        pBuilder.define(IcariaAnimalEntity.COOLDOWN, this.minCooldown);
        pBuilder.define(IcariaAnimalEntity.DURATION, this.minDuration);
        pBuilder.define(IcariaAnimalEntity.TICK, this.minTick);
    }

    @Override
    public void handleEntityEvent(byte pId) {
        if (pId == 18) {
            for (int i = 0; i < 7; ++i) {
                double random = this.random.nextGaussian() * 0.025D;
                this.level().addParticle(ParticleTypes.HEART, this.getRandomX(1.0D), this.getRandomY() + 0.5D, this.getRandomZ(1.0D), random, random, random);
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
        this.setTick(pCompound.getInt("Tick"));
    }

    public void setCooldown(int pSize) {
        int ticks = Mth.clamp(pSize, this.minCooldown, this.maxCooldown);
        this.entityData.set(IcariaAnimalEntity.COOLDOWN, ticks);
    }

    public void setDuration(int pSize) {
        int ticks = Mth.clamp(pSize, this.minDuration, this.maxDuration);
        this.entityData.set(IcariaAnimalEntity.DURATION, ticks);
    }

    public void setTick(int pSize) {
        int tick = Mth.clamp(pSize, this.minTick, this.maxTick);
        this.entityData.set(IcariaAnimalEntity.TICK, tick);
    }

    public void spawnChildFromBreeding(ServerLevel pLevel, IcariaAnimalEntity pEntity) {
        var entity = this.getBreedOffspring(pLevel, pEntity);
        if (entity != null) {
            entity.moveTo(this.getX(), this.getY(), this.getZ(), 0.0F, 0.0F);
            entity.setSize(this.minSize);
            entity.setTick(this.minTick);
            pEntity.setCooldown(this.maxCooldown);
            this.setCooldown(this.maxCooldown);
            pEntity.setDuration(this.minDuration);
            this.setDuration(this.minDuration);
            pLevel.addFreshEntityWithPassengers(entity);
            pLevel.broadcastEntityEvent(this, (byte) 18);
            if (pLevel.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
                pLevel.addFreshEntity(new ExperienceOrb(pLevel, this.getX(), this.getY(), this.getZ(), this.getRandom().nextInt(7) + 1));
            }
        }
    }

    @Override
    public @Nonnull InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        var itemStack = pPlayer.getItemInHand(pHand);
        if (this.isFood(itemStack)) {
            if (!this.level().isClientSide()) {
                if (!this.isBaby()) {
                    if (!this.inLove()) {
                        if (!this.onCooldown()) {
                            itemStack.shrink(1);
                            pPlayer.awardStat(Stats.ANIMALS_BRED);
                            this.level().broadcastEntityEvent(this, (byte) 18);
                            this.setDuration(this.maxDuration);
                            return InteractionResult.SUCCESS;
                        }
                    }
                }
            }

            if (this.isBaby()) {
                itemStack.shrink(1);
                this.level().addParticle(ParticleTypes.HAPPY_VILLAGER, this.getRandomX(1.0D), this.getRandomY() + 0.5D, this.getRandomZ(1.0D), 0.0D, 0.0D, 0.0D);
                this.setTick(this.getTick() + ((this.maxTick - this.getTick()) / 10));
                return InteractionResult.sidedSuccess(this.level().isClientSide());
            }

            if (this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            }
        }

        return super.mobInteract(pPlayer, pHand);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData) {
        this.setTick(this.random.nextIntBetweenInclusive(0, 64000));
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData);
    }
}
