package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.goal.CaptainRevenantSummonGoal;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;
import com.axanthic.icaria.common.spell.IcariaSummonSpell;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CaptainRevenantEntity extends RevenantEntity {
    public int maxUnequips = 40;
    public int minUnequips = 0;
    public int maxRallying = 120;
    public int minRallying = 0;
    public int maxReequips = 40;
    public int minReequips = 0;

    public AnimationState unequipsAnimationState = new AnimationState();
    public AnimationState rallyingAnimationState = new AnimationState();
    public AnimationState reequipsAnimationState = new AnimationState();

    public static final EntityDataAccessor<Byte> SPELL = SynchedEntityData.defineId(CaptainRevenantEntity.class, EntityDataSerializers.BYTE);

    public static final EntityDataAccessor<Integer> UNEQUIPS = SynchedEntityData.defineId(CaptainRevenantEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> RALLYING = SynchedEntityData.defineId(CaptainRevenantEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> REEQUIPS = SynchedEntityData.defineId(CaptainRevenantEntity.class, EntityDataSerializers.INT);

    public TargetingConditions targetingConditions = TargetingConditions.forNonCombat().range(16.0D).ignoreLineOfSight().ignoreInvisibilityTesting();

    public CaptainRevenantEntity(EntityType<? extends CaptainRevenantEntity> pType, Level pLevel) {
        super(pType, pLevel);
    }

    public boolean doSummoning() {
        return !this.onUnequips() && !this.onReequips() && !this.onRallying() && this.level().getNearbyEntities(CrawlerRevenantEntity.class, this.targetingConditions, this, this.getBoundingBox().inflate(16.0D)).size() <= 2;
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        if (this.doSummoning()) {
            this.setUnequips(this.maxUnequips);
        }

        return super.hurt(pSource, pAmount);
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    public boolean onRallying() {
        return this.getRallying() > this.minRallying;
    }

    public boolean onReequips() {
        return this.getReequips() > this.minReequips;
    }

    public boolean onUnequips() {
        return this.getUnequips() > this.minUnequips;
    }

    public int getRallying() {
        return this.entityData.get(CaptainRevenantEntity.RALLYING);
    }

    public int getReequips() {
        return this.entityData.get(CaptainRevenantEntity.REEQUIPS);
    }

    public int getUnequips() {
        return this.entityData.get(CaptainRevenantEntity.UNEQUIPS);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putInt("Unequips", this.getUnequips());
        pCompound.putInt("Rallying", this.getRallying());
        pCompound.putInt("Reequips", this.getReequips());
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.onUnequips()) {
            int unequips = this.getUnequips();
            if (unequips > this.minUnequips) {
                --unequips;
                this.setUnequips(unequips);
                this.setRallying(this.maxRallying);
            }
        } else if (this.onRallying()) {
            int rallying = this.getRallying();
            if (rallying > this.minRallying) {
                --rallying;
                this.setRallying(rallying);
                this.setReequips(this.maxReequips);
            }
        } else if (this.onReequips()) {
            int reequips = this.getReequips();
            if (reequips > this.minReequips) {
                --reequips;
                this.setReequips(reequips);
            }
        }
    }

    @Override
    public void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(CaptainRevenantEntity.SPELL, (byte) 0);
        this.entityData.define(CaptainRevenantEntity.UNEQUIPS, this.minUnequips);
        this.entityData.define(CaptainRevenantEntity.RALLYING, this.minRallying);
        this.entityData.define(CaptainRevenantEntity.REEQUIPS, this.minReequips);
    }

    @Override
    public void playStepSound(BlockPos pPos, BlockState pState) {
        this.playSound(IcariaSoundEvents.CAPTAIN_REVENANT_STEP, 0.1F, 1.0F);
    }

    @Override
    public void populateDefaultEquipmentSlots(RandomSource pRandom, DifficultyInstance pDifficulty) {
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(IcariaItems.ORICHALCUM_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(IcariaItems.ORICHALCUM_CHESTPLATE.get()));
        if (pRandom.nextInt(6) == 0) {
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(IcariaItems.ORICHALCUM_TOOLS.bident.get()));
        } else {
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(IcariaItems.ORICHALCUM_TOOLS.sword.get()));
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setUnequips(pCompound.getInt("Unequips"));
        this.setRallying(pCompound.getInt("Rallying"));
        this.setReequips(pCompound.getInt("Reequips"));
    }

    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(3, new CaptainRevenantSummonGoal(this));
        this.goalSelector.addGoal(4, new MoveTowardsRestrictionGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.001F));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 10.0F, 0.025F, false));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, ArganHoundEntity.class, true, true));
    }

    public void setCasting(IcariaSummonSpell pSpell) {
        this.entityData.set(CaptainRevenantEntity.SPELL, (byte) pSpell.id);
    }

    public void setRallying(int pCooldown) {
        int ticks = Mth.clamp(pCooldown, this.minRallying, this.maxRallying);
        this.entityData.set(CaptainRevenantEntity.RALLYING, ticks);
    }

    public void setReequips(int pCooldown) {
        int ticks = Mth.clamp(pCooldown, this.minReequips, this.maxReequips);
        this.entityData.set(CaptainRevenantEntity.REEQUIPS, ticks);
    }

    public void setUnequips(int pCooldown) {
        int ticks = Mth.clamp(pCooldown, this.minUnequips, this.maxUnequips);
        this.entityData.set(CaptainRevenantEntity.UNEQUIPS, ticks);
    }

    public void stopMove() {
        if (this.onUnequips() || this.onRallying() || this.onReequips()) {
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.0D);
        } else {
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.25D);
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            if (this.onUnequips()) {
                this.unequipsAnimationState.startIfStopped(this.tickCount);
                this.reequipsAnimationState.stop();
            } else if (this.onRallying()) {
                this.rallyingAnimationState.startIfStopped(this.tickCount);
                this.unequipsAnimationState.stop();
            } else if (this.onReequips()) {
                this.reequipsAnimationState.startIfStopped(this.tickCount);
                this.rallyingAnimationState.stop();
            }
        } else {
            this.stopMove();
        }
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 4.0D).add(Attributes.FOLLOW_RANGE, 32.0D).add(Attributes.MAX_HEALTH, 100.0D).add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    @Override
    public SoundEvent getDeathSound() {
        return IcariaSoundEvents.CAPTAIN_REVENANT_DEATH;
    }

    @Override
    public SoundEvent getHurtSound(DamageSource pDamageSource) {
        return IcariaSoundEvents.CAPTAIN_REVENANT_HURT;
    }
}
