package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class PyromancerRevenantEntity extends RevenantEntity implements RangedAttackMob {
	public int maxAiming = 40;
	public int minAiming = 0;
	public int maxReload = 80;
	public int minReload = 0;
	public int maxThrown = 40;
	public int minThrown = 0;

	public AnimationState reloadAnimationState = new AnimationState();
	public AnimationState thrownAnimationState = new AnimationState();

	public static final EntityDataAccessor<Integer> AIMING = SynchedEntityData.defineId(PyromancerRevenantEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> RELOAD = SynchedEntityData.defineId(PyromancerRevenantEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> THROWN = SynchedEntityData.defineId(PyromancerRevenantEntity.class, EntityDataSerializers.INT);

	public PyromancerRevenantEntity(EntityType<? extends PyromancerRevenantEntity> pEntityType, Level pLevel) {
		super(pEntityType, pLevel, true);
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

	@Override
	public boolean removeWhenFarAway(double pDistanceToClosestPlayer) {
		return false;
	}

	public int getAiming() {
		return this.getEntityData().get(PyromancerRevenantEntity.AIMING);
	}

	public int getReload() {
		return this.getEntityData().get(PyromancerRevenantEntity.RELOAD);
	}

	public int getThrown() {
		return this.getEntityData().get(PyromancerRevenantEntity.THROWN);
	}

	@Override
	public void addAdditionalSaveData(ValueOutput pValueOutput) {
		super.addAdditionalSaveData(pValueOutput);
		pValueOutput.putInt("Aiming", this.getAiming());
		pValueOutput.putInt("Reload", this.getReload());
		pValueOutput.putInt("Thrown", this.getThrown());
	}

	@Override
	public void aiStep() {
		super.aiStep();
		if (this.onThrown()) {
			var thrown = this.getThrown();
			if (thrown > this.minThrown) {
				--thrown;
				this.setThrown(thrown);
				this.setReload(this.maxReload);
			}
		} else if (this.onReload()) {
			var reload = this.getReload();
			if (reload > this.minReload) {
				--reload;
				this.setReload(reload);
				this.setAiming(this.maxAiming);
				if (reload < this.maxReload / 2) {
					this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(IcariaItems.GREEK_FIRE_GRENADE.get()));
				}
			}
		} else if (this.onAiming()) {
			var aiming = this.getAiming();
			if (aiming > this.minAiming) {
				--aiming;
				this.setAiming(aiming);
			}
		}
	}

	@Override
	public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
		super.defineSynchedData(pBuilder);
		pBuilder.define(PyromancerRevenantEntity.AIMING, this.minAiming);
		pBuilder.define(PyromancerRevenantEntity.RELOAD, this.minReload);
		pBuilder.define(PyromancerRevenantEntity.THROWN, this.minThrown);
	}

	@Override
	public void performRangedAttack(LivingEntity pLivingEntity, float pVelocity) {
		if (!this.onAiming()) {
			var x = pLivingEntity.getX() - this.getX();
			var y = pLivingEntity.getY() - this.getY();
			var z = pLivingEntity.getZ() - this.getZ();
			var d = Math.sqrt(x * x + z * z) * 0.2D;

			var entity = new GreekFireGrenadeEntity(this.level(), this, new ItemStack(IcariaItems.GREEK_FIRE_GRENADE.get()));

			entity.shoot(x, y + d, z, 1.0F, 8.0F);

			this.level().addFreshEntity(entity);
			this.level().playSound(null, this.blockPosition(), IcariaSoundEvents.GREEK_FIRE_GRENADE_THROW, SoundSource.HOSTILE, 0.1F, 1.0F);
			this.setItemSlot(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
			this.setThrown(this.maxThrown);
		}
	}

	@Override
	public void populateDefaultEquipmentSlots(RandomSource pRandomSource, DifficultyInstance pDifficultyInstance) {
		this.populateDefaultEquipmentSlots();
	}

	public void populateDefaultEquipmentSlots() {
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(IcariaItems.GREEK_FIRE_GRENADE.get()));
	}

	@Override
	public void readAdditionalSaveData(ValueInput pValueInput) {
		super.readAdditionalSaveData(pValueInput);
		this.setAiming(pValueInput.getIntOr("Aiming", 0));
		this.setReload(pValueInput.getIntOr("Reload", 0));
		this.setThrown(pValueInput.getIntOr("Thrown", 0));
	}

	@Override
	public void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1.0D, 80, 12.0F));
		this.goalSelector.addGoal(3, new MoveTowardsRestrictionGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.001F));
		this.goalSelector.addGoal(5, new OpenDoorGoal(this, true));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 10.0F, 0.025F, false));
		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true, true));
	}

	public void setAiming(int pAiming) {
		this.getEntityData().set(PyromancerRevenantEntity.AIMING, pAiming);
	}

	public void setReload(int pReload) {
		this.getEntityData().set(PyromancerRevenantEntity.RELOAD, pReload);
	}

	public void setThrown(int pThrown) {
		this.getEntityData().set(PyromancerRevenantEntity.THROWN, pThrown);
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
		return Mob.createMobAttributes().add(Attributes.FOLLOW_RANGE, 32.0D).add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.2D);
	}
}
