package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaEntityTypes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.IndirectEntityDamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.EntityTeleportEvent;

import java.util.Objects;

import javax.annotation.ParametersAreNonnullByDefault;

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
        super(pType, pLevel, 0.25F, 0.125F, 0.25F);
        this.tentacleSpeed = 1.0F / (this.random.nextFloat() + 1.0F) * 0.2F;
    }

    @Override
    public boolean canBeLeashed(Player pPlayer) {
        return false;
    }

    public boolean hasMovementVector() {
        return this.tx != 0.0F || this.ty != 0.0F || this.tz != 0.0F;
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        if (this.getType() == IcariaEntityTypes.ENDER_JELLYFISH.get()) {
            if (this.isInvulnerableTo(pSource)) {
                return false;
            } else if (pSource instanceof IndirectEntityDamageSource) {
                boolean flag;
                Entity entity = pSource.getDirectEntity();
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
                if (!this.level.isClientSide()) {
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
        return super.hurt(pSource, pAmount) && PotionUtils.getPotion(pPotion.getItem()) == Potions.WATER;
    }

    @Override
    public boolean isIgnoringBlockTriggers() {
        return true;
    }

    @Override
    public boolean isSensitiveToWater() {
        return this.getType() == IcariaEntityTypes.ENDER_JELLYFISH.get();
    }

    @Override
    public boolean removeWhenFarAway(double pDistanceToClosestPlayer) {
        return false;
    }

    public boolean teleport() {
        if (!this.level.isClientSide() && this.isAlive()) {
            return this.teleport(this.getX() + (this.random.nextDouble() - 0.5D) * 64.0D, this.getY() + (this.random.nextInt(64) - 32), this.getZ() + (this.random.nextDouble() - 0.5D) * 64.0D);
        } else {
            return false;
        }
    }

    public boolean teleport(double pX, double pY, double pZ) {
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos(pX, pY, pZ);
        while (mutableBlockPos.getY() > this.level.getMinBuildHeight() && !this.level.getBlockState(mutableBlockPos).getMaterial().blocksMotion()) {
            mutableBlockPos.move(Direction.DOWN);
        }

        BlockState blockState = this.level.getBlockState(mutableBlockPos);
        boolean blocksMotion = blockState.getMaterial().blocksMotion();
        boolean isWater = blockState.getFluidState().is(FluidTags.WATER);
        if (blocksMotion && !isWater) {
            EntityTeleportEvent.EnderEntity event = ForgeEventFactory.onEnderTeleport(this, pX, pY, pZ);
            boolean flag = this.randomTeleport(pX, pY, pZ, true);
            if (event.isCanceled()) {
                return false;
            }

            if (flag && !this.isSilent()) {
                this.playSound(SoundEvents.ENDERMAN_TELEPORT, 1.0F, 1.0F);
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
            if (this.level.isClientSide) {
                this.tentacleMovement = (Mth.PI * 2.0F);
            } else {
                this.tentacleMovement -= (Mth.PI * 2.0F);
                if (this.random.nextInt(10) == 0) {
                    this.tentacleSpeed = 1.0F / (this.random.nextFloat() + 1.0F) * 0.2F;
                }

                this.level.broadcastEntityEvent(this, (byte) 19);
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

        if (!this.level.isClientSide) {
            this.setDeltaMovement((this.tx * this.speed), (this.ty * this.speed), (this.tz * this.speed));
        }

        Vec3 vec3 = this.getDeltaMovement();
        double d = vec3.horizontalDistance();
        this.xBodyRot += (-(Mth.atan2(d, vec3.y)) * (180.0F / Mth.PI)) * 0.1F - this.xBodyRot * 0.1F;
        this.yBodyRot += (-(Mth.atan2(vec3.x, vec3.z)) * (180.0F / Mth.PI) - this.yBodyRot) * 0.1F;
        this.zBodyRot += Mth.PI * this.rotateSpeed * 1.5F;
        this.setYRot(this.yBodyRot);
        if (this.getType() == IcariaEntityTypes.ENDER_JELLYFISH.get()) {
            if (this.level.isClientSide) {
                for (int i = 0; i < 2; ++i) {
                    this.level.addParticle(ParticleTypes.PORTAL, this.getRandomX(0.5D), this.getRandomY() - 0.25D, this.getRandomZ(0.5D), (this.random.nextDouble() - 0.5D) * 2.0D, -this.random.nextDouble(), (this.random.nextDouble() - 0.5D) * 2.0D);
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
            pPlayer.hurt(DamageSource.mobAttack(this), this.getSize());
            if (!pPlayer.isCreative()) {
                if (this.getType() == IcariaEntityTypes.ENDER_JELLYFISH.get()) {
                    pPlayer.addEffect(new MobEffectInstance(MobEffects.WITHER, this.getSize() * 100, 0), this);
                } else if (this.getType() == IcariaEntityTypes.FIRE_JELLYFISH.get()) {
                    pPlayer.setSecondsOnFire(this.getSize() * 5);
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
        this.goalSelector.addGoal(2, new JellyfishFleeGoal());
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
        Objects.requireNonNull(this.getAttribute(Attributes.ATTACK_DAMAGE)).setBaseValue(size);
        Objects.requireNonNull(this.getAttribute(Attributes.MAX_HEALTH)).setBaseValue(size * size);
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

    public static class JellyfishRandomMovementGoal extends Goal {
        public final JellyfishEntity entity;

        public JellyfishRandomMovementGoal(JellyfishEntity pEntity) {
            this.entity = pEntity;
        }

        @Override
        public boolean canUse() {
            return true;
        }

        @Override
        public void tick() {
            int i = this.entity.getNoActionTime();
            if (i > 100) {
                this.entity.setMovementVector(0.0F, 0.0F, 0.0F);
            } else if (this.entity.getRandom().nextInt(reducedTickDelay(50)) == 0 || !this.entity.hasMovementVector()) {
                float f0 = this.entity.getRandom().nextFloat() * (Mth.PI * 2.0F);
                float f1 = Mth.cos(f0) * 0.2F;
                float f2 = this.entity.getRandom().nextFloat() * 0.2F - 0.1F;
                float f3 = Mth.sin(f0) * 0.2F;
                this.entity.setMovementVector(f1, f2, f3);
            }
        }
    }

    public class JellyfishFleeGoal extends Goal {
        public int fleeTicks;

        @Override
        public boolean canUse() {
            LivingEntity livingEntity = JellyfishEntity.this.getLastHurtByMob();
            if (livingEntity != null) {
                return JellyfishEntity.this.distanceToSqr(livingEntity) < 100.0D;
            } else {
                return false;
            }
        }

        @Override
        public void start() {
            this.fleeTicks = 0;
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }

        @Override
        public void tick() {
            ++this.fleeTicks;
            LivingEntity livingEntity = JellyfishEntity.this.getLastHurtByMob();
            if (livingEntity != null) {
                Vec3 vec3 = new Vec3(JellyfishEntity.this.getX() - livingEntity.getX(), JellyfishEntity.this.getY() - livingEntity.getY(), JellyfishEntity.this.getZ() - livingEntity.getZ());
                BlockState blockState = JellyfishEntity.this.level.getBlockState(new BlockPos(JellyfishEntity.this.getX() + vec3.x, JellyfishEntity.this.getY() + vec3.y, JellyfishEntity.this.getZ() + vec3.z));
                if (blockState.isAir()) {
                    double length = vec3.length();
                    if (length > 0.0D) {
                        vec3.normalize();
                        double d = 3.0D;
                        if (length > 5.0D) {
                            d -= (length - 5.0D) / 5.0D;
                        }

                        if (d > 0.0D) {
                            vec3 = vec3.scale(d);
                        }
                    }

                    JellyfishEntity.this.setMovementVector((float) vec3.x / 20.0F, (float) vec3.y / 20.0F, (float) vec3.z / 20.0F);
                }

                if (this.fleeTicks % 10 == 5) {
                    JellyfishEntity.this.level.addParticle(ParticleTypes.BUBBLE, JellyfishEntity.this.getX(), JellyfishEntity.this.getY(), JellyfishEntity.this.getZ(), 0.0D, 0.0D, 0.0D);
                }
            }
        }
    }
}
