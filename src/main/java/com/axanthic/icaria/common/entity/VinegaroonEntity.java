package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.goal.IcariaArachnidTargetGoal;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;
import com.axanthic.icaria.common.registry.IcariaValues;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class VinegaroonEntity extends IcariaArachnidEntity implements RangedAttackMob {
	public int maxCooldown = 120;
	public int minCooldown = 0;

	public AnimationState attackAnimationState = new AnimationState();

	public static final EntityDataAccessor<Boolean> CLIMBING = SynchedEntityData.defineId(VinegaroonEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Integer> COOLDOWN = SynchedEntityData.defineId(VinegaroonEntity.class, EntityDataSerializers.INT);

	public VinegaroonEntity(EntityType<? extends VinegaroonEntity> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	@Override
	public boolean canRiderInteract() {
		return true;
	}

	@Override
	public boolean doHurtTarget(ServerLevel pServerLevel, Entity pEntity) {
		pEntity.startRiding(this);
		return super.doHurtTarget(pServerLevel, pEntity);
	}

	@Override
	public boolean onClimbable() {
		return this.getClimbing();
	}

	public boolean onCooldown() {
		return this.getCooldown() > this.minCooldown;
	}

	@Override
	public boolean shouldRiderSit() {
		return false;
	}

	public boolean getClimbing() {
		return this.getEntityData().get(VinegaroonEntity.CLIMBING);
	}

	public int getCooldown() {
		return this.getEntityData().get(VinegaroonEntity.COOLDOWN);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag pCompoundTag) {
		super.addAdditionalSaveData(pCompoundTag);
		pCompoundTag.putBoolean("Climbing", this.getClimbing());
		pCompoundTag.putInt("Cooldown", this.getCooldown());
	}

	@Override
	public void aiStep() {
		super.aiStep();
		this.tickCooldown();
	}

	@Override
	public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
		super.defineSynchedData(pBuilder);
		pBuilder.define(VinegaroonEntity.CLIMBING, false);
		pBuilder.define(VinegaroonEntity.COOLDOWN, this.minCooldown);
	}

	@Override
	public void performRangedAttack(LivingEntity pLivingEntity, float pVelocity) {
		var x = pLivingEntity.getX() - this.getX();
		var y = pLivingEntity.getY() - this.getY();
		var z = pLivingEntity.getZ() - this.getZ();
		var d = Math.sqrt(x * x + z * z) * 0.2D;

		var entity = new VinegarEntity(this.level(), this, new ItemStack(IcariaItems.VINEGAR.get()));

		entity.shoot(x, y + d, z, 2.0F, 2.0F);

		this.level().addFreshEntity(entity);
		this.level().playSound(null, this.blockPosition(), IcariaSoundEvents.VINEGAROON_SHOOT, SoundSource.HOSTILE);
	}

	@Override
	public void playStepSound(BlockPos pBlockPos, BlockState pBlockState) {
		this.playSound(IcariaSoundEvents.VINEGAROON_STEP, 0.1F, 1.0F);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag pCompoundTag) {
		super.readAdditionalSaveData(pCompoundTag);
		this.setClimbing(pCompoundTag.getBooleanOr("Climbing", false));
		this.setCooldown(pCompoundTag.getIntOr("Cooldown", 0));
	}

	@Override
	public void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.001F));
		this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 5.0F, 0.025F, false));
		this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new IcariaArachnidTargetGoal<>(this, Player.class, true, true));
	}

	public void setClimbing(boolean pClimbing) {
		this.getEntityData().set(VinegaroonEntity.CLIMBING, pClimbing);
	}

	public void setCooldown(int pCooldown) {
		this.getEntityData().set(VinegaroonEntity.COOLDOWN, pCooldown);
	}

	@Override
	public void tick() {
		super.tick();
		if (this.level().isClientSide()) {
			this.tickAttack();
		} else {
			this.setClimbing(this.horizontalCollision);
			this.tickRangedAttack();
			this.tickRiding();
		}
	}

	public void tickAttack() {
		if (this.onCooldown()) {
			this.attackAnimationState.startIfStopped(this.tickCount);
		} else {
			this.attackAnimationState.stop();
		}
	}

	public void tickCooldown() {
		if (this.onCooldown()) {
			var cooldown = this.getCooldown();
			if (cooldown > this.minCooldown) {
				--cooldown;
				this.setCooldown(cooldown);
			}
		}
	}

	public void tickRangedAttack() {
		if (this.countPlayerPassengers() == 0) {
			if (this.getTarget() instanceof Player player) {
				if (!this.onCooldown()) {
					this.performRangedAttack(this.getTarget(), this.distanceTo(player));
					this.setCooldown(this.maxCooldown);
				}
			}
		}
	}

	public void tickRiding() {
		if (this.countPlayerPassengers() == 1) {
			if (this.getFirstPassenger() instanceof Player player) {
				if (!player.isCreative()) {
					player.setShiftKeyDown(false);
					if (this.getHealth() < this.getMaxHealth() * 0.5F) {
						player.stopRiding();
					}
				}
			}
		}
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return Mob.createMobAttributes().add(Attributes.ARMOR, 8.0D).add(Attributes.ATTACK_DAMAGE, 4.0D).add(Attributes.MAX_HEALTH, 32.0D).add(Attributes.MOVEMENT_SPEED, 0.2D);
	}

	@Override
	public PathNavigation createNavigation(Level pLevel) {
		return new WallClimberNavigation(this, pLevel);
	}

	@Override
	public SoundEvent getAmbientSound() {
		return IcariaSoundEvents.VINEGAROON_AMBIENT;
	}

	@Override
	public SoundEvent getDeathSound() {
		return IcariaSoundEvents.VINEGAROON_DEATH;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource pDamageSource) {
		return IcariaSoundEvents.VINEGAROON_HURT;
	}

	@Override
	public Vec3 getPassengerAttachmentPoint(Entity pEntity, EntityDimensions pEntityDimensions, float pPartialTick) {
		return new Vec3(0.0D, pEntityDimensions.height(), 0.875D).yRot(IcariaValues.DEG_2_RAD * -this.getYHeadRot());
	}
}
