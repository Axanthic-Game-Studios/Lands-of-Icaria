package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.goal.JellyfishFleeGoal;
import com.axanthic.icaria.common.goal.JellyfishRandomMovementGoal;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;

import net.neoforged.neoforge.event.EventHooks;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class JellyfishEntity extends SizedFlyingMobEntity {
    public float rotateSpeed;
    public float speed;
    public float tentacleAngle;
    public float oldTentacleAngle;
    public float tentacleMovement;
    public float oldTentacleMovement;
    public float tentacleSpeed;
    public float tx;
    public float ty;
    public float tz;
    public float xBodyRot;
    public float oldXBodyRot;
    public float zBodyRot;
    public float oldZBodyRot;

    public JellyfishEntity(EntityType<? extends JellyfishEntity> pType, Level pLevel) {
        super(pType, pLevel, 0.25F, 0.25F, 0.15F, 0.75F, 0.25F);
        this.tentacleSpeed = 1.0F / (this.random.nextFloat() + 1.0F) * 0.2F;
    }

    public boolean hasMovementVector() {
        return this.tx != 0.0F || this.ty != 0.0F || this.tz != 0.0F;
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        if (this.getType() == IcariaEntityTypes.ENDER_JELLYFISH.get()) {
            if (this.isInvulnerableTo(pSource)) {
                return false;
            } else if (pSource.is(DamageTypeTags.IS_PROJECTILE)) {
                boolean flag;
                var entity = pSource.getDirectEntity();
                if (entity instanceof ThrownPotion) {
                    flag = this.hurtWithCleanWater(pSource, (ThrownPotion) entity, pAmount);
                } else {
                    flag = false;
                }

                for (int i = 0; i < 64; ++i) {
                    if (this.teleport()) {
                        return true;
                    }
                }

                return flag;
            } else {
                if (!this.level().isClientSide()) {
                    if (this.random.nextInt(10) != 0) {
                        if (!(pSource.getEntity() instanceof LivingEntity)) {
                            this.teleport();
                        }
                    }
                }

                return super.hurt(pSource, pAmount);
            }
        } else {
            return super.hurt(pSource, pAmount);
        }
    }

    public boolean hurtWithCleanWater(DamageSource pSource, ThrownPotion pPotion, float pAmount) {
        return super.hurt(pSource, pAmount) && pPotion.getItem().getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY).is(Potions.WATER);
    }

    @Override
    public boolean isIgnoringBlockTriggers() {
        return true;
    }

    @Override
    public boolean isSensitiveToWater() {
        return this.getType() == IcariaEntityTypes.ENDER_JELLYFISH.get();
    }

    public boolean teleport() {
        if (!this.level().isClientSide() && this.isAlive()) {
            return this.teleport(this.getX() + (this.random.nextDouble() - 0.5D) * 64.0D, this.getY() + (this.random.nextInt(64) - 32), this.getZ() + (this.random.nextDouble() - 0.5D) * 64.0D);
        } else {
            return false;
        }
    }

    public boolean teleport(double pX, double pY, double pZ) {
        var mutablePos = new BlockPos.MutableBlockPos(pX, pY, pZ);
        while (mutablePos.getY() > this.level().getMinBuildHeight() && !this.level().getBlockState(mutablePos).blocksMotion()) {
            mutablePos.move(Direction.DOWN);
        }

        var blockState = this.level().getBlockState(mutablePos);
        if (blockState.blocksMotion() && !blockState.getFluidState().is(FluidTags.WATER)) {
            boolean flag = this.randomTeleport(pX, pY, pZ, true);
            if (EventHooks.onEnderTeleport(this, pX, pY, pZ).isCanceled()) {
                return false;
            }

            if (flag && !this.isSilent()) {
                this.playSound(SoundEvents.ENDERMAN_TELEPORT, 0.1F, 1.0F);
            }

            return flag;
        } else {
            return false;
        }
    }

    @Override
    public void aiStep() {
        super.aiStep();
        this.oldTentacleAngle = this.tentacleAngle;
        this.oldTentacleMovement = this.tentacleMovement;
        this.tentacleMovement += this.tentacleSpeed;
        this.oldXBodyRot = this.xBodyRot;
        this.oldZBodyRot = this.zBodyRot;
        if (this.tentacleMovement > (Mth.PI * 2.0D)) {
            if (this.level().isClientSide()) {
                this.tentacleMovement = (Mth.PI * 2.0F);
            } else {
                this.tentacleMovement -= (Mth.PI * 2.0F);
                if (this.random.nextInt(10) == 0) {
                    this.tentacleSpeed = 1.0F / (this.random.nextFloat() + 1.0F) * 0.2F;
                }

                this.level().broadcastEntityEvent(this, (byte) 19);
            }
        }

        if (this.tentacleMovement < Mth.PI) {
            float f = this.tentacleMovement / Mth.PI;
            this.tentacleAngle = Mth.sin(f * f * Mth.PI) * Mth.PI * 0.25F;
            if (f > 0.75D) {
                this.rotateSpeed = 1.0F;
                this.speed = 1.0F;
            } else {
                this.rotateSpeed *= 0.8F;
            }
        } else {
            this.rotateSpeed *= 0.99F;
            this.speed *= 0.9F;
            this.tentacleAngle = 0.0F;
        }

        if (!this.level().isClientSide()) {
            this.setDeltaMovement((this.tx * this.speed), (this.ty * this.speed), (this.tz * this.speed));
        }

        var vec3 = this.getDeltaMovement();
        this.xBodyRot += (float) ((-(Mth.atan2(vec3.horizontalDistance(), vec3.y)) * (180.0F / Mth.PI)) * 0.1F - this.xBodyRot * 0.1F);
        this.yBodyRot += (float) ((-(Mth.atan2(vec3.x, vec3.z)) * (180.0F / Mth.PI) - this.yBodyRot) * 0.1F);
        this.zBodyRot += Mth.PI * this.rotateSpeed * 1.5F;
        this.setYRot(this.yBodyRot);
        if (this.getType() == IcariaEntityTypes.ENDER_JELLYFISH.get()) {
            if (this.level().isClientSide()) {
                for (int i = 0; i < 2; ++i) {
                    this.level().addParticle(ParticleTypes.PORTAL, this.getRandomX(0.5D), this.getRandomY() - 0.25D, this.getRandomZ(0.5D), (this.random.nextDouble() - 0.5D) * 2.0D, -this.random.nextDouble(), (this.random.nextDouble() - 0.5D) * 2.0D);
                }
            }
        }
    }

    @Override
    public void customServerAiStep() {
        super.customServerAiStep();
        if (this.getType() == IcariaEntityTypes.ENDER_JELLYFISH.get()) {
            if (this.random.nextInt(100) == 0) {
                this.teleport();
            }
        }
    }

    @Override
    public void handleEntityEvent(byte pId) {
        if (pId == 19) {
            this.tentacleMovement = 0.0F;
        } else {
            super.handleEntityEvent(pId);
        }
    }

    @Override
    public void playerTouch(Player pPlayer) {
        if (pPlayer instanceof ServerPlayer) {
            pPlayer.hurt(this.damageSources().mobAttack(this), this.getSize());
            if (!pPlayer.isCreative()) {
                if (this.getType() == IcariaEntityTypes.ENDER_JELLYFISH.get()) {
                    pPlayer.addEffect(new MobEffectInstance(MobEffects.WITHER, this.getSize() * 100, 0), this);
                } else if (this.getType() == IcariaEntityTypes.FIRE_JELLYFISH.get()) {
                    pPlayer.igniteForSeconds(this.getSize() * 5);
                } else if (this.getType() == IcariaEntityTypes.NATURE_JELLYFISH.get()) {
                    pPlayer.addEffect(new MobEffectInstance(MobEffects.POISON, this.getSize() * 100, 0), this);
                } else if (this.getType() == IcariaEntityTypes.VOID_JELLYFISH.get()) {
                    pPlayer.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, this.getSize() * 100, 0), this);
                } else if (this.getType() == IcariaEntityTypes.WATER_JELLYFISH.get()) {
                    pPlayer.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, this.getSize() * 100, 0), this);
                }
            }
        }
    }

    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(1, new JellyfishRandomMovementGoal(this));
        this.goalSelector.addGoal(2, new JellyfishFleeGoal(this));
    }

    public void setMovementVector(float pTx, float pTy, float pTz) {
        this.tx = pTx;
        this.ty = pTy;
        this.tz = pTz;
    }

    @Override
    public void setSize(int pSize) {
        super.setSize(pSize);
        int size = Mth.clamp(pSize, this.minSize, this.maxSize);
        this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(size);
        this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(size * size);
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 4.0D).add(Attributes.MAX_HEALTH, 16.0D);
    }

    @Override
    public Entity.MovementEmission getMovementEmission() {
        return Entity.MovementEmission.EVENTS;
    }

    @Override
    public PathNavigation createNavigation(Level pLevel) {
        return new FlyingPathNavigation(this, pLevel);
    }

    @Override
    public SoundEvent getAmbientSound() {
        return SoundEvents.SQUID_AMBIENT;
    }

    @Override
    public SoundEvent getDeathSound() {
        return SoundEvents.SQUID_DEATH;
    }

    @Override
    public SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.SQUID_HURT;
    }
}
