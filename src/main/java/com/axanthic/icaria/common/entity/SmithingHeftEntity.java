package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.helper.IcariaCommonHelper;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaFluids;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.gamerules.GameRules;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SmithingHeftEntity extends Entity {
	public static final EntityDataAccessor<BlockState> BLOCK_STATE = SynchedEntityData.defineId(SmithingHeftEntity.class, EntityDataSerializers.BLOCK_STATE);

	public SmithingHeftEntity(EntityType<? extends SmithingHeftEntity> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	public SmithingHeftEntity(EntityType<? extends SmithingHeftEntity> pEntityType, Level pLevel, BlockState pBlockState) {
		this(pEntityType, pLevel);
		this.setBlockState(pBlockState);
	}

	@Override
	public boolean causeFallDamage(double pFallDistance, float pDamageModifier, DamageSource pDamageSource) {
		var amount = Math.min(this.fallDistance, 40.0D);
		var boundingBox = this.getBoundingBox();
		var damageSource = this.damageSources().fallingBlock(this);
		var predicate = EntitySelector.NO_CREATIVE_OR_SPECTATOR.and(EntitySelector.LIVING_ENTITY_STILL_ALIVE);
		this.level().getEntities(this, boundingBox, predicate).forEach(entity -> IcariaCommonHelper.hurt(damageSource, entity, (float) amount));
		return true;
	}

	@Override
	public boolean displayFireAnimation() {
		return false;
	}

	@Override
	public boolean hurtServer(ServerLevel pServerLevel, DamageSource pDamageSource, float pDamage) {
		return false;
	}

	@Override
	public boolean isAttackable() {
		return false;
	}

	@Override
	public void addAdditionalSaveData(ValueOutput pValueOutput) {
		pValueOutput.store("BlockState", BlockState.CODEC, this.getBlockState());
	}

	@Override
	public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
		pBuilder.define(SmithingHeftEntity.BLOCK_STATE, Blocks.AIR.defaultBlockState());
	}

	@Override
	public void readAdditionalSaveData(ValueInput pValueInput) {
		this.setBlockState(pValueInput.read("BlockState", BlockState.CODEC).orElse(Blocks.AIR.defaultBlockState()));
	}

	public void setBlockState(BlockState pBlockState) {
		this.entityData.set(SmithingHeftEntity.BLOCK_STATE, pBlockState);
	}

	@Override
	public void tick() {
		if (this.onGround()) {
			var fluidState = this.level().getFluidState(this.blockPosition());
			if (this.level().getBlockState(this.blockPosition()).canBeReplaced() && this.getBlockState().canSurvive(this.level(), this.blockPosition())) {
				this.level().setBlockAndUpdate(this.blockPosition(), this.getBlockState().trySetValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, fluidState.is(IcariaFluids.MEDITERRANEAN_WATER)).trySetValue(BlockStateProperties.WATERLOGGED, fluidState.is(Fluids.WATER)));
				this.playSound(SoundEvents.ANVIL_LAND);
				this.discard();
			} else if (this.level() instanceof ServerLevel serverLevel && serverLevel.getGameRules().get(GameRules.ENTITY_DROPS)) {
				this.spawnAtLocation(serverLevel, this.getBlockState().getBlock());
				this.playSound(SoundEvents.ANVIL_BREAK);
				this.discard();
			}
		} else {
			this.move(MoverType.SELF, this.getDeltaMovement());
			this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.05D, 0.0D));
		}
	}

	public BlockState getBlockState() {
		return this.entityData.get(SmithingHeftEntity.BLOCK_STATE);
	}

	@Override
	public MovementEmission getMovementEmission() {
		return MovementEmission.NONE;
	}

	@Override
	public MoveSimulationType getMoveSimulationType() {
		return MoveSimulationType.SERVER_AND_CLIENT;
	}
}
