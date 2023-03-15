package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraftforge.common.IPlantable;
import net.minecraftforge.event.ForgeEventFactory;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ForestHagEntity extends Monster {
    public int targetChangeTime;
    public int targetSoundsTime = Integer.MIN_VALUE;

    public static final EntityDataAccessor<Boolean> TARGETING = SynchedEntityData.defineId(ForestHagEntity.class, EntityDataSerializers.BOOLEAN);

    public ForestHagEntity(EntityType<? extends ForestHagEntity> pType, Level pLevel) {
        super(pType, pLevel);
        this.xpReward = 10;
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
        boolean flag = pEntity.hurt(DamageSource.mobAttack(this), (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE));
        this.level.broadcastEntityEvent(this, (byte) 4);
        if (pEntity instanceof LivingEntity livingEntity) {
            double knockback = this.getAttributeValue(Attributes.ATTACK_KNOCKBACK) - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE);
            if (flag) {
                if (knockback > 0.0D) {
                    pEntity.push(0.0D, knockback * 0.5D, 0.0D);
                }
            }
        }

        return pEntity instanceof LivingEntity && flag;
    }

    public boolean isTargeting() {
        return this.entityData.get(TARGETING);
    }

    @Override
    public boolean removeWhenFarAway(double pDistanceToClosestPlayer) {
        return false;
    }

    @Override
    public float getStandingEyeHeight(Pose pPose, EntityDimensions pDimensions) {
        if (this.getType() == IcariaEntityTypes.CYPRESS_FOREST_HAG.get()) {
            return 2.375F;
        } else if (this.getType() == IcariaEntityTypes.DROUGHTROOT_FOREST_HAG.get()) {
            return 2.125F;
        } else if (this.getType() == IcariaEntityTypes.FIR_FOREST_HAG.get()) {
            return 2.125F;
        } else if (this.getType() == IcariaEntityTypes.LAUREL_FOREST_HAG.get()) {
            return 2.125F;
        } else if (this.getType() == IcariaEntityTypes.OLIVE_FOREST_HAG.get()) {
            return 2.125F;
        } else {
            return 0.0F;
        }
    }

    @Override
    public void actuallyHurt(DamageSource pDamageSource, float pDamageAmount) {
        Entity entity = pDamageSource.getEntity();
        if (entity instanceof LivingEntity livingEntity) {
            ItemStack itemStack = livingEntity.getMainHandItem();
            if (itemStack.getItem() instanceof AxeItem) {
                pDamageAmount *= 2;
            }
        }

        if (pDamageSource.isFire()) {
            pDamageAmount *= 2;
        }

        super.actuallyHurt(pDamageSource, pDamageAmount);
    }

    @Override
    public void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(TARGETING, false);
    }

    @Override
    public void dropCustomDeathLoot(DamageSource pDamageSource, int pLooting, boolean pRecentlyHit) {
        super.dropCustomDeathLoot(pDamageSource, pLooting, pRecentlyHit);
        if (pDamageSource.getEntity() instanceof Creeper creeper) {
            if (creeper.isPowered()) {
                if (creeper.canDropMobsSkull()) {
                    creeper.increaseDroppedSkulls();
                    if (this.getType() == IcariaEntityTypes.CYPRESS_FOREST_HAG.get()) {
                        this.spawnAtLocation(IcariaItems.CYPRESS_FOREST_HAG_SKULL.get());
                    } else if (this.getType() == IcariaEntityTypes.DROUGHTROOT_FOREST_HAG.get()) {
                        this.spawnAtLocation(IcariaItems.DROUGHTROOT_FOREST_HAG_SKULL.get());
                    } else if (this.getType() == IcariaEntityTypes.FIR_FOREST_HAG.get()) {
                        this.spawnAtLocation(IcariaItems.FIR_FOREST_HAG_SKULL.get());
                    } else if (this.getType() == IcariaEntityTypes.LAUREL_FOREST_HAG.get()) {
                        this.spawnAtLocation(IcariaItems.LAUREL_FOREST_HAG_SKULL.get());
                    } else if (this.getType() == IcariaEntityTypes.OLIVE_FOREST_HAG.get()) {
                        this.spawnAtLocation(IcariaItems.OLIVE_FOREST_HAG_SKULL.get());
                    }
                }
            }
        }
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> pKey) {
        super.onSyncedDataUpdated(pKey);
        if (TARGETING.equals(pKey)) {
            if (this.isTargeting()) {
                if (this.level.isClientSide) {
                    this.playTargetSounds();
                }
            }
        }
    }

    public void playTargetSounds() {
        if (this.tickCount >= this.targetSoundsTime + 400) {
            this.targetSoundsTime = this.tickCount;
            if (!this.isSilent()) {
                this.level.playLocalSound(this.getX(), this.getY(), this.getZ(), SoundEvents.ENDERMAN_STARE, SoundSource.HOSTILE, 1.0F, 1.0F, false);
            }
        }
    }

    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.001F));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 10.0F, 0.025F, false));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(6, new ForestHagPlaceSaplingGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
    }

    @Override
    public void setTarget(@Nullable LivingEntity pTarget) {
        super.setTarget(pTarget);
        if (pTarget == null) {
            this.targetChangeTime = 0;
            this.entityData.set(TARGETING, false);
        } else {
            this.targetChangeTime = this.tickCount;
            this.entityData.set(TARGETING, true);
        }
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 16.0D).add(Attributes.ATTACK_KNOCKBACK, 1.0D).add(Attributes.FOLLOW_RANGE, 64.0D).add(Attributes.KNOCKBACK_RESISTANCE, 0.5D).add(Attributes.MAX_HEALTH, 48.0D).add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    @Override
    public SoundEvent getAmbientSound() {
        return this.isTargeting() ? SoundEvents.ENDERMAN_SCREAM : SoundEvents.ENDERMAN_AMBIENT;
    }

    @Override
    public SoundEvent getDeathSound() {
        return SoundEvents.ENDERMAN_DEATH;
    }

    @Override
    public SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.ENDERMAN_HURT;
    }

    public static class ForestHagPlaceSaplingGoal extends Goal {
        public ForestHagEntity entity;

        public ForestHagPlaceSaplingGoal(ForestHagEntity pEntity) {
            this.entity = pEntity;
        }

        @Override
        public boolean canUse() {
            return this.entity.getRandom().nextInt(reducedTickDelay(5000)) == 0 && !this.entity.isAggressive() && ForgeEventFactory.getMobGriefingEvent(this.entity.level, this.entity);
        }

        @Override
        public void tick() {
            Level level = this.entity.level;
            Block sapling = null;
            BlockPos blockPos = new BlockPos(this.entity.getX(), this.entity.getY(), this.entity.getZ());
            BlockPos belowPos = blockPos.below();
            BlockState blockState = level.getBlockState(blockPos);
            BlockState belowState = level.getBlockState(belowPos);
            if (this.entity.getType() == IcariaEntityTypes.CYPRESS_FOREST_HAG.get()) {
                sapling = IcariaBlocks.CYPRESS_SAPLING.get();
            } else if (this.entity.getType() == IcariaEntityTypes.DROUGHTROOT_FOREST_HAG.get()) {
                sapling = IcariaBlocks.DROUGHTROOT_SAPLING.get();
            } else if (this.entity.getType() == IcariaEntityTypes.FIR_FOREST_HAG.get()) {
                sapling = IcariaBlocks.FIR_SAPLING.get();
            } else if (this.entity.getType() == IcariaEntityTypes.LAUREL_FOREST_HAG.get()) {
                sapling = IcariaBlocks.LAUREL_SAPLING.get();
            } else if (this.entity.getType() == IcariaEntityTypes.OLIVE_FOREST_HAG.get()) {
                sapling = IcariaBlocks.OLIVE_SAPLING.get();
            }

            if (sapling != null) {
                if (blockState.isAir() && belowState.canSustainPlant(this.entity.level, belowPos, Direction.UP, (IPlantable) sapling)) {
                    this.entity.level.playSound(null, this.entity, SoundEvents.GRASS_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
                    this.entity.level.setBlock(blockPos, sapling.defaultBlockState(), 2);
                }
            }
        }
    }
}
