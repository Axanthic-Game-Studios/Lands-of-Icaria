package com.axanthic.icaria.common.entity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CrawlerRevenantEntity extends RevenantEntity {
	public int maxTick = 60;
	public int minTick = 0;

	public static final EntityDataAccessor<Integer> TICK = SynchedEntityData.defineId(CrawlerRevenantEntity.class, EntityDataSerializers.INT);

	public CrawlerRevenantEntity(EntityType<? extends CrawlerRevenantEntity> pType, Level pLevel) {
		super(pType, pLevel);
	}

	@Override
	public boolean canRide(Entity pVehicle) {
		return false;
	}

	public boolean onTick() {
		return this.getTick() < this.maxTick;
	}

	public float getShadowStrength() {
		return this.getTick() / (float) this.maxTick;
	}

	public int getTick() {
		return this.entityData.get(CrawlerRevenantEntity.TICK);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag pCompound) {
		super.addAdditionalSaveData(pCompound);
		pCompound.putInt("Tick", this.getTick());
	}

	@Override
	public void aiStep() {
		super.aiStep();
		if (this.isAlive()) {
			int tick = this.getTick();
			if (tick < this.maxTick) {
				++tick;
				this.setTick(tick);
			}
		}
	}

	@Override
	public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
		super.defineSynchedData(pBuilder);
		pBuilder.define(CrawlerRevenantEntity.TICK, this.minTick);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag pCompound) {
		super.readAdditionalSaveData(pCompound);
		this.setTick(pCompound.getInt("Tick"));
	}

	public void setTick(int pSize) {
		int tick = Mth.clamp(pSize, this.minTick, this.maxTick);
		this.entityData.set(CrawlerRevenantEntity.TICK, tick);
	}

	@Override
	public void tick() {
		super.tick();
		if (this.level().isClientSide()) {
			this.tickParticlePlusSounds();
		}
	}

	public void tickParticlePlusSounds() {
		if (this.onTick()) {
			this.level().playLocalSound(this.getX(), this.getY(), this.getZ(), this.getBlockStateOn().getSoundType(this.level(), this.blockPosition(), this).getBreakSound(), SoundSource.BLOCKS, 1.0F, 1.0F, false);
			for (int i = 0; i < 15; ++i) {
				double x = this.getX() + Mth.randomBetween(this.getRandom(), -0.75F, 0.75F);
				double y = this.getY();
				double z = this.getZ() + Mth.randomBetween(this.getRandom(), -0.75F, 0.75F);
				this.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, this.getBlockStateOn()), x, y, z, 0.0D, 0.0D, 0.0D);
			}
		}
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 2.0D).add(Attributes.FOLLOW_RANGE, 32.0D).add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.125D);
	}
}
