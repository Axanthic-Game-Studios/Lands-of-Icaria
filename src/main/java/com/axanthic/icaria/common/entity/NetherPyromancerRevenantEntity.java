package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class NetherPyromancerRevenantEntity extends RevenantEntity implements RangedAttackMob {
    public int maxAiming = 40;
    public int minAiming = 0;
    public int maxReload = 80;
    public int minReload = 0;
    public int maxThrown = 40;
    public int minThrown = 0;

    public AnimationState reloadAnimationState = new AnimationState();
    public AnimationState thrownAnimationState = new AnimationState();

    public static final EntityDataAccessor<Integer> AIMING = SynchedEntityData.defineId(NetherPyromancerRevenantEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> RELOAD = SynchedEntityData.defineId(NetherPyromancerRevenantEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> THROWN = SynchedEntityData.defineId(NetherPyromancerRevenantEntity.class, EntityDataSerializers.INT);

    public NetherPyromancerRevenantEntity(EntityType<? extends NetherPyromancerRevenantEntity> pType, Level pLevel) {
        super(pType, pLevel);
    }

    public boolean onAiming() {
        return this.getAiming() > this.minAiming;
    }

    public boolean onReload() {
        return this.getReload() > this.minReload;
    }

    public boolean onThrown() {
        return this.getThrown() > this.minThrown;
    }

    public int getAiming() {
        return this.entityData.get(NetherPyromancerRevenantEntity.AIMING);
    }

    public int getReload() {
        return this.entityData.get(NetherPyromancerRevenantEntity.RELOAD);
    }

    public int getThrown() {
        return this.entityData.get(NetherPyromancerRevenantEntity.THROWN);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putInt("Aiming", this.getAiming());
        pCompound.putInt("Reload", this.getReload());
        pCompound.putInt("Thrown", this.getThrown());
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.onThrown()) {
            int thrown = this.getThrown();
            if (thrown > this.minThrown) {
                --thrown;
                this.setThrown(thrown);
                this.setReload(this.maxReload);
            }
        } else if (this.onReload()) {
            int reload = this.getReload();
            if (reload > this.minReload) {
                --reload;
                this.setReload(reload);
                this.setAiming(this.maxAiming);
                if (reload < this.maxReload / 2) {
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(IcariaItems.GREEK_FIRE_GRENADE.get()));
                }
            }
        } else if (this.onAiming()) {
            int aiming = this.getAiming();
            if (aiming > this.minAiming) {
                --aiming;
                this.setAiming(aiming);
            }
        }
    }

    @Override
    public void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(NetherPyromancerRevenantEntity.AIMING, this.minAiming);
        this.entityData.define(NetherPyromancerRevenantEntity.RELOAD, this.minReload);
        this.entityData.define(NetherPyromancerRevenantEntity.THROWN, this.minThrown);
    }

    @Override
    public void performRangedAttack(LivingEntity pTarget, float pVelocity) {
        if (!this.onAiming()) {
            var entity = new GreekFireGrenadeEntity(this.level(), this, this.useItem);

            double d0 = pTarget.getX() - this.getX();
            double d1 = pTarget.getY(0.3D) - entity.getY();
            double d2 = pTarget.getZ() - this.getZ();
            double d3 = Math.sqrt(d0 * d0 + d2 * d2);

            entity.shoot(d0, d1 + d3 * 0.2D, d2, 1.0F, 8.0F);

            this.level().addFreshEntity(entity);
            this.setItemSlot(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
            this.setThrown(this.maxThrown);
            if (!this.isSilent()) {
                this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.ARROW_SHOOT, this.getSoundSource(), 1.0F, 1.0F + (this.random.nextFloat() - this.random.nextFloat()) * 0.2F);
            }
        }
    }

    @Override
    public void populateDefaultEquipmentSlots(RandomSource pRandom, DifficultyInstance pDifficulty) {
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(IcariaItems.GREEK_FIRE_GRENADE.get()));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setAiming(pCompound.getInt("Aiming"));
        this.setReload(pCompound.getInt("Reload"));
        this.setAiming(pCompound.getInt("Thrown"));
    }

    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1.0D, 80, 12.0F));
        this.goalSelector.addGoal(3, new MoveTowardsRestrictionGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.001F));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 10.0F, 0.025F, false));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true, true));
    }

    public void setAiming(int pTick) {
        this.entityData.set(NetherPyromancerRevenantEntity.AIMING, pTick);
    }

    public void setReload(int pTick) {
        this.entityData.set(NetherPyromancerRevenantEntity.RELOAD, pTick);
    }

    public void setThrown(int pTick) {
        this.entityData.set(NetherPyromancerRevenantEntity.THROWN, pTick);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            if (this.onThrown()) {
                this.thrownAnimationState.startIfStopped(this.tickCount);
                this.reloadAnimationState.stop();
            } else if (this.onReload()) {
                this.reloadAnimationState.startIfStopped(this.tickCount);
                this.thrownAnimationState.stop();
            }
        }
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.createMobAttributes().add(Attributes.FOLLOW_RANGE, 32.0D).add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    @Override
    public SoundEvent getAmbientSound() {
        return IcariaSoundEvents.PYROMANCER_REVENANT_AMBIENT;
    }
}
