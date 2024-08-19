package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class BubbleSpellEntity extends ThrowableProjectile {
	public int minAge = 200;
	public int maxAge = 400;

	public static final EntityDataAccessor<Integer> AGE = SynchedEntityData.defineId(BubbleSpellEntity.class, EntityDataSerializers.INT);

	public BubbleSpellEntity(EntityType<? extends BubbleSpellEntity> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	@Override
	public boolean isInWater() {
		return false;
	}

	@Override
	public double getDefaultGravity() {
		return 0.0D;
	}

	public int getAge() {
		return this.entityData.get(BubbleSpellEntity.AGE);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag pCompound) {
		super.addAdditionalSaveData(pCompound);
		pCompound.putInt("Age", this.getAge());
	}

	@Override
	public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
		pBuilder.define(BubbleSpellEntity.AGE, 0);
	}

	@Override
	public void onHitBlock(BlockHitResult pResult) {
		super.onHitBlock(pResult);
		this.pop();
	}

	@Override
	public void onHitEntity(EntityHitResult pResult) {
		if (pResult.getEntity() instanceof LivingEntity livingEntity) {
			livingEntity.hurt(this.damageSources().magic(), 2.0F);
			this.pop();
		}
	}

	public void pop() {
		this.discard();
		this.playSound(IcariaSoundEvents.BUBBLE_SPELL_POP);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag pCompound) {
		super.readAdditionalSaveData(pCompound);
		this.setAge(pCompound.getInt("Age"));
	}

	public void setAge(int pAge) {
		this.entityData.set(BubbleSpellEntity.AGE, pAge);
	}

	@Override
	public void tick() {
		super.tick();
		int age = this.getAge();
		if (age < this.getRandom().nextIntBetweenInclusive(this.minAge, this.maxAge)) {
			age++;
			this.setAge(age);
		} else {
			this.pop();
		}
	}
}
