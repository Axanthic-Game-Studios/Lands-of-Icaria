package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaSoundEvents;
import com.axanthic.icaria.data.tags.IcariaBlockTags;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.Event;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class VinegaroonEntity extends IcariaArachnidEntity implements RangedAttackMob {
    public int maxCooldown = 120;
    public int minCooldown = 0;

    public AnimationState attackAnimationState = new AnimationState();

    public static final EntityDataAccessor<Byte> CLIMBING = SynchedEntityData.defineId(VinegaroonEntity.class, EntityDataSerializers.BYTE);
    public static final EntityDataAccessor<Integer> COOLDOWN = SynchedEntityData.defineId(VinegaroonEntity.class, EntityDataSerializers.INT);

    public VinegaroonEntity(EntityType<? extends VinegaroonEntity> pType, Level pLevel) {
        super(pType, pLevel);
        this.xpReward = 5;
    }

    @Override
    public boolean canBeAffected(MobEffectInstance pEffectInstance) {
        if (pEffectInstance.getEffect() == MobEffects.POISON) {
            var event = new MobEffectEvent.Applicable(this, pEffectInstance);
            MinecraftForge.EVENT_BUS.post(event);
            return event.getResult() == Event.Result.ALLOW;
        }

        return super.canBeAffected(pEffectInstance);
    }

    @Override
    public boolean canRiderInteract() {
        return true;
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
        pEntity.startRiding(this);
        return super.doHurtTarget(pEntity);
    }

    public boolean isClimbing() {
        return (this.entityData.get(VinegaroonEntity.CLIMBING) & 1) != 0;
    }

    @Override
    public boolean onClimbable() {
        return this.isClimbing();
    }

    public boolean onCooldown() {
        return this.getCooldown() > this.minCooldown;
    }

    @Override
    public boolean shouldRiderSit() {
        return false;
    }

    public float getHalfHealth() {
        return this.getMaxHealth() * 0.5F;
    }

    @Override
    public float getStandingEyeHeight(Pose pPose, EntityDimensions pDimensions) {
        return 0.75F;
    }

    public int getCooldown() {
        return this.entityData.get(VinegaroonEntity.COOLDOWN);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putInt("Cooldown", this.getCooldown());
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.onCooldown()) {
            int cooldown = this.getCooldown();
            if (cooldown > this.minCooldown) {
                --cooldown;
                this.setCooldown(cooldown);
            }
        }
    }

    @Override
    public void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(VinegaroonEntity.CLIMBING, (byte) 0);
        this.entityData.define(VinegaroonEntity.COOLDOWN, this.minCooldown);
    }

    @Override
    public void makeStuckInBlock(BlockState pState, Vec3 pMotionMultiplier) {
        if (!pState.is(IcariaBlockTags.ICARIA_COBWEB_BLOCKS)) {
            super.makeStuckInBlock(pState, pMotionMultiplier);
        }
    }

    @Override
    public void performRangedAttack(LivingEntity pTarget, float pVelocity) {
        var entity = new VinegarEntity(this.level, this, this.useItem);

        double d0 = pTarget.getX() - this.getX();
        double d1 = pTarget.getY() - entity.getY();
        double d2 = pTarget.getZ() - this.getZ();
        double d3 = Math.sqrt(d0 * d0 + d2 * d2);

        entity.shoot(d0, d1 + d3 * 0.2D, d2, 2.0F, 2.0F);

        this.level.addFreshEntity(entity);
        if (!this.isSilent()) {
            this.level.playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.ARROW_SHOOT, this.getSoundSource(), 1.0F, 1.0F + (this.random.nextFloat() - this.random.nextFloat()) * 0.2F);
        }
    }

    @Override
    public void playStepSound(BlockPos pPos, BlockState pState) {
        this.playSound(SoundEvents.SPIDER_STEP, 0.1F, 1.0F);
    }

    @Override
    public void positionRider(Entity pPassenger) {
        super.positionRider(pPassenger);
        pPassenger.setPos(this.getX() + 0.625D, this.getY() + this.getPassengersRidingOffset() + pPassenger.getMyRidingOffset(), this.getZ() + 0.5D);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setCooldown(pCompound.getInt("Cooldown"));
    }

    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.001F));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 5.0F, 0.025F, false));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true, true));
    }

    public void setClimbing(boolean pClimbing) {
        byte b = this.entityData.get(VinegaroonEntity.CLIMBING);
        if (pClimbing) {
            b = (byte) (b | 1);
        } else {
            b = (byte) (b & -2);
        }

        this.entityData.set(VinegaroonEntity.CLIMBING, b);
    }

    public void setCooldown(int pCooldown) {
        int ticks = Mth.clamp(pCooldown, this.minCooldown, this.maxCooldown);
        this.entityData.set(VinegaroonEntity.COOLDOWN, ticks);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level.isClientSide) {
            if (this.onCooldown()) {
                this.attackAnimationState.startIfStopped(this.tickCount);
            } else {
                this.attackAnimationState.stop();
            }
        } else {
            this.setClimbing(this.horizontalCollision);
            if (this.hasExactlyOnePlayerPassenger()) {
                if (this.getFirstPassenger() instanceof Player player) {
                    if (!player.isCreative()) {
                        player.setShiftKeyDown(false);
                        if (this.getHealth() < this.getHalfHealth()) {
                            player.stopRiding();
                        }
                    }
                }
            } else if (this.getTarget() != null) {
                float distance = this.distanceTo(this.getTarget());
                if (distance >= 4.0F) {
                    if (!this.onCooldown()) {
                        this.performRangedAttack(this.getTarget(), distance);
                        this.setCooldown(this.maxCooldown);
                    }
                }
            }
        }
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.createMobAttributes().add(Attributes.ARMOR, 8.0D).add(Attributes.ATTACK_DAMAGE, 4.0D).add(Attributes.MAX_HEALTH, 32.0D).add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    @Override
    public MobType getMobType() {
        return MobType.ARTHROPOD;
    }

    @Override
    public PathNavigation createNavigation(Level pLevel) {
        return new WallClimberNavigation(this, pLevel);
    }

    @Override
    public SoundEvent getAmbientSound() {
        return IcariaSoundEvents.SCORPION_AMBIENT;
    }

    @Override
    public SoundEvent getDeathSound() {
        return IcariaSoundEvents.SCORPION_DEATH;
    }

    @Override
    public SoundEvent getHurtSound(DamageSource pDamageSource) {
        return IcariaSoundEvents.SCORPION_HURT;
    }
}
