package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SlugEntity extends SizedPathfinderMobEntity {
    public float red;
    public float green;
    public float blue;

    public int maxCooldown = 400;
    public int minCooldown = 0;
    public int maxHide = 80;
    public int minHide = 0;
    public int maxShow = 80;
    public int minShow = 0;

    public AnimationState hideAnimationState = new AnimationState();
    public AnimationState hurtAnimationState = new AnimationState();
    public AnimationState moveAnimationState = new AnimationState();
    public AnimationState showAnimationState = new AnimationState();

    public static final EntityDataAccessor<Byte> CLIMBING = SynchedEntityData.defineId(SlugEntity.class, EntityDataSerializers.BYTE);

    public static final EntityDataAccessor<Integer> COOLDOWN = SynchedEntityData.defineId(SlugEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> HIDE = SynchedEntityData.defineId(SlugEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> SHOW = SynchedEntityData.defineId(SlugEntity.class, EntityDataSerializers.INT);

    public SlugEntity(EntityType<? extends SlugEntity> pType, Level pLevel) {
        super(pType, pLevel, 0.25F, 0.25F, 0.15F, 0.75F, 0.25F);
    }

    public boolean doHide() {
        return !this.onCooldown() && !this.onHide() && !this.onShow() && this.getBlockStateOn().is(BlockTags.DIRT);
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        if (this.doHide() && this.getHealth() < 4.0F) {
            this.setHide(this.maxHide);
        }

        return super.hurt(pSource, pAmount);
    }

    public boolean isClimbing() {
        return (this.entityData.get(SlugEntity.CLIMBING) & 1) != 0;
    }

    public boolean isMovingOnLand() {
        return this.onGround() && this.getDeltaMovement().horizontalDistanceSqr() > 0;
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public boolean onClimbable() {
        return this.isClimbing();
    }

    public boolean onCooldown() {
        return this.getCooldown() > this.minCooldown;
    }

    public boolean onHide() {
        return this.getHide() > this.minHide;
    }

    public boolean onHurt() {
        return this.hurtTime > 0;
    }

    public boolean onShow() {
        return this.getShow() > this.minShow;
    }

    public float getShadowStrength() {
        if (this.onHide()) {
            return this.getHide() / (float) this.maxHide;
        } else if (this.onCooldown()) {
            return 0.0F;
        } else if (this.onShow()) {
            return 1.0F - (this.getShow() / (float) this.maxShow);
        } else {
            return 1.0F;
        }
    }

    @Override
    public float getVoicePitch() {
        return super.getVoicePitch() - 0.75F;
    }

    public int getCooldown() {
        return this.entityData.get(SlugEntity.COOLDOWN);
    }

    public int getHide() {
        return this.entityData.get(SlugEntity.HIDE);
    }

    public int getShow() {
        return this.entityData.get(SlugEntity.SHOW);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putInt("Cooldown", this.getCooldown());
        pCompound.putInt("Hide", this.getHide());
        pCompound.putInt("Show", this.getShow());
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.onHide()) {
            int hide = this.getHide();
            if (hide > this.minHide) {
                --hide;
                this.setHide(hide);
                this.setCooldown(this.maxCooldown);
            }
        } else if (this.onCooldown()) {
            int cooldown = this.getCooldown();
            if (cooldown > this.minCooldown) {
                --cooldown;
                this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, cooldown, 3, false, false));
                this.setCooldown(cooldown);
                this.setShow(this.maxShow);
            }
        } else if (this.onShow()) {
            int show = this.getShow();
            if (show > this.minShow) {
                --show;
                this.setShow(show);
            }
        }
    }

    @Override
    public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
        super.defineSynchedData(pBuilder);
        pBuilder.define(SlugEntity.CLIMBING, (byte) 0);
        pBuilder.define(SlugEntity.COOLDOWN, this.minCooldown);
        pBuilder.define(SlugEntity.HIDE, this.minHide);
        pBuilder.define(SlugEntity.SHOW, this.minShow);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setCooldown(pCompound.getInt("Cooldown"));
        this.setHide(pCompound.getInt("Hide"));
        this.setShow(pCompound.getInt("Show"));
    }

    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.001F));
    }

    public void setClimbing(boolean pClimbing) {
        byte b = this.entityData.get(SlugEntity.CLIMBING);
        if (pClimbing) {
            b = (byte) (b | 1);
        } else {
            b = (byte) (b & -2);
        }

        this.entityData.set(SlugEntity.CLIMBING, b);
    }

    public void setCooldown(int pCooldown) {
        int ticks = Mth.clamp(pCooldown, this.minCooldown, this.maxCooldown);
        this.entityData.set(SlugEntity.COOLDOWN, ticks);
    }

    public void setHide(int pCooldown) {
        int ticks = Mth.clamp(pCooldown, this.minHide, this.maxHide);
        this.entityData.set(SlugEntity.HIDE, ticks);
    }

    public void setShow(int pCooldown) {
        int ticks = Mth.clamp(pCooldown, this.minShow, this.maxShow);
        this.entityData.set(SlugEntity.SHOW, ticks);
    }

    @Override
    public void setSize(int pSize) {
        super.setSize(pSize);
        int size = Mth.clamp(pSize, this.minSize, this.maxSize);
        this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(size * size);
    }

    public void stopMove() {
        if (this.onHide() || this.onCooldown() || this.onShow()) {
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.0D);
        } else {
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.125D);
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            this.tickParticlePlusSounds();
            this.tickRegisterRaysValues();
            if (this.isClimbing() || this.isMovingOnLand()) {
                this.moveAnimationState.startIfStopped(this.tickCount);
            } else {
                this.moveAnimationState.stop();
            }

            if (this.onHide() || this.onCooldown()) {
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
            this.stopMove();
        }
    }

    public void tickParticlePlusSounds() {
        if ((this.onHide() && this.getHide() < 40) || (this.onShow() && this.getShow() > 40) && !this.onCooldown()) {
            this.level().playLocalSound(this.getX(), this.getY(), this.getZ(), this.getBlockStateOn().getSoundType(this.level(), this.blockPosition(), this).getBreakSound(), SoundSource.BLOCKS, 1.0F, 1.0F, false);
            for (int i = 0; i < 15; ++i) {
                double x = this.getX() + Mth.randomBetween(this.getRandom(), -0.75F, 0.75F);
                double y = this.getY();
                double z = this.getZ() + Mth.randomBetween(this.getRandom(), -0.75F, 0.75F);
                this.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, this.getBlockStateOn()), x, y, z, 0.0D, 0.0D, 0.0D);
            }
        }
    }

    public void tickRegisterRaysValues() {
        if (this.tickCount < 20) {
            this.red = IcariaClientHelper.getRed(this);
            this.green = IcariaClientHelper.getGreen(this);
            this.blue = IcariaClientHelper.getBlue(this);
        }
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.createMobAttributes().add(Attributes.KNOCKBACK_RESISTANCE, 1.0D).add(Attributes.MAX_HEALTH, 16.0D).add(Attributes.MOVEMENT_SPEED, 0.125D);
    }

    @Override
    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        var itemStack = pPlayer.getItemInHand(pHand);
        if (itemStack.getItem() == IcariaItems.HALITE_DUST.get()) {
            if (!this.level().isClientSide()) {
                pPlayer.awardStat(Stats.ITEM_USED.get(IcariaItems.HALITE_DUST.get()));
                this.hurt(this.damageSources().generic(), 1.0F);
                if (this.doHide()) {
                    this.setHide(this.maxHide);
                }

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
