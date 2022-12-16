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
    public final AnimationState walkAnimationState = new AnimationState();
    public static final EntityDataAccessor<Integer> ID_SIZE = SynchedEntityData.defineId(HyliasterEntity.class, EntityDataSerializers.INT);

    public HyliasterEntity(EntityType<? extends Monster> pType, Level pLevel) {
        super(pType, pLevel);
    }

    public boolean isMovingOnLand() {
        return this.onGround && this.getDeltaMovement().horizontalDistanceSqr() > 0;
    }

    public float getDimensionFromSize() {
        return ((this.getSize() + ((-this.getSize() + 5.0F) * 0.175F)) - 0.5F);
    }

    @Override
    public float getStandingEyeHeight(Pose pPose, EntityDimensions pSize) {
        return getDimensionFromSize() * 0.125F;
    }

    public int getSize() {
        return this.entityData.get(ID_SIZE);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putInt("Size", this.getSize() - 1);
    }

    @Override
    public void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ID_SIZE, 1);
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> pKey) {
        if (ID_SIZE.equals(pKey)) {
            this.refreshDimensions();
            this.setYRot(this.yHeadRot);
            this.yBodyRot = this.yHeadRot;
            if (this.isInWater() && this.random.nextInt(20) == 0) {
                this.doWaterSplashEffect();
            }
        }

        super.onSyncedDataUpdated(pKey);
    }

    @Override
    public void playStepSound(BlockPos pPos, BlockState pState) {
        this.playSound(SoundEvents.SLIME_SQUISH, 0.1F, 1.0F);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        this.setSize(pCompound.getInt("Size") + 1, false);
        super.readAdditionalSaveData(pCompound);
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
        int size = this.getSize();
        if (!this.level.isClientSide && size > 1 && this.isDeadOrDying()) {
            for(int l = 0; l < size; ++l) {
                float xOffset = ((float)(l % 2) - 0.5F) * size * 0.25F;
                float zOffset = ((float)(l / 2) - 0.5F) * size * 0.25F;

                HyliasterEntity entity = IcariaEntities.HYLIASTER.get().create(this.level);

                if (entity != null) {
                    if (this.isPersistenceRequired()) {
                        entity.setPersistenceRequired();
                    }

                    entity.setCustomName(this.getCustomName());
                    entity.setNoAi(this.isNoAi());
                    entity.setInvulnerable(this.isInvulnerable());
                    entity.setSize(1, true);
                    entity.moveTo(this.getX() + (double)xOffset, this.getY() + 0.5D, this.getZ() + (double)zOffset, this.random.nextFloat() * 360.0F, 0.0F);
                    this.level.addFreshEntity(entity);
                }
            }
        }

        super.remove(pReason);
    }

    public void setSize(int pSize, boolean pResetHealth) {
        int size = Mth.clamp(pSize, 0, 127);

        this.entityData.set(ID_SIZE, size);

        this.reapplyPosition();
        this.refreshDimensions();

        Objects.requireNonNull(this.getAttribute(Attributes.ATTACK_DAMAGE)).setBaseValue(size);
        Objects.requireNonNull(this.getAttribute(Attributes.MAX_HEALTH)).setBaseValue(size * size);
        Objects.requireNonNull(this.getAttribute(Attributes.MOVEMENT_SPEED)).setBaseValue(0.1D + (size * 0.04D));

        if (pResetHealth) {
            this.setHealth(this.getMaxHealth());
        }

        this.xpReward = size;
    }

    @Override
    public void tick() {
        if (this.level.isClientSide()) {
            if (this.isMovingOnLand()) {
                this.walkAnimationState.startIfStopped(this.tickCount);
            } else {
                this.walkAnimationState.stop();
            }
        }

        super.tick();
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 4.0D).add(Attributes.MAX_HEALTH, 16.0D).add(Attributes.MOVEMENT_SPEED, 0.1D);
    }

    @Override
    public EntityDimensions getDimensions(Pose pPose) {
        float size = this.getDimensionFromSize() * 1.125F;
        return super.getDimensions(pPose).scale(size);
    }

    @Override
    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        ItemStack itemStack = pPlayer.getItemInHand(pHand);
        if (itemStack.getItem() == IcariaItems.VIAL_EMPTY.get()) {
            pPlayer.getLevel().playSound(pPlayer, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.BOTTLE_FILL, SoundSource.NEUTRAL, 1.0F, 1.0F);
            if (!this.level.isClientSide) {
                this.setSize(this.getSize() - 1, true);
                if (this.getSize() < 1) {
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
        this.setSize(4, true);
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
    }
}
