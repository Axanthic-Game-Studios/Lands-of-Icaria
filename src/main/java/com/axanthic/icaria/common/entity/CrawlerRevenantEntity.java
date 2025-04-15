package com.axanthic.icaria.common.entity;

import javax.annotation.ParametersAreNonnullByDefault;

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

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CrawlerRevenantEntity extends RevenantEntity {
	public int maxTick = 60;
	public int minTick = 0;

	public static final EntityDataAccessor<Integer> TICK = SynchedEntityData.defineId(CrawlerRevenantEntity.class, EntityDataSerializers.INT);

	public CrawlerRevenantEntity(EntityType<? extends CrawlerRevenantEntity> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	@Override
	public boolean canRide(Entity pEntity) {
		return false;
	}

	public boolean onTick() {
		return this.getTick() < this.maxTick;
	}

	public float getShadowStrength() {
		return this.getTick() / (float) this.maxTick;
	}

	public int getTick() {
		return this.getEntityData().get(CrawlerRevenantEntity.TICK);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag pCompoundTag) {
		super.addAdditionalSaveData(pCompoundTag);
		pCompoundTag.putInt("Tick", this.getTick());
	}

	@Override
	public void aiStep() {
		super.aiStep();
		this.tickTick();
	}

	@Override
	public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
		super.defineSynchedData(pBuilder);
		pBuilder.define(CrawlerRevenantEntity.TICK, this.minTick);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag pCompoundTag) {
		super.readAdditionalSaveData(pCompoundTag);
		this.setTick(pCompoundTag.getInt("Tick"));
	}

	public void setTick(int pTick) {
		this.getEntityData().set(CrawlerRevenantEntity.TICK, pTick);
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
			for (var i = 0; i < 15; ++i) {
				var x = this.getX() + Mth.randomBetween(this.getRandom(), -0.75F, 0.75F);
				var y = this.getY();
				var z = this.getZ() + Mth.randomBetween(this.getRandom(), -0.75F, 0.75F);
				var blockParticleOption = new BlockParticleOption(ParticleTypes.BLOCK, this.getBlockStateOn());
				this.level().addParticle(blockParticleOption, x, y, z, 0.0D, 0.0D, 0.0D);
			}
		}
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 2.0D).add(Attributes.FOLLOW_RANGE, 32.0D).add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.1D);
	}
}
