package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;
import com.axanthic.icaria.data.registry.IcariaLootTables;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class LootVaseEntity extends Entity {
	public static final EntityDataAccessor<BlockPos> BLOCK_POS = SynchedEntityData.defineId(LootVaseEntity.class, EntityDataSerializers.BLOCK_POS);
	public static final EntityDataAccessor<BlockState> BLOCK_STATE = SynchedEntityData.defineId(LootVaseEntity.class, EntityDataSerializers.BLOCK_STATE);

	public LootVaseEntity(EntityType<? extends LootVaseEntity> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	public LootVaseEntity(EntityType<? extends LootVaseEntity> pEntityType, Level pLevel, BlockState pBlockState, BlockPos pBlockPos) {
		this(pEntityType, pLevel);
		this.setBlockPos(pBlockPos);
		this.setBlockState(pBlockState);
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

	@Override
	public void addAdditionalSaveData(ValueOutput pValueOutput) {
		pValueOutput.store("BlockPos", BlockPos.CODEC, this.getBlockPos());
		pValueOutput.store("BlockState", BlockState.CODEC, this.getBlockState());
	}

	@Override
	public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
		pBuilder.define(LootVaseEntity.BLOCK_POS, BlockPos.ZERO);
		pBuilder.define(LootVaseEntity.BLOCK_STATE, Blocks.AIR.defaultBlockState());
	}

	public void dropFromLootTable(DamageSource pDamageSource) {
		if (this.level().getServer() != null) {
			if (this.level() instanceof ServerLevel serverLevel) {
				var lootContext = new LootParams.Builder(serverLevel).withOptionalParameter(LootContextParams.DIRECT_ATTACKING_ENTITY, pDamageSource.getDirectEntity()).withOptionalParameter(LootContextParams.ATTACKING_ENTITY, pDamageSource.getEntity()).withParameter(LootContextParams.DAMAGE_SOURCE, pDamageSource).withParameter(LootContextParams.ORIGIN, this.position()).withParameter(LootContextParams.THIS_ENTITY, this).create(LootContextParamSets.ENTITY);
				var lootTable = this.getBlockState().is(IcariaBlocks.RED_LOOT_VASE.get()) ? IcariaLootTables.RED_LOOT_VASE : this.getBlockState().is(IcariaBlocks.LOST_LOOT_VASE.get()) ? IcariaLootTables.LOST_LOOT_VASE : IcariaLootTables.CYAN_LOOT_VASE;
				lootContext.getLevel().getServer().reloadableRegistries().getLootTable(lootTable).getRandomItems(lootContext).forEach(itemStack -> this.spawnAtLocation(serverLevel, itemStack));
			}
		}
	}

	@Override
	public void readAdditionalSaveData(ValueInput pValueInput) {
		this.setBlockPos(pValueInput.read("BlockPos", BlockPos.CODEC).orElse(BlockPos.ZERO));
		this.setBlockState(pValueInput.read("BlockState", BlockState.CODEC).orElse(Blocks.AIR.defaultBlockState()));
	}

	public void setBlockPos(BlockPos pBlockPos) {
		this.entityData.set(LootVaseEntity.BLOCK_POS, pBlockPos);
	}

	public void setBlockState(BlockState pBlockState) {
		this.entityData.set(LootVaseEntity.BLOCK_STATE, pBlockState);
	}

	@Override
	public void tick() {
		if (this.onGround()) {
			this.discard();
			this.dropFromLootTable(this.damageSources().fall());
			this.playSound(IcariaSoundEvents.VASE_BREAK);
		} else {
			this.move(MoverType.SELF, this.getDeltaMovement());
			this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.05D, 0.0D));
		}
	}

	public BlockPos getBlockPos() {
		return this.entityData.get(LootVaseEntity.BLOCK_POS);
	}

	public BlockState getBlockState() {
		return this.entityData.get(LootVaseEntity.BLOCK_STATE);
	}

	@Override
	public Entity.MovementEmission getMovementEmission() {
		return Entity.MovementEmission.NONE;
	}
}
