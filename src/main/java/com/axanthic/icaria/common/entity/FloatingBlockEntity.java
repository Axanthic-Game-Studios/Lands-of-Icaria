package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.helper.IcariaCommonHelper;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FloatingBlockEntity extends Entity {
	public int maxTick = 300;
	public int minTick = 0;

	public static final EntityDataAccessor<BlockPos> BLOCK_POS = SynchedEntityData.defineId(FloatingBlockEntity.class, EntityDataSerializers.BLOCK_POS);
	public static final EntityDataAccessor<BlockState> BLOCK_STATE = SynchedEntityData.defineId(FloatingBlockEntity.class, EntityDataSerializers.BLOCK_STATE);
	public static final EntityDataAccessor<Integer> TICK = SynchedEntityData.defineId(FloatingBlockEntity.class, EntityDataSerializers.INT);

	public FloatingBlockEntity(EntityType<? extends FloatingBlockEntity> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	public FloatingBlockEntity(EntityType<? extends FloatingBlockEntity> pEntityType, Level pLevel, BlockState pBlockState, BlockPos pBlockPos) {
		this(pEntityType, pLevel);
		this.setBlockPos(pBlockPos);
		this.setBlockState(pBlockState);
	}

	@Override
	public boolean causeFallDamage(double pFallDistance, float pDamageMultiplier, DamageSource pDamageSource) {
		var amount = Math.min(this.fallDistance, 40.0D);
		var boundingBox = this.getBoundingBox();
		var damageSource = this.damageSources().fallingBlock(this);
		var predicate = EntitySelector.NO_CREATIVE_OR_SPECTATOR.and(EntitySelector.LIVING_ENTITY_STILL_ALIVE);
		this.level().getEntities(this, boundingBox, predicate).forEach((entity) -> IcariaCommonHelper.hurt(damageSource, entity, (float) amount));
		return true;
	}

	@Override
	public boolean displayFireAnimation() {
		return false;
	}

	@Override
	public boolean hurtServer(ServerLevel pServerLevel, DamageSource pDamageSource, float pAmount) {
		return false;
	}

	@Override
	public boolean isAttackable() {
		return false;
	}

	public int getTick() {
		return this.getEntityData().get(FloatingBlockEntity.TICK);
	}

	@Override
	public void addAdditionalSaveData(ValueOutput pValueOutput) {
		pValueOutput.store("BlockPos", BlockPos.CODEC, this.getBlockPos());
		pValueOutput.store("BlockState", BlockState.CODEC, this.getBlockState());
		pValueOutput.putInt("Tick", this.getTick());
	}

	@Override
	public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
		pBuilder.define(FloatingBlockEntity.BLOCK_POS, BlockPos.ZERO);
		pBuilder.define(FloatingBlockEntity.BLOCK_STATE, Blocks.AIR.defaultBlockState());
		pBuilder.define(FloatingBlockEntity.TICK, this.minTick);
	}

	@Override
	public void readAdditionalSaveData(ValueInput pValueInput) {
		this.setBlockPos(pValueInput.read("BlockPos", BlockPos.CODEC).orElse(BlockPos.ZERO));
		this.setBlockState(pValueInput.read("BlockState", BlockState.CODEC).orElse(Blocks.AIR.defaultBlockState()));
		this.setTick(pValueInput.getIntOr("Tick", 0));
	}

	public void setBlockPos(BlockPos pBlockPos) {
		this.getEntityData().set(FloatingBlockEntity.BLOCK_POS, pBlockPos);
	}

	public void setBlockState(BlockState pBlockState) {
		this.getEntityData().set(FloatingBlockEntity.BLOCK_STATE, pBlockState);
	}

	public void setTick(int pTick) {
		this.getEntityData().set(FloatingBlockEntity.TICK, pTick);
	}

	@Override
	public void tick() {
		super.tick();
		this.move(MoverType.SELF, this.getDeltaMovement());
		var tick = this.getTick();
		if (tick < this.maxTick) {
			tick++;
			this.setTick(tick);
		} else {
			this.setDeltaMovement(this.getDeltaMovement().add(0.0, -0.05D, 0.0));
			if (this.onGround()) {
				if (this.level().getBlockState(this.blockPosition()).canBeReplaced() && this.getBlockState().canSurvive(this.level(), this.blockPosition())) {
					this.level().setBlockAndUpdate(this.blockPosition(), this.getBlockState());
					this.discard();
				} else if (this.level() instanceof ServerLevel serverLevel && serverLevel.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
					this.spawnAtLocation(serverLevel, this.getBlockState().getBlock());
					this.discard();
				}
			}
		}
	}

	public BlockPos getBlockPos() {
		return this.getEntityData().get(FloatingBlockEntity.BLOCK_POS);
	}

	public BlockState getBlockState() {
		return this.getEntityData().get(FloatingBlockEntity.BLOCK_STATE);
	}

	@Override
	public MovementEmission getMovementEmission() {
		return MovementEmission.NONE;
	}
}
