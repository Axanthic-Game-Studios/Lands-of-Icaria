package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.helper.IcariaCommonHelper;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class BubbleSpellEntity extends ThrowableProjectile {
	public int maxAge = 400;
	public int minAge = 200;

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
		return this.getEntityData().get(BubbleSpellEntity.AGE);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag pCompoundTag) {
		super.addAdditionalSaveData(pCompoundTag);
		pCompoundTag.putInt("Age", this.getAge());
	}

	@Override
	public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
		pBuilder.define(BubbleSpellEntity.AGE, 0);
	}

	@Override
	public void onHitBlock(BlockHitResult pBlockHitResult) {
		super.onHitBlock(pBlockHitResult);
		this.pop();
	}

	@Override
	public void onHitEntity(EntityHitResult pEntityHitResult) {
		this.pop();
		IcariaCommonHelper.hurt(this.damageSources().magic(), pEntityHitResult.getEntity(), 2.0F);
	}

	public void pop() {
		this.discard();
		this.playSound(IcariaSoundEvents.BUBBLE_SPELL_POP);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag pCompoundTag) {
		super.readAdditionalSaveData(pCompoundTag);
		this.setAge(pCompoundTag.getInt("Age"));
	}

	public void setAge(int pAge) {
		this.getEntityData().set(BubbleSpellEntity.AGE, pAge);
	}

	@Override
	public void tick() {
		super.tick();
		var age = this.getAge();
		if (age < this.getRandom().nextIntBetweenInclusive(this.minAge, this.maxAge)) {
			age++;
			this.setAge(age);
		} else {
			this.pop();
		}
	}
}
