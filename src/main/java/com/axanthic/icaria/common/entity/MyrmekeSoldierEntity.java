package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.goal.MyrmekeSoldierHurtByTargetGoal;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class MyrmekeSoldierEntity extends MyrmekeDroneEntity {
	public int maxTick = 40;
	public int minTick = 0;

	public static final EntityDataAccessor<Integer> TICK = SynchedEntityData.defineId(MyrmekeSoldierEntity.class, EntityDataSerializers.INT);

	public MyrmekeSoldierEntity(EntityType<? extends MyrmekeSoldierEntity> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	public boolean onTick() {
		return this.getTick() < this.maxTick;
	}

	public float getShadowStrength() {
		return this.getTick() / (float) this.maxTick;
	}

	public int getTick() {
		return this.getEntityData().get(MyrmekeSoldierEntity.TICK);
	}

	@Override
	public void addAdditionalSaveData(ValueOutput pValueOutput) {
		super.addAdditionalSaveData(pValueOutput);
		pValueOutput.putInt("Tick", this.getTick());
	}

	@Override
	public void aiStep() {
		super.aiStep();
		this.tickTick();
	}

	@Override
	public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
		super.defineSynchedData(pBuilder);
		pBuilder.define(MyrmekeSoldierEntity.TICK, this.minTick);
	}

	@Override
	public void playStepSound(BlockPos pBlockPos, BlockState pBlockState) {
		this.playSound(IcariaSoundEvents.MYRMEKE_SOLDIER_STEP, 0.1F, 1.0F);
	}

	@Override
	public void readAdditionalSaveData(ValueInput pValueInput) {
		super.readAdditionalSaveData(pValueInput);
		this.setTick(pValueInput.getIntOr("Tick", 0));
	}

	@Override
	public void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(2, new LeapAtTargetGoal(this, 0.25F));
		this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.001F));
		this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new MyrmekeSoldierHurtByTargetGoal(this).setAlertOthers());
	}

	public void setTick(int pTick) {
		this.getEntityData().set(MyrmekeSoldierEntity.TICK, pTick);
	}

	@Override
	public void tick() {
		super.tick();
		if (this.level().isClientSide()) {
			this.tickParticlePlusSounds();
		}
	}

	public void tickTick() {
		if (this.isAlive()) {
			var tick = this.getTick();
			if (tick < this.maxTick) {
				++tick;
				this.setTick(tick);
			}
		}
	}

	public void tickParticlePlusSounds() {
		if (this.onTick()) {
			this.level().playLocalSound(this.getX(), this.getY(), this.getZ(), this.getBlockStateOn().getSoundType(this.level(), this.blockPosition(), this).getBreakSound(), SoundSource.BLOCKS, 1.0F, 1.0F, false);
			for (var i = 0; i < 25; ++i) {
				var x = this.getX() + Mth.randomBetween(this.getRandom(), -0.75F, 0.75F);
				var y = this.getY();
				var z = this.getZ() + Mth.randomBetween(this.getRandom(), -0.75F, 0.75F);
				var blockParticleOption = new BlockParticleOption(ParticleTypes.BLOCK, this.getBlockStateOn());
				this.level().addParticle(blockParticleOption, x, y, z, 0.0D, 0.0D, 0.0D);
			}
		}
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 4.0D).add(Attributes.MAX_HEALTH, 16.0D).add(Attributes.MOVEMENT_SPEED, 0.2D);
	}

	@Override
	public SoundEvent getAmbientSound() {
		return IcariaSoundEvents.MYRMEKE_SOLDIER_AMBIENT;
	}

	@Override
	public SoundEvent getDeathSound() {
		return IcariaSoundEvents.MYRMEKE_SOLDIER_DEATH;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource pDamageSource) {
		return IcariaSoundEvents.MYRMEKE_SOLDIER_HURT;
	}
}
